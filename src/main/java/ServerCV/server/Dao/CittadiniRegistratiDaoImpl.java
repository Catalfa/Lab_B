package ServerCV.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Common.DatiCittadino;
import Common.DatiCittadino;
import Common.InfoCittadino;
import ServerCV.server.Dao.Interfacce.CittadiniRegistratiDao;
import ServerCV.server.Dao.GeneralDao;

/**
 * Nicolo' Ferrari, Mat. 732707, Varese
 * Alessandro Formenti, Mat. 734465, Varese
 * Luigi Mucciarone, Mat. 732714, Varese
 * Luca Alberti, Mat. 733096, Varese
 */

/**
 * Classe contenente le implementazioni delle interfacce di CittadiniRegistratiDAO.
 */
public class CittadiniRegistratiDaoImpl extends GeneralDao implements CittadiniRegistratiDao {
	
	/**
	 * Metodo che inserisce i dati del cittadino nella tabella cittadini_registrati.
	 * @param citizenData	I dati del cittadino che si sta registrando.
	 */
	@Override
	public void insertCittadino(DatiCittadino citizenData) {
		String qAddValuesCittadiniRegistrati = "INSERT INTO cittadini_registrati VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qAddValuesCittadiniRegistrati);
			pstmt.setString(1, citizenData.getNomeCittadino());
			pstmt.setString(2, citizenData.getCognomeCittadino());
			pstmt.setString(3, citizenData.getCFCittadino());
			pstmt.setString(4, citizenData.getEmailCittadino());
			pstmt.setString(5, citizenData.getUsernameCittadino());
			pstmt.setString(6, (citizenData.getPasswordCittadino()).toString());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
	
	/**
	 * Metodo che restituisce le informazioni dei cittadini.
	 * @param cf 	Il CF del cittadino.
	 * @return 		Il nome e cognome del cittadino.
	 */
	@Override
	public DatiCittadino getDatiCittadino(String cf) {
		DatiCittadino datiCittadino = null;
		String qGetInfoCittadini = "SELECT nome, cognome FROM cittadini_registrati WHERE cf = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qGetInfoCittadini);
			pstmt.setString(1, cf);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				datiCittadino = new DatiCittadino(rs.getString("nome"), rs.getString("cognome"), null, null, null, null);
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
	 * Metodo che controlla se la password inserita corrisponde a quella presente sul DB per quel determinato cittadino.
	 * @param username	Lo username del cittadino.
	 * @param password	La password del cittadino.
	 * @return			Se i dati insertiti dal cittadino sono corretti.
	 */
	@Override
	public boolean checkPwCittadino(String username, String password) {
		String qCitizenPasswordMatch = "SELECT userid, password FROM cittadini_registrati WHERE userid = ? AND password = ?";
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

	/**
	 * Metodo che controlla se e' gia' presente un cittadino registtrato con quel determinato username.
	 * @param username		Lo username del cittadino che sta tentando di registrarsi.
	 * @return				Se esiste o meno quel determinato username.
	 */
	@Override
	public boolean existCittadino(String username) {
		String qExistCitizenOnDb = "SELECT userid FROM cittadini_registrati WHERE userid = ?";
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
	 * Metodo che restituisce il CF del cittadino.
	 * @param username	Il nome del cittadino.
	 * @return			Il CF del cittadino.
	 */
	@Override
	public DatiCittadino getCfCittadino(String username) {
		DatiCittadino datiCittadino = null;
		String qGetCitizenCf = "SELECT cf FROM cittadini_registrati WHERE userid = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qGetCitizenCf);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				datiCittadino = new DatiCittadino(null, null, rs.getString("cf"), null, null, null);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return datiCittadino;
	}

	/**
	 * Metodo che controlla se esiste gia' un cittadino registrato con quel CF.
	 * @param cf	Il CF del cittadino che si sta registrando
	 * @return		Se e' gia' presente un cittadino registrato con quel CF.
	 */
	@Override
	public boolean existCfCittadino(String cf) {
		String qExistCfInCittadiniRegistrati = "SELECT cf FROM cittadini_registrati WHERE cf = ?";
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
	 * Metodo che aggiorna il valore dell'ID della vaccinazione per quel determinato cittadino registrato.
	 * @param id	L'ID della vaccinazione.
	 * @param cf	Il CF del cittadino registrato.
	 */
	@Override
	public void updateIdCittadino(int id, String cf) {
		String qUpdateIdVaccinazioneInCittadiniRegistrati = "UPDATE cittadini_registrati SET idvaccinazione = ? WHERE cf = ?";
		PreparedStatement pstmt;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qUpdateIdVaccinazioneInCittadiniRegistrati);
			pstmt.setInt(1, id);
			pstmt.setString(2, cf);
			pstmt.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Metodo che controlla se l'ID della vaccinazione inserito e' gia' stato utilizzato.
	 * @param id	L'ID della vaccinazione.
	 * @return		Se e' gia' stato utilizzato quell'ID.
	 */
	@Override
	public boolean existIdCittadino(int id) {
		String qExistIdInCittadiniRegistrati = "SELECT idvaccinazione FROM cittadini_registrati WHERE idvaccinazione = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistIdInCittadiniRegistrati);
			pstmt.setInt(1, id);
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
	 * Metodo che restituisce l'ID della vaccinazione per quel determinato cittadino.
	 * @param cf	Il CF del cittadino.
	 * @return		L'ID della vaccinazione.
	 */
	@Override
	public int getIdCittadino(String cf) {
		String qGetIdVaccinazioneInCittadiniRegistrati = "SELECT idvaccinazione FROM cittadini_registrati WHERE cf = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qGetIdVaccinazioneInCittadiniRegistrati);
			pstmt.setString(1, cf);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				return rs.getInt("idvaccinazione");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return 0;
	}

	/**
	 * Metodo che conta quanti cittadini sono stati vaccinati.
	 * @return		Il numero di cittadini vaccinati.
	 */
	@Override
	public int countCittadiniVaccinati() {
		String qCountCittadiniVaccinati = "SELECT COUNT(idvaccinazione) AS count_vaccinazioni FROM cittadini_registrati";
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
