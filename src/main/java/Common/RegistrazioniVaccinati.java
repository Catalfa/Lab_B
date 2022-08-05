package Common;



import java.io.Serializable;
import java.sql.Date;

/**
 * Classe oggetto per i dati dei dati delle vaccinazioni.
 */
public class RegistrazioniVaccinati implements Serializable {
	private String idCentro;
	private String nomeCentro;
	private String cf;
	private Date dataVaccino;
	private String tipoVaccino;
	private int idVaccinazione;

	private String nome;
	private String cognome;
	
	/**
	 * Costruttore della classe.
	 * @param idCentro		Il nome del centro vaccinale.
	 * @param cf				Il CF del cittadino.
	 * @param dataVaccino		La data di prenotazione della vaccinazione.
	 * @param tipoVaccino		La tipologia di vaccino somministrata.
	 * @param idVaccinazione	L'ID vaccinazione del cittadino.
	 */
	public RegistrazioniVaccinati(String nomeCentro, String idCentro, String cf, Date dataVaccino, String tipoVaccino, int idVaccinazione, String nome, String cognome) {
		this.idCentro = idCentro;
		this.nomeCentro=nomeCentro;
		this.cf = cf;
		this.dataVaccino = dataVaccino;
		this.tipoVaccino = tipoVaccino;
		this.idVaccinazione = idVaccinazione;
		this.nome=nome;
		this.cognome=cognome;
	}
	
	/**
	 * Metodo che restituisce il nome del centro vaccinale.
	 * @return		Il nome del centro vaccinale.
	 */
	public String getIdCentro() {
		return idCentro;
	}

	public String getnomeCentro(){return  nomeCentro;}

	
	/**
	 * Metodo che restituisce il Cf del cittadino.
	 * @return		Il Cf del cittadino.
	 */
	public String getCf() {
		return cf;
	}
	
	/**
	 * Metodo che restituisce la data della vaccinazione.
	 * @return		La data della vaccinazione.
	 */
	public Date getDataVaccino() {
		return dataVaccino;
	}
	
	/**
	 * Metodo che restituisce il tipo di vaccino somministrato.
	 * @return		Il tipo di vaccino somministrato.
	 */
	public String getTipoVaccino() {
		return tipoVaccino;
	}
	
	/**
	 * Metodo che restituisce l'ID della vaccinazione.
	 * @return		L'Id della vaccinazione.
	 */
	public int getIdVaccinazione() {
		return idVaccinazione;
	}

	/**
	 * Metodo che restituisce il nome del vaccinato
	 * @return nome del vaccinato
	 */
	public String getNomeVaccinato(){return nome;}

	/**
	 * Metodo che ritorna il cognome del vaccinato
	 * @return cognome del vaccinato
	 */
	public String getCognomeVaccinato(){return cognome;}
	
}
