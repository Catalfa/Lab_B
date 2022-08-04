package ServerCV.server;

import ServerCV.interfaccia.Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Classe che esegue l'avvio del server.
 */
public class ServerStart {
	/*public static void main(String[] args) {
		if (args == null || args.length != 3) {
			System.out.println(
					"ERRORE. Per avviare il server, inserire i dati del DB come parametro (<URL> <username> <password>)");
			System.exit(0);
		}
	}*/

	public void start() {
		try {
		Server stub = (Server) new ServerImpl();
		Registry registry = LocateRegistry.createRegistry(1100);
		registry.rebind("ServerCV", stub);
		System.out.println("Server avviato");
	} catch (Exception ex) {
		System.out.println(ex);
	}
	}
}
