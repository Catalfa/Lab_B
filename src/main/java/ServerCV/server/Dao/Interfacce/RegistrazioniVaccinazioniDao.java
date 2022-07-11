package ServerCV.server.Dao.Interfacce;

/**
 * Nicolo' Ferrari, Mat. 732707, Varese
 * Alessandro Formenti, Mat. 734465, Varese
 * Luigi Mucciarone, Mat. 732714, Varese
 * Luca Alberti, Mat. 733096, Varese
 */

/**
 * Interfaccia contenente i metodi che verranno utilizzati per le query sulla tabella registrazioni_vaccinazioni.
 */
public interface RegistrazioniVaccinazioniDao {

	/**
	 * Interfaccia che gestisce l'esistenza di un CF all'interno delle prenotazioni.
	 * @param cf		Il CF del cittadino che si e' prenotato per la vaccinazione.
	 * @return			Se il CF e' gia' stato usato per prenotare una vaccinazione.
	 */
	public boolean existCf(String cf);
	
}
