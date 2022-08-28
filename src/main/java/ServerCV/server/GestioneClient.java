package ServerCV.server;

import Common.*;
import ServerCV.database.gestioneDB.CentriVaccinaliDaoImpl;
import ServerCV.database.gestioneDB.CittadiniRegistratiDaoImpl;
import ServerCV.database.gestioneDB.EventiAvversiDaoImpl;
import ServerCV.database.gestioneDB.interfacceDB.CentriVaccinaliDao;
import ServerCV.database.gestioneDB.interfacceDB.CittadiniRegistratiDao;
import ServerCV.database.gestioneDB.interfacceDB.EventiAvversiDao;
import ServerCV.interfaccia.Client;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Classe che gestisce le classi del DB per metterle a disposizione del client.
 */
public class GestioneClient {

	CittadiniRegistratiDao cittadiniRegistratiDao = new CittadiniRegistratiDaoImpl();
	CentriVaccinaliDao centriVaccinaliDao =new CentriVaccinaliDaoImpl();
	EventiAvversiDao eventiAvversiDao =new EventiAvversiDaoImpl();
	ConcurrentHashMap<Integer, Client> clients = new ConcurrentHashMap<>();
	Integer clientCount = 0;


	/**
	 * Metodo che gestisce la registrazione del client agli eventi.
	 * @param client	Il client.
	 * @return			Il codice del client.
	 */
	//ok
	public Integer subscribeToEvents(Client client) {
		clients.put(clientCount++, client);
		return clientCount;
	}
	
	/**
	 * Metodo che gestisce l'aggiornamento le statistiche delle homepage di tutti i client. 
	 * @param nuoviCentri		Il numero di nuovi centri.
	 * @param nuoviVaccinati	Il numero di nuovi vaccinati.
	 */
	//ok
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
	//ok
	public void unsubscribeToEvents(Integer key) {
		clients.remove(key);
	}

	/**
	 * Metodo che gestisce la registrazione del cittadino.
	 * @param datiCittadino	Le informazioni del cittadino.
	 * @return				Un codice per gestire i vari casi di avviso ed errore.
	 */
	//ok
	public int gestRegistraCittadino(DatiCittadino datiCittadino) {
		CittadiniRegistratiDaoImpl cittadiniRegistratiDaoImpl =new CittadiniRegistratiDaoImpl();
		if( cittadiniRegistratiDaoImpl.existCfCittadino(datiCittadino.getCFCittadino())){
				System.out.println("problemi cf");
				return 0; //in caso che il codice fiscale sia già registrato
			} else  {
				if(cittadiniRegistratiDaoImpl.insertCittadino(datiCittadino)) {
					return 1; //in caso la registrazione avvenisse con successo
				}
				else{
					return 0; //in caso che il codice fiscale sia già registrato
				}
			}
	}
	
	/**
	 * Metodo che gestisce il login del cittadino.
	 * @param username	Lo username del cittadino.
	 * @param pw		La password del cittadino.
	 * @return			Un codice per gestire i vari casi di avviso ed errore.
	 */
	//ok
	public int gestLoginCittadino(String username, String pw) {
		if(!cittadiniRegistratiDao.existCittadino(username))
			return 2 ;
		else if(cittadiniRegistratiDao.checkPwCittadino(username, pw))//se password inserita = pw sul db -> login)
			return 1;
		else
			return 3;
	}

	//ok
	public int gestLoginCentroVaccinale(String username, String password){
		if(centriVaccinaliDao.checkLoginCentro(username,password)){
			return 1;
		}else if(!centriVaccinaliDao.existCentro(username)){
			return 2;
		}else {
			return 3;
		}

	}

	/**
	 * Metodo che gestisce l'ottenimento del CF del cittadino registrato in base all'username.
	 * @param username	Lo username del cittadino.
	 * @return			Il CF del cittadino.
	 */
	//ok
	public String gestOttieniCF(String username) {
		DatiCittadino datiCittadino = cittadiniRegistratiDao.getCfCittadino(username);
		return datiCittadino.getCFCittadino();
	}

	/**
	 * Metodo che gestisce le informazioni dei cittadini registrati.
	 * @param cf	Il CF del cittadino.
	 * @return		Il nome e il cognome del cittadino.
	 */
	//ok
	public InfoCittadino gestOttieniInfoCittadino(String cf){
		DatiCittadino datiCittadino = cittadiniRegistratiDao.getDatiCittadino(cf);
		return new InfoCittadino(datiCittadino.getNomeCittadino(), (datiCittadino.getCognomeCittadino()));

	}
	
