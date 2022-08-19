package ClientCV.AccessoLibero.Controller;

import ClientCV.AccessoLibero.View.InfCvView;
import ClientCV.CentriVaccinali.View.MainAccLibFrameView;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import ServerCV.interfaccia.Server;

public class InfCvController {

    /*Server Stub;


    public InfCvView infCvView;


    private Utility utility = new Utility();

    public InfCvController(InfCvView infCvView) {
        Stub = ServerSingleton.getInstance();
        this.infCvView = infCvView;
    }



    public void goBack() {
        MainAccLibFrameView mainAccLibFrameView = new MainAccLibFrameView();
        mainAccLibFrameView.setVisible(true);
        infCvView.dispose();
    }

    public int infCv(String nomeCv, String comune, String tipologia) {

        if (nomeCv.isEmpty() || comune.isEmpty() || tipologia.isEmpty()) {
            utility.showWarningPopUp("Attenzione!", "Controllare che tutti i campi siano compilati.");
            return 0;
        }

        else{
            try {
                return Stub.infCv(nomeCv,comune, tipologia);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    /**
     * Metodo che crea un nuovo frame e manda in dispose quello corrente.
     */
  /*  public void invio() {                                           //CLASSE SUCCESSIVA
        InfCvView InformazioniCvView = new InfCvView();
        InformazioniCvView.setVisible(true);
        infCvView.dispose();
    }*/


}


