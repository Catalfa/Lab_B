package ClientCV.Cittadino.Controller;

import ClientCV.Cittadino.View.Ricerca_CentroVaccinale_View;
import ClientCV.Cittadino.View.SelezionaCentro_View;

import javax.swing.*;

public class SelezionaCentro_Controller extends JFrame{

    SelezionaCentro_View view;
    Ricerca_CentroVaccinale_View ricercaCv_View;

    public SelezionaCentro_Controller(SelezionaCentro_View selezionaCentro_View){
        this.view = selezionaCentro_View;
    }
    
    public void back(){
        view.setVisible(false);
        view.dispose();
        Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View = new Ricerca_CentroVaccinale_View();
    }

    public void closeWindow(){
        view.setVisible(false);
    }

    
}
