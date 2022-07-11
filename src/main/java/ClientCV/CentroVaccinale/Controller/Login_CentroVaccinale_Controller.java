package ClientCV.CentroVaccinale.Controller;

import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.CentroVaccinale.View.Login_CentroVaccinale_View;
import ClientCV.CentroVaccinale.View.SignIn_CentroVaccinale_View;

public class Login_CentroVaccinale_Controller {

    //no todo per il momento
    
    private Login_CentroVaccinale_View loginCentroVaccinaleView;

    public Login_CentroVaccinale_Controller(Login_CentroVaccinale_View loginCentroVaccinaleView) {
        this.loginCentroVaccinaleView = loginCentroVaccinaleView;
    }

    public void goBack() {
        MainLoginFrameView mainLoginFrameView = new MainLoginFrameView();
        mainLoginFrameView.setVisible(true);
        loginCentroVaccinaleView.dispose();
    }

    public int loginCentroVaccinale(String matricola, char[] password) {
        return 0;
    }

    public void signIn() {
        SignIn_CentroVaccinale_View signInCentroVaccinaleView = new SignIn_CentroVaccinale_View();
        signInCentroVaccinaleView.setVisible(true);
        loginCentroVaccinaleView.dispose();
    }

}
