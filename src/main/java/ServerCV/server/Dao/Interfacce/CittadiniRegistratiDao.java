package ServerCV.server.Dao.Interfacce;

import Common.DatiCittadino;

/**
 * Nicolo' Ferrari, Mat. 732707, Varese
 * Alessandro Formenti, Mat. 734465, Varese
 * Luigi Mucciarone, Mat. 732714, Varese
 * Luca Alberti, Mat. 733096, Varese
 */

/**
 * Interfaccia contenente i metodi che verranno utilizzati per le query sulla tabella cittadini_registrati.
 */
public interface CittadiniRegistratiDao {
	
	/**
	 * Interfaccia che gestisce l'inserimento di un cittadino.
	 * @param citizenData	I dati del cittadino.
	 */
	public void insertCittadino(DatiCittadino citizenData);
	
	/**
	 * Interfaccia che gestisce l'ottenimento dei dati di un cittadino.
	 * @param cf	Il CF del cittadino.
	 * @return		I dati del cittadino.
	 */
	public DatiCittadino getDatiCittadino(String cf);
	
	/**
	 * Interfaccia che gestisce il controllo sui dati inseriti dal cittadino durante il login.
	 * @param username		Lo username del cittadino.
	 * @param password		La password del cittadino.
	 * @return				Se i dati corrispondono o no.
	 */
	public boolean checkPwCittadino(String username, String password);
	
	/**
	 * Interfaccia che gestisce l'esistenza di un cittadino.
	 * @param username		Lo username del cittadino.
	 * @return				Se esiste o no il cittadino.
	 */
	public boolean existCittadino(String username);
	
	/**
	 * Interfaccia che gestisce l'ottenimento del CF di un cittadino.
	 * @param username		Lo username del cittadino.
	 * @return				I dati del cittadino.
	 */
	public DatiCittadino getCfCittadino(String username);
	
	/**
	 * Interfaccia che gestisce l'esistenza del CF di un cittadino.
	 * @param cf	Il CF di un cittadino.
	 * @return		Se il CF e' gia' stato usato o no.
	 */
	public boolean existCfCittadino(String cf);
	
	/**
	 * Interfaccia che gestisce l'aggiornamento dell'ID della vaccinazione di un cittadino.
	 * @param id	L'ID della vaccinazione del cittadino.
	 * @param cf	Il CF del cittadino.
	 */
	public void updateIdCittadino(int id, String cf);
	
	/**
	 * Interfaccia che gestisce l'esistenza dell'ID della vaccinazione di un cittadino.
	 * @param id	L'ID della vaccinazione del cittadino.
	 * @return		Se l'ID della vaccinazione inserito e' gia' stato utilizzato o no.
	 */
	public boolean existIdCittadino(int id);
	
	/**
	 * Interfaccia che gestisce l'ottenimento dell'ID della vaccinazione di un cittadino.
	 * @param cf	Il CF del cittadino.
	 * @return		Se l'ID della vaccinazione e' gia' stato utilizzato.
	 */
	public int getIdCittadino(String cf);
	
	/**
	 * Interfaccia che gestisce la conta dei cittadini che sono stati vaccinati.
	 * @return		Il numero di cittadini che sono stati vaccinati.
	 */
	public int countCittadiniVaccinati();
}
