package ClientCV.Cittadino.Controller;

import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.Cittadino.View.LoginCittadinoView;
import ClientCV.Cittadino.View.SignInCittadinoView;

public class LoginCittadinoController {
    
    private LoginCittadinoView loginCittadinoView;

    public LoginCittadinoController(LoginCittadinoView loginCittadinoView) {
        this.loginCittadinoView = loginCittadinoView;
    }

    public void goBack() {
        MainLoginFrameView mainLoginFrameView = new MainLoginFrameView();
        mainLoginFrameView.setVisible(true);
        loginCittadinoView.dispose();
    }

    public int loginCittadino(String username, char[] password) {
        return 0;
    }

    public void signinCittadino() {
        SignInCittadinoView signInCittadinoView = new SignInCittadinoView();
        signInCittadinoView.setVisible(true);
        loginCittadinoView.dispose();
    }

}
