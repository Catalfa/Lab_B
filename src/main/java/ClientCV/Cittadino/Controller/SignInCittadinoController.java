package ClientCV.Cittadino.Controller;

import ClientCV.CentriVaccinali.Controller.MainLoginFrameController;
import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.Cittadino.View.AggiungiEventoAvversoView;
import ClientCV.Cittadino.View.SignInCittadinoView;
import ClientCV.Cittadino.View.LoginCittadinoView;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.DatiCittadino;
import ServerCV.interfaccia.Server;

import javax.swing.*;
import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * classe che gestisce la registrazione di un nuovo cittadino
 */
public class SignInCittadinoController extends JFrame {

    private SignInCittadinoView signInCittadinoView;
    private Utility utility = new Utility();
    public final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);
    Server stub;
   // MainLoginFrameController controller = new MainLoginFrameController(new MainLoginFrameView());


    /**
     * Costruttore della classe
     * @param signInCittadinoView
     */
    public SignInCittadinoController(SignInCittadinoView signInCittadinoView) {
        this.signInCittadinoView = signInCittadinoView;
        stub = ServerSingleton.getInstance();
    }

    /**
     * metodo bottone back chiude frame corrente e torna frame Login cittadino
     */
    public void goBack() {
        LoginCittadinoView loginCittadinoView = new LoginCittadinoView();
        loginCittadinoView.setVisible(true);
        signInCittadinoView.dispose();
    }

    /**
     * metodo che gestisce sign-in del cittadino
     * @param cittadini insieme dei dati del cittadino
     * @return 1 in caso di problemi, 0 in caso contrario
     * @throws RemoteException
     */
    public int signIn(DatiCittadino cittadini) throws RemoteException {

        AggiungiEventoAvversoView aggiungiEventoAvversoView = new AggiungiEventoAvversoView();
        aggiungiEventoAvversoView.setVisible(true);
        signInCittadinoView.dispose();

        if (cittadini.getNomeCittadino().isEmpty() || cittadini.getCognomeCittadino().isEmpty()
                || cittadini.getCFCittadino().length() < 16 || cittadini.getEmailCittadino().isEmpty()
                || cittadini.getUsernameCittadino().isEmpty() || cittadini.getPasswordCittadino().length() == 0) {
            utility.showWarningPopUp("Attenzione", "Controllare che tutti i campi siano compilati");
            SignInCittadinoView signInCittadinoView = new SignInCittadinoView();
            signInCittadinoView.setVisible(true);
            return 1;
        }

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(cittadini.getEmailCittadino());
        if (!matcher.find()) {
            utility.showWarningPopUp("Attenzione", "La mail non è valida, controllare la formattazione");
            SignInCittadinoView signInCittadinoView = new SignInCittadinoView();
            signInCittadinoView.setVisible(true);
            return 1;
        }

        if (cittadini.getPasswordCittadino().length() < 6) {
            utility.showWarningPopUp("Attenzione", "La password deve essere di almeno 6 caratteri");
            SignInCittadinoView signInCittadinoView = new SignInCittadinoView();
            signInCittadinoView.setVisible(true);
            return 1;
        }
        if (stub.registraCittadino(cittadini) == 1) {
            new Utility().showConfirmationPopUp("avviso", " registrazione effettuata con successo!");
            LoginCittadinoView loginframe = new LoginCittadinoView();
            loginframe.setVisible(true);
        } else {
            new Utility().showWarningPopUp("attenzione", "Codice Fiscale già registrato");
            SignInCittadinoView signInCittadinoView = new SignInCittadinoView();
            signInCittadinoView.setVisible(true);
        }

        signInCittadinoView.dispose();

        return 0;
    }

    /**
     * metodo bottone reset cancella dati inseriti e rimane su frame corrente
     */
    public void reset() {
        for (int i = 0; i < 8; i++)
            signInCittadinoView.textFields[i].setText("");
        signInCittadinoView.passwordField.setText("");
    }
}