package ClientCV.client;

import ServerCV.interfaccia.Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Classe che permette la creazione di una sola istanza della classe server.
 */
public class ServerSingleton {
	
	private static Server instance;
	
	/**
	 * Costruttore della classe.
	 */
	private ServerSingleton () {}
	
	/**
	 * Metodo che controlla se esiste gia' un'istanza del server, nel caso non esista ne crea una.
	 * @return		L'istanza del server.
	 */
	public static Server getInstance() {
		if(instance == null) {
			try {
				Registry registry = LocateRegistry.getRegistry(1100);
				instance = (Server)registry.lookup("serverCV");
				System.err.println("client collegato");
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
			
		return instance;
	}
	
	
}
