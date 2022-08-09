package ServerCV.database.gestioneDB;

import Common.DatiCittadino;
import ServerCV.database.ConnessioneDB;
import ServerCV.database.gestioneDB.interfacceDB.CittadiniRegistratiDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CittadiniRegistratiDaoImpl extends GeneralDao implements CittadiniRegistratiDao {

	/**
	 * Metodo che inserisce i dati nella tabella cittadini_registrati.
	 * @param citizenData	I dati del cittadino che si sta registrando.
	 */
	//Query funziona
	@Override
	public void insertCittadino(DatiCittadino citizenData) {
		String qAddValuesCittadiniRegistrati = "INSERT INTO Cittadini_Registrati VALUES (?,?,?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qAddValuesCittadiniRegistrati);
			pstmt.setString(1, citizenData.getCFCittadino());
			pstmt.setString(2, citizenData.getNomeCittadino());
			pstmt.setString(3, citizenData.getCognomeCittadino());
			pstmt.setString(4, citizenData.getEmailCittadino());
			pstmt.setString(5, citizenData.getUsernameCittadino());
			pstmt.setString(6, citizenData.getPasswordCittadino());
			pstmt.setString(7,citizenData.getIdvaccinazione());
			pstmt.setString(8,citizenData.getIdcentro());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
	
	/**
	 * Metodo che restituisce le informazioni dei cittadini.
	 * @param cf 	Il codice fiscale del cittadino.
	 * @return 		Il nome e cognome del cittadino.
	 */
	//Query funziona
	@Override
	public DatiCittadino getDatiCittadino(String cf) {
		DatiCittadino datiCittadino = null;
		String qGetInfoCittadini = "SELECT nome, cognome FROM Cittadini_Registrati WHERE cf = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection =openConnection();
			pstmt = connection.prepareStatement(qGetInfoCittadini);
			pstmt.setString(1, cf);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				datiCittadino = new DatiCittadino(rs.getString("nome"), rs.getString("cognome"), null, null, null, null, null, null);
				return datiCittadino;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return datiCittadino;
	}
	
	/**
	 * Metodo che controlla se la password inserita corrisponde a quella presente sul Db per quel determinato cittadino.
	 * @param username	L'username del cittadino registrato.
	 * @param password	La password del cittadino registrato.
	 * @return			Se la password dell'utente registrato e' corretta.
	 */
	//query implementata
	@Override
	public boolean checkPwCittadino(String username, String password) {
		String qCitizenPasswordMatch = "SELECT userid, password FROM Cittadini_Registrati WHERE userid = ? AND password = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qCitizenPasswordMatch);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			while(rs.next())
				return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return false;
	}

	//query implementata
	@Override
	public boolean existCittadino(String username) {
		String qExistCitizenOnDb = "SELECT userid FROM Cittadini_Registrati WHERE userid = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistCitizenOnDb);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			while(rs.next())
				return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return false;
	}

	/**
	 * Metodo che restituisce il Cf del cittadino.
	 * @param username	Il nome del cittadino registrato.
	 * @return			Il Cf del cittadino registrato.
	 */
	//query funziona
	@Override
	public DatiCittadino getCfCittadino(String username) {
		DatiCittadino datiCittadino = null;
		String qGetCitizenCf = "SELECT cf FROM Cittadini_Registrati WHERE userid = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qGetCitizenCf);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				datiCittadino = new DatiCittadino(null, null, rs.getString("cf"), null, null, null, null, null);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return datiCittadino;
	}

	/**
	 * Metodo che controlla se esiste gia' un cittadino registrato con quel Cf.
	 * @param cf	Il Cf del cittadino che si sta registrando
	 * @return		Se e' gia' presente un cittadino registrato con quel Cf.
	 */
	//query implementata
	@Override
	public boolean existCfCittadino(String cf) {
		String qExistCfInCittadiniRegistrati = "SELECT cf FROM Cittadini_Registrati WHERE cf = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistCfInCittadiniRegistrati);
			pstmt.setString(1, cf);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
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
	 * Metodo che aggiorna il valore dell'Id vaccinazione per quel determinato cittadino registrato.
	 * @param id	L'Id della vaccinazione.
	 * @param cf	Il Cf del cittadino registrato.
	 */
	//query funziona, però Rondo devi cambiare il tipo dell'id da int a String nella classe GestioneClient che si trova nel package server
	@Override
	public void updateIdCittadino(int id, String cf) {
		String id1=String.valueOf(id);
		String qUpdateIdVaccinazioneInCittadiniRegistrati = "UPDATE Cittadini_Registrati SET idvaccinazione = ? WHERE cf = ?";
		PreparedStatement pstmt;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qUpdateIdVaccinazioneInCittadiniRegistrati);
			pstmt.setString(1, id1);
			pstmt.setString(2, cf);
			pstmt.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Metodo che controlla se l'Id vaccinazione inserito e' gia' stato utilizzato.
	 * @param id	L'Id della vaccinazione.
	 * @return		Se e' gia' stato utilizzato quell'Id.
	 */
	//query funziona; però c'è lostesso discorso fatto prima sempre per quanto rigurada l'id
	@Override
	public boolean existIdCittadino(int id) {
		String id1=String.valueOf(id);
		String qExistIdInCittadiniRegistrati = "SELECT idvaccinazione FROM Cittadini_Registrati WHERE idvaccinazione = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistIdInCittadiniRegistrati);
			pstmt.setString(1, id1);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
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
	 * Metodo che restituisce l'Id vaccinazione per quel determinato cittadino registrato.
	 * @param cf	Il Cf del cittadino registrato.
	 * @return		L'Id della vaccinazione.
	 */
	//query funziona. Rondo devi modificare il metodo 'gestControlloPreRegistrazioneEventoAvverso' che si trova sempre in GestioneClient
	@Override
	public int getIdCittadino(String cf) {
		String qGetIdVaccinazioneInCittadiniRegistrati = "SELECT idvaccinazione FROM Cittadini_Registrati WHERE cf = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qGetIdVaccinazioneInCittadiniRegistrati);
			pstmt.setString(1, cf);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
					String id=rs.getString("idvaccinazione");
				return Integer.valueOf(id);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return 0;
	}

	//query modificata e funzionante
	@Override
	public int countCittadiniVaccinati() {
		String qCountCittadiniVaccinati = "SELECT COUNT(idvaccinazione) AS count_vaccinazioni FROM Cittadini_Registrati WHERE (idvaccinazione IS NOT NULL)";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qCountCittadiniVaccinati);
			rs = pstmt.executeQuery();
			
			while(rs.next())
				return rs.getInt("count_vaccinazioni");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return 0;
	}
	

}
