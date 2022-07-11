package Common;

import java.io.Serializable;

public class InfoCittadino implements Serializable{
    
    private String nome;
    private String cognome;

    public InfoCittadino(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNomeCittadino(){
        return nome;
    }

    public String getCognomeCittadino(){
        return cognome;
    }

}
