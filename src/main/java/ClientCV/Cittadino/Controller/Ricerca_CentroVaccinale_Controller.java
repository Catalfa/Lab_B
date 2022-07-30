package ClientCV.Cittadino.Controller;

import ClientCV.Cittadino.View.LoginCittadinoView;
import ClientCV.Cittadino.View.Ricerca_CentroVaccinale_View;
import ClientCV.Cittadino.View.SelezionaCentro_View;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.InfoCentriVaccinali;
import ServerCV.interfaccia.Server;

import java.util.ArrayList;
import java.util.List;

public class Ricerca_CentroVaccinale_Controller {

    private Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View;
    private LoginCittadinoView loginCittadinoView;
    private SelezionaCentro_View selezionaCentro_View;
    private Server Stub;
    
    public Ricerca_CentroVaccinale_Controller(Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View){
        this.ricerca_CentroVaccinale_View = ricerca_CentroVaccinale_View;
    }

    public void back(){
        ricerca_CentroVaccinale_View.deleteView();
        loginCittadinoView = new LoginCittadinoView();
        loginCittadinoView.setVisible(true);
    }

    public void cercaCentro(String nome){
        //TODO implementare in modo da poter passare e ricevere i dati dal e verso il DB
        //Fare anche metodo che se non ci sono centri corrispondenti a quel nome esce un messaggio 
        //di avviso presente in utility
        List<InfoCentriVaccinali> listaCentri = new ArrayList();
        try {
            this.Stub = ServerSingleton.getInstance();
            listaCentri  = this.Stub.cercaCentroVaccinale(nome);
        } catch (Exception e) {
            e.printStackTrace();
            Utility.showInformationPopUp("Attenzione!", "Nessun Centro Trovato");
        }
        
        selezionaCentro_View = new SelezionaCentro_View(listaCentri);
        selezionaCentro_View.setVisible(true);
    }
    
}
