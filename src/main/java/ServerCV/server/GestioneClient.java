package ServerCV.server;

import Common.*;
import ServerCV.database.gestioneDB.CentriVaccinaliDaoImpl;
import ServerCV.database.gestioneDB.CittadiniRegistratiDaoImpl;
import ServerCV.database.gestioneDB.DaoFactory;
import ServerCV.database.gestioneDB.interfacceDB.CentriVaccinaliDao;
import ServerCV.database.gestioneDB.interfacceDB.CittadiniRegistratiDao;
import ServerCV.database.gestioneDB.interfacceDB.EventiAvversiDao;
import ServerCV.database.gestioneDB.interfacceDB.RegistrazioniVaccinazioniDao;
import ServerCV.interfaccia.Client;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Classe che gestisce le classi del DB per metterle a disposizione del client.
 */
public class GestioneClient {

	CittadiniRegistratiDao cittadiniRegistratiDao = (CittadiniRegistratiDao) DaoFactory.getDao("CittadiniRegistratiDao");
	CentriVaccinaliDao centriVaccinaliDao = (CentriVaccinaliDao) DaoFactory.getDao("CentriVaccinaliDao");
	EventiAvversiDao eventiAvversiDao = (EventiAvversiDao) DaoFactory.getDao("EventiAvversiDao");
	RegistrazioniVaccinazioniDao registrazioniVaccinazioniDao = (RegistrazioniVaccinazioniDao) DaoFactory.getDao("RegistrazioniVaccinazioniDao");
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
	public void gestRegistraCittadino(DatiCittadino datiCittadino) {
		CittadiniRegistratiDao DAO =(CittadiniRegistratiDaoImpl) new DaoFactory().getDao("CittadiniRegistratiDao");
		DAO.insertCittadino(datiCittadino);
		/*if(cittadiniRegistratiDao.existCfCittadino(datiCittadino.getCFCittadino()))
			System.err.println("codice fiscale già registrato");
		else
		if(!cittadiniRegistratiDao.existCittadino(datiCittadino.getUsernameCittadino())) {
			cittadiniRegistratiDao.insertCittadino(datiCittadino);
			System.err.println("cittadino regsitrato con successo");
		}*/
	}
	
	/**
	 * Metodo che gestisce il login del cittadino.
	 * @param username	Lo username del cittadino.
	 * @param pw		La password del cittadino.
	 * @return			Un codice per gestire i vari casi di avviso ed errore.
	 */
	public Boolean gestLoginCittadino(String username, String pw) {
		if(!cittadiniRegistratiDao.existCittadino(username))
			return false;
		else if(cittadiniRegistratiDao.checkPwCittadino(username, pw))//se password inserita = pw sul db -> login)
			return true;
		else
			return false;
	}

	/**
	 * Metodo che gestisce l'ottenimento del CF del cittadino registrato in base all'username.
	 * @param username	Lo username del cittadino.
	 * @return			Il CF del cittadino.
	 */
	//da finire, devo capire come passare la connessione
	public String gestOttieniCF(String username) {/*
		DatiCittadino datiCittadino = cittadiniRegistratiDao.getCfCittadino(username);
		return datiCittadino.getCFCittadino();
		String sql="SELECT cf FROM Cittadini_Registrati WHERE userid=?";
		PreparedStatement pstmt;
		ResultSet rs;
		String cf="";
		try {
			Connection connessione = null;
			pstmt=connessione.prepareStatement(sql);
			pstmt.setString(1,username);
			rs=pstmt.executeQuery();
			while(rs.next()){
				cf=rs.getString("cf");
			}
			if(cf.equals(null) || cf.equals(""))
				System.out.println("cf non presente");
			else
			System.out.println(cf);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		*/
		return username;
	}

	/**
	 * Metodo che gestisce le informazioni dei cittadini registrati.
	 * @param cf	Il CF del cittadino.
	 * @return		Il nome e il cognome del cittadino.
	 */
	public InfoCittadino gestOttieniInfoCittadino(String cf){
		CittadiniRegistratiDao cittadiniRegistrati=null;
		DatiCittadino datiCittadino = cittadiniRegistrati.getDatiCittadino(cf);
		return new InfoCittadino(datiCittadino.getNomeCittadino(), (datiCittadino.getPasswordCittadino().toCharArray()));

	}
	
