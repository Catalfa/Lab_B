package ClientCV.AccessoLibero.Controller;

import ClientCV.AccessoLibero.View.ShowInfoCentroVaccinaleCitizenView;
import ClientCV.client.ServerSingleton;
import ServerCV.interfaccia.Server;

/**
 * Nicolo' Ferrari, Mat. 732707, Varese
 * Alessandro Formenti, Mat. 734465, Varese
 * Luigi Mucciarone, Mat. 732714, Varese
 * Luca Alberti, Mat. 733096, Varese
 */

/**
 * Classe contenente tutti i controlli effettuati nella View ShowInfoCentroVaccinaleCitizen.
 */
public class ShowInfoCentroVaccinaleCitizenController {
	
	ShowInfoCentroVaccinaleCitizenView view;
	
	Server stub;
	
	/**
	 * Costruttore della classe.
	 * @param view La View della classe corrente.
	 */
	public ShowInfoCentroVaccinaleCitizenController(ShowInfoCentroVaccinaleCitizenView view) {
		this.view = view;
		this.stub = ServerSingleton.getInstance();
	}
	
	
}
