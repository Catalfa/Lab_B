package ClientCV.AccessoLibero.Controller;

import ClientCV.AccessoLibero.View.InfCvView;
import ClientCV.CentriVaccinali.View.MainAccLibFrameView;
import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.CentroVaccinale.View.Registra_CentroVaccinale_View;
import ClientCV.Cittadino.View.AggiungiEventoAvversoView;
import ClientCV.Cittadino.View.LoginCittadinoView;
import ClientCV.Cittadino.View.Ricerca_CentroVaccinale_View;
import ClientCV.Cittadino.View.SignInCittadinoView;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.InfoCentriVaccinali;
import Common.InfoCittadino;
import ServerCV.interfaccia.Server;

import javax.swing.*;
import java.rmi.RemoteException;

public class InfCvController {

    Server Stub;


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
    public void invio() {
        Registra_CentroVaccinale_View signInCentroVaccinaleView = new Registra_CentroVaccinale_View();
        signInCentroVaccinaleView.setVisible(true);
        infCvView.dispose();
    }


}


