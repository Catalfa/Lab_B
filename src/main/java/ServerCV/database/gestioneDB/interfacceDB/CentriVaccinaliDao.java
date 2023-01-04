package ServerCV.database.gestioneDB.interfacceDB;

import Common.InfoCentriVaccinali;
import Common.RegistrazioniVaccinati;

import java.sql.ResultSet;
import java.util.List;

/**
 * Interfaccia per i centri vaccinali.
 */

public interface CentriVaccinaliDao {

	/**
	 * Metodo che inserisce i dati nella tabella centri_vaccinali.
	 * @param infoCentroVaccinale I dati del centro vaccinale.
	 */
	public void insertDatiCentroVaccinale(InfoCentriVaccinali infoCentroVaccinale);

	/**
	 * Metodo che effettua una ricerca del centro vaccinale.
	 * @param researchText Il testo scritto dall'utente.
	 * @return Lista centri trovati in base alla ricerca
	 */
	public List<InfoCentriVaccinali> findCentroVaccinale(String researchText);

	/**
	 * Metodo che controlla se esiste gi� un centro vaccinale con quel nome sul
	 * DB.
	 * @param nomeCentro Il nome del centro vaccinale.
	 * @return Se e' gia' esistente un centro con lo stesso nome
	 */
	public Boolean existCentroVaccinale(String nomeCentro);

	/**
	 * Metodo che controlla se esiste un centro vaccinale con quel nome nel DB.
	 * @param username Lo username del centro vaccinale.
	 * @return Se è già esistente un centro con lo stesso username
	 */
	public Boolean existCentro(String username);

	/**
	 * Metodo usato per controllare il login del centro
	 * verifica se esiste già un centro con quello username e password nel DB.
	 * @param username Lo username del centro vaccinale.
	 * @param password La password del centro vaccinale.
	 * @return Se esiste già un centro con quello username e quella passowrd nel DB
	 */
	public Boolean checkLoginCentro(String username, String password);

	/**
	 * Metodo che crea la tabella Vaccinati_NomeCentroVaccinale in maniera dinamica.
	 * @param nomeCentro Il nome del centro vaccinale.
	 */
	public void createVaccinati_(String nomeCentro);
	//public void alterVaccinati_(String nomeCentro);

	/**
	 * Metodo che converte i valori ottenuti dal ResultSet in un dato di tipo
	 * InfoCentroVaccinale
	 * utilizzato nella ricerca di un centro vaccinale nel metodo
	 * findCentroVaccinale
	 * .
	 * @param rs Il ResultSet di una query.
	 * @return I valori della query sotto forma di informazioni.
	 */
	public InfoCentriVaccinali convertToInfoCentro(ResultSet rs);

	/**
	 * Metodo che controlla se e' già stata effettuata una vaccinazione per quel Cf
	 * in quel determinato centro vaccinale.
	 * @param nomeCentro Il nome del centro vaccinale.
	 * @param cf  Il Cf del cittadino registrato.
	 * @return Se e' gia' stata effettuata una vaccinazione in quel centro
	 * vaccinale
	 */
	public Boolean existCf(String nomeCentro, String cf);

	/**
	 * Metodo che controlla se il cittadino registrato e' stato vaccinato in quel
	 * determinato centro vaccinale.
	 * @param nomeCentro Il nome del centro vaccinale.
	 * @param id L'Id della vaccinazione.
	 * @return Se la vaccinazione e' stata effettuata in quel determinato centro
	 * vaccinale.
	 */
	public Boolean existIdVaccinazione(String nomeCentro, String id);

	/**
	 * Metodo che inserisce i dati inseriti dal cittadino registrato in fase di
	 * prenotazione dopo essere stato vaccinato.
	 * @param registrazioneVaccinato I dati di prenotazione della vaccinazione del
	 *                               cittadino registrato.
	 */
	public void insertVaccinato(RegistrazioniVaccinati registrazioneVaccinato);

	/**
	 * Metodo che conta il numero di centri vaccinali nel DB.
	 * @return Il numero di centri vaccinali
	 */
	public int countCentriVaccinali();
}
