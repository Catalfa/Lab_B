package ServerCV.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import ServerCV.interfaccia.Server;
import ServerCV.server.Dao.DaoFactory;
import ServerCV.server.Dao.GeneralDao;

/**
 * Classe che esegue l'avvio del server.
 */
public class ServerStart {
	private GeneralDao db = new GeneralDao();
	private Scanner sc = new Scanner(System.in);
	private String url;
	private String username;
	private String psw;
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

	public ServerStart() {
		if (start()) {
			System.out.println("server disponibile");
		} else {
			System.err.println("server non disponibile");
		}
	}

	public Boolean start() {
		try {
			Server stub = (Server) new ServerImpl();
			Registry registry = LocateRegistry.createRegistry(1400);
			registry.rebind("serverCV", stub);
			url = "jdbc:postgresql://localhost:5433/ServerCV";
			username = "rondo";
			psw = "1234";
			DaoFactory.setDatabaseType("PostgreSQL");
			db.setDatabaseParams(url, username, psw);

			if (db.openConnection() == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
}
