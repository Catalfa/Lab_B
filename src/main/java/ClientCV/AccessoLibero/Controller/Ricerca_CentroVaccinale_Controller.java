package ClientCV.AccessoLibero.Controller;

import ClientCV.AccessoLibero.View.InfoCvView;
import ClientCV.CentriVaccinali.View.MainAccLibFrameView;
import ClientCV.Cittadino.View.AggiungiEventoAvversoView;
import ClientCV.Cittadino.View.LoginCittadinoView;
import ClientCV.AccessoLibero.View.Ricerca_CentroVaccinale_View;
import ClientCV.AccessoLibero.View.SelezionaCentro_View;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.InfoCentriVaccinali;
import ServerCV.interfaccia.Server;

import java.util.ArrayList;
import java.util.List;

public class Ricerca_CentroVaccinale_Controller {

    private Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View;

    private SelezionaCentro_View selezionaCentro_View;

    //private InfoCvView infoCvView;
    private Server Stub;
    
    public Ricerca_CentroVaccinale_Controller(Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View){
        this.ricerca_CentroVaccinale_View = ricerca_CentroVaccinale_View;
    }

    public void back(){
        ricerca_CentroVaccinale_View.deleteView();
        MainAccLibFrameView mainAccLibFrameView = new MainAccLibFrameView();
        mainAccLibFrameView.setVisible(true);
    }

    public void cercaCentro(String nome){

        System.out.println(nome+" Nome in cercacentro"); //usato per verificare che il nome venisse passato
        List<InfoCentriVaccinali> listaCentri=new ArrayList<>();
    //  nome="Astolfo";            usato per vedere se inserendo il nome da codice la lista funziona
        try {
            this.Stub = ServerSingleton.getInstance();
            System.out.println(nome+" Nome per stub"); //usato per verificare che il nome venisse passato
            listaCentri  = this.Stub.cercaCentroVaccinale(nome);
            System.out.println(listaCentri.get(0).getNomeCentro());
            System.out.println(listaCentri.get(0).getTipologia());
            System.out.println(listaCentri.get(0).getQualificatore());
            System.out.println(listaCentri.get(0).getNomeVia());
            System.out.println(listaCentri.get(0).getNumCiv());
            System.out.println(listaCentri.get(0).getComune());
            System.out.println(listaCentri.get(0).getProvincia());
            System.out.println(listaCentri.get(0).getCap());
            selezionaCentro_View = new SelezionaCentro_View(listaCentri);
           // selezionaCentro_View.setVisible(true);
          //  InfoCvView infoCvView= new InfoCvView(listaCentri);
            selezionaCentro_View.setVisible(true);
            ricerca_CentroVaccinale_View.dispose();
        } catch (Exception e) {
            e.printStackTrace();
            Utility.showInformationPopUp("Attenzione!", "Nessun Centro Trovato");
            Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View = new Ricerca_CentroVaccinale_View();
            ricerca_CentroVaccinale_View.setVisible(true);
        }




    }

    public void setSelezionaCentro_View(SelezionaCentro_View selezionaCentro_View) {
        this.selezionaCentro_View = selezionaCentro_View;
    }
}
