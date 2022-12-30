package ServerCV.database.gestioneDB;

import ServerCV.database.gestioneDB.interfacceDB.EventiAvversiDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventiAvversiDaoImpl extends GeneralDao implements EventiAvversiDao {

	/**
	 * Metodo che inserisce i dati all'interno della tabella eventi_avversi.
	 *
	 */
	// query implementata
	// non verifcato funzionamento su DB
	@Override
	public void insertEventoAvverso(String id_vaccinazione, String id_centro, String evento, Integer severita,
			String note, String cf) {
		String qInserisciEventiAvversi = "INSERT INTO Eventi_Avversi (id_vaccinazione, id_centro, nome_evento, severita, note_opzionali, cf) VALUES (?, ?, ?, ?, ?,?)";
		PreparedStatement pstmt;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qInserisciEventiAvversi);
			pstmt.setString(1, id_vaccinazione);
			pstmt.setString(2, id_centro);
			pstmt.setString(3, evento);
			pstmt.setInt(4, severita);
			pstmt.setString(5, note);
			pstmt.setString(6, cf);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Metodo che conta e restituisce il numero di segnalazioni effetuate per quel
	 * determinato centro vaccinale.
	 * 
	 * @param nomeCentro Il nome del centro vaccinale.
	 * @return Il numero di segnalazioni effettuate per quel determinato centro
	 *         vaccinale.
	 */
	// query implementata
	@Override
	public int getSegnalazioni(String nomeCentro) {
		String id_cen = getNomeCentro(nomeCentro);
		String qGetNumSegnalazioni = "SELECT count(id_centro) AS count_segnalazioni FROM eventi_avversi WHERE id_centro = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qGetNumSegnalazioni);
			pstmt.setString(1, id_cen);
			rs = pstmt.executeQuery();

			if (rs.next()) {
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
	 * Metodo che calcola e restituisce il valore medio dell'intensita' dell'evento
	 * avverso per quel determinato centro vaccinale.
	 * 
	 * @param id_centro Il nome del centro vaccinale.
	 * @param evento     Il tipo di evento avverso.
	 * @return Il valore medio di quel determinato evento.
	 */
	// query implementata
	@Override
	public double getImportanzaEvento(String id_centro, String evento) {
		String qGetImportanzaEvento = "SELECT avg(severita) AS media_valori FROM Eventi_Avversi WHERE id_centro = ? AND nome_evento = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qGetImportanzaEvento);
			pstmt.setString(1, id_centro);
			pstmt.setString(2, evento);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pstmt.setString(1, id_centro);
				pstmt.setString(2, evento);
				rs = pstmt.executeQuery();
				break;
			}

			while (rs.next()) {
				return rs.getDouble("media_valori");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		System.out.println("passa 0");
		return 0.0;
	}

	/**
	 * Metodo che controlla se sono gia' stati inseriti degli eventi avversi per
	 * quel determinato cittadino registrato.
	 * 
	 * @param id L'Id della vaccinazione.
	 * @return Se sono gia' stati inseriti degli eventi avversi.
	 */
	// query implementata
	public boolean existId(String[] id) {
		String qExistIdInEventiAvversi = "SELECT id_vaccinazione FROM Eventi_Avversi WHERE id_vaccinazione = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistIdInEventiAvversi);
			pstmt.setString(1, id[0]);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		} finally {
			closeConnection(connection);
		}
		return false;
	}

	public String getNomeCentro(String nome_centro) {
		String tmp = null;
		String qCentroPasswordMatch = "SELECT id_centro FROM CentriVaccinali WHERE nome_centro=?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qCentroPasswordMatch);
			pstmt.setString(1, nome_centro);
			rs = pstmt.executeQuery();

			while (rs.next())
				tmp = rs.getString("id_centro");
			System.out.println(tmp);
			return tmp;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return tmp;
		} finally {
			closeConnection(connection);
		}
	}

}
