package ClientCV.AccessoLibero.Controller;

import ClientCV.AccessoLibero.View.InfoCvView;
import ClientCV.AccessoLibero.View.Ricerca_CentroVaccinale_View;
import ClientCV.AccessoLibero.View.SelezionaCentro_View;
import ClientCV.CentriVaccinali.View.MainAccLibFrameView;

public class InfoCvController {

    private InfoCvView infoCvView;
    private Ricerca_CentroVaccinale_View ricerca_centroVaccinale_View;

    public InfoCvController(InfoCvView infoCvView) {
        this.infoCvView = infoCvView;
    }


  /*  public MainAccLibFrameController(MainAccLibFrameView mainAccLibFrameView){
        this.mainAccLibFrameView = mainAccLibFrameView;
    }
    */



    public void back() {
        infoCvView.setVisible(false);
        infoCvView.dispose();
        Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View = new Ricerca_CentroVaccinale_View();
    }

  /*  public void closeWindow() {        //metodo finale per chiudere finestre aperte
        view.setVisible(false);
    } */
}
