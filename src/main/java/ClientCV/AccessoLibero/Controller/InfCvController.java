package ClientCV.AccessoLibero.Controller;

import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.Cittadino.View.AggiungiEventoAvversoView;
import ClientCV.Cittadino.View.LoginCittadinoView;
import ClientCV.Cittadino.View.Ricerca_CentroVaccinale_View;
import ClientCV.Cittadino.View.SignInCittadinoView;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.InfoCittadino;
import ServerCV.interfaccia.Server;

import javax.swing.*;
import java.rmi.RemoteException;

public class InfCvController {

    Server Stub;

    //Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View;
    public InfCvView infCvView;

    //public InfoCittadino infoCittadino;                      /** controllo*/
    private Utility utility = new Utility();

    public InfCvController(InfCvView infCvView) {
        Stub = ServerSingleton.getInstance();
        this.infCvView = infCvView;
    }

    public void goBack() {
        MainLoginFrameView mainLoginFrameView = new MainLoginFrameView();
        mainLoginFrameView.setVisible(true);
        infCvView.dispose();
    }

    public int infCv(String nomeCv, String comune, String tipologia) throws RemoteException {

        if(nomeCv.toString().isEmpty() || comune == null || tipologia == null){
            utility.showWarningPopUp("Attenzione!", "Controllare che tutti i campi siano compilati.");
            return 1;
        }

        if(comune.toString().isEmpty() || nomeCv == null || tipologia == null){
            utility.showWarningPopUp("Attenzione!", "Controllare che tutti i campi siano compilati.");
            return 1;
        }

        if(tipologia.toString().isEmpty() || nomeCv == null || comune == null){
            utility.showWarningPopUp("Attenzione!", "Controllare che tutti i campi siano compilati.");
            return 1;
        }
        //TODO creare metodo per il controllo nel DB prima di aprire il frame "Ricerca_CentroVaccinale_View"

        switch (Stub.loginCittadino(nomeCv, comune.toString())){
            //TODO @Andre implementare frame successivi
            case 1:
                InformazioniCvView informazioniCvView = new InformazioniCvView(cf);        //creo classe InformazioniCv
                break;
            case 2:
                //username non esistente
                break;
            case 3:
                //password errata
                break;
        }
        InformazioniCvView infoCentro = new InformazioniCvView();  /////////////////////
        infCvView.dispose();

        return 0;
    }

}
