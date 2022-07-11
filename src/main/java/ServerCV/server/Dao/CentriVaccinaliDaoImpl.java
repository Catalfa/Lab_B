package ServerCV.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Common.Indirizzo;
import Common.InfoCentriVaccinali;
import Common.RegistraVaccinato;
import ServerCV.server.Utility;
import ServerCV.server.Dao.Interfacce.CentriVaccinaliDao;
import ServerCV.server.Dao.GeneralDao;

/**
 * Nicolo' Ferrari, Mat. 732707, Varese
 * Alessandro Formenti, Mat. 734465, Varese
 * Luigi Mucciarone, Mat. 732714, Varese
 * Luca Alberti, Mat. 733096, Varese
 */

/**
 * Classe contenente le implementazioni delle interfacce di CentriVaccinaliDAO.
 */
public class CentriVaccinaliDaoImpl extends GeneralDao implements CentriVaccinaliDao {
	
	/**
	 * Metodo che inserisce i dati del centro vaccinale nella tabella centri_vaccinali.
	 * @param infoCentroVaccinale	I dati del centro vaccinale.
	 */
	@Override
	public void insertDatiCentroVaccinale(InfoCentriVaccinali infoCentroVaccinale) {
		String qAddValuesCentroVaccinale = "INSERT INTO centri_vaccinali(nomeCentro, indirizzo, tipologia) VALUES (?, ?, ?)";
		PreparedStatement pstmt;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qAddValuesCentroVaccinale);
			pstmt.setString(1, infoCentroVaccinale.getNomeCentro());
			pstmt.setString(2, infoCentroVaccinale.toString());
			pstmt.setString(3, infoCentroVaccinale.getTipologiaCentro());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
	
