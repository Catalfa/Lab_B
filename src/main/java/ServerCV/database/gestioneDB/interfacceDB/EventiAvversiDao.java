package ServerCV.database.gestioneDB.interfacceDB;

/**
 * Interfaccia per gli eventi avversi.
 */
public interface EventiAvversiDao {

	/**
	 * Metodo che inserisce i dati all'interno della tabella eventi_avversi.
	 * @param idVaccinazione L'id della vaccinazione.
	 * @param nomeCentro Il nome del centro vaccinale.
	 * @param evento  L'evento avverso.
	 * @param severita La severità dell'evento avverso.
	 * @param note Le note opzionali.
	 * @param cf Il cf del cittadino.
	 */
	public void insertEventoAvverso(String idVaccinazione, String nomeCentro, String evento, Integer severita, String note, String cf);

	/**
	 *  Metodo che conta e restituisce il numero di segnalazioni effetuate per quel
	 *  determinato centro vaccinale.
	 * @param nomeCentro Il nome del centro vaccinale
	 * @return Il numero di segnalazioni effettuate per quel determinato centro
	 * vaccinale.
	 */
	public int getSegnalazioni(String nomeCentro);

	/**
	 * Metodo che calcola e restituisce il valore medio dell'intensita' dell'evento
	 * avverso per quel determinato centro vaccinale.
	 * @param nomeCentro Il nome del centro vaccinale.
	 * @param evento  Il tipo di evento avverso.
	 * @return
	 */
	public double getImportanzaEvento(String nomeCentro, String evento);

	/**
	 * Metodo che controlla se sono gia' stati inseriti degli eventi avversi per
	 *  quel determinato cittadino registrato.
	 * @param id L'array con gli id delle vaccinazioni.
	 * @return Se sono gia' stati inseriti degli eventi avversi.
	 */
	public boolean existId(String [] id);
	
}
