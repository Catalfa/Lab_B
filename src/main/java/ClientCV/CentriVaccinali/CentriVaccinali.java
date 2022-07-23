package ClientCV.CentriVaccinali;

import  ClientCV.client.ClientStart;
import ClientCV.CentriVaccinali.View.HomePageView;
import ServerCV.interfaccia.Client;
import ServerCV.server.ServerImpl;
import ServerCV.server.ServerStart;

public class CentriVaccinali {
    static ServerStart server=new ServerStart();


    public static void main(String[] args) {

        server.start();
        ClientStart.start();
    }
}