	/**
	 * Metodo che effettua la ricerca di un centro vaccinale.
	 * @param researchText 	Il testo di ricerca.
	 */
	@Override
	public List<InfoCentriVaccinali> findCentroVaccinale(String researchText) {
		List<InfoCentriVaccinali> list = new ArrayList<>();
		String qResearchQuery = "SELECT nomecentro, indirizzo, tipologia FROM centri_vaccinali WHERE "
				+ "nomecentro LIKE '%" +researchText+ "%' "
				+ "OR indirizzo LIKE '%" +researchText+ "%' "
				+ "OR tipologia LIKE '%" +researchText+ "%'";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qResearchQuery);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				InfoCentriVaccinali tempInfo = convertToInfoCentro(rs);
				list.add(tempInfo);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return list;
	}

	/**
	 * Metodo che controlla se esiste gia' un centro vaccinale con quel nome sul DB.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @return				Se e' gia' esistente un centro con lo stesso nome 
	 */
	@Override
	public boolean existCentroVaccinale(String nomeCentro) {
		String nomeCentroUC = nomeCentro.toUpperCase();
		String inizialeNomeCentroUC = String.valueOf(Utility.getNameForQuery(nomeCentroUC).charAt(0));
		String qExistCenterOnDb = "SELECT nomecentro FROM centri_vaccinali WHERE nomecentro LIKE '" +inizialeNomeCentroUC+ "%' ";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistCenterOnDb);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String nomeCentroOnDB = rs.getString("nomecentro");
				nomeCentroOnDB = Utility.getNameForQuery(nomeCentroOnDB).toUpperCase();
				nomeCentroUC = Utility.getNameForQuery(nomeCentroUC);
				if(nomeCentroUC.equals(nomeCentroOnDB))
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
	 * Metodo che crea la tabella Vaccinati_NomeCentroVaccinale cambiando il nome in maniera dinamica.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 */
	public void createVaccinati_(String nomeCentro) {
		String qCreateVaccinati_NomeCentro = "CREATE TABLE vaccinati_" +nomeCentro+ "("
				+ "nomeCentro varchar, "
				+ "nome varchar, "
				+ "cognome varchar, "
				+ "cf varchar(16), "
				+ "dataVaccinazione DATE, "
				+ "tipoVaccino varchar, "
				+ "idVaccinazione smallint, "
				+ "CONSTRAINT fk_Vaccinati" +nomeCentro+ "_CentriVaccinali "
				+ "FOREIGN KEY(nomeCentro) "
				+ "REFERENCES centri_vaccinali(nomeCentro) ON UPDATE CASCADE ON DELETE NO ACTION)";
		PreparedStatement pstmt;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qCreateVaccinati_NomeCentro);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
	
	/**
	 * Metodo che modifica la tabella Vaccinati_NomeCentroVaccinale impostando una nuova FK.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 */
	public void alterVaccinati_(String nomeCentro) {
		String qAlterVaccinati_NomeCentro = "ALTER TABLE vaccinati_" +nomeCentro+ " "
				+ "ADD FOREIGN KEY(cf) "
				+ "REFERENCES cittadini_registrati(cf) ON UPDATE CASCADE ON DELETE NO ACTION";
		PreparedStatement pstmt;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qAlterVaccinati_NomeCentro);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}



	/**
	 * Metodo che controlla se la password inserita corrisponde a quella presente sul DB per quel determinato Operatore Sanitario.
	 * @param id		L'id dell'Operatore Sanitario.
	 * @param password	La password dell'Operatore Sanitario.
	 * @return			Se i dati inseriti dall'Operatore Sanitario sono corretti.
	 */
	@Override
	public boolean checkPwDoctor(String id, String password) {
		String qDoctorPasswordMatch = "SELECT id, password FROM operatori_sanitari WHERE id = ? AND password = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qDoctorPasswordMatch);
			pstmt.setString(1, id);
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
	 * Metodo che controlla se l'id inserito esiste nel DB.
	 * @param id 	L'id dell'Operatore Sanitario che sta tentando di registrarsi.
	 * @return		Se e' gia' stato utilizzato quel determinato id.
	 */


	/**
	 * Metodo che converte i valori ottenuti dal ResultSet in un dato di tipo InfoCentroVaccinale.	
	 * @param rs	Il ResultSet di una query.
	 * @return		I valori della query sotto forma di informazioni.
	 */
	public InfoCentriVaccinali convertToInfoCentro(ResultSet rs) {
		String nomeCentro = null;
		String indirizzo = null;
		String tipoVaccino = null;
		try {
			nomeCentro = rs.getString("nomecentro");
			indirizzo = rs.getString("indirizzo");
			tipoVaccino = rs.getString("tipologia");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		String [] aux;
		aux=indirizzo.split(", ");
		Indirizzo a=new Indirizzo(aux[0],aux[1], Integer.parseInt(aux[2]), aux[3], aux[4], Integer.parseInt(aux[5]) );

		InfoCentriVaccinali infoCentro = new InfoCentriVaccinali(nomeCentro, a, tipoVaccino);
		return infoCentro;
	}

	
	/**
	 * Metodo che controlla se e' gia' stata effettuata una vaccinazione per quel CF in quel determinato centro vaccinale..
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @param cf			Il Cf del cittadino registrato.
	 * @return				Se e' gia' stata effettuata una vaccinazione in quel centro vaccinale.
	 */
	@Override
	public boolean existCf(String nomeCentro, String cf) {
		String qExistCfInVaccinati_ = "SELECT cf FROM vaccinati_" +Utility.getNameForQuery(nomeCentro).toLowerCase()+ " WHERE cf = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistCfInVaccinati_);
			pstmt.setString(1, cf);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
	 * Metodo che controlla se il cittadino e' stato vaccinato in quel determinato centro vaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @param id			L'ID della vaccinazione.
	 * @return				Se la vaccinazione e' stata effettuata in quel determinato centro vaccinale.
	 */
	@Override
	public boolean existId(String nomeCentro, int id) {
		nomeCentro = Utility.getNameForQuery(nomeCentro).toLowerCase();
		String qExistIdInVaccinati_ = "SELECT idvaccinazione from vaccinati_" +nomeCentro+ " WHERE idvaccinazione = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistIdInVaccinati_);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
	 * Metodo che inserisce i dati del cittadino dopo essere stato vaccinato.
	 * @param registrazioneVaccinato	I dati di prenotazione della vaccinazione del cittadino.
	 */
	@Override
	public void insertVaccinato(RegistraVaccinato registrazioneVaccinato) {
		String nomeCentro = registrazioneVaccinato.getNomeCentro();
		String qAddRegistrazioneVaccinato = "INSERT INTO vaccinati_" +Utility.getNameForQuery(nomeCentro).toLowerCase()+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qAddRegistrazioneVaccinato);
			pstmt.setString(1, registrazioneVaccinato.getNomeCentro());
			pstmt.setString(4, registrazioneVaccinato.getCf());
			pstmt.setDate(5, registrazioneVaccinato.getDataVaccino());
			pstmt.setString(6, registrazioneVaccinato.getTipoVaccino());
			pstmt.setInt(7, registrazioneVaccinato.getIdVaccinazione());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Metodo che conta il numero di centri vaccinali presenti sul DB.
	 * @return		Il numero di centri vaccinali esistenti.
	 */
	@Override
	public int countCentriVaccinali() {
		String qCountCentriVaccinali = "SELECT COUNT(*) AS count_centri FROM centri_vaccinali";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qCountCentriVaccinali);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				return rs.getInt("count_centri");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return 0;
	}
}
