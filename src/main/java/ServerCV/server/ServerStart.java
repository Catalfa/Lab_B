package ServerCV.server;

import ServerCV.database.CreazioneTabelle;
import ServerCV.database.gestioneDB.CittadiniRegistratiDaoImpl;
import ServerCV.database.gestioneDB.GeneralDao;
import ServerCV.interfaccia.Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.SQLException;
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


	public void start(String porta,String nomeDb, String user, String password) {

		CreazioneTabelle ct = new CreazioneTabelle();
		Connection connessione = null;

		try {
			Server stub = (Server) new ServerImpl();
			Registry registry = LocateRegistry.createRegistry(1100);
			registry.rebind("ServerCV", stub);
			GeneralDao.setDatabaseParams(porta ,nomeDb, user, password);
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

			System.out.println(new CittadiniRegistratiDaoImpl().CheckCFCittadino("dibla","MMMMMMMMMMMMMMMM"));

			System.out.println("Sto creando la tabella centrivaccinali...");
			ct.Create_CentroVaccinale(connessione);
			System.out.println("Sto creando la tabella cittadini_registrati...");
			ct.Create_CittadinoRegistrato(connessione);
			System.out.println("Sto creando la tabella vaccinati...");
			System.out.println("Sto creando la tabella eventi_avversi...");
			ct.Create_EventiAvversi(connessione);
			try {
				ct.CreateTables(connessione);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
