package ClientCV.Cittadino.Controller;

import javax.swing.JFrame;

import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.Cittadino.View.AggiungiEventoAvversoView;
import ClientCV.Cittadino.View.SignInCittadinoView;
import Common.DatiCittadino;

public class SignInCittadinoController extends JFrame{
    
    private SignInCittadinoView signInCittadinoView;
    public JFrame isVisible;
    

    public SignInCittadinoController(SignInCittadinoView signInCittadinoView) {
        this.signInCittadinoView = signInCittadinoView;
    }

    public void goBack() {
        MainLoginFrameView mainLoginFrameView = new MainLoginFrameView();
        mainLoginFrameView.setVisible(true);
        signInCittadinoView.dispose();
    }

    
    public int signIn(DatiCittadino cittadini) {
        AggiungiEventoAvversoView eventoAvversoView = new AggiungiEventoAvversoView();
        signInCittadinoView.dispose();
        return 0;
    }

    public void reset() {
        for(int i=0; i<5; i++)
            signInCittadinoView.textFields[i].setText("");
            signInCittadinoView.passwordField.setText("");
    }
}
