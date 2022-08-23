package Common;

import java.io.Serializable;

/**
 * Classe oggetto per i dati degli eventi avversi.
 */
public class EventiAvversi implements Serializable{
    private String id_evento;
	private String nomeCentro;
	private String[] evento;
	private Integer[] severita;
	private String[] notes;
	private String cf;
    
    /**
	 * Costruttore della classe.
	 * @param id_evento	L'ID della vaccinazione del cittadino.
	 * @param nomeCentro		Il nome del centro vaccinale.
	 * @param evento			La lista degli eventi.
	 * @param severita			L'intensita' degli eventi.
	 * @param note				le note degli eventi.
	 */

	//int id_evento, String nomeCentro, String evento, Integer severita, String note
	

    public EventiAvversi(String id_evento, String nomeCentro, String[] evento,  Integer[] severita, String[] note) {
        this.id_evento = id_evento;
		this.nomeCentro = nomeCentro;
		this.evento = evento;
		this.severita = severita;
		this.notes = note;
    }

    /**
	 * Metodo che restituisce l'Id vaccinazione del cittadino.
	 * @return		L'ID vaccinazione del cittadino.
	 */
    public String getIdEvento(){
        return id_evento;
    }

    /**
	 * Metodo che restituisce il nome del centro di vaccinazione.
	 * @return		Il nome del centro di vaccinazione.
	 */
    public String getNomeCentro(){
        return nomeCentro;
    }

    /**
	 * Metodo che restituisce un array di evento.
	 * @return		L'array contenente gli eventi.
	 */
    public String[] getEvento(){
        return evento;
    }

    /**
	 * Metodo che restituisce un array di grado di severità corrispondente ai vari eventi.
	 * @return		Il grado di severità.
	 */
    public Integer[] getSeverita(){
        return severita;
    }

    /**
	 * Metodo che restituisce un array di note degli eventi, massimo 256 caratteri.
	 * @return		L'array contenente gli eventi.
	 */
    public String[] getNotes(){
        return notes;
    }

	public String getCf_evento(){
		return cf;
	}
}
    

