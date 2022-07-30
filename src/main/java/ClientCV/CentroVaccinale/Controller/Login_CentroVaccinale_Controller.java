package ClientCV.CentroVaccinale.Controller;

import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.CentroVaccinale.View.Login_CentroVaccinale_View;
import ClientCV.CentroVaccinale.View.Registra_CentroVaccinale_View;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.InfoCentriVaccinali;
import ServerCV.interfaccia.Server;

public class Login_CentroVaccinale_Controller {
    InfoCentriVaccinali infoCentroVaccinali;

    private Login_CentroVaccinale_View loginCVaccView;
    Utility utility = new Utility();
    Server Stab;

    public Login_CentroVaccinale_Controller(Login_CentroVaccinale_View loginCVaccView) {
        this.loginCVaccView = loginCVaccView;
        Stab = ServerSingleton.getInstance();
    }

    /**
	 * Metodo che torna al frame precedente.
	 */
    public void goBack() {
        MainLoginFrameView mainLoginFrameView = new MainLoginFrameView();
        //mainLoginFrameView.setVisible(true);
        loginCVaccView.dispose();
    }

    /**
	 * Metodo che gestisce il login del centro vaccinale.
	 * @param nomeCentroVaccinale	Il nome del centro vaccinale.
     * @param idCentro              L'id del centro vaccinale.
	 * @return				Un codice per.
	 */
    public int loginCentroVaccinale(String nomeCentroVaccinale, String idCentro) {

        //String idcentro, String nome_centro, String tipologia, String qualificatore, String nomevia, int numciv, String comune, String provincia, String sigla, int cap 
        infoCentroVaccinali = new InfoCentriVaccinali(idCentro, nomeCentroVaccinale);
        
        if(nomeCentroVaccinale.isEmpty() || idCentro.isEmpty()){
            utility.showWarningPopUp("Attenzione", "Riempire tutti i campi.");
            return 1;
        }

        else{
            try {
                this.Stab.loginCittadino(nomeCentroVaccinale, idCentro.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return 0;
    }

    /**
	 * Metodo che crea un nuovo frame e manda in dispose quello corrente.
	 */
    public void signIn() {
        Registra_CentroVaccinale_View signInCentroVaccinaleView = new Registra_CentroVaccinale_View();
        signInCentroVaccinaleView.setVisible(true);
        loginCVaccView.dispose();
    }

}
