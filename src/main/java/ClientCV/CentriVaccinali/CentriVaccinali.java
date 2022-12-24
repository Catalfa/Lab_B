package ClientCV.CentriVaccinali;

import ClientCV.client.ClientStart;
import Common.RegistrazioniVaccinati;
import ServerCV.database.gestioneDB.CentriVaccinaliDaoImpl;
import ServerCV.server.ServerStart;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CentriVaccinali {
    static ServerStart server = new ServerStart();
    static ClientStart client = new ClientStart();

    public static void main(String[] args) {
        server.start();
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
