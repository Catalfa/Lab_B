package ServerCV.database.gestioneDB.interfacceDB;

import Common.DatiCittadino;

import java.rmi.RemoteException;

/**
 * Interfaccia per i cittadini registrati.
 */

public interface CittadiniRegistratiDao {

	/**
	 * Metodo che inserisce i dati nella tabella cittadini_registrati.
	 * @param citizenData I dati del cittadino che si sta registrando.
	 * @return Se l'inserimento è andato a buon fine
	 */
	public Boolean insertCittadino(DatiCittadino citizenData);

	/**
	 * Metodo che restituisce le informazioni dei cittadini.
	 * @param cf Il codice fiscale del cittadino.
	 * @return Il nome e cognome del cittadino.
	 */
	public DatiCittadino getDatiCittadino(String cf) ;

	/**
	 * Metodo cheverifica la corrispondenza del codice fiscale a un determinato username.
	 *
	 * @param username Lo username del cittadino.
	 * @param cf Il CF del cittadino.
	 * @return vero se corrisponde.
	 */
	boolean CheckCFCittadino(String username, String cf);

	/**
	 * Metodo che controlla se la password inserita corrisponde
	 * a quella presente sul Db per quel determinato cittadino.
	 * @param username L'username del cittadino registrato.
	 * @param password La password del cittadino registrato.
	 * @return Se la password dell'utente registrato e' corretta.
	 */
	public boolean checkPwCittadino(String username, String password);

	/**
	 * Metodo che controlla se esiste già un cittadino con quello username nel DB.
	 * @param username Lo username del cittadino.
	 * @return Se è già esistente un cittadino con quello username nel DB
	 */
	public boolean existCittadino(String username);

	/**
	 * Metodo che restituisce il Cf del cittadino.
	 * @param  username Il nome del cittadino registrato.
	 * @return Il cf del cittadino registrato.
	 */
	public DatiCittadino getCfCittadino(String username);

	/**
	 *  Metodo che controlla se esiste gia' un cittadino registrato con quel Cf.
	 * @param cf Il cf del cittadino che si sta registrando
	 * @return Se e' gia' presente un cittadino registrato con quel Cf.
	 */
	public boolean existCfCittadino(String cf);

	/**
	 * Metodo che aggiorna il valore dell'Id vaccinazione per quel determinato cittadino registrato.
	 * @param id L'id della vaccinazione.
	 * @param cf Il cf del cittadino registrato.
	 */
	public void updateIdCittadino(String id, String cf);

	/**
	 * Metodo che controlla se l'id vaccinazione inserito e' gia' stato utilizzato.
	 * @param id L'id della vaccinazione.
	 * @return Se e' gia' stato utilizzato quell'id.
	 */
	public boolean existIdCittadino(String id);

	/**
	 * Metodo che restituisce l'id vaccinazione per quel determinato cittadino registrato.
	 * @param cf Il cf del cittadino registrato.
	 * @return L'id della vaccinazione.
	 */
	public String[] getIdCittadino(String cf);

	/**
	 * Metodo che effettua il conteggio dei cittadini vaccinati.
	 * @return Il numero di cittadini vaccinati
	 */
	public int countCittadiniVaccinati();
}
