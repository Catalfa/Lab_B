package Common;

import java.io.Serializable;

public class Indirizzo implements Serializable {

    private String qualificatore;
    private String nome_via;
    private int numero_civico;
    private String comune;
    private String provincia;
    private int cap;

    public Indirizzo(String qualificatore, String nome_via, int numero_civico, String comune, String provincia, int cap) {
        this.qualificatore = qualificatore;
        this.nome_via = nome_via;
        this.numero_civico = numero_civico;
        this.comune = comune;
        this.provincia = provincia;
        this.cap = cap;
    }
    
}
