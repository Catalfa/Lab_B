package Common;

import java.io.Serializable;

/**
 * Classe oggetto per i dati degli eventi avversi.
 */
public class EventiAvversi implements Serializable{
    private int idVaccinazione;
	private String nomeCentro;
	private String[] evento;
	private Integer[] severita;
	private String[] notes;
    
    /**
	 * Costruttore della classe.
	 * @param idVaccinazione	L'ID della vaccinazione del cittadino.
	 * @param nomeCentro		Il nome del centro vaccinale.
	 * @param evento			La lista degli eventi.
	 * @param severita			L'intensita' degli eventi.
	 * @param notes				le note degli eventi.
	 */
    public EventiAvversi(int idVaccinazione, String nomeCentro, String[] evento,  Integer[] severita, String[] notes) {
        this.idVaccinazione = idVaccinazione;
		this.nomeCentro = nomeCentro;
		this.evento = evento;
		this.severita = severita;
		this.notes = notes;
    }

    /**
	 * Metodo che restituisce l'Id vaccinazione del cittadino.
	 * @return		L'ID vaccinazione del cittadino.
	 */
    public int getidVaccinazione(){
        return idVaccinazione;
    }

    public String getNomeCentro(){
        return nomeCentro;
    }

    public String[] getEvento(){
        return evento;
    }

    public Integer[] getSeverita(){
        return severita;
    }

    public String[] getNotes(){
        return notes;
    }



}
    

