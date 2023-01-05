package ClientCV.CentriVaccinali;

import ServerCV.ConnectionView;
import ClientCV.client.ClientStart;
import ServerCV.server.ServerStart;


/**
 * Classe main Centri Vaccinali
 */
public class CentriVaccinali {
    static ServerStart server = new ServerStart();
    static ClientStart client = new ClientStart();


    /**
     * Costruttore della classe
     * @param args
     */
    public static void main(String[] args) {
        client.start();

        /*
         * String sDate1="2015-03-31";
         * java.sql.Date date1=null;
         * date1= Date.valueOf(sDate1);
         * CentriVaccinaliDaoImpl cv=new CentriVaccinaliDaoImpl();
         * Common.RegistrazioniVaccinati rv=new
         * RegistrazioniVaccinati("Santa Maria","CE44","mnbvcxzlkjhgfds",
         * date1,"Pfizer","VA007","Andra","Russo");
         * cv.insertVaccinato(rv);
         */
    }
}
