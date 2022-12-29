package ServerCV.server;

import Common.DatiCittadino;
import Common.InfoCentriVaccinali;
import Common.InfoCittadino;
import Common.RegistrazioniVaccinati;
import ServerCV.interfaccia.Client;
import ServerCV.interfaccia.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * Classe che implementa le interfacce del server e del client.
 */
public class ServerImpl extends UnicastRemoteObject implements Server {
	GestioneClient gestClient = new GestioneClient();

	/**
	 * Metodo che richiama la sua superclasse.
	 * 
	 * @throws RemoteException Eccezione remota.
	 */
	public ServerImpl() throws RemoteException {
		super();
	}

	/**
	 * Metodo implementativo del server che iscrive il client agli eventi.
	 */
	@Override
	public Integer subscribeToEvents(Client client) throws RemoteException {
		return gestClient.subscribeToEvents(client);
	}

	/**
	 * Metodo implementativo del server che disiscrive il client dagli eventi.
	 */
	@Override
	public void unsubscribeToEvents(Integer clientId) throws RemoteException {
		gestClient.unsubscribeToEvents(clientId);
	}

	/**
	 * Metodo implementativo del server che registra i centri vaccinali.
	 */
	@Override
	public int registraCentroVaccinale(InfoCentriVaccinali infoCentroVaccinale) throws RemoteException {
		return gestClient.gestRegistraCentroVaccinale(infoCentroVaccinale);
	}

	/**
	 * Metodo implementativo del server che effettua il login del cittadino.
	 * 
	 * @return
	 */
	@Override
	public int loginCittadino(String username, String password, String cf) throws RemoteException {
		return gestClient.gestLoginCittadino(username, password);
	}

	// metodo per il login di un centro, ritorna 1 se il login è stato effettuato
	// con successo,
	// 2 se non esiste centro con quell'username e 3 se la password non è corretta
	public int loginCentroVaccinale(String username, String password) throws RemoteException {
		return gestClient.gestLoginCentroVaccinale(username, password);
	}

	/**
	 * Metodo implementativo del server che effettua la ricerca del centro
	 * vaccinale.
	 */
	@Override
	public List<InfoCentriVaccinali> cercaCentroVaccinale(String testo) throws RemoteException {
		return gestClient.gestRicercaCentroVaccinale(testo);
	}

	/**
	 * Metodo implementativo del server per ottenere il CF del cittadino.
	 */
	@Override
	public String ottieniCf(String username) throws RemoteException {
		return gestClient.gestOttieniCF(username);
	}

	/**
	 * Metodo implementativo del server per ottenere le informazioni dei cittadini.
	 * 
	 * @return
	 */
	@Override
	public InfoCittadino getInfoCittadini(String cf) throws RemoteException {
		return gestClient.gestOttieniInfoCittadino(cf);
	}

	/**
	 * Metodo implementativo del server per registrare un cittadino vaccinato.
	 */
	@Override
	public int registraVaccinato(RegistrazioniVaccinati datiRegistrazione) throws RemoteException {
		return gestClient.gestRegistraVaccinato(datiRegistrazione);
	}

	/**
	 * Metodo implementativo del server per controllare se un cittadino � stato
	 * vaccinato prima di inserire un evento avvero.
	 */
	public Boolean controlloPreRegistrazioneEventoAvverso(String cf) throws RemoteException {
		return gestClient.gestControlloPreRegistrazioneEventoAvverso(cf);
	}

	/**
	 * Metodo implementativo del server per ottenere l'ID della vaccinazione del
	 * cittadino.
	 */
	public String ottieniIdVaccinazione(String cf) throws RemoteException {
		return gestClient.gestOttieniIdVaccinazione(cf);
	}

	/**
	 * Metodo implementativo del server per ottenere il numero di segnalazioni per
	 * un determinato centro vaccinale.
	 */
	public int ottieniNumSegnalazioni(String nomeCentro) throws RemoteException {
		return gestClient.gestOttieniNumSegnalazioni(nomeCentro);
	}

	/**
	 * Metodo implementativo del server per ottenere i valori medi degli eventi per
	 * un determinato centro vaccinale.
	 */
	@Override
	public Double getImportanzaEvento(String id_centro, String evento) throws RemoteException {
		return gestClient.gestOttieniImportanzaEventi(id_centro, evento);
	}

	/**
	 * Metodo implementativo del server per ottenere le statistiche del client.
	 */
	@Override
	public int[] getStatisticheHomepage() throws RemoteException {
		return gestClient.getStatistiche();
	}

	@Override
	public int infCv(String nomeCv, String comune, String tipologia) {
		return 0;
	}

	@Override
	public int infCv(String nomeCv, String tipoEv, int intensitàMedia, String noteEv) {
		return 0;
	}

	@Override
	public int registraVaccinato(String nome, String cognome, String vaccinoSomministrato, String idVaccinazione,
			int dataVaccino, String idCentro) {
		return 0;
	}

	/**
	 * Metodo implementativo del server per inserire gli eventi avversi.
	 */
	@Override
	public int InserisciEventiAvversi(Common.EventiAvversi eventoAvverso, String codiceFiscale) throws RemoteException {
		return gestClient.gestInserimentoEventoAvverso(eventoAvverso);
	}

	/**
	 * Metodo implementativo del server che registra i cittadini.
	 * 
	 * @return
	 */
	@Override
	public int registraCittadino(DatiCittadino datiCittadino) throws RemoteException {
		return gestClient.gestRegistraCittadino(datiCittadino);
	}
}
