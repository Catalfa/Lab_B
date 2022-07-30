package Common;

import java.io.Serializable;

public class InfoCittadino implements Serializable{
    
    private String nome;
    private char[] cognome;

    public InfoCittadino(String userName, char[] pwd) {
        this.nome = userName;
        this.cognome = pwd;
    }

    public String getUserName(){
        return nome;
    }

    public char[] getPassword(){
        return cognome;
    }

}
