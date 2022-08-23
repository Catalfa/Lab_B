package ClientCV.CentroVaccinale.Controller;

import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.CentroVaccinale.View.Registra_CentroVaccinale_View;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.InfoCentriVaccinali;
import ServerCV.interfaccia.Server;

import java.rmi.RemoteException;
import java.util.regex.Pattern;

public class Registra_CentroVaccinale_Controller {

    Server Stub;
    
    private Registra_CentroVaccinale_View registraCentroVaccinaleView;
    private Utility utility = new Utility();
    public final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public Registra_CentroVaccinale_Controller(Registra_CentroVaccinale_View registraCentroVaccinaleView) {
        this.registraCentroVaccinaleView = registraCentroVaccinaleView;
        Stub = ServerSingleton.getInstance();
    }

    /**
	 * Metodo che torna al frame precedente.
	 */
    public void goBack() {
        MainLoginFrameView mainLoginFrameView = new MainLoginFrameView();
        mainLoginFrameView.setVisible(true);
        registraCentroVaccinaleView.dispose();
    }

    //* In base al codice restituito dal server puo' mostrare, o un messaggio d'errore o uno di avvenuto inserimento.

    /**
	 * Metodo che, dopo aver effettuato vari controlli, invia al server i dati per registrare un nuovo centro vaccinale.
     * @param cVaccinale    Il nome del centro vaccinale.
     */
    public int signIn(InfoCentriVaccinali cVaccinale) throws RemoteException {

        /*
        gli errori di tipo 1 sono errori dal lato client
        gli errori di tipo 2 sono errori dal lato server
        return tipo 0indica che non ci sono errori 
        */

        if(cVaccinale.getIdCentro().isEmpty() || cVaccinale.getNomeCentro().isEmpty() ||
            cVaccinale.getTipologia().isEmpty() || cVaccinale.getQualificatore().isEmpty() ||
            cVaccinale.getNomeVia().isEmpty() || cVaccinale.getNumCiv() == 0 ||
            cVaccinale.getComune().isEmpty() || cVaccinale.getProvincia().isEmpty() || 
            cVaccinale.getCap()==0){

            utility.showWarningPopUp("Attenzione", "Controllare che tutti i campi siano compilati.");
            return 1;
        }

        //Controlla con il metodo presente nel bottone "buttons[1] nella View"
        if(cVaccinale.getNumCiv() == -1){
            utility.showWarningPopUp("Attenzione", "Il numero civico dev'essere un numero.");
            return 1;
        }

        if(cVaccinale.getCap() < 10000){
            utility.showWarningPopUp("Attenzione", "Controllare che il campo CAP sia corretto.");
            return 1;
        }

        if(cVaccinale.getProvincia().length() != 2){
            utility.showWarningPopUp("Attenzione", "La provincia deve essere una sigla di due caratteri.");
            return 1;
        }
        
        return Stub.registraCentroVaccinale(cVaccinale);
    }

    
    public void reset() {
        for(int i=0; i<7; i++)
        registraCentroVaccinaleView.textFields[i].setText("");
        registraCentroVaccinaleView.passwordField.setText("");
    }
}
