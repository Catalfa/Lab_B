package ClientCV.AccessoLibero.Controller;

import ClientCV.CentriVaccinali.View.MainAccLibFrameView;
import ClientCV.AccessoLibero.View.Ricerca_CentroVaccinale_View;
import ClientCV.AccessoLibero.View.Tabella_centri;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.InfoCentriVaccinali;
import ServerCV.interfaccia.Server;

import java.util.ArrayList;
import java.util.List;


/** Classe per effettuare la ricerca di un centro vaccinale
 */


public class Ricerca_CentroVaccinale_Controller {

    private Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View;


    private Server Stub;


    /**  Costruttore della classe Ricerca Centro Vaccinale
     *
     * @param ricerca_CentroVaccinale_View
     */

    public Ricerca_CentroVaccinale_Controller(Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View) {
        this.ricerca_CentroVaccinale_View = ricerca_CentroVaccinale_View;
    }


    /** Metodo che crea collegamento con la classe precedente MainAccLib

     */
    public void back() {
        ricerca_CentroVaccinale_View.deleteView();
        MainAccLibFrameView mainAccLibFrameView = new MainAccLibFrameView();
        mainAccLibFrameView.setVisible(true);
    }

    /** Metodo che permette ricercare Centro vaccinale selezionato dal DB

     */
    public void cercaCentro(String nome) {

        List<InfoCentriVaccinali> listaCentri = new ArrayList<>();


        try {
            this.Stub = ServerSingleton.getInstance();
            listaCentri = this.Stub.cercaCentroVaccinale(nome);

            try {
                new Tabella_centri(listaCentri);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ricerca_CentroVaccinale_View.dispose();
        } catch (Exception e) {
            e.printStackTrace();
            Utility.showInformationPopUp("Attenzione!", "Nessun Centro Trovato");
            Ricerca_CentroVaccinale_View ricerca_CentroVaccinale_View = new Ricerca_CentroVaccinale_View();
            ricerca_CentroVaccinale_View.setVisible(true);
        }

    }

}
