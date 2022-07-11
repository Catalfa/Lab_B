package Common;

import java.io.Serializable;

/**
 * Classe oggetto per i dati dei cittadini registrati.
 */
public class DatiCittadino implements Serializable{
    
    private String nome;
    private String cognome;
    private String cf;
    private String email;
    private String username;
    private char[] password;

    public DatiCittadino(String nome, String cognome, String cf, String email, String username, char[] password) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getNomeCittadino(){
        return nome;
    }

    public String getCognomeCittadino(){
        return cognome;
    }

    public String getCFCittadino() {
        return cf;
    }

    public String getEmailCittadino() {
        return email;
    }

    public String getUsernameCittadino() {
        return username;
    }

    public char[] getPasswordCittadino() {
        return password;
    }
}
