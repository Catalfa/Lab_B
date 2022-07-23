package ClientCV.client;

import ClientCV.CentriVaccinali.View.HomePageView;
import ServerCV.interfaccia.Server;

import java.rmi.RemoteException;

/**
 * Classe che avvia la comunicazione col server.
 */
public class ClientStart {

	public ClientStart() {
		start();
	}

	public static void start() {
		Server stub = ServerSingleton.getInstance();
		HomePageView homePage = new HomePageView();
		homePage.setVisible(true);

	}

}