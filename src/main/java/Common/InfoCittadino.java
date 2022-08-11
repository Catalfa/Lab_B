package Common;

import java.io.Serializable;

public class InfoCittadino implements Serializable{
    
    private String nome;
    private String cognome;

    public InfoCittadino(String Name, String Surname) {
        this.nome = Name;
        this.cognome=Surname;
    }

    public String getUserName(){
        return nome;
    }

    public String getNome(){return cognome;
    }

}
