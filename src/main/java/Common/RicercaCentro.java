package Common;

public class RicercaCentro {
    
    private String nome;

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
