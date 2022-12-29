package ClientCV.AccessoLibero.Controller;

import ClientCV.AccessoLibero.View.ShowInfoCentroVaccinaleCitizenView;
import ClientCV.client.ServerSingleton;
import ServerCV.interfaccia.Server;

/**
 * Classe contenente tutti i controlli effettuati nella View ShowInfoCentroVaccinale
 */
public class ShowInfoCentroVaccinaleCitizenController {
	
	ShowInfoCentroVaccinaleCitizenView view;
	
	Server stub;
	
	/**
	 * Costruttore della classe
	 */
	public ShowInfoCentroVaccinaleCitizenController(ShowInfoCentroVaccinaleCitizenView view) {
		this.view = view;
		this.stub = ServerSingleton.getInstance();
	}
	
	
}
