package ServerCV.interfaccia;

import Common.DatiCittadino;
import Common.InfoCentriVaccinali;
import Common.InfoCittadino;
import Common.RegistrazioniVaccinati;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Classe ServerCV.interfaccia del server.
 */
public interface Server extends Remote {
	
	/**
	 * Metodo per gestire la registrazione del client agli eventi.
	 * @param client			Il client.
	 * @return					Il codice del client.
	 * @throws RemoteException	Eccezione remota.
	 */
	Integer subscribeToEvents(Client client) throws RemoteException;

	boolean CheckCFCittadino(String username, String cf) throws RemoteException;

	public String[] getIdCittadino(String cf)throws RemoteException;

	/**
	 * Metodo per gestire la rimozione del client dagli eventi.
	 * @param clientId			Il codice del client.
	 * @throws RemoteException	Eccezione remota.
	 */
	void unsubscribeToEvents(Integer clientId) throws RemoteException;
	
	/**
	 * Metodo per gestire la registrazione del centro vaccinale.
	 * @param infoCentroVaccinale 	Le informazioni del centro vaccinale.
	 * @return						Un codice per gestire i vari casi di avviso ed errore.
	 * @throws RemoteException		Eccezione remota.
	 */
	int registraCentroVaccinale(InfoCentriVaccinali infoCentroVaccinale) throws RemoteException;
	
	/**
	 * Metodo per gestire la registrazione del cittadino.
	 * @param datiCittadino        Le informazioni del cittadino.
	 * @throws RemoteException	Eccezione remota.
     * @return
	 */
	int registraCittadino(DatiCittadino datiCittadino) throws RemoteException;
	
	/**
	 * Metodo per gestire il login del cittadino.
	 *
	 * @param username Lo username del cittadino.
	 * @param password La password del cittadino.
	 * @param cf
	 * @throws RemoteException Eccezione remota.
	 * @return Un codice per gestire i vari casi di avviso ed errore.
	 */
	int loginCittadino(String username, String password, String cf) throws RemoteException;
	/**
	 * Metodo per gestire il login del centro vaccinale.
	 * @param username            Lo username del centro vaccinale.
	 * @param password            La password del centro vaccinale.
	 * @return					Un codice per gestire i vari casi di avviso ed errore.
	 * @throws RemoteException	Eccezione remota.
	 */
	int loginCentroVaccinale(String username, String password) throws RemoteException;

	/**
	 * Metodo per gestire la ricerca del centro vaccinale.
	 * @param testo				Il testo di ricerca.
	 * @return					Una lista contenente tutti i dati dei centri vaccinali.
	 * @throws RemoteException	Eccezione remota.
	 */
	List<InfoCentriVaccinali> cercaCentroVaccinale(String testo) throws RemoteException;
	
	/**
	 * Metodo per gestire il CF del cittadino registrato in base all'username.
	 * @param username			Lo username del cittadino.
	 * @return					Il CF del cittadino.
	 * @throws RemoteException	Eccezione remota.
	 */
	String ottieniCf(String username) throws RemoteException;

	/**
	 * Metodo per gestire il controllo dei dati prima della prenotazione.
	 * @param cf				Il CF del cittadino.
	 * @return					Un codice per gestire i vari casi di avviso ed errore.
	 * @throws RemoteException	Eccezione remota.
	 */
	Boolean controlloPreRegistrazioneEventoAvverso(String cf) throws RemoteException;
	
	/**
	 * Metodo per gestire l'ID della vaccinazione dell'utente.
	 * @param cf				Il CF del cittadino.
	 * @return					L'ID della vaccinazione del cittadino.
	 * @throws RemoteException	Eccezione remota.
	 */
	String ottieniIdVaccinazione(String cf) throws RemoteException;
	
	/**
	 * Metodo per gestire il numero di segnalazioni di un determinato centro vaccinale.
	 * @param nomeCentro		Il nome del centro vaccinale.
	 * @return					Il numero di segnalazioni di eventi avversi per quel determinato centro vaccinale.
	 * @throws RemoteException	Eccezione remota.
	 */
	int ottieniNumSegnalazioni(String nomeCentro) throws RemoteException;
	
	/**
	 * Metodo per gestire le informazioni dei cittadini registrati.
	 * @param cf                Il CF del cittadino.
	 * @return					Il nome e il cognome del cittadino.
	 * @throws RemoteException	Eccezione remota.
	 */
	InfoCittadino getInfoCittadini(String cf) throws RemoteException;

	/**
	 * Metodo per gestire la vaccinazione di un cittadino.
	 * @param datiRegistrazione		I dati che il cittadino ha inserito al momento della prenotazione.
	 * @return						Un codice per gestire i vari casi di avviso ed errore.
	 * @throws RemoteException		Eccezione remota.
	 */
	public int registraVaccinato(RegistrazioniVaccinati datiRegistrazione) throws RemoteException;
	
	/**
	 * Metodo per gestire l'inserimento di eventi avversi.
	 * @param eventoAvverso		I dati degli eventi aversi.
	 * @return					Un codice per gestire i vari casi di avviso ed errore.
	 * @throws RemoteException	Eccezione remota.
	 */
	public int InserisciEventiAvversi(Common.EventiAvversi eventoAvverso, String codiceFiscale) throws RemoteException;
	
	/**
	 * Metodo per gestire l'ottenimento della severita' media per un determinato tipo di evento.
	 * @param nomeCentro		Il nome del centro vaccinale.
	 * @param evento			Il tipo di evento avverso.
	 * @return					La media dei valori dell'intensita' per quel determinato tipo di evento.
	 * @throws RemoteException	Eccezione remota.
	 */
	public Double getImportanzaEvento(String nomeCentro, String evento) throws RemoteException;
	
	/**
	 * Metodo per gestire l'ottenimento delle statistiche dalla Homepage.
	 * @return					La lista delle statistiche.
	 * @throws RemoteException	Eccezione remota.
	 */
	public int[] getStatisticheHomepage() throws RemoteException;

	int infCv(String nomeCv, String comune, String tipologia) throws RemoteException;


	int infCv(String nomeCv, String tipoEv, int intensitàMedia, String noteEv) throws RemoteException;

	/**
	 * Metodo per la gestione della registrazione di un vaccinato.
	 * @param nome Il nome del vaccinato.
	 * @param cognome Il cognome del vaccinato.
	 * @param vaccinoSomministrato Il vaccino somministrato.
	 * @param idVaccinazione L'id di vaccinazione
	 * @param dataVaccino La data di vaccinazione.
	 * @param idCentro L'id del centro vaccinale.
	 * @return Un codice per gestire i vari casi di avviso ed errore.
	 * @throws RemoteException
	 */
	int registraVaccinato(String nome, String cognome, String vaccinoSomministrato, String idVaccinazione, int dataVaccino, String idCentro) throws RemoteException;
}
