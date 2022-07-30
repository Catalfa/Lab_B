package ServerCV.database;

import java.sql.Connection;
import java.util.Scanner;

public class MainProva {
    public static void main(String[] args){  //main di prova usato per verificare se la connessione riusciva e le createTable funzionavano
        CreazioneTabelle ct= new CreazioneTabelle();
        Connection connessione;
        Scanner sc=new Scanner(System.in);
        System.out.println("Inserisci il nome del database");
        String nomeDb=sc.next();
        System.out.println("Inserisci lo username");
        String user=sc.next();
        System.out.println("Inserisci la password");
        String password=sc.next();
        ConnessioneDB conn=new ConnessioneDB(nomeDb,user,password);
        connessione=conn.Connessione();
        System.out.println("Sto creando la tabella centrivaccinali...");
        ct.Create_CentroVaccinale(connessione);
        System.out.println("Sto creando la tabella cittadini_registrati...");
        ct.Create_CittadinoRegistrato(connessione);
        System.out.println("Sto creando la tabella vaccinati...");
        String nomecentro="SantaMaria";
        ct.Create_Vaccinato(connessione,nomecentro);
        System.out.println("Sto creando la tabella eventi_avversi...");
        ct.Create_EventiAvversi(connessione);

    }
}
