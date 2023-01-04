package Common;

/**
 * Classe oggetto per i dati della ricerca del centro.
 */
public class RicercaCentro {
    
    private String nome;

    /**
     * Costruttore della classe RicercaCentro.
     * @param testo La stringa per la ricerca.
     */

    public RicercaCentro(String testo) {
        this.nome = testo;
    }

    /**
	 * Metodo che restituisce il nome del centro vaccinale.
	 * @return		Il nome del centro vaccinale.
	 */
    public String getNomeCentro() {
        return nome;
    }
}
