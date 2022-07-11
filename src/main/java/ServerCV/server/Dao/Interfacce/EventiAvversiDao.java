package ServerCV.server.Dao.Interfacce;

/**
 * Nicolo' Ferrari, Mat. 732707, Varese
 * Alessandro Formenti, Mat. 734465, Varese
 * Luigi Mucciarone, Mat. 732714, Varese
 * Luca Alberti, Mat. 733096, Varese
 */

/**
 * Interfaccia contenente i metodi che verranno utilizzati per le query sulla tabella eventi_avversi.
 */
public interface EventiAvversiDao {
	
	/**
	 * Interfaccia che gestisce l'inserimento degli eventi avversi.
	 * @param idVaccinazione	L'ID della vaccinazione di un cittadino.
	 * @param nomeCentro		Il nome del centro vaccinale.
	 * @param evento			Il nome dell'evento avverso.
	 * @param severita			L'intensita' dell'evento avverso.
	 * @param note				Eventuali note sull'evento avverso.
	 */
	public void insertEventoAvverso(int idVaccinazione, String nomeCentro, String evento, Integer severita, String note);
	
	/**
	 * Interfaccia che gestisce l'ottenimento del numero di segnalazioni per un determinato centro vaccinale.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @return				Il numero di segnalazioni.
	 */
	public int getSegnalazioni(String nomeCentro);
	
	/**
	 * Interfaccia che gestisce l'ottenimento del valore medio dell'intesita' per un determinato evento avverso.
	 * @param nomeCentro	Il nome del centro vaccinale.
	 * @param evento		Il nome dell'evento avverso.
	 * @return				L'intensita' media per quel determinato evento avverso.
	 */
	public double getImportanzaEvento(String nomeCentro, String evento);
	
	/**
	 * Interfaccia che gestisce il controllo sull'esistenza di un determinato ID della vaccinazione.
	 * @param id	L'ID della vaccinazione.
	 * @return		Se sono gia' state inserite delle segnalazioni con quel determinato ID.
	 */
	public boolean existId(int id);
	
}
