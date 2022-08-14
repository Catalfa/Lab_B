package ClientCV.CentriVaccinali.Controller;

import ClientCV.AccessoLibero.View.EvAvvView;
import ClientCV.AccessoLibero.View.InfCvView;
import ClientCV.CentriVaccinali.View.HomePageView;
import ClientCV.CentriVaccinali.View.MainAccLibFrameView;
//import ClientCV.CentroVaccinale.View.Login_CentroVaccinale_View;    ATTENZIONE- importare quando creo classe
//import ClientCV.Cittadino.View.LoginCittadinoView;

public class MainAccLibFrameController {
    private MainAccLibFrameView accLibFrameView;

    public MainAccLibFrameController(MainAccLibFrameView loginFrameView){
        this.accLibFrameView = accLibFrameView;
    }

    /**
     * Metodo che torna al frame precedente.
     */
    public void backToHomePage() {
        HomePageView homePageView = new HomePageView();
        homePageView.setVisible(true);
        accLibFrameView.dispose();
    }

    /**
     * Metodo che crea un nuovo frame e manda in dispose quello corrente.
     */
   public void createConsultaInfoCvFrame() {
        InfCvView infCvView = new InfCvView();
        infCvView.setVisible(true);
        accLibFrameView.dispose();
    }

    /*public void createTabEventiAvvFrame() {                  //SBLOCCO QUANDO FACCIO EVV AVV
        EvAvvView evAvvView = new EvAvvView();
        EvAvvView.setVisible(true);
        accLibFrameView.dispose();
    }*/
}
