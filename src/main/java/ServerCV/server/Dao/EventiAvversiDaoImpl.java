package ServerCV.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Common.EventiAvversi;
import ServerCV.server.Dao.Interfacce.EventiAvversiDao;
import ServerCV.server.Dao.GeneralDao;

/**
 * Nicolo' Ferrari, Mat. 732707, Varese
 * Alessandro Formenti, Mat. 734465, Varese
 * Luigi Mucciarone, Mat. 732714, Varese
 * Luca Alberti, Mat. 733096, Varese
 */

/**
 * Classe contenente le implementazioni delle interfacce di EventiAvversiDAO.
 */
public class EventiAvversiDaoImpl extends GeneralDao implements EventiAvversiDao {

	/**
	 * Metodo che inserisce i dati dell'evento avverso all'interno della tabella eventi_avversi.
	 * @param idVaccinazione		L'ID della vaccinazione.
	 * @param nomeCentro			Il nome del centro vaccinale.
	 * @param evento				Il nome dell'evento avverso.
	 * @param severita				L'intensita' dell'evento avverso.
	 * @param note					Eventuali note sull'evento avverso.
	 */
	@Override
	public void insertEventoAvverso(int idVaccinazione, String nomeCentro, String evento, Integer severita, String note) {
		String qInserisciEventiAvversi = "INSERT INTO eventi_avversi (idvaccinazione, nomecentro, evento, importanza, note) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qInserisciEventiAvversi);
			pstmt.setInt(1, idVaccinazione);
			pstmt.setString(2, nomeCentro);
			pstmt.setString(3, evento);
			pstmt.setInt(4, severita);
			pstmt.setString(5, note);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Metodo che conta e restituisce il numero di segnalazioni effetuate per quel determinato centro vaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @return				Il numero di segnalazioni effettuate per quel determinato centro vaccinale.
	 */
	@Override
	public int getSegnalazioni(String nomeCentro) {
		String qGetNumSegnalazioni = "SELECT count(nomecentro) AS count_segnalazioni FROM eventi_avversi WHERE nomecentro = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qGetNumSegnalazioni);
			pstmt.setString(1, nomeCentro);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("count_segnalazioni");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return 0;
	}

	/**
	 * Metodo che calcola il valore medio dell'intensita' degli eventi avversi per quel determinato centro vaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @param evento		Il tipo di evento avverso.
	 * @return				Il valore medio di quel determinato evento.
	 */
	@Override
	public double getImportanzaEvento(String nomeCentro, String evento) {
		String qGetImportanzaEvento = "SELECT avg(importanza) AS media_valori FROM eventi_avversi WHERE nomecentro = ? AND evento = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qGetImportanzaEvento);
			pstmt.setString(1, nomeCentro);
			pstmt.setString(2, evento);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				return rs.getDouble("media_valori");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return 0.0;
	}
	
	/**
	 * Metodo che controlla se un determinato cittadino ha gia' inserito degli eventi avversi.
	 * @param id	L'ID della vaccinazione.
	 * @return		Se sono gia' stati inseriti degli eventi avversi.
	 */
	public boolean existId(int id) {
		String qExistIdInEventiAvversi = "SELECT idvaccinazione FROM eventi_avversi WHERE idvaccinazione = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistIdInEventiAvversi);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return false;
	}

}
