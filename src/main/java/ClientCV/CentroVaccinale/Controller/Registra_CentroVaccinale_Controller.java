package ClientCV.CentroVaccinale.Controller;

import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.CentroVaccinale.View.RegistraVaccinatoView;
import ClientCV.CentroVaccinale.View.Registra_CentroVaccinale_View;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.InfoCentriVaccinali;
import ServerCV.interfaccia.Server;

import java.rmi.RemoteException;
import java.util.regex.Pattern;


/**
 * classe Registra Centro gestisce sign-in di un nuovo centro
 */
public class Registra_CentroVaccinale_Controller {

    Server Stub;
    
    private Registra_CentroVaccinale_View registraCentroVaccinaleView;
    private Utility utility = new Utility();
    public final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    /**
     * Costruttore della classe
     * @param registraCentroVaccinaleView view su cui si baserà il controller
     */
    public Registra_CentroVaccinale_Controller(Registra_CentroVaccinale_View registraCentroVaccinaleView) {
        this.registraCentroVaccinaleView = registraCentroVaccinaleView;
        Stub = ServerSingleton.getInstance();
    }

    /**
	 * Metodo bottne che torna al frame precedente e manda dispose quello corrente
	 */
    public void goBack() {
        MainLoginFrameView mainLoginFrameView = new MainLoginFrameView();
        mainLoginFrameView.setVisible(true);
        registraCentroVaccinaleView.dispose();
    }



    /**
	 * Metodo che, dopo aver effettuato vari controlli, invia al server i dati per registrare un nuovo centro vaccinale.
     * @param cVaccinale    Il nome del centro vaccinale.
     */
    public int signIn(InfoCentriVaccinali cVaccinale) throws RemoteException {

        RegistraVaccinatoView registraVaccinatoView = new RegistraVaccinatoView();
        registraVaccinatoView.setVisible(true);
        registraCentroVaccinaleView.dispose();

        if(cVaccinale.getIdCentro().isEmpty() || cVaccinale.getNomeCentro().isEmpty() ||
            cVaccinale.getTipologia().isEmpty() || cVaccinale.getQualificatore().isEmpty() ||
            cVaccinale.getNomeVia().isEmpty() || cVaccinale.getNumCiv() == 0 ||
            cVaccinale.getComune().isEmpty() || cVaccinale.getProvincia().isEmpty() || 
            cVaccinale.getCap()==0 || cVaccinale.getUsername().isEmpty() || cVaccinale.getPassword().isEmpty()){

            utility.showWarningPopUp("Attenzione", "Controllare che tutti i campi siano compilati.");
            Registra_CentroVaccinale_View registra_centroVaccinale_view = new Registra_CentroVaccinale_View();
            registra_centroVaccinale_view.setVisible(true);
            return 1;
        }


        if(cVaccinale.getNumCiv() == -1){
            utility.showWarningPopUp("Attenzione", "Il numero civico dev'essere un numero.");
            Registra_CentroVaccinale_View registra_centroVaccinale_view = new Registra_CentroVaccinale_View();
            registra_centroVaccinale_view.setVisible(true);
            return 1;
        }
        if(cVaccinale.getProvincia().length() != 2){
            utility.showWarningPopUp("Attenzione", "La provincia deve essere una sigla di due caratteri.");
            Registra_CentroVaccinale_View registra_centroVaccinale_view = new Registra_CentroVaccinale_View();
            registra_centroVaccinale_view.setVisible(true);
            return 1;
        }
        int c=Stub.registraCentroVaccinale(cVaccinale);

        Utility.showInformationPopUp("Complimenti!","Registrazione effettuata con successo!");
        return c;
    }

    /**
     * metodo bottone reset cancella dati inseriti e rimane sul frame corrente
     */
    public void reset() {
        for(int i=0; i<10; i++)
        registraCentroVaccinaleView.textFields[i].setText("");
        registraCentroVaccinaleView.passwordField.setText("");
    }
}
