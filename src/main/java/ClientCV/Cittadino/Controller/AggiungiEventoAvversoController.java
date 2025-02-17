package ClientCV.Cittadino.Controller;

import ClientCV.Cittadino.View.AggiungiEventoAvversoView;
import ClientCV.Cittadino.View.LoginCittadinoView;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.EventiAvversi;
import ServerCV.interfaccia.Server;

import java.awt.event.KeyEvent;
import java.rmi.RemoteException;

/**
 * Classe che gestisce l'inserimento degli eventi avversi
 */
public class AggiungiEventoAvversoController {

    public LoginCittadinoView cf;
    private AggiungiEventoAvversoView eventoAvversoView;
    private Server Stub;
    //private ServerImpl serverImpl;

    /**
     * costruttore della classe
     * @param eventoAvversoView view su cui si baserà il controller
     */
    public AggiungiEventoAvversoController(AggiungiEventoAvversoView eventoAvversoView) {
        Stub = ServerSingleton.getInstance();
        this.eventoAvversoView = eventoAvversoView;
    }


    /**
     * metodo bottone back chiude frame corrente e torna frame precedente login cittadino
     */
    public void goBack(){
        LoginCittadinoView loginCittadinoView = new LoginCittadinoView();
        loginCittadinoView.setVisible(true);
        eventoAvversoView.deleteView();
    }


    /**
	 * Metodo che, dopo aver effettuato vari controlli, invia al server i dati per registrare gli eventi avversi inseriti dal cittadino.
	 * In base al codice restituito dal server puo' mostrare, o un messaggio d'errore o uno di avvenuto inserimento.
	 * @param intensitaEventi	L'intensit� dei vari eventi.
	 * @param noteEventi		Le note sui vari eventi.
	 * @param nomeCentro		Il nome del centro vaccinale.
	 * @param eventi			La lista degli eventi. */

     public void inserisciEventiAvversiAction( String idEvento,String codiceFiscale,String nomeCentro, String[] eventi, Integer[] intensitaEventi, String[] noteEventi){
        EventiAvversi eventoAvverso = new EventiAvversi(idEvento, nomeCentro, eventi, intensitaEventi, noteEventi,codiceFiscale);

        try {
            int risultato = Stub.InserisciEventiAvversi(eventoAvverso, codiceFiscale);
           if (risultato == 2) {
                Utility.showErrorPopUp("ERRORE", "Non risulta vaccinazione intestato al tuo ID vaccinazione, potrai effettuare segnalazioni solo dopo aver ricevuto il vaccino");
                return;
            }if (risultato == 3) {
                Utility.showErrorPopUp("ERRORE", "Sono gia' stati inseriti degli eventi avversi per questo Id");
                return;
            }
            if (risultato == 1 ) {
                Utility.showInformationPopUp("Richiesta andata a buon fine.", "Eventi avversi inseriti con successo");
                LoginCittadinoView loginCittadinoView = new LoginCittadinoView();
                loginCittadinoView.setVisible(true);
                eventoAvversoView.deleteView();

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
        if(count_numCharNote==256){

            Utility.showErrorPopUp("ERRORE", "Raggiunto numero massimo di caratteri disponibili");
            arg0.consume();
        }
        return;
    }


}
