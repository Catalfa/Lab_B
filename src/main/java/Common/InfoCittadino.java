package Common;

import java.io.Serializable;

public class InfoCittadino implements Serializable{
    
    private String nome;
    private char[] password;

    public InfoCittadino(String userName, char[] pwd) {
        this.nome = userName;
        this.password = pwd;
    }

    public String getUserName(){
        return nome;
    }

    public char[] getPassword(){
        return password;
    }

}
