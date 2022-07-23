package Test;

import ClientCV.client.ClientStart;
import ServerCV.interfaccia.Server;
import ServerCV.server.ServerStart;

import java.rmi.RemoteException;

public class main {

    public static void main(String[] args) throws RemoteException {
        ServerStart server = new ServerStart();
        ClientStart client = new ClientStart();

    }
}
