package ClientCV.CentriVaccinali.Controller;

import ClientCV.CentriVaccinali.View.HomePageView;
import ClientCV.CentriVaccinali.View.MainAccLibFrameView;
import ClientCV.CentriVaccinali.View.MainLoginFrameView;
import ServerCV.interfaccia.Client;

import java.rmi.RemoteException;

public class HomePageController implements Client {
    
    HomePageView homePageView;

    public HomePageController(HomePageView homePageView){
        this.homePageView = homePageView;
    }

    /**
	 * Metodo che crea un nuovo frame e manda in dispose quello corrente.
	 */
    public void createLoginFrame(){
        MainLoginFrameView f = new MainLoginFrameView();
        f.setVisible(true);
        homePageView.dispose();
    }

    public void createAccLibFrame(){                              //ATT new
        MainAccLibFrameView f = new MainAccLibFrameView();
        f.setVisible(true);
        homePageView.dispose();
    }

    @Override
    public void update(int[] statistiche) throws RemoteException {
        if(statistiche[0] != 0) {
            //homePageView.updateStatisticheCentri(statistiche[0]);
        }else if(statistiche[1] != 0){
            //homePageView.updateStatisticheVaccinati(statistiche[1]);
    }}
}
