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
public class
ServerStart {
	private GeneralDao db=new GeneralDao();
	private Scanner sc=new Scanner(System.in);
	private String url;
	private String username;
	private String psw;
	/*public static void main(String[] args) {
		if (args == null || args.length != 3) {
			System.out.println(
					"ERRORE. Per avviare il server, inserire i dati del DB come parametro (<URL> <username> <password>)");
			System.exit(0);
		}
	}*/

	public Boolean start() {
		try {
		Server stub = (Server) new ServerImpl();
		Registry registry = LocateRegistry.createRegistry(1100);
		registry.rebind("serverCV", stub);
		System.out.println("Server avviato");
		System.out.println("inserire url Database:");
		url="jdbc:postgresql://localhost:5433/ServerCV";
		System.out.println("inserire username :");
		username="rondo";
		System.out.println("inserire password :");
		psw="1234";
		DaoFactory.setDatabaseType("PostgreSQL");
		db.setDatabaseParams(url,username,psw);
		db.openConnection();
		return true;
	} catch (Exception ex) {
		System.out.println(ex);
		return false;
	}
	}
}
