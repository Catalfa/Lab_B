package ServerCV.database;

import ClientCV.client.ClientStart;
import ClientCV.client.ServerSingleton;
import Common.DatiCittadino;
import Common.InfoCentriVaccinali;
import ServerCV.database.gestioneDB.CentriVaccinaliDaoImpl;
import ServerCV.database.gestioneDB.GeneralDao;
import ServerCV.interfaccia.Server;
import ServerCV.server.ServerStart;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.Scanner;

public class MainProva {
    public static void main(String[] args) throws RemoteException {  //main di prova usato per verificare se la connessione riusciva e le createTable funzionavano
        new ServerStart().start();
        new ClientStart().start();
        CreazioneTabelle ct= new CreazioneTabelle();
        Connection connessione;
        Scanner sc=new Scanner(System.in);
        System.out.println("Inserisci il nome del database");
        String nomeDb=sc.next();
        System.out.println("Inserisci lo username");
        String user=sc.next();
        System.out.println("Inserisci la password");
        String password=sc.next();
        GeneralDao.setDatabaseParams(nomeDb,user,password);
        Connection conn=GeneralDao.openConnection();
        System.out.println("Sto creando la tabella centrivaccinali...");
        ct.Create_CentroVaccinale(conn);
        System.out.println("Sto creando la tabella cittadini_registrati...");
        ct.Create_CittadinoRegistrato(conn);
        System.out.println("Sto creando la tabella vaccinati...");
        String nomecentro="SantaMaria";
        new CentriVaccinaliDaoImpl().createVaccinati_(nomecentro);
        System.out.println("Sto creando la tabella eventi_avversi...");
        ct.Create_EventiAvversi(conn);
        Server stub= ServerSingleton.getInstance();
        //InfoCentriVaccinali dati=new InfoCentriVaccinali("qwerty", "laSchiranna", "ospedaliero", "via", "24 maggio", 9, "varese", "varese","VA",21100);
        //CentriVaccinaliDaoImpl imp= new CentriVaccinaliDaoImpl();
        // imp.insertDatiCentroVaccinale(dati);
       // stub.registraCentroVaccinale(dati);


    }
}
