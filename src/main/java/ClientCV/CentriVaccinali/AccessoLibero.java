package ClientCV.CentriVaccinali;

import ClientCV.client.ClientStart;
import ServerCV.server.ServerStart;

public class AccessoLibero {
    static ServerStart server=new ServerStart();
    static ClientStart client= new ClientStart();

    public static void main(String[] args) {
        server.start();
        client.start();
    }
}
