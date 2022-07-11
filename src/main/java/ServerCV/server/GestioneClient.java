package ServerCV.server;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import ClientCV.CentriVaccinali.CentriVaccinali;
import Common.*;
import ServerCV.interfaccia.Client;
import ServerCV.server.Dao.*;
import ServerCV.server.Dao.Interfacce.CentriVaccinaliDao;

/**
 * Classe che gestisce le classi del DB per metterle a disposizione del client.
 */
public class GestioneClient {
	ConcurrentHashMap<Integer, Client> clients = new ConcurrentHashMap<>();
	Integer clientCount = 0;
	
	//TODO da implementare il metodo getDao in DaoFactory @Rondo
	//CentriVaccinaliDao centriVaccinaliDao = (CentriVaccinaliDao) DaoFactory.getDao("CentriVaccinaliDao");


	/**
	 * Metodo che gestisce la registrazione del client agli eventi.
	 * @param client	Il client.
	 * @return			Il codice del client.
	 */
	public Integer subscribeToEvents(Client client) {
		clients.put(clientCount++, client);
		return clientCount;
	}
	
	/**
	 * Metodo che gestisce l'aggiornamento le statistiche delle homepage di tutti i client. 
	 * @param nuoviCentri		Il numero di nuovi centri.
	 * @param nuoviVaccinati	Il numero di nuovi vaccinati.
	 */
	public void updateAllClients(int nuoviCentri, int nuoviVaccinati) {
		Set<Integer> set = clients.keySet();
		List<Integer> deadClients = new LinkedList<>();
		for(Integer key : set) {
			try {
				clients.get(key).update(new int[] {nuoviCentri, nuoviVaccinati});
			} catch (RemoteException ex) {
				deadClients.add(key);
			};
		}
		
		for(Integer key : deadClients) {
			unsubscribeToEvents(key);
		}
	}
	
	/**
	 * Metodo che gestisce la rimozione del client dagli eventi.
	 * @param key		Il codice del client.
	 */
	public void unsubscribeToEvents(Integer key) {
		clients.remove(key);
	}

	/**
	 * Metodo che gestisce la registrazione del cittadino.
	 * @param datiCittadino	Le informazioni del cittadino.
	 * @return				Un codice per gestire i vari casi di avviso ed errore.
	 */
	public int gestRegistraCittadino(DatiCittadino datiCittadino) {
		return 3;
	}
	
	/**
	 * Metodo che gestisce il login del cittadino.
	 * @param username	Lo username del cittadino.
	 * @param pw		La password del cittadino.
	 * @return			Un codice per gestire i vari casi di avviso ed errore.
	 */
	public int gestLoginCittadino(String username, String pw) {
		return 3;
	}

	/**
	 * Metodo che gestisce l'ottenimento del CF del cittadino registrato in base all'username.
	 * @param username	Lo username del cittadino.
	 * @return			Il CF del cittadino.
	 */
	public String gestOttieniCF(String username) {
		return null;
	}

	/**
	 * Metodo che gestisce le informazioni dei cittadini registrati.
	 * @param cf	Il CF del cittadino.
	 * @return		Il nome e il cognome del cittadino.
	 */
	public InfoCittadino gestOttieniInfoCittadino(String cf) {
		return null;
	}
	
	/**
	 * Metodo che gestisce la vaccinazione di un cittadino.
	 * @param datoRegistrazione		I dati che il cittadino ha inserito al momento della prenotazione.
	 * @return						Un codice per gestire i vari casi di avviso ed errore.
	 */
	public int gestRegistraVaccinato(RegistraVaccinato datoRegistrazione) {
		return 2;
	}

	/**
	 * Metodo che gestisce la registrazione del centro vaccinale.
	 * @param infoCentroVaccinale	Le informazioni del centro vaccinale.
	 * @return						Un codice per gestire i vari casi di avviso ed errore.
	 */
	public int gestRegistraCentroVaccinale(InfoCentriVaccinali infoCentroVaccinale) {
		return 3;
	}

	/**
	 * Metodo che gestisce l'esistenza di un CF nella lista dei CF che hanno prenotato una vaccinazione.
	 * @param cf	Il CF del cittadino.
	 * @return		Se esiste vero, altrimenti falso.
	 */
	public boolean gestExistCfRegistrazioneVaccinazione(String cf) {
		return true;
	}

	/**
	 * Metodo che gestisce il controllo dell'ID della vaccinazione prima di inserire un evento avverso.
	 * @param cf	Il CF del cittadino.
	 * @return		Un codice per gestire i vari casi di avviso ed errore.
	 */
	public int gestControlloPreRegistrazioneEventoAvverso(String cf) {
		return 3;
	}
	
	/**
	 * Metodo che gestisce l'ottenimento dell'ID della vaccinazione.
	 * @param cf	Il CF del cittadino.
	 * @return		L'ID della vaccinazione di quel cittadino.
	 */
	public String gestOttieniIdVaccinazione(String cf) {
		return null;
	}

	/**
	 * Metodo che gestisce la ricerca dei centri vaccinali.
	 * @param testo		Il testo di ricerca.
	 * @return			Una lista dei vari centri vaccinali.
	 */
	public List<InfoCentriVaccinali>gestRicercaCentroVaccinale(String testo) {
		return null;
	}

	/**
	 * Metodo che gestisce l'inserimento degli eventi avversi.
	 * @param eventoAvverso		Gli eventi avversi.
	 * @return					Un codice per gestire i vari casi di avviso ed errore.
	 */

	//TODO da rivedere e implementare eventiAvversiDao e getIdVaccinazione
	public int gestInserimentoEventoAvverso(EventiAvversi eventoAvverso) {/*
		if(!centriVaccinaliDao.existId(eventoAvverso.getNomeCentro(), eventoAvverso.getIdVaccinazione()))
		return 0;
		else{
			for(int i=0; i<6; i++){
				eventiAvversiDao.insetEventoAvverso(eventoAvverso.getIdVaccinazione(), eventoAvverso.getNomeCentro(),
													eventoAvverso.getEvento()[i], eventoAvverso.getSeverita()[i],
													eventoAvverso.getNotes()[i]);
			}
			return 1;
		}
	*/return 0;
	}
	
	
	/**
	 * Metodo che gestisce l'ottenimento del numero di segnalazioni per un determinato centro vaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @return				Il numero di segnalazioni per quel determinato centro vaccinale.
	 */
	public int gestOttieniNumSegnalazioni(String nomeCentro) {
	return 3;
	}
	
	/**
	 * Metodo che gestisce l'ottenimento dell'intensita' media di ogni evento per un determinato centro vaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @param evento		Il nome dell'evento avverso.
	 * @return				Il valore medio dell'intensita' di quel determinato evento.
	 */
	public Double gestOttieniImportanzaEventi(String nomeCentro, String evento) {
		return null;
	}

	/**
	 * Metodo che gestisce le statistiche visualizzate nella homepage del client.
	 * @return		Le statistiche.
	 */
	public int[] getStatistiche() {
		return null;
	}
}
	
	
