package ServerCV.database;

import ClientCV.client.ClientStart;
import ClientCV.client.ServerSingleton;
import Common.DatiCittadino;
import Common.InfoCentriVaccinali;
import ServerCV.database.gestioneDB.CentriVaccinaliDaoImpl;
import ServerCV.database.gestioneDB.CittadiniRegistratiDaoImpl;
import ServerCV.database.gestioneDB.GeneralDao;
import ServerCV.interfaccia.Server;
import ServerCV.server.ServerStart;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.Scanner;

public class MainProva {
    public static void main(String[] args) throws RemoteException {  //main di prova usato per verificare se la connessione riusciva e le createTable funzionavano
        new ServerStart().start();
       Server stub;
       stub=ServerSingleton.getInstance();
        //InfoCentriVaccinali dati=new InfoCentriVaccinali("qwerty", "laSchiranna", "ospedaliero", "via", "24 maggio", 9, "varese", "varese","VA",21100);
        //CentriVaccinaliDaoImpl imp= new CentriVaccinaliDaoImpl();
        // imp.insertDatiCentroVaccinale(dati);
       // stub.registraCentroVaccinale(dati);

        CentriVaccinaliDaoImpl cv=new CentriVaccinaliDaoImpl();
        CittadiniRegistratiDaoImpl cr=new CittadiniRegistratiDaoImpl();
        //Common.InfoCentriVaccinali icv=new InfoCentriVaccinali("Cen03","Pw03","CE03","Padre Pio","Ospedaliero","Via","Marzio",45,"Como","Como",2134);
       // cv.insertDatiCentroVaccinale(icv);
        Common.DatiCittadino dc=new DatiCittadino("Andra","Russo","ANDRRUSS012FR","andrearusso1@gmail.com","andrea1","russo1","VA000","CE00");
         cr.insertCittadino(dc);

    }
}
