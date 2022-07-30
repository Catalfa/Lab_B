package ServerCV.server;

import ServerCV.database.ConnessioneDB;

import java.sql.Connection;
import java.util.Scanner;

//main di prova che uso per verificare le query in GestioneClient
public class MainProva {
    public static void main(String[] args){
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
//GestioneClient gc=new GestioneClient();
//gc.gestOttieniCF("alebaro");
    }
}
