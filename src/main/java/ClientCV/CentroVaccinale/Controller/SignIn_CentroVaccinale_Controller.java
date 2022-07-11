package ClientCV.CentroVaccinale.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ClientCV.Utility;
import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ClientCV.CentroVaccinale.View.SignIn_CentroVaccinale_View;
import Common.CentroVaccinale;

public class SignIn_CentroVaccinale_Controller {

    //todo
    //Modificare la classe in modo che rispetti CentroVaccinale presente in Common, modificare quella, vedi todo
    
    private SignIn_CentroVaccinale_View signInCentroVaccinaleView;
    private Utility utility = new Utility();
    public final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public SignIn_CentroVaccinale_Controller(SignIn_CentroVaccinale_View signInCentroVaccinaleView) {
        this.signInCentroVaccinaleView = signInCentroVaccinaleView;
    }

    public void goBack() {
        MainLoginFrameView mainLoginFrameView = new MainLoginFrameView();
        mainLoginFrameView.setVisible(true);
        signInCentroVaccinaleView.dispose();
    }

    public int signIn(CentroVaccinale cVaccinale) {
        String matricola = cVaccinale.GetMatricola();

        if(cVaccinale.GetNome().isEmpty() || cVaccinale.GetCognome().isEmpty() || cVaccinale.GetEmail().isEmpty() || cVaccinale.GetMatricola().isEmpty() || cVaccinale.GetPassword().length==0) {
            utility.showWarningPopUp("Attenzione", "Controllare che tutti i campi siano compilati");
            return 1;
        }

        if(!(matricola.matches("[0-9]+") && matricola.length() == 6)) {
            utility.showWarningPopUp("Attenzione", "Controllare che la matricola contenga solo numeri e sia lunga 6 cifre");
            return 1;
        }

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(cVaccinale.GetEmail());
        if(!matcher.find()) {
            utility.showWarningPopUp("Attenzione", "La mail non è valida, controllare la formattazione");
            return 1;
        }

        if(cVaccinale.GetPassword().length <6) {
            utility.showWarningPopUp("Attenzione", "La password deve essere di almeno 6 caratteri");
            return 1;
        }

        return 0;
    }

    public void reset() {
        for(int i=0; i<4; i++)
        signInCentroVaccinaleView.textFields[i].setText("");
        signInCentroVaccinaleView.passwordField.setText("");
    }
}
