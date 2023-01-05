package ClientCV.CentriVaccinali.Controller;


import ClientCV.AccessoLibero.View.Ricerca_CentroVaccinale_View;
import ClientCV.CentriVaccinali.View.HomePageView;
import ClientCV.CentriVaccinali.View.MainAccLibFrameView;


/**
 * Classe che permette esecuzione del programma tramite Accesso Libero
 */
public class MainAccLibFrameController {
    private MainAccLibFrameView mainAccLibFrameView;
    private Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View;


    /**
     * Costruttore della classe
     *
     * @param mainAccLibFrameView view su cui si baserà il controller
     */
    public MainAccLibFrameController(MainAccLibFrameView mainAccLibFrameView) {
        this.mainAccLibFrameView = mainAccLibFrameView;
    }

    /**
     * Metodo Back che torna al frame precedente.
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
}