	/**
	 * Metodo che gestisce la vaccinazione di un cittadino.
	 * @param datoRegistrazione		I dati che il cittadino ha inserito al momento della prenotazione.
	 * @return						Un codice per gestire i vari casi di avviso ed errore.
	 */
	public int gestRegistraVaccinato(RegistrazioniVaccinati datoRegistrazione) {
		if(centriVaccinaliDao.existCf(datoRegistrazione.getNomeCentro(), datoRegistrazione.getCf()))
			return 3;
		else
		if(cittadiniRegistratiDao.existIdCittadino(datoRegistrazione.getIdVaccinazione()))
			return 2;
		else {
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
	 * Metodo che gestisce l'esistenza di un CF nella lista dei CF che hanno prenotato una vaccinazione.
	 * @param cf	Il CF del cittadino.
	 * @return		Se esiste vero, altrimenti falso.
	 */
	public boolean gestExistCfRegistrazioneVaccinazione(String cf) {
		return registrazioniVaccinazioniDao.existCf(cf);
	}

	/**
	 * Metodo che gestisce il controllo dell'ID della vaccinazione prima di inserire un evento avverso.
	 * @param cf	Il CF del cittadino.
	 * @return		Un codice per gestire i vari casi di avviso ed errore.
	 */
	public int gestControlloPreRegistrazioneEventoAvverso(String cf) {
		if(eventiAvversiDao.existId(cittadiniRegistratiDao.getIdCittadino(cf)))
			return 1;
		return 2;
	}
	
	/**
	 * Metodo che gestisce l'ottenimento dell'ID della vaccinazione.
	 * @param cf	Il CF del cittadino.
	 * @return		L'ID della vaccinazione di quel cittadino.
	 */
	public String gestOttieniIdVaccinazione(String cf) {
		return Integer.toString(cittadiniRegistratiDao.getIdCittadino(cf));
	}

	/**
	 * Metodo che gestisce la ricerca dei centri vaccinali.
	 * @param testo		Il testo di ricerca.
	 * @return			Una lista dei vari centri vaccinali.
	 */
	public List<InfoCentriVaccinali>gestRicercaCentroVaccinale(String testo) {
		return centriVaccinaliDao.findCentroVaccinale(testo);
	}

	/**
	 * Metodo che gestisce l'inserimento degli eventi avversi.
	 * @param eventoAvverso		Gli eventi avversi.
	 * @return					Un codice per gestire i vari casi di avviso ed errore.
	 */

	//TODO da rivedere e implementare eventiAvversiDao e getIdVaccinazione
	public int gestInserimentoEventoAvverso(EventiAvversi eventoAvverso) {

		//int id_evento, String nomeCentro, String evento,  Integer severita, String note

		if(!centriVaccinaliDao.existId(eventoAvverso.getNomeCentro(), eventoAvverso.getIdEvento()))
			return 2;
		else {
			for(int i=0; i<6; i++) {
				eventiAvversiDao.insertEventoAvverso(eventoAvverso.getIdEvento(),
						eventoAvverso.getNomeCentro(),
						eventoAvverso.getEvento()[i],
						eventoAvverso.getSeverita()[i],
						eventoAvverso.getNotes()[i]);
			}
			return 1;
		}
		/*
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
	*/
	}
	
	
	/**
	 * Metodo che gestisce l'ottenimento del numero di segnalazioni per un determinato centro vaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @return				Il numero di segnalazioni per quel determinato centro vaccinale.
	 */
	public int gestOttieniNumSegnalazioni(String nomeCentro) {
		return eventiAvversiDao.getSegnalazioni(nomeCentro)/6;
	}
	
	/**
	 * Metodo che gestisce l'ottenimento dell'intensita' media di ogni evento per un determinato centro vaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @param evento		Il nome dell'evento avverso.
	 * @return				Il valore medio dell'intensita' di quel determinato evento.
	 */
	public Double gestOttieniImportanzaEventi(String nomeCentro, String evento) {

		return eventiAvversiDao.getImportanzaEvento(nomeCentro, evento);
	}

	/**
	 * Metodo che gestisce le statistiche visualizzate nella homepage del client.
	 * @return		Le statistiche.
	 */
	public int[] getStatistiche() {
		int countCentri = centriVaccinaliDao.countCentriVaccinali();
		int countVaccinati = cittadiniRegistratiDao.countCittadiniVaccinati();
		int[] statistiche = {countCentri, countVaccinati};
		return statistiche;
	}
}
	
	
