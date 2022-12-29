package ClientCV.AccessoLibero.Controller;

import ClientCV.AccessoLibero.View.InfoCvView;
import ClientCV.AccessoLibero.View.Ricerca_CentroVaccinale_View;

public class InfoCvController {

    private InfoCvView infoCvView;
    private Ricerca_CentroVaccinale_View ricerca_centroVaccinale_View;

    public InfoCvController(InfoCvView infoCvView) {
        this.infoCvView = infoCvView;
    }

    public void back() {
        ricerca_centroVaccinale_View.setVisible(false);
        infoCvView.dispose();
        new Ricerca_CentroVaccinale_View();
    }

    /*
     * public void closeWindow() { //metodo finale per chiudere finestre aperte
     * view.setVisible(false);
     * }
     */
}
