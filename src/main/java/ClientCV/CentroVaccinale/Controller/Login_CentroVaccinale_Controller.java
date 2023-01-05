package ClientCV.CentroVaccinale.Controller;

import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.CentroVaccinale.View.Login_CentroVaccinale_View;
import ClientCV.CentroVaccinale.View.Registra_CentroVaccinale_View;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.InfoCentriVaccinali;
import ServerCV.interfaccia.Server;


/**
 * Classe che effettua login di un centro
 */
public class Login_CentroVaccinale_Controller {
    InfoCentriVaccinali infoCentroVaccinali;

    private Login_CentroVaccinale_View loginCVaccView;
    Utility utility = new Utility();
    Server Stub;


    /**
     * Costruttore della classe
     * @param loginCVaccView
     */
    public Login_CentroVaccinale_Controller(Login_CentroVaccinale_View loginCVaccView) {
        this.loginCVaccView = loginCVaccView;
        Stub = ServerSingleton.getInstance();
    }

    /**
     * Metodo bottone back chiude frame corrente e torna frame precendente Login
     */
    public void goBack() {
        MainLoginFrameView mainLoginFrameView = new MainLoginFrameView();
        mainLoginFrameView.setVisible(true);
        loginCVaccView.dispose();
    }

    /**
     * Metodo che gestisce il login del centro vaccinale.
     */
    public int loginCentroVaccinale(String user, String password) {

        // String idcentro, String nome_centro, String tipologia, String qualificatore,
        // String nomevia, int numciv, String comune, String provincia, String sigla,
        // int cap
        // infoCentroVaccinali = new InfoCentriVaccinali(idCentro, nomeCentroVaccinale);

        if (user.isEmpty() || password.isEmpty()) { // ATT ciclo controllo compilare campi, copio per acc lib
            utility.showWarningPopUp("Attenzione", "Riempire tutti i campi.");
            return 0;
        } else {
            try {
                int a = Stub.loginCentroVaccinale(user, password);
                if (a == 1) {
                    loginCVaccView.dispose();
                }
                return a;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    /**
     * Metodo che crea un nuovo frame e chiude quello corrente.
     */
    public void signIn() {
        Registra_CentroVaccinale_View signInCentroVaccinaleView = new Registra_CentroVaccinale_View();
        signInCentroVaccinaleView.setVisible(true);
        loginCVaccView.dispose();
    }

}
