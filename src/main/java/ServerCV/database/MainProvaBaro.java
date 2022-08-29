package ServerCV.database;

import Common.DatiCittadino;
import Common.InfoCentriVaccinali;
import Common.RegistrazioniVaccinati;
import ServerCV.database.gestioneDB.CentriVaccinaliDaoImpl;
import ServerCV.database.gestioneDB.CittadiniRegistratiDaoImpl;
import ServerCV.database.gestioneDB.EventiAvversiDaoImpl;
import ServerCV.database.gestioneDB.GeneralDao;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Locale;
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

        cr.updateIdCittadino("3456", "Andrea");

        contr = cr.existIdCittadino("3457");
        prove_controllo(contr);

       // int contr2 = Integer.parseInt(cr.getIdCittadino("Andreee"));
       // prove_controllo2(contr2);

        int numvaccinati = cr.countCittadiniVaccinati();
        System.out.println("Numero cittadini vaccinati: " + numvaccinati);

        CentriVaccinaliDaoImpl cv=new CentriVaccinaliDaoImpl();
        contr=cv.existCentroVaccinale("SAntaMaria");
        prove_controllo(contr);
        int numvcentri = cv.countCentriVaccinali();
        System.out.println("Numero centri vaccinali: " + numvcentri);


        EventiAvversiDaoImpl ea=new EventiAvversiDaoImpl();
        int numsegnalazioni=ea.getSegnalazioni("Santa Maria");
        System.out.println("Numero segnalazioni per centro Santa Maria: "+numsegnalazioni);
        double mediaseverita=ea.getImportanzaEvento("Santa Maria","mal di testa");
        System.out.println("Mediia delle severità dei mal di testa per il centro Santa Maria: "+mediaseverita);

     //   String ritorno=accorpamento("Santa Maria Immacolata");
       // System.out.println(ritorno);
      contr=cv.existCf("Santa Maria","ALMU01PO");
        prove_controllo(contr);
/*
        contr=cv.existIdVaccinazione("Santa Maria", "3456");
        System.out.println("controllo cf");
        prove_controllo(contr);
*/
/*
        contr=cv.existCentro("Cen01");
        prove_controllo(contr);

        contr=cv.checkLoginCentro("Can01","Pa01");
        prove_controllo(contr);
*/

     //System.out.println("Insert del cittadino");
    // Common.DatiCittadino dc=new DatiCittadino("Antonio","Muratore","ANTO,UR12FR","antoniomuratore@gmail.com","antonio","muratore","VA050","CE09");
      // cr.insertCittadino(dc);
        /*
        Common.DatiCittadino dc2;
       dc2 =cr.getDatiCittadino("ANDRRUSS012FR");
        cicloDati(dc2);

        dc2=cr.getCfCittadino("andrea1");
       System.out.println(dc2.getCFCittadino());
       Date dt= Date.valueOf(LocalDate.now());
       */

    //   Common.RegistrazioniVaccinati rv=new RegistrazioniVaccinati("Santa Maria","CE00","ANDRRUSS012FR", dt,"Pfizer",3456,"Andra","Russo");
    //   cv.insertVaccinato(rv);

     //   Common.InfoCentriVaccinali icv=new InfoCentriVaccinali("Cen03","Pw03","CE03","Padre Pio","Ospedaliero","Via","Marzio",45,"Como","Como",2134);
       // cv.insertDatiCentroVaccinale(icv);
        List<InfoCentriVaccinali> info=cv.findCentroVaccinale("Astolfo");
        estraiDati(info);
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

    public static String accorpamento(String centro){
        String tmp="";
        String fin="";

        for(int i=0;i<centro.length();i++){
            char ch=centro.charAt(i);
            if(ch==' '){
                tmp=tmp;
            }
            else {
                tmp = tmp + ch;

            }
        }


        return tmp.toLowerCase();
    }

    public static void cicloDati(DatiCittadino dc3){
    System.out.println(dc3.getNomeCittadino());
    System.out.println(dc3.getCognomeCittadino());
    }

    public static void estraiDati(List<InfoCentriVaccinali> info){
     System.out.println(info.get(0).getIdCentro());
        System.out.println(info.get(0).getNomeCentro());
        System.out.println(info.get(0).getNomeVia());
        System.out.println(info.get(0).getNumCiv());
        System.out.println(info.get(0).getTipologia());
        System.out.println(info.get(0).getComune());
        System.out.println(info.get(0).getCap());
        System.out.println(info.get(0).getProvincia());

    }
}