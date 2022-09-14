package ClientCV.CentriVaccinali.Controller;


import ClientCV.AccessoLibero.View.Ricerca_CentroVaccinale_View;
import ClientCV.CentriVaccinali.View.HomePageView;
import ClientCV.CentriVaccinali.View.MainAccLibFrameView;
//import ClientCV.CentroVaccinale.View.Login_CentroVaccinale_View;    ATTENZIONE- importare quando creo classe
//import ClientCV.Cittadino.View.LoginCittadinoView;

public class MainAccLibFrameController {
    private MainAccLibFrameView mainAccLibFrameView;
    private Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View;

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
        Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View = new Ricerca_CentroVaccinale_View();
        ricerca_CentroVaccinale_View.setVisible(true);
        mainAccLibFrameView.dispose();
    }

    public Ricerca_CentroVaccinale_View getRicerca_CentroVaccinale_View() {
        return ricerca_CentroVaccinale_View;
    }

    public void setRicerca_CentroVaccinale_View(Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View) {
        this.ricerca_CentroVaccinale_View = ricerca_CentroVaccinale_View;
    }
}
