package ServerCV.database.gestioneDB;

import Common.InfoCentriVaccinali;
import Common.RegistrazioniVaccinati;
import ServerCV.database.CreazioneTabelle;
import ServerCV.database.gestioneDB.interfacceDB.CentriVaccinaliDao;
import ServerCV.server.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CentriVaccinaliDaoImpl extends GeneralDao implements CentriVaccinaliDao {
	
	/**
	 * Metodo che inserisce i dati nella tabella centri_vaccinali.
	 * @param infoCentroVaccinale	I dati del centro vaccinale.
	 */
	//Devo controllare se metodo funziona su DB, query già implementata ma ancora da provare
	@Override
	public void insertDatiCentroVaccinale(InfoCentriVaccinali infoCentroVaccinale) {
		String qAddValuesCentroVaccinale = "INSERT INTO CentriVaccinali(id_centro, nome_centro,tipologia,qualificatore, nome_via,num_civ, comune, provincia, cap, username, password ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qAddValuesCentroVaccinale);
			pstmt.setString(1, infoCentroVaccinale.getIdCentro());
			pstmt.setString(2, infoCentroVaccinale.getNomeCentro());
			pstmt.setString(3, infoCentroVaccinale.getTipologia().toLowerCase());
			pstmt.setString(4, infoCentroVaccinale.getQualificatore());
			pstmt.setString(5, infoCentroVaccinale.getNomeVia());
			pstmt.setString(6, ((Integer)infoCentroVaccinale.getNumCiv()).toString());
			pstmt.setString(7, infoCentroVaccinale.getComune());
			pstmt.setString(8, infoCentroVaccinale.getProvincia());
			pstmt.setInt(9, infoCentroVaccinale.getCap());
			pstmt.setString(10, infoCentroVaccinale.getUsername());
			pstmt.setString(11, infoCentroVaccinale.getPassword());
			pstmt.executeUpdate();
			createVaccinati_(infoCentroVaccinale.getNomeCentro());
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
	//query implementata
	@Override
	public List<InfoCentriVaccinali> findCentroVaccinale(String researchText) {
		List<InfoCentriVaccinali> list = new ArrayList<>();
		/*
		String qResearchQuery = "SELECT * FROM CentriVaccinali WHERE "
				+ "nome_centro LIKE '%" +researchText+ "%' "
				+ "OR comune LIKE '%" +researchText+ "%' "
				+ "OR tipologia LIKE '%" +researchText+ "%'";
*/
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		String query2="SELECT * FROM CentriVaccinali WHERE nome_centro=? OR comune=? OR tipologia=? ";

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(query2);
			pstmt.setString(1,researchText);
			pstmt.setString(2,researchText);
			pstmt.setString(3,researchText);
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
	//query implementata
	@Override
	public Boolean existCentroVaccinale(String nomeCentro) {
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
	//query implementata
	public Boolean existCentro(String username) {
		String qExistCitizenOnDb = "SELECT nome_centro FROM CentriVaccinali WHERE username = ?";
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

	//metodo per controllare che lo user del centro sia corretto
	public Boolean existUser(String username){
		String qExistCenterOnDb = "SELECT username FROM CentriVaccinali WHERE username = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistCenterOnDb);
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

	//query implementata
	public Boolean checkLoginCentro(String username, String password) {
		String qCentroPasswordMatch = "SELECT username, password FROM CentriVaccinali WHERE username = ? AND password = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qCentroPasswordMatch);
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
	 * Metodo che crea la tabella Vaccinati_NomeCentroVaccinale in maniera dinamica.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 */
	//query NON implementata, bisogna capire quando chiamarla
	public void createVaccinati_(String nomeCentro) {
		String centro=accorpamento(nomeCentro);
		Connection conn=openConnection();
		new CreazioneTabelle().Create_Vaccinato(conn, centro);
		closeConnection(conn);
	}
	
	/**
	 * Metodo che converte i valori ottenuti dal ResultSet in un dato di tipo InfoCentroVaccinale
	 * utilizzato nella ricerca di un centro vaccinale nel metodo findCentroVaccinale
	 * .
	 * @param rs	Il ResultSet di una query.
	 * @return		I valori della query sotto forma di informazioni.
	 */
	//query implementata
	public InfoCentriVaccinali convertToInfoCentro(ResultSet rs) {
		String nome_centro=null;
		String tipologia=null;
		String qualificatore=null;
		String nomevia=null;
		int numciv=0;
		String comune=null;
		String provincia=null;
		int cap=0;
		String idcentro=null;
		try {
			nome_centro = rs.getString("nome_centro");
			tipologia = rs.getString("tipologia");
			qualificatore = rs.getString("qualificatore");
			nomevia=rs.getString("nome_via");
			numciv=rs.getInt("num_civ");
			comune=rs.getString("comune");
			provincia=rs.getString("provincia");
			cap=rs.getInt("cap");
			idcentro=rs.getString("id_centro");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		InfoCentriVaccinali infoCentro = new InfoCentriVaccinali(idcentro,nome_centro,tipologia,qualificatore,nomevia,numciv,comune,provincia,cap);
		return infoCentro;}

	/**
	 * Metodo che controlla se e' gi� stata effettuata una vaccinazione per quel Cf in quel determinato centro vaccinale..
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @param cf			Il Cf del cittadino registrato.
	 * @return				Se e' gia' stata effettuata una vaccinazione in quel centro vaccinale.
	 */
	//Devo verificare che metodo funzioni su DB, ma già implementata
	@Override
	public Boolean existCf(String nomeCentro, String cf) {
		String centro=accorpamento(nomeCentro);
		String qExistCfInVaccinati_ = "SELECT cf FROM Vaccinati_" +Utility.getNameForQuery(centro).toLowerCase()+ " WHERE cf = ?";
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

	public String getNomeCentro(String id_centro){
		String tmp=null;
		String qCentroPasswordMatch = "SELECT nome_centro FROM CentriVaccinali WHERE id_centro=?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qCentroPasswordMatch);
			pstmt.setString(1, id_centro);
			rs = pstmt.executeQuery();

			while(rs.next())
				tmp =rs.getString("nome_centro");
			System.out.println(tmp);
				return tmp;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return tmp;
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Metodo che controlla se il cittadino registrato e' stato vaccinato in quel determinato centro vaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @param id			L'Id della vaccinazione.
	 * @return				Se la vaccinazione e' stata effettuata in quel determinato centro vaccinale.
	 */
	//query implementata
	@Override
	public Boolean existIdVaccinazione(String nomeCentro, String id) {
		String centro=getNomeCentro(nomeCentro);
		System.out.println(centro);
		createVaccinati_(centro);
		centro=accorpamento(centro);
		String qExistIdInVaccinati_ = "SELECT idvaccinazione from Vaccinati_" +centro+ " WHERE idvaccinazione = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistIdInVaccinati_);
			pstmt.setString(1, id);
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
	//Non verificato che moto sia funzionante su DB, ma già implementata
	@Override

	//TODO metodo da sistemare per far sì che si possa registrare un vaccinato e che questo possa successivamente inserire un evento avveso
	public void insertVaccinato(RegistrazioniVaccinati registrazioneVaccinato) {
		String nomeCentro = registrazioneVaccinato.getnomeCentro();
		String aux=nomeCentro.toLowerCase();
        String trimmedString = aux.trim();
        String nome = trimmedString.replaceAll("\\s", "");
		String qAddRegistrazioneVaccinato = "INSERT INTO Vaccinati_" +Utility.getNameForQuery(nome).toLowerCase()+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		Connection connection = null;
		
		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qAddRegistrazioneVaccinato);
			pstmt.setString(1, registrazioneVaccinato.getCf());
			pstmt.setString(2, registrazioneVaccinato.getNomeVaccinato());
			pstmt.setString(3, registrazioneVaccinato.getCognomeVaccinato());
			pstmt.setString(4, registrazioneVaccinato.getDataVaccino());
			pstmt.setString(5, registrazioneVaccinato.getTipoVaccino());
			pstmt.setString(6, registrazioneVaccinato.getIdVaccinazione());
			pstmt.setString(7, registrazioneVaccinato.getIdCentro());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	//Query implementata
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

	//metodo che viene usato per ridurre il nome del centro in un'unica stringa compatta (usata solo per i metodi del vaccinato)
	public static String accorpamento(String centro){
		String tmp="";
		String fin="";

		for(int i=0;i<centro.length();i++){
			char ch=centro.charAt(i);
			if(ch==' '){
				tmp=tmp;
			}
			else {
				tmp = tmp + ch;

			}
		}


		return tmp.toLowerCase();
	}
}
