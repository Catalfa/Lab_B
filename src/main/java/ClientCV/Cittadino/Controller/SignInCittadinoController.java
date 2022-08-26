package ClientCV.Cittadino.Controller;

import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.CentroVaccinale.View.RegistraVaccinatoView;
import ClientCV.Cittadino.View.AggiungiEventoAvversoView;
import ClientCV.Cittadino.View.SignInCittadinoView;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.DatiCittadino;
import Common.InfoCentriVaccinali;
import ServerCV.database.gestioneDB.CentriVaccinaliDaoImpl;
import ServerCV.interfaccia.Server;

import javax.swing.*;
import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInCittadinoController extends JFrame{
    
    private SignInCittadinoView signInCittadinoView;
    private AggiungiEventoAvversoView eventoAvversoView;
    private Utility utility = new Utility();
    public final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    Server stub;
    
    

    public SignInCittadinoController(SignInCittadinoView signInCittadinoView) {
        this.signInCittadinoView = signInCittadinoView;
        stub= ServerSingleton.getInstance();
    }

    public void goBack() {
        MainLoginFrameView mainLoginFrameView = new MainLoginFrameView();
        mainLoginFrameView.setVisible(true);
        signInCittadinoView.dispose();
    }

    public int signIn(DatiCittadino cittadini) throws RemoteException {

        AggiungiEventoAvversoView aggiungiEventoAvversoView = new AggiungiEventoAvversoView();   /**COANDO COLLEGAMENTO NUOVO**/
        aggiungiEventoAvversoView.setVisible(true);
        signInCittadinoView.dispose();

         if(cittadini.getNomeCittadino().isEmpty() || cittadini.getCognomeCittadino().isEmpty() || cittadini.getCFCittadino().length() < 16 || cittadini.getEmailCittadino().isEmpty() ||cittadini.getUsernameCittadino().isEmpty() || cittadini.getPasswordCittadino().length()==0 ){
            utility.showWarningPopUp("Attenzione", "Controllare che tutti i campi siano compilati");
            return 1;    
        }
        
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(cittadini.getEmailCittadino());
        if(!matcher.find()){
            utility.showWarningPopUp("Attenzione", "La mail non è valida, controllare la formattazione");
            return 1;
        }

        if(cittadini.getPasswordCittadino().length() <6) {
            utility.showWarningPopUp("Attenzione", "La password deve essere di almeno 6 caratteri");
            return 1;
        }
        if(stub.registraCittadino(cittadini)==1){
               new Utility().showConfirmationPopUp("avviso"," registrazione effettuata con successo");
           }else{
               new Utility().showWarningPopUp("attenzione", "errore nella registrazioe");
           }
            
            signInCittadinoView.dispose();
        
        return 0;
    }

    public void reset() {
        for(int i=0; i<8; i++)
            signInCittadinoView.textFields[i].setText("");
            signInCittadinoView.passwordField.setText("");
    }
}