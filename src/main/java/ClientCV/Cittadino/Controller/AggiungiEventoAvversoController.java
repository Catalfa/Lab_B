package ClientCV.Cittadino.Controller;

import ClientCV.Cittadino.View.AggiungiEventoAvversoView;
import ClientCV.Cittadino.View.Ricerca_CentroVaccinale_View;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.EventiAvversi;
import ServerCV.interfaccia.Server;
import ServerCV.server.*;

import java.awt.event.KeyEvent;
import java.rmi.RemoteException;

public class AggiungiEventoAvversoController {

    private AggiungiEventoAvversoView eventoAvversoView;
    private Server Stub;
    //private ServerImpl serverImpl;
    
    public AggiungiEventoAvversoController(AggiungiEventoAvversoView eventoAvversoView) {
        Stub = ServerSingleton.getInstance();
        this.eventoAvversoView = eventoAvversoView;
    }

    //Se la view estende JFrame allora definisco il .setVisible() nella classe della view
    //Se la view invece definisce il JFrame come oggetto allora posso richiamare il frame nel controller e 
    //  appicargli il metodo .setVisible()

    public void goBack(){
        //SelezionaCentro_View selezionaCentro_View = new SelezionaCentro_View(serverImpl.cercaCentroVaccinale(testo));
        Ricerca_CentroVaccinale_View view = new Ricerca_CentroVaccinale_View();
        eventoAvversoView.deleteView();
    }

    /**
	 * Metodo che, dopo aver effettuato vari controlli, invia al server i dati per registrare gli eventi avversi inseriti dal cittadino.
	 * In base al codice restituito dal server puo' mostrare, o un messaggio d'errore o uno di avvenuto inserimento.
	 * @param intensitaEventi	L'intensit� dei vari eventi.
	 * @param noteEventi		Le note sui vari eventi.
	 * @param nomeCentro		Il nome del centro vaccinale.
	 * @param eventi			La lista degli eventi.
	 */
    
     public void inserisciEventiAvversiAction(String idEvento, String nomeCentro, String[] eventi, Integer[] intensitaEventi, String[] noteEventi){
        EventiAvversi eventoAvverso = new EventiAvversi(Integer.parseInt(idEvento), nomeCentro, eventi, intensitaEventi, noteEventi);

        try {
            int risultato = Stub.InserisciEventiAvversi(eventoAvverso);
            if (risultato == 2) {
                Utility.showErrorPopUp("ERRORE", "Non ti sei vaccinato in questo centro vaccinale");
                return;
            }if (risultato == 1) {
                Utility.showInformationPopUp("Richiesta andata a buon fine.", "Eventi avversi inseriti con successo");

                //eventoAvversoView.deleteView();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
	 * Metodo che conta il numero di caratteri digirati e mostra un pop-up di errore quando viene raggiunto il massimo numero di caratteri disponibili.
	 * @param arg0				L'evento chiave.
	 * @param count_numCharNote		Il numero di caratteri disponibili rimanenti.
	 */
    public void checkNumCharAction(KeyEvent arg0, int count_numCharNote) {
        if(count_numCharNote==0) {
            Utility.showErrorPopUp("ERRORE", "Ragiunto numero massimo di caratteri disponibili");
            arg0.consume();
        }
        return;
    }

}
