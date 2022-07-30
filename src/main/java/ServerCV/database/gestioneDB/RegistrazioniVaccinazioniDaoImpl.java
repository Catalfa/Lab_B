package ServerCV.database.gestioneDB;

import Common.PrenotazioniVaccini;
import ServerCV.database.gestioneDB.interfacceDB.RegistrazioniVaccinazioniDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrazioniVaccinazioniDaoImpl extends GeneralDao implements RegistrazioniVaccinazioniDao {
//discutere della nuova tabella registrazioni_vaccinazioni che non fa parte dell'implementazione iniziale
	/**
	 * Metodo che inserisce i dati dell'utente che si � prenotato per il vaccino.
	 * @param prenotazioneVaccino	I dati del cittadino registrato che si e' prenotato.
	 */
	@Override
	public void insertPrenotazioneVaccinazione(PrenotazioniVaccini prenotazioneVaccino) {
		String qAddPrenotazioniVaccini = "INSERT INTO registrazioni_vaccinazioni VALUES (?, ?, ?)";
		PreparedStatement pstmt;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qAddPrenotazioniVaccini);
			pstmt.setString(1, prenotazioneVaccino.getNomeCentro());
			pstmt.setString(2, prenotazioneVaccino.getCF());
			pstmt.setDate(3, prenotazioneVaccino.getData());
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Metodo che controlla se il Cf inserito e' gia' stato usato per prenotarsi ad una vaccinazione.
	 * @param cf	Il codice fiscale del cittadino registrato.
	 * @return		Se e' gia' stato usato quel Cf per effettuare una registrazione.
	 */
	@Override
	public boolean existCf(String cf) {
		String qExistCfInRegistrazioniVaccinazioni = "SELECT cf FROM registrazioni_vaccinazioni WHERE cf = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistCfInRegistrazioniVaccinazioni);
			pstmt.setString(1, cf);
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

	/**
	 * Metodo che restituisce le informazioni della prenotazione del vaccino di quel determinato cittadino registrato.
	 * @param cf	Il Cf del cittadino registrato.
	 * @return		I dati di prenotazione della vaccinazione del cittadino registrato.
	 */
	@Override
	public PrenotazioniVaccini getInfoPrenotazione(String cf) {
		PrenotazioniVaccini prenotaVaccino = null;
		String qGetInfoPrenotazioneVaccinazione = "SELECT * FROM registrazioni_vaccinazioni WHERE cf = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qGetInfoPrenotazioneVaccinazione);
			pstmt.setString(1, cf);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				prenotaVaccino = new PrenotazioniVaccini(rs.getString("nomecentro"), rs.getString("cf"), rs.getDate("dataprenotazione"));
				return prenotaVaccino;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return prenotaVaccino;
	}
	

}
