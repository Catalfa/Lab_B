package ClientCV.Cittadino.Controller;

import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.Cittadino.View.AggiungiEventoAvversoView;
import ClientCV.Cittadino.View.LoginCittadinoView;
import ClientCV.AccessoLibero.View.Ricerca_CentroVaccinale_View;
import ClientCV.Cittadino.View.SignInCittadinoView;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.InfoCittadino;
import ServerCV.database.gestioneDB.CittadiniRegistratiDaoImpl;
import ServerCV.interfaccia.Server;

import java.rmi.RemoteException;

public class LoginCittadinoController {

    Server Stub;
    
    Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View;
    public LoginCittadinoView loginCittadinoView;

    public InfoCittadino infoCittadino;
    private Utility utility = new Utility();

    public LoginCittadinoController(LoginCittadinoView loginCittadinoView) {
        Stub = ServerSingleton.getInstance();
        this.loginCittadinoView = loginCittadinoView;
    }

    public void goBack() {
        MainLoginFrameView mainLoginFrameView = new MainLoginFrameView();
        mainLoginFrameView.setVisible(true);
        loginCittadinoView.dispose();
    }

    public int loginCittadino(String username, char[] password, String cf) throws RemoteException {

        if(username.toString().isEmpty() || password.length == 0 || cf == null || cf.length()!=16){
            utility.showWarningPopUp("Attenzione!", "Controllare che tutti i campi siano compilati correttamente.");
            return 1;
        }

       /* if(!new CittadiniRegistratiDaoImpl().CheckCfCittadino(username,cf)){
            utility.showWarningPopUp("Attenzione!", "verifica che i dati inderiti siano corretti.");
            return 1;
        } */

        switch (Stub.loginCittadino(username,password.toString(), cf)){
            case 1:
                AggiungiEventoAvversoView eventoAvversoView = new AggiungiEventoAvversoView(new CittadiniRegistratiDaoImpl().getIdCittadino(cf));      //log corretto
                break;
            case 2:
                utility.showWarningPopUp("Attenzione!", "Username errato");
                break;
            case 3:
                utility.showWarningPopUp("Attenzione!", "Password errata");
                break;
            case 4:
                utility.showWarningPopUp("Attenzione!", "Codice Fiscale errato");
                break;
        }
        loginCittadinoView.dispose();
        
        return 0;
    }

    public void signinCittadino() {
        SignInCittadinoView signInCittadinoView = new SignInCittadinoView();
        signInCittadinoView.setVisible(true);
        loginCittadinoView.dispose();
    }

}
