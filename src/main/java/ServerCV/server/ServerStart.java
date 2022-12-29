package ServerCV.server;

import ServerCV.database.CreazioneTabelle;
import ServerCV.database.gestioneDB.GeneralDao;
import ServerCV.interfaccia.Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.util.Scanner;

/**
 * Classe che esegue l'avvio del server.
 */
public class ServerStart {
	/*
	 * public static void main(String[] args) {
	 * if (args == null || args.length != 3) {
	 * System.out.println(
	 * "ERRORE. Per avviare il server, inserire i dati del DB come parametro (<URL> <username> <password>)"
	 * );
	 * System.exit(0);
	 * }
	 * }
	 */

	public void start() {
		CreazioneTabelle ct = new CreazioneTabelle();
		Connection connessione = null;

		try {
			Server stub = (Server) new ServerImpl();
			Registry registry = LocateRegistry.createRegistry(1100);
			registry.rebind("ServerCV", stub);
			Scanner sc = new Scanner(System.in);
			System.out.println("Inserisci il nome del database");
			String nomeDb = sc.next();
			System.out.println("Inserisci lo username");
			String user = sc.next();
			System.out.println("Inserisci la password");
			String password = sc.next();
			sc.close();
			GeneralDao.setDatabaseParams(nomeDb, user, password);
			connessione = GeneralDao.openConnection();
			if (connessione == null)
				System.out.println("Errore");
			else {
				System.out.println("Connessione riuscita");
				System.out.println("Server avviato");
			}

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			System.out.println("Sto creando la tabella centrivaccinali...");
			ct.Create_CentroVaccinale(connessione);
			System.out.println("Sto creando la tabella cittadini_registrati...");
			ct.Create_CittadinoRegistrato(connessione);
			System.out.println("Sto creando la tabella vaccinati...");
			String nomecentro = "SantaMaria";
			ct.Create_Vaccinato(connessione, nomecentro);
			System.out.println("Sto creando la tabella eventi_avversi...");
			ct.Create_EventiAvversi(connessione);
			try {
				ct.CreateTables(connessione);
			} catch (Exception e) {
				System.out.println("zio pera");
			}
		}
	}
}
