package ClientCV.AccessoLibero.Controller;

import ClientCV.AccessoLibero.View.ShowInfo_CV_CittadinoView;
import ClientCV.client.ServerSingleton;
import ServerCV.interfaccia.Server;

public class ShowInfo_CV_CittadinoController {

    ShowInfo_CV_CittadinoView view;
	
	Server stub;
	
	/**
	 * Costruttore della classe.
	 * @param view La View della classe corrente.
	 */
	public ShowInfo_CV_CittadinoController(ShowInfo_CV_CittadinoView view) {
		this.view = view;
		this.stub = ServerSingleton.getInstance();
	}

    /*
    *Metodo per tornare alla view precedente, TODO da implementere metodo goBack()
    */
    public void goBack(){
		//frame da mettere in dispose
		//frame da settare visible
    }
}
