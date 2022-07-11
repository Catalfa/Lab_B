package ClientCV.CentriVaccinali;

import  ClientCV.client.ClientStart;
import ClientCV.CentriVaccinali.View.HomePageView;
import ServerCV.interfaccia.Client;
import ServerCV.server.ServerImpl;
import ServerCV.server.ServerStart;

public class CentriVaccinali {
    static ServerStart server=new ServerStart();
    static ClientStart client= new ClientStart();

    public static void main(String[] args) {
        HomePageView homePage = new HomePageView();
        homePage.setVisible(true);
        server.start();
        client.start();
    }
}
