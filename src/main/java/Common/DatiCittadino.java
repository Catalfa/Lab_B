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
    private String password;
    private String idvaccinazione;
    private String idcentro;

    public DatiCittadino(String nome, String cognome, String cf, String email, String username, String password, String idvaccinazione, String idcentro) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.email = email;
        this.username = username;
        this.password = password;
        this.idvaccinazione=idvaccinazione;
        this.idcentro=idcentro;
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

    public String getPasswordCittadino() {
        return password;
    }

    public String getIdvaccinazione(){return idvaccinazione;}

    public String getIdcentro(){return idcentro;}
}
