package ClientCV.CentriVaccinali.Controller;


import ClientCV.AccessoLibero.View.Ricerca_CentroVaccinale_View;
import ClientCV.CentriVaccinali.View.HomePageView;
import ClientCV.CentriVaccinali.View.MainAccLibFrameView;
//import ClientCV.CentroVaccinale.View.Login_CentroVaccinale_View;    ATTENZIONE- importare quando creo classe
//import ClientCV.Cittadino.View.LoginCittadinoView;

public class MainAccLibFrameController {
    private MainAccLibFrameView mainAccLibFrameView;

    public MainAccLibFrameController(MainAccLibFrameView mainAccLibFrameView){
        this.mainAccLibFrameView = mainAccLibFrameView;
    }

    /**
     * Metodo che torna al frame precedente.
     */
    public void backToHomePage() {
        HomePageView homePageView = new HomePageView();
        homePageView.setVisible(true);
        mainAccLibFrameView.dispose();
    }

    /**
     * Metodo che crea un nuovo frame e manda in dispose quello corrente.
     */
   public void createConsultaInfoCvFrame() {
        Ricerca_CentroVaccinale_View ricerca_centroVaccinale_view = new Ricerca_CentroVaccinale_View();
        ricerca_centroVaccinale_view.setVisible(true);
        mainAccLibFrameView.dispose();
    }

}
