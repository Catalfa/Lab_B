package ClientCV.Cittadino.Controller;


import ClientCV.CentriVaccinali.View.MainAccLibFrameView;
import ClientCV.Cittadino.View.EvAvvView;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.EventiAvversi;
import ServerCV.interfaccia.Server;
public class EvAvvController {
    /*
   Server Stub;


    public EvAvvView evAvvView;


    private Utility utility = new Utility();

    public EvAvvController(EvAvvView evAvvView) {
        Stub = ServerSingleton.getInstance();
        this.evAvvView = evAvvView;
    }
e


    public void goBack() {
        MainAccLibFrameView mainAccLibFrameView = new MainAccLibFrameView();
        mainAccLibFrameView.setVisible(true);
       // evAvvView.dispose();
    }

    public int evAvv(String nomeCv, String tipoEv, int intensitàMedia, String noteEv) {
        EventiAvversi segnalazione=new EventiAvversi();
        if (nomeCv.isEmpty() || tipoEv.isEmpty() || intensitàMedia == 0 || intensitàMedia > 10 || noteEv.isEmpty()) {
            utility.showWarningPopUp("Attenzione!", "Controllare che tutti i campi siano compilati.");
            return 0;
        }

        else{
            try {
                return Stub.infCv(nomeCv,tipoEv, intensitàMedia, noteEv);
                Stub.InserisciEventiAvversi()
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }


    /**
     * Metodo che crea un nuovo frame e manda in dispose quello corrente.
     *
     *
     *
     *
     * ATTTTTTTTTTTT
     *QUESTO è ULTIMO FRAME, NON DEVO INVIARE IN UNO SUCCESSIVO MA SALVARE DATI, COME LO SISTEMO?
     */


   /* public void invio() {
        Registra_CentroVaccinale_View signInCentroVaccinaleView = new Registra_CentroVaccinale_View();
        signInCentroVaccinaleView.setVisible(true);
        infCvView.dispose();
    } */
}
