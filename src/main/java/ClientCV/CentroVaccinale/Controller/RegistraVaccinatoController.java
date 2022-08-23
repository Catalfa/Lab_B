package ClientCV.CentroVaccinale.Controller;

import ClientCV.AccessoLibero.View.InfCvView;
import ClientCV.CentriVaccinali.View.MainAccLibFrameView;
import ClientCV.CentroVaccinale.View.Login_CentroVaccinale_View;
import ClientCV.CentroVaccinale.View.RegistraVaccinatoView;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import ServerCV.interfaccia.Server;

public class RegistraVaccinatoController {

    Server Stub;


    public RegistraVaccinatoView registraVaccinatoView;


    private Utility utility = new Utility();
    private String cf;

    public RegistraVaccinatoController(RegistraVaccinatoView registraVaccinatoView) {
        Stub = ServerSingleton.getInstance();
        this.registraVaccinatoView = registraVaccinatoView;
    }



    public void goBack() {
        Login_CentroVaccinale_View login_centroVaccinale_view = new Login_CentroVaccinale_View();
        login_centroVaccinale_view.setVisible(true);
        registraVaccinatoView.dispose();
    }

    public int infCv(String nome, String cognome, String cf, String vaccinoSomministrato, String idVaccinazione , int dataVaccino, String idCentro) {
        this.cf = cf;

        if (nome.isEmpty() || cognome.isEmpty() || vaccinoSomministrato.isEmpty() || idVaccinazione.isEmpty() || dataVaccino == 0 || idCentro.isEmpty()) {
            utility.showWarningPopUp("Attenzione!", "Controllare che tutti i campi siano compilati.");
            return 0;
        } else {
            try {
                return Stub.registraVaccinato(nome, cognome, vaccinoSomministrato, idVaccinazione, dataVaccino, idCentro);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

}
