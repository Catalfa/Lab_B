package ClientCV.Cittadino.Controller;

import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.Cittadino.View.AggiungiEventoAvversoView;
import ClientCV.Cittadino.View.LoginCittadinoView;
import ClientCV.Cittadino.View.Ricerca_CentroVaccinale_View;
import ClientCV.Cittadino.View.SignInCittadinoView;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.InfoCittadino;
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

        if(username.toString().isEmpty() || password.length == 0){
            utility.showWarningPopUp("Attenzione!", "Controllare che tutti i campi siano compilati.");
            return 1;
        }
        if(password.length < 6){
            utility.showWarningPopUp("Attenzione!", "La password non può essere lunga meno di 6 caratteri.");
            return 1;
        }

        //TODO creare metodo per il controllo nel DB prima di aprire il frame "Ricerca_CentroVaccinale_View"

        switch (Stub.loginCittadino(username,password.toString())){
            //TODO @Andre implementare frame successivi
            case 1:
                AggiungiEventoAvversoView eventoAvversoView = new AggiungiEventoAvversoView(cf);
                break;
            case 2:
                //username non esistente
                break;
            case 3:
                //password errata
                break;
        }
        Ricerca_CentroVaccinale_View ricerca_centro = new Ricerca_CentroVaccinale_View();
        loginCittadinoView.dispose();
        
        return 0;
    }

    public void signinCittadino() {
        SignInCittadinoView signInCittadinoView = new SignInCittadinoView();
        signInCittadinoView.setVisible(true);
        loginCittadinoView.dispose();
    }

}
