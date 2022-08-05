package ServerCV.database.gestioneDB;

import Common.InfoCentriVaccinali;
import Common.RegistrazioniVaccinati;
import ServerCV.database.gestioneDB.interfacceDB.CentriVaccinaliDao;
import ServerCV.server.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CentriVaccinaliDaoImpl extends GeneralDao implements CentriVaccinaliDao {
	
	/**
	 * Metodo che inserisce i dati nella tabella centri_vaccinali.
	 * @param infoCentroVaccinale	I dati del centro vaccinale.
	 */
	//Devo controllare se metodo funziona su DB
	@Override
	public void insertDatiCentroVaccinale(InfoCentriVaccinali infoCentroVaccinale) {
		String qAddValuesCentroVaccinale = "INSERT INTO CentriVaccinali(id_centro, nome_centro,tipologia,qualificatore, nome_via,num_civ, comune, provincia, cap ) VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qAddValuesCentroVaccinale);
			pstmt.setString(1, infoCentroVaccinale.getIdCentro());
			pstmt.setString(2, infoCentroVaccinale.getNomeCentro());
			pstmt.setString(3, infoCentroVaccinale.getTipologia());
			pstmt.setString(4, infoCentroVaccinale.getQualificatore());
			pstmt.setString(5, infoCentroVaccinale.getNomeVia());
			pstmt.setString(6, ((Integer)infoCentroVaccinale.getNumCiv()).toString());
			pstmt.setString(7, infoCentroVaccinale.getComune());
			pstmt.setString(8, infoCentroVaccinale.getProvincia());
			pstmt.setString(9, ((Integer)infoCentroVaccinale.getCap()).toString());

			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
	
	/**
	 * Metodo che effettua una ricerca del centro vaccinale.
	 * @param researchText 	Il testo scritto dall'utente.
	 */
	//aggiornato query con dati corretti
	// Per l'indirizzo è lo stesso discorso fatto prima
	@Override
	public List<InfoCentriVaccinali> findCentroVaccinale(String researchText) {
		List<InfoCentriVaccinali> list = new ArrayList<>();
		String qResearchQuery = "SELECT nome_centro, nome_via, tipologia FROM CentriVaccinali WHERE "
				+ "nome_centro LIKE '%" +researchText+ "%' "
				+ "OR nome_via LIKE '%" +researchText+ "%' "
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
	 * Metodo che controlla se il esiste gi� un centro vaccinale con quel nome sul Db.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @return				Se e' gia' esistente un centro con lo stesso nome 
	 */
	//query funziona
	@Override
	public boolean existCentroVaccinale(String nomeCentro) {
		String qExistCenterOnDb = "SELECT nome_centro FROM CentriVaccinali WHERE nome_centro = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistCenterOnDb);
			pstmt.setString(1, nomeCentro);
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
	 * Metodo che crea la tabella Vaccinati_NomeCentroVaccinale in maniera dinamica.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 */
	//Segnalo che manca la definizione della PK, io userei cf e dataVaccinazione come PK
	//non modificato perchè necessito di chiarimenti su questa tabella
	public void createVaccinati_(String nomeCentro) {
		String qCreateVaccinati_NomeCentro = "CREATE TABLE Vaccinati_" +nomeCentro+ "("
				+ "nomeCentro varchar, "
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
	//Devo verificare che motodo sia funzionante su DB
	public void alterVaccinati_(String nomeCentro) {
		String qAlterVaccinati_NomeCentro = "ALTER TABLE Vaccinati_" +nomeCentro+ " "
				+ "ADD FOREIGN KEY(cf) "
				+ "REFERENCES Cittadini_Registrati(cf) ON UPDATE CASCADE ON DELETE NO ACTION";
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
	 * Metodo che converte i valori ottenuti dal ResultSet in un dato di tipo InfoCentroVaccinale.	
	 * @param rs	Il ResultSet di una query.
	 * @return		I valori della query sotto forma di informazioni.
	 */
	public InfoCentriVaccinali convertToInfoCentro(ResultSet rs) {
		String nomeCentro = null;
		String psw = null;
		try {
			nomeCentro = rs.getString("nomecentro");
			psw = rs.getString("password");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		//TODO controllare costruttore classe infoCentriVaccinali
		//InfoCentriVaccinali infoCentro = new InfoCentriVaccinali();
		InfoCentriVaccinali infoCentro =null;
		return infoCentro;
	}

	
	/**
	 * Metodo che controlla se e' gi� stata effettuata una vaccinazione per quel Cf in quel determinato centro vaccinale..
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @param cf			Il Cf del cittadino registrato.
	 * @return				Se e' gia' stata effettuata una vaccinazione in quel centro vaccinale.
	 */
	//Devo verificare che mtodo funzioni su DB
	@Override
	public boolean existCf(String nomeCentro, String cf) {
		String qExistCfInVaccinati_ = "SELECT cf FROM Vaccinati_" +Utility.getNameForQuery(nomeCentro).toLowerCase()+ " WHERE cf = ?";
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
	 * Metodo che controlla se il cittadino registrato e' stato vaccinato in quel determinato centro vaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @param id			L'Id della vaccinazione.
	 * @return				Se la vaccinazione e' stata effettuata in quel determinato centro vaccinale.
	 */
	//aggiornato query con dati corretti
	@Override
	public boolean existId(String nomeCentro, int id) {
		String qExistIdInVaccinati_ = "SELECT idvaccinazione from Vaccinati_" +nomeCentro+ " WHERE idvaccinazione = ?";
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
	 * Metodo che inserisce i dati inseriti dal cittadino registrato in fase di prenotazione dopo essere stato vaccinato.
	 * @param registrazioneVaccinato	I dati di prenotazione della vaccinazione del cittadino registrato.
	 */
	//Sistemato metodo, tranne piccolo detttaglio da discutere con rondo
	//Non verificato che moto sia funzionante su DB
	@Override
	public void insertVaccinato(RegistrazioniVaccinati registrazioneVaccinato) {
		String nomeCentro = registrazioneVaccinato.getnomeCentro();
		String qAddRegistrazioneVaccinato = "INSERT INTO Vaccinati_" +Utility.getNameForQuery(nomeCentro).toLowerCase()+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qAddRegistrazioneVaccinato);
			pstmt.setString(1, registrazioneVaccinato.getCf());
			pstmt.setString(2, registrazioneVaccinato.getNomeVaccinato());
			pstmt.setString(3, registrazioneVaccinato.getCognomeVaccinato());
			pstmt.setDate(4, registrazioneVaccinato.getDataVaccino());
			pstmt.setString(5, registrazioneVaccinato.getTipoVaccino());
			pstmt.setInt(6, registrazioneVaccinato.getIdVaccinazione());
			pstmt.setString(7, registrazioneVaccinato.getIdCentro());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	//Query funziona
	@Override
	public int countCentriVaccinali() {
		String qCountCentriVaccinali = "SELECT COUNT(*) AS count_centri FROM CentriVaccinali";
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
