package ServerCV.database;

import ServerCV.database.gestioneDB.CentriVaccinaliDaoImpl;
import ServerCV.database.gestioneDB.CittadiniRegistratiDaoImpl;
import ServerCV.database.gestioneDB.GeneralDao;

import java.sql.Connection;
import java.util.Scanner;

public class MainProvaBaro {

    public static void main(String[] args) {
        CreazioneTabelle ct = new CreazioneTabelle();
        Connection connessione;
        boolean contr;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci il nome del database");
        String nomeDb = sc.next();
        System.out.println("Inserisci lo username");
        String user = sc.next();
        System.out.println("Inserisci la password");
        String password = sc.next();
        GeneralDao.setDatabaseParams(nomeDb, user, password);
        connessione = GeneralDao.openConnection();
        if (connessione == null)
            System.out.println("Errore");
        else
            System.out.println("Connessione riuscita");

        //  System.out.println("Sto creando la tabella centrivaccinali...");
        //  ct.Create_CentroVaccinale(connessione);
        //  System.out.println("Sto creando la tabella cittadini_registrati...");
        //  ct.Create_CittadinoRegistrato(connessione);
        //  System.out.println("Sto creando la tabella vaccinati...");
        // String nomecentro="SantaMaria";
        //  ct.Create_Vaccinato(connessione,nomecentro);
        // System.out.println("Sto creando la tabella eventi_avversi...");
        // ct.Create_EventiAvversi(connessione);
        //  Common.DatiCittadino dc=new DatiCittadino("Andrea","Russo","ANDRUS3454OS","andrearusso@gmail.com","andrea","russo"/*,"A00","CE00"*/);
        CittadiniRegistratiDaoImpl cr = new CittadiniRegistratiDaoImpl();
        // cr.insertCittadino(dc);
        contr = cr.checkPwCittadino("andrea", "russo");
        prove_controllo(contr);


        contr = cr.existCittadino("andeee");
        prove_controllo(contr);

        contr = cr.existCfCittadino("Andrea");
        prove_controllo(contr);

        cr.updateIdCittadino(3456, "Andrea");

        contr = cr.existIdCittadino(3457);
        prove_controllo(contr);

        int contr2 = cr.getIdCittadino("Andreee");
        prove_controllo2(contr2);

        int numvaccinati = cr.countCittadiniVaccinati();
        System.out.println("Numero cittadini vaccinati: " + numvaccinati);

        CentriVaccinaliDaoImpl cv=new CentriVaccinaliDaoImpl();
        contr=cv.existCentroVaccinale("SAntaMaria");
        prove_controllo(contr);
        int numvcentri = cv.countCentriVaccinali();
        System.out.println("Numero centri vaccinali: " + numvcentri);
    }

    public static void prove_controllo(boolean check) {
        if (check == true)
            System.out.println("È presente");
        else
            System.out.println("Non è presente");
    }

    public static void prove_controllo2(int check) {
        if (check == 0)
            System.out.println("Non è presente");
        else {
            System.out.println("Id vaccinazione: " + check);
        }
    }
}