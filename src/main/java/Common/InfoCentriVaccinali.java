package Common;

public class InfoCentriVaccinali {
    
    private String nome_centro;
    private String indirizzo_centro;
    private String tipologia_centro;

    public InfoCentriVaccinali(String nome_centro, Indirizzo indirizzo_centro, String tipologia_centro) {
        this.nome_centro = nome_centro;
        this.indirizzo_centro = indirizzo_centro.toString();
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
        String [] aux;
        aux=indirizzo_centro.split(", ");
        Indirizzo a=new Indirizzo(aux[0],aux[1], Integer.parseInt(aux[2]), aux[3], aux[4], Integer.parseInt(aux[5]) );


        return a;
    }

    public String getTipologiaCentro() {
        return tipologia_centro;
    }
    
}
