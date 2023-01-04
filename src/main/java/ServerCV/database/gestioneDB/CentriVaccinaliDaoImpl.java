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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Classe oggetto per la gestione delle query dei centri vaccinali registrati.
 */

public class CentriVaccinaliDaoImpl extends GeneralDao implements CentriVaccinaliDao {

	/**
	 * Metodo che inserisce i dati nella tabella centri_vaccinali.
	 * 
	 * @param infoCentroVaccinale I dati del centro vaccinale.
	 */

	@Override
	public void insertDatiCentroVaccinale(InfoCentriVaccinali infoCentroVaccinale) {
		String qAddValuesCentroVaccinale = "INSERT INTO CentriVaccinali(id_centro, nome_centro,tipologia,qualificatore, nome_via,num_civ, comune, provincia, cap, username, password ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qAddValuesCentroVaccinale);
			pstmt.setString(1, infoCentroVaccinale.getIdCentro().toLowerCase());
			pstmt.setString(2, infoCentroVaccinale.getNomeCentro().toLowerCase());
			pstmt.setString(3, infoCentroVaccinale.getTipologia().toLowerCase());
			pstmt.setString(4, infoCentroVaccinale.getQualificatore().toLowerCase());
			pstmt.setString(5, infoCentroVaccinale.getNomeVia().toLowerCase());
			pstmt.setString(6, ((Integer) infoCentroVaccinale.getNumCiv()).toString());
			pstmt.setString(7, infoCentroVaccinale.getComune().toLowerCase());
			pstmt.setString(8, infoCentroVaccinale.getProvincia().toLowerCase());
			pstmt.setInt(9, infoCentroVaccinale.getCap());
			pstmt.setString(10, infoCentroVaccinale.getUsername().toLowerCase());
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
	 * 
	 * @param researchText Il testo scritto dall'utente.
	 * @return Lista centri trovati in base alla ricerca
	 */
	@Override
	public List<InfoCentriVaccinali> findCentroVaccinale(String researchText) {
		List<InfoCentriVaccinali> list = new ArrayList<>();
		/*
		 * String qResearchQuery = "SELECT * FROM CentriVaccinali WHERE "
		 * + "nome_centro LIKE '%" +researchText+ "%' "
		 * + "OR comune LIKE '%" +researchText+ "%' "
		 * + "OR tipologia LIKE '%" +researchText+ "%'";
		 */
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;
		String query2 = "SELECT * FROM CentriVaccinali WHERE nome_centro=? OR comune=? OR tipologia=? ";

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(query2);
			pstmt.setString(1, researchText.toLowerCase());
			pstmt.setString(2, researchText.toLowerCase());
			pstmt.setString(3, researchText.toLowerCase());
			rs = pstmt.executeQuery();

			while (rs.next()) {
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
	 * Metodo che controlla se esiste gi� un centro vaccinale con quel nome sul
	 * Db.
	 * 
	 * @param nomeCentro Il nome del centro vaccinale.
	 * @return Se e' gia' esistente un centro con lo stesso nome
	 */

	@Override
	public Boolean existCentroVaccinale(String nomeCentro) {
		String qExistCenterOnDb = "SELECT nome_centro FROM CentriVaccinali WHERE nome_centro = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistCenterOnDb);
			pstmt.setString(1, nomeCentro.toLowerCase());
			rs = pstmt.executeQuery();

			while (rs.next())
				return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return false;
	}

	/**
	 * Metodo che controlla se esiste un centro vaccinale con quel nome nel DB.
	 *
	 * @param username Lo username del centro vaccinale.
	 * @return Se è già esistente un centro con lo stesso username
	 */

	public Boolean existCentro(String username) {
		String qExistCitizenOnDb = "SELECT nome_centro FROM CentriVaccinali WHERE username = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistCitizenOnDb);
			pstmt.setString(1, username.toLowerCase());
			rs = pstmt.executeQuery();

			while (rs.next())
				return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return false;
	}

	/**
	 * Metodo per controllare se esiste già un centro con lo stesso username nel DB.
	 *
	 * @param username Lo username del centro vaccinale.
	 * @return Se è già esistente un centro con lo stesso username
	 */

	public Boolean existUser(String username) {
		String qExistCenterOnDb = "SELECT username FROM CentriVaccinali WHERE username = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistCenterOnDb);
			pstmt.setString(1, username.toLowerCase());
			rs = pstmt.executeQuery();

			while (rs.next())
				return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return false;
	}

	/**
	 * Metodo usato per controllare il login del centro
	 * verifica se esiste già un centro con quello username e password nel DB.
	 *
	 * @param username Lo username del centro vaccinale.
	 * @param password La password del centro vaccinale.
	 * @return Se esiste già un centro con quello username e quella passowrd nel DB
	 */
	public Boolean checkLoginCentro(String username, String password) {
		String qCentroPasswordMatch = "SELECT username, password FROM CentriVaccinali WHERE username = ? AND password = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qCentroPasswordMatch);
			pstmt.setString(1, username.toLowerCase());
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			while (rs.next())
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
	 * 
	 * @param nomeCentro Il nome del centro vaccinale.
	 */

	public void createVaccinati_(String nomeCentro) {
		String centro = accorpamento(nomeCentro);
		Connection conn = openConnection();
		new CreazioneTabelle().Create_Vaccinato(conn, centro);
		closeConnection(conn);
	}

	/**
	 * Metodo che converte i valori ottenuti dal ResultSet in un dato di tipo
	 * InfoCentroVaccinale
	 * utilizzato nella ricerca di un centro vaccinale nel metodo
	 * findCentroVaccinale
	 * .
	 * 
	 * @param rs Il ResultSet di una query.
	 * @return I valori della query sotto forma di informazioni.
	 */

	public InfoCentriVaccinali convertToInfoCentro(ResultSet rs) {
		String nome_centro = null;
		String tipologia = null;
		String qualificatore = null;
		String nomevia = null;
		int numciv = 0;
		String comune = null;
		String provincia = null;
		int cap = 0;
		String idcentro = null;
		try {
			nome_centro = rs.getString("nome_centro");
			tipologia = rs.getString("tipologia");
			qualificatore = rs.getString("qualificatore");
			nomevia = rs.getString("nome_via");
			numciv = rs.getInt("num_civ");
			comune = rs.getString("comune");
			provincia = rs.getString("provincia");
			cap = rs.getInt("cap");
			idcentro = rs.getString("id_centro");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		InfoCentriVaccinali infoCentro = new InfoCentriVaccinali(idcentro, nome_centro, tipologia, qualificatore,
				nomevia, numciv, comune, provincia, cap);
		return infoCentro;
	}

	/**
	 * Metodo che controlla se e' già stata effettuata una vaccinazione per quel Cf
	 * in quel determinato centro vaccinale..
	 * 
	 * @param nomeCentro Il nome del centro vaccinale.
	 * @param cf         Il Cf del cittadino registrato.
	 * @return Se e' gia' stata effettuata una vaccinazione in quel centro
	 *         vaccinale.
	 */

	@Override
	public Boolean existCf(String nomeCentro, String cf) {
		String centro = accorpamento(nomeCentro);
		String qExistCfInVaccinati_ = "SELECT cf FROM Vaccinati_" + Utility.getNameForQuery(centro).toLowerCase()
				+ " WHERE cf = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistCfInVaccinati_);
			pstmt.setString(1, cf.toUpperCase());
			rs = pstmt.executeQuery();

			if (rs.next()) {
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
	 * Metodo che controlla se è presente un centro con quell'id.
	 *
	 * @param id_centro L'id del centro vaccinale.
	 * @return Il nome del centro vaccinale con quel determinato id
	 */

	public String getNomeCentro(String id_centro) {
		String tmp = null;
		String qCentroPasswordMatch = "SELECT nome_centro FROM CentriVaccinali WHERE id_centro=?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qCentroPasswordMatch);
			pstmt.setString(1, id_centro.toLowerCase());
			rs = pstmt.executeQuery();

			while (rs.next())
				tmp = rs.getString("nome_centro");
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
	 * Metodo che controlla se il cittadino registrato e' stato vaccinato in quel
	 * determinato centro vaccinale.
	 * 
	 * @param nomeCentro Il nome del centro vaccinale.
	 * @param id         L'Id della vaccinazione.
	 * @return Se la vaccinazione e' stata effettuata in quel determinato centro
	 *         vaccinale.
	 */

	@Override
	public Boolean existIdVaccinazione(String nomeCentro, String id) {
		String centro = getNomeCentro(nomeCentro);
		createVaccinati_(centro);
		centro = accorpamento(centro);
		String qExistIdInVaccinati_ = "SELECT idvaccinazione from Vaccinati_" + centro + " WHERE idvaccinazione = ?";
		PreparedStatement pstmt;
		ResultSet rs;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qExistIdInVaccinati_);
			pstmt.setString(1, id.toLowerCase());
			rs = pstmt.executeQuery();

			if (rs.next()) {
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
	 * Metodo che inserisce i dati inseriti dal cittadino registrato in fase di
	 * prenotazione dopo essere stato vaccinato.
	 * 
	 * @param registrazioneVaccinato I dati di prenotazione della vaccinazione del
	 *                               cittadino registrato.
	 */

	@Override
	// TODO metodo da sistemare per far sì che si possa registrare un vaccinato e
	// che questo possa successivamente inserire un evento avveso
	public void insertVaccinato(RegistrazioniVaccinati registrazioneVaccinato) {
		String nomeCentro = registrazioneVaccinato.getnomeCentro();
		String aux = nomeCentro.toLowerCase();
		String trimmedString = aux.trim();
		String nome = trimmedString.replaceAll("\\s", "");
		String qAddRegistrazioneVaccinato = "INSERT INTO Vaccinati_" + Utility.getNameForQuery(nome).toLowerCase()
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		Connection connection = null;

		try {
			connection = openConnection();
			pstmt = connection.prepareStatement(qAddRegistrazioneVaccinato);
			pstmt.setString(1, registrazioneVaccinato.getCf().toUpperCase());
			pstmt.setString(2, registrazioneVaccinato.getNomeVaccinato().toLowerCase());
			pstmt.setString(3, registrazioneVaccinato.getCognomeVaccinato().toLowerCase());
			pstmt.setString(4, registrazioneVaccinato.getDataVaccino());
			pstmt.setString(5, registrazioneVaccinato.getTipoVaccino().toLowerCase());
			pstmt.setString(6, registrazioneVaccinato.getIdVaccinazione().toLowerCase());
			pstmt.setString(7, registrazioneVaccinato.getIdCentro().toLowerCase());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * Metodo che conta il numero di centri vaccinali nel DB.
	 *
	 * @return Il numero di centri vaccinali
	 */
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

			while (rs.next()) {
				return rs.getInt("count_centri");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return 0;
	}

	/**
	 * Metodo che toglie lo spazio da un nome centro composto
	 * @param centro Nome del centro.
	 * @return Una stringa contenente il nome del centro vaccinale senza spazi.
	 */

	public static String accorpamento(String centro) {
		String tmp = "";

		for (int i = 0; i < centro.length(); i++) {
			char ch = centro.charAt(i);
			if (ch == ' ') {

			} else {
				tmp = tmp + ch;

			}
		}

		return tmp.toLowerCase();
	}
}
