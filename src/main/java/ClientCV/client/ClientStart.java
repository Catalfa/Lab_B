package ClientCV.client;

import ClientCV.CentriVaccinali.View.HomePageView;
import ServerCV.interfaccia.Server;

/**
 * Classe che avvia la comunicazione col server.
 */
public class ClientStart {
	/**
	 * metodo che avvia l'interfaccia grafica del programma
	 */
	public static void start() {

		Server stub = ServerSingleton.getInstance();
		HomePageView homePage = new HomePageView();
		homePage.setVisible(true);
	}
}