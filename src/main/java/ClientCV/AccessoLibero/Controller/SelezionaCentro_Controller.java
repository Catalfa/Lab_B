package ClientCV.AccessoLibero.Controller;

import ClientCV.AccessoLibero.View.Ricerca_CentroVaccinale_View;
import ClientCV.AccessoLibero.View.SelezionaCentro_View;

import javax.swing.*;

public class SelezionaCentro_Controller {

    private SelezionaCentro_View view;
    private Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View;

    public SelezionaCentro_Controller(SelezionaCentro_View selezionaCentro_View) {
        this.view = selezionaCentro_View;
    }

    public void back() {
        view.setVisible(false);
        view.dispose();
        Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View = new Ricerca_CentroVaccinale_View();
    }

    public void closeWindow() {        //metodo finale per chiudere finestre aperte
        view.setVisible(false);
    }

    public Ricerca_CentroVaccinale_View getRicerca_CentroVaccinale_View() {
        return ricerca_CentroVaccinale_View;
    }

    public void setRicerca_CentroVaccinale_View(Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View) {
        this.ricerca_CentroVaccinale_View = ricerca_CentroVaccinale_View;
    }
}


