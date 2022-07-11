package ServerCV.server.Dao.Interfacce;

import java.sql.ResultSet;
import java.util.List;

import Common.InfoCentriVaccinali;
import Common.RegistraVaccinato;

/**
 * Nicolo' Ferrari, Mat. 732707, Varese
 * Alessandro Formenti, Mat. 734465, Varese
 * Luigi Mucciarone, Mat. 732714, Varese
 * Luca Alberti, Mat. 733096, Varese
 */

/**
 * Interfaccia contenente i metodi che verranno utilizzati per le query sulla tabella centri_vaccinali.
 */
public interface CentriVaccinaliDao {

	/**
	 * Interfaccia che gestisce l'inserimento dei dati di un centro vaccinale.
	 * @param infoCentroVaccinale	I dati di un centro vaccinale.
	 */
	public void insertDatiCentroVaccinale(InfoCentriVaccinali infoCentroVaccinale);
	
	/**
	 * Interfaccia che gestisce la ricerca di un centro vaccinale. 
	 * @param researchText	Testo di ricerca.
	 * @return				Lista contenente le informazioni dei centri vaccinali.
	 */
	public List<InfoCentriVaccinali> findCentroVaccinale(String researchText);

	/**
	 * Interfaccia che gestisce il controllo sui dati inseriti dall'Operatore Sanitario durante il login.
	 * @param id		L'id dell'Operatore Sanitario.
	 * @param password	La password dell'Operatore Sanitario.
	 * @return			Se i dati corrispondono o no.
	 */
	public boolean checkPwDoctor(String id, String password);


	/**
	 * Interfaccia che gestisce il controllo dell'esistenza di un centro vaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @return				Se esiste o no quel centro vaccinale.
	 */
	public boolean existCentroVaccinale(String nomeCentro);
	
	/**
	 * Interfaccia che gestisce la creazione dinamica della tabella vaccinati_nomeCentroVaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 */
	public void createVaccinati_(String nomeCentro);
	
	/**
	 * Interfaccia che gestisce la modifica della tabella vaccinati_nomeCentroVaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 */
	public void alterVaccinati_(String nomeCentro);
	
	/**
	 * Interfaccia che gestisce la conversione da ResultSet ad InfoCentriVaccinali.
	 * @param rs	Il ResultSet di una query
	 * @return		Il valore convertito.
	 */
	public InfoCentriVaccinali convertToInfoCentro(ResultSet rs);
	
	/**
	 * Interfaccia che gestisce l'esistenza di un CF all'interno di una tabella vaccinati_NomeCentroVaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @param cf			Il CF del cittadino.
	 * @return				Se esiste o no il CF.
	 */
	public boolean existCf(String nomeCentro, String cf);
	
	/**
	 * Interfaccia che gestisce l'esistenza dell'ID della vaccinazione all'interno di una tabella vaccinati_NomeCentroVaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @param id			L'ID della vaccinazione.
	 * @return				Se esiste o no l'ID della vaccinazione.
	 */
	public boolean existId(String nomeCentro, int id);
	
	/**
	 * Interfaccia che gestisce l'inserimento di un vaccinato all'interno della rispettiva tabella vaccinati_NomeCentroVaccinale.
	 * @param registrazioneVaccinato	I dati della vaccinazione del cittadino
	 */
	public void insertVaccinato(RegistraVaccinato registrazioneVaccinato);
	
	/**
	 * Interfaccia che gestisce la conta del numero di centri vaccinali esistenti.
	 * @return		Il numero di centri vaccinali esistenti.
	 */
	public int countCentriVaccinali();
}
