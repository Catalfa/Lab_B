package ServerCV.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ServerCV.server.Dao.GeneralDao;
import ServerCV.server.Dao.Interfacce.RegistrazioniVaccinazioniDao;

/**
 * Nicolo' Ferrari, Mat. 732707, Varese
 * Alessandro Formenti, Mat. 734465, Varese
 * Luigi Mucciarone, Mat. 732714, Varese
 * Luca Alberti, Mat. 733096, Varese
 */

/**
 * Classe contenente le implementazioni delle interfacce di RegistrazioniVaccinazioniDAO.
 */
public class RegistrazioniVaccinazioniDaoImpl extends GeneralDao implements RegistrazioniVaccinazioniDao {


	/**
	 * Metodo che controlla se il CF inserito e' gia' stato usato per prenotarsi ad una vaccinazione.
	 * @param cf	Il CF del cittadino registrato.
	 * @return		Se e' gia' stato usato quel CF per effettuare una registrazione.
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

	

}