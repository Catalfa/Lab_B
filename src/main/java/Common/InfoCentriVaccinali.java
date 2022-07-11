package Common;

public class InfoCentriVaccinali {
    
    private String nome_centro;
    private Indirizzo indirizzo_centro;
    private String tipologia_centro;

    public InfoCentriVaccinali(String nome_centro, Indirizzo indirizzo_centro, String tipologia_centro) {
        this.nome_centro = nome_centro;
        this.indirizzo_centro = indirizzo_centro;
        this.tipologia_centro = tipologia_centro;
    }

    /**
	 * Metodo che restituisce il nome del centro vaccinale.
	 * @return		Il nome del centro vaccinale.
	 */
    public String getNomeCentro() {
        return nome_centro;
    }

    public Indirizzo getIndirizzoCentro() {
        return indirizzo_centro; 
    }

    public String getTipologiaCentro() {
        return tipologia_centro;
    }
    
}
