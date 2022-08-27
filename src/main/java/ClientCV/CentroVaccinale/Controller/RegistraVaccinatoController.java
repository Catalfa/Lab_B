package ClientCV.CentroVaccinale.Controller;

import ClientCV.CentroVaccinale.View.Login_CentroVaccinale_View;
import ClientCV.CentroVaccinale.View.RegistraVaccinatoView;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import Common.RegistrazioniVaccinati;
import ServerCV.interfaccia.Server;

public class RegistraVaccinatoController {

    Server Stub;


    public RegistraVaccinatoView registraVaccinatoView;


    private Utility utility = new Utility();

    public RegistraVaccinatoController(RegistraVaccinatoView registraVaccinatoView) {
        Stub = ServerSingleton.getInstance();
        this.registraVaccinatoView = registraVaccinatoView;
    }



    public void goBack() {
        Login_CentroVaccinale_View login_centroVaccinale_view = new Login_CentroVaccinale_View();
        login_centroVaccinale_view.setVisible(true);
        registraVaccinatoView.dispose();
    }

    public void registraVaccinato(RegistrazioniVaccinati vaccinato) {

        if (vaccinato.getNomeVaccinato().isEmpty() ||vaccinato.getCognomeVaccinato().isEmpty() || vaccinato.getIdVaccinazione().isEmpty() || vaccinato.getTipoVaccino().isEmpty() || vaccinato.getDataVaccino() == null || vaccinato.getIdCentro().isEmpty() || vaccinato.getnomeCentro().isEmpty()) {
            utility.showWarningPopUp("Attenzione!", "Controllare che tutti i campi siano compilati.");
            return;
        } else {
            try {
                     switch (Stub.registraVaccinato(vaccinato)){
                         case 1:
                            Utility.showInformationPopUp("complimenti", "vaccinazione effettuata con successo");
                             break;
                         case 2:
                             utility.showWarningPopUp("Attenzione!", "ID vaccinazione già esistente.");

                             break;
                         case 3:
                             utility.showWarningPopUp("Attenzione!", "cittadino già registrato.");
                             break;

                     }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return;
    }

}
