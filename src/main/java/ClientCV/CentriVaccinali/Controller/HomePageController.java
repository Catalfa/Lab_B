package ClientCV.CentriVaccinali.Controller;

import ClientCV.CentriVaccinali.View.HomePageView;
import ClientCV.CentriVaccinali.View.MainAccLibFrameView;
import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ServerCV.interfaccia.Client;

import java.rmi.RemoteException;


/**
 *  Classe iniziale HomePage che permette scegliere l'esecuzione del programma tramite accesso libero  oppure tramite login
 */
public class HomePageController implements Client {
    
    HomePageView homePageView;


    /**
     * Costruttore della classe
     * @param homePageView view su cui si baserà il controller
     */
    public HomePageController(HomePageView homePageView){
        this.homePageView = homePageView;
    }

    /**
	 * Metodo che collega HomePage alla classe Login e chiude frame corrente.
	 */
    public void createLoginFrame(){
        MainLoginFrameView f = new MainLoginFrameView();
        f.setVisible(true);
        homePageView.dispose();
    }


    /**
     * Metodo che collega HomePage alla classe AccessoLibero e chiude frame corrente
     */
    public void createAccLibFrame(){
        MainAccLibFrameView f = new MainAccLibFrameView();
        f.setVisible(true);
        homePageView.dispose();
    }


    /**
     * Metodo che aggiorna la lista Statistiche  Centri e dei Vaccinati
     * @param statistiche		La lista delle statistiche.
     * @throws RemoteException
     */
    @Override
    public void update(int[] statistiche) throws RemoteException {
        if(statistiche[0] != 0) {
            //homePageView.updateStatisticheCentri(statistiche[0]);
        }else if(statistiche[1] != 0){
            //homePageView.updateStatisticheVaccinati(statistiche[1]);
    }}
}
