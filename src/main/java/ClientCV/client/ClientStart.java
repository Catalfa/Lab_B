package ClientCV.client;

import ServerCV.interfaccia.Server;

import java.rmi.RemoteException;

/**
 * Classe che avvia la comunicazione col server.
 */
public class ClientStart {

	public static void start() {
		Server stub = ServerSingleton.getInstance();
	}
}