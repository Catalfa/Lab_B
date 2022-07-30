package ClientCV.CentriVaccinali.Controller;

import ClientCV.CentriVaccinali.View.HomePageView;
import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.CentroVaccinale.View.Login_CentroVaccinale_View;
import ClientCV.Cittadino.View.LoginCittadinoView;

public class MainLoginFrameController {
    
    private MainLoginFrameView loginFrameView;

    public MainLoginFrameController(MainLoginFrameView loginFrameView){
        this.loginFrameView = loginFrameView;
    }

    /**
	 * Metodo che torna al frame precedente.
	 */
    public void backToHomePage() {
        HomePageView homePageView = new HomePageView();
        homePageView.setVisible(true);
        loginFrameView.dispose();
    }

    /**
	 * Metodo che crea un nuovo frame e manda in dispose quello corrente.
	 */
    public void createLoginCittadinoFrame() {
        LoginCittadinoView loginCittadinoView = new LoginCittadinoView();
        loginCittadinoView.setVisible(true);
        loginFrameView.dispose();
    }

    public void createLoginDottoreFrame() {
        Login_CentroVaccinale_View loginDottoreView = new Login_CentroVaccinale_View();
        loginDottoreView.setVisible(true);
        loginFrameView.dispose();
    }

}