	/**
	 * Metodo che gestisce la vaccinazione di un cittadino.
	 * @param datoRegistrazione		I dati che il cittadino ha inserito al momento della prenotazione.
	 * @return						Un codice per gestire i vari casi di avviso ed errore.
	 */
	//ok
	public int gestRegistraVaccinato(RegistrazioniVaccinati datoRegistrazione) {
		if(centriVaccinaliDao.existCf(datoRegistrazione.getnomeCentro(), datoRegistrazione.getCf())){
			return 3;
		} else if(cittadiniRegistratiDao.existIdCittadino(datoRegistrazione.getIdVaccinazione())){
			return 2;
		} else {
			centriVaccinaliDao.insertVaccinato(datoRegistrazione);
			cittadiniRegistratiDao.updateIdCittadino(datoRegistrazione.getIdVaccinazione(), datoRegistrazione.getCf());;
			updateAllClients(0, 1);
			return 1;
		}
	}

	/**
	 * Metodo che gestisce la registrazione del centro vaccinale.
	 * @param infoCentroVaccinale	Le informazioni del centro vaccinale.
	 * @return						Un codice per gestire i vari casi di avviso ed errore.
	 */
	//ok
	public int gestRegistraCentroVaccinale(InfoCentriVaccinali infoCentroVaccinale) {
		if(centriVaccinaliDao.existCentroVaccinale(infoCentroVaccinale.getNomeCentro()))
			return 2;
		else {
			centriVaccinaliDao.insertDatiCentroVaccinale(infoCentroVaccinale);
			String nome = infoCentroVaccinale.getNomeCentro();
			nome = Utility.getNameForQuery(nome);
			centriVaccinaliDao.createVaccinati_(nome);
			updateAllClients(1, 0);

			return 1;
		}
	}

	/**
	 * Metodo che gestisce il controllo dell'ID della vaccinazione prima di inserire un evento avverso.
	 * @param cf	Il CF del cittadino.
	 * @return		Un codice per gestire i vari casi di avviso ed errore.
	 */
	//ok
	public boolean gestControlloPreRegistrazioneEventoAvverso(String cf) {
		if(eventiAvversiDao.existId(cittadiniRegistratiDao.getIdCittadino(cf)))
			return false;
		return true;
	}
	
	/**
	 * Metodo che gestisce l'ottenimento dell'ID della vaccinazione.
	 * @param cf	Il CF del cittadino.
	 * @return		L'ID della vaccinazione di quel cittadino.
	 */
	//ok
	public String gestOttieniIdVaccinazione(String cf) {
		return (cittadiniRegistratiDao.getIdCittadino(cf))[0];
	}

	/**
	 * Metodo che gestisce la ricerca dei centri vaccinali.
	 * @param testo		Il testo di ricerca.
	 * @return			Una lista dei vari centri vaccinali.
	 */
	//ok
	public List<InfoCentriVaccinali>gestRicercaCentroVaccinale(String testo) {
		return centriVaccinaliDao.findCentroVaccinale(testo);
	}

	/**
	 * Metodo che gestisce l'inserimento degli eventi avversi.
	 * @param eventoAvverso		Gli eventi avversi.
	 * @return					Un codice per gestire i vari casi di avviso ed errore.
	 */

	//ok
	public int gestInserimentoEventoAvverso(EventiAvversi eventoAvverso) {
		if(!centriVaccinaliDao.existIdVaccinazione(eventoAvverso.getNomeCentro(), eventoAvverso.getIdEvento()))
			return 2;
		else if(!gestControlloPreRegistrazioneEventoAvverso(eventoAvverso.getCf_evento()))
			return 3;
		else{
				for(int i=0; i<7; i++) {
					eventiAvversiDao.insertEventoAvverso(
							eventoAvverso.getIdEvento(),
							eventoAvverso.getNomeCentro(),
							eventoAvverso.getEvento()[i],
							eventoAvverso.getSeverita()[i],
							eventoAvverso.getNotes()[i],
							eventoAvverso.getCf_evento());
				}
				return 1;
			}

	}

	/**
	 * Metodo che gestisce l'ottenimento del numero di segnalazioni per un determinato centro vaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @return				Il numero di segnalazioni per quel determinato centro vaccinale.
	 */
	//ok
	public int gestOttieniNumSegnalazioni(String nomeCentro) {
		return eventiAvversiDao.getSegnalazioni(nomeCentro)/6;
	}
	
	/**
	 * Metodo che gestisce l'ottenimento dell'intensita' media di ogni evento per un determinato centro vaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @param evento		Il nome dell'evento avverso.
	 * @return				Il valore medio dell'intensita' di quel determinato evento.
	 */
	//ok
	public Double gestOttieniImportanzaEventi(String nomeCentro, String evento) {
		return eventiAvversiDao.getImportanzaEvento(nomeCentro, evento);
	}

	/**
	 * Metodo che gestisce le statistiche visualizzate nella homepage del client.
	 * @return		Le statistiche.
	 */
	//ok
	public int[] getStatistiche() {
		int countCentri = centriVaccinaliDao.countCentriVaccinali();
		int countVaccinati = cittadiniRegistratiDao.countCittadiniVaccinati();
		int[] statistiche = {countCentri, countVaccinati};
		return statistiche;
	}
}
	
	
