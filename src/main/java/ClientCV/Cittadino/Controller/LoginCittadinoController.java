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


/**
 * Classe Login cittadino permette di fare login come cittadino
 */
public class LoginCittadinoController {

    Server Stub;

    Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View;
    public LoginCittadinoView loginCittadinoView;

    public InfoCittadino infoCittadino;
    private Utility utility = new Utility();


    /**
     * Costruttore della classe
     * @param loginCittadinoView
     */
    public LoginCittadinoController(LoginCittadinoView loginCittadinoView) {
        this.loginCittadinoView = loginCittadinoView;
        Stub = ServerSingleton.getInstance();
    }


    /**
     * metodo bottone back chiude frame corrente e apre frame precedente login
     */
    public void goBack() {
        MainLoginFrameView mainLoginFrameView = new MainLoginFrameView();
        mainLoginFrameView.setVisible(true);
        loginCittadinoView.dispose();
    }


    /**
     * metodo gestisce login del cittadino
     * @param username
     * @param password
     * @param cf
     * @return
     * @throws RemoteException
     */
    public int loginCittadino(String username, char[] password, String cf) throws RemoteException {

        AggiungiEventoAvversoView aggiungiEventoAvversoView = new AggiungiEventoAvversoView();
        aggiungiEventoAvversoView.setVisible(true);
        loginCittadinoView.dispose();



        if (username.toString().isEmpty() || password.length == 0 || cf.length() != 16) {
            utility.showWarningPopUp("Attenzione!", "Controllare che tutti i campi siano compilati correttamente.");
            loginCittadinoView = new LoginCittadinoView();
            loginCittadinoView.setVisible(true);
            return 1;
        }

        if (!Stub.CheckCFCittadino(username, cf)) {
            utility.showWarningPopUp("Attenzione!", "verifica che i dati inderiti siano corretti.");
            loginCittadinoView = new LoginCittadinoView();
            loginCittadinoView.setVisible(true);
            return 1;
        }

        String [] aux=Stub.getIdCittadino(cf);

        switch (Stub.loginCittadino(username, password.toString(), cf)) {
            case 1:
                new AggiungiEventoAvversoView(Stub.getIdCittadino(cf ));
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


    /**
     * metodo permette fare sign-in di un nuovo cittadino
     */
    public void signinCittadino() {
        SignInCittadinoView signInCittadinoView = new SignInCittadinoView();
        signInCittadinoView.setVisible(true);
        loginCittadinoView.dispose();
    }

}
