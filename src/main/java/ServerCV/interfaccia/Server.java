package ServerCV.interfaccia;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Common.DatiCittadino;
import Common.InfoCentriVaccinali;
import Common.InfoCittadino;
import Common.RegistraVaccinato;

/**
 * Classe ServerCV.interfaccia del server.
 */
public interface Server extends Remote {
	
	/**
	 * Interfaccia per gestire la registrazione del client agli eventi.
	 * @param client			Il client.
	 * @return					Il codice del client.
	 * @throws RemoteException	Eccezione remota.
	 */
	Integer subscribeToEvents(Client client) throws RemoteException;
	
	/**
	 * Interfaccia per gestire la rimozione del client dagli eventi.
	 * @param clientId			Il codice del client.
	 * @throws RemoteException	Eccezione remota.
	 */
	void unsubscribeToEvents(Integer clientId) throws RemoteException;
	
	/**
	 * Interfaccia per gestire la registrazione del centro vaccinale.
	 * @param infoCentroVaccinale 	Le informazioni del centro vaccinale.
	 * @return						Un codice per gestire i vari casi di avviso ed errore.
	 * @throws RemoteException		Eccezione remota.
	 */
	int registraCentroVaccinale(InfoCentriVaccinali infoCentroVaccinale) throws RemoteException;
	
	/**
	 * Interfaccia per gestire la registrazione del cittadino.
	 * @param datiCittadino		Le informazioni del cittadino.
	 * @return					Un codice per gestire i vari casi di avviso ed errore.
	 * @throws RemoteException	Eccezione remota.
	 */
	int registraCittadino(DatiCittadino datiCittadino) throws RemoteException;
	
	/**
	 * Interfaccia per gestire il login del cittadino.
	 * @param username			Lo username del cittadino.
	 * @param password			La password del cittadino.
	 * @return					Un codice per gestire i vari casi di avviso ed errore.
	 * @throws RemoteException	Eccezione remota.
	 */
	int loginCittadino(String username, String password) throws RemoteException;

	/**
	 * Interfaccia per gestire la ricerca del centro vaccinale.
	 * @param testo				Il testo di ricerca.
	 * @return					Una lista contenente tutti i dati dei centri vaccinali.
	 * @throws RemoteException	Eccezione remota.
	 */
	List<InfoCentriVaccinali> cercaCentroVaccinale(String testo) throws RemoteException;
	
	/**
	 * Interfaccia per gestire il CF del cittadino registrato in base all'username.
	 * @param username			Lo username del cittadino.
	 * @return					Il CF del cittadino.
	 * @throws RemoteException	Eccezione remota.
	 */
	String ottieniCf(String username) throws RemoteException;

	/**
	 * Interfaccia per gestire il controllo dei dati prima della prenotazione.
	 * @param cf				Il CF del cittadino.
	 * @return					Un codice per gestire i vari casi di avviso ed errore.
	 * @throws RemoteException	Eccezione remota.
	 */
	int controlloPreRegistrazioneEventoAvverso(String cf) throws RemoteException;
	
	/**
	 * Interfaccia per gestire l'ID della vaccinazione dell'utente.
	 * @param cf				Il CF del cittadino.
	 * @return					L'ID della vaccinazione del cittadino.
	 * @throws RemoteException	Eccezione remota.
	 */
	String ottieniIdVaccinazione(String cf) throws RemoteException;
	
	/**
	 * Interfaccia per gestire il numero di segnalazioni di un determinato centro vaccinale.
	 * @param nomeCentro		Il nome del centro vaccinale.
	 * @return					Il numero di segnalazioni di eventi avversi per quel determinato centro vaccinale.
	 * @throws RemoteException	Eccezione remota.
	 */
	int ottieniNumSegnalazioni(String nomeCentro) throws RemoteException;
	
	/**
	 * Interfaccia per gestire le informazioni dei cittadini registrati.
	 * @param cf                Il CF del cittadino.
	 * @return					Il nome e il cognome del cittadino.
	 * @throws RemoteException	Eccezione remota.
	 */
	InfoCittadino getInfoCittadini(String cf) throws RemoteException;

	/**
	 * Interfaccia per gestire la vaccinazione di un cittadino.
	 * @param datiRegistrazione		I dati che il cittadino ha inserito al momento della prenotazione.
	 * @return						Un codice per gestire i vari casi di avviso ed errore.
	 * @throws RemoteException		Eccezione remota.
	 */
	public int registraVaccinato(RegistraVaccinato datiRegistrazione) throws RemoteException;
	
	/**
	 * Interfaccia per gestire l'inserimento di eventi avversi.
	 * @param eventoAvverso		I dati degli eventi aversi.
	 * @return					Un codice per gestire i vari casi di avviso ed errore.
	 * @throws RemoteException	Eccezione remota.
	 */
	public int InserisciEventiAvversi(Common.EventiAvversi eventoAvverso) throws RemoteException;
	
	/**
	 * Interfaccia per gestire l'ottenimento della severita' media per un determinato tipo di evento.
	 * @param nomeCentro		Il nome del centro vaccinale.
	 * @param evento			Il tipo di evento avverso.
	 * @return					La media dei valori dell'intensita' per quel determinato tipo di evento.
	 * @throws RemoteException	Eccezione remota.
	 */
	public Double getImportanzaEvento(String nomeCentro, String evento) throws RemoteException;
	
	/**
	 * Interfaccia per gestire l'ottenimento delle statistiche dalla Homepage.
	 * @return					La lista delle statistiche.
	 * @throws RemoteException	Eccezione remota.
	 */
	public int[] getStatisticheHomepage() throws RemoteException;
}
