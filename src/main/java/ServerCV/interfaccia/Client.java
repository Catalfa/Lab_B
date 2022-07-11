package ServerCV.interfaccia;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaccia per il client.
 */
public interface Client extends Remote {

	/**
	 * Metodo astratto per aggiornare le statistiche.
	 * @param statistiche		La lista delle statistiche.
	 * @throws RemoteException	Eccezione remota.
	 */
	public abstract void update(int[] statistiche) throws RemoteException;
	
}
