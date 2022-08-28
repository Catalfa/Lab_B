package ClientCV.AccessoLibero.Controller;

import ClientCV.AccessoLibero.View.Ricerca_CentroVaccinale_View;
import ClientCV.AccessoLibero.View.SelezionaCentro_View;

import javax.swing.*;

public class SelezionaCentro_Controller extends JFrame{

    private SelezionaCentro_View view;
    private Ricerca_CentroVaccinale_View ricerca_centroVaccinale_View;

    public SelezionaCentro_Controller(SelezionaCentro_View selezionaCentro_View){
        this.view = selezionaCentro_View;
    }
    
    public void back(){
        view.setVisible(false);
        view.dispose();
        Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View = new Ricerca_CentroVaccinale_View();
        System.out.println("ciao");
    }

    public void closeWindow(){
        view.setVisible(false);
    }                  //metodo finale per chiudere finestre aperte

    
}
