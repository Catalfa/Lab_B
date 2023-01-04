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

    /**
     * Costruttore della classe DatiCittadino.
     * @param nome Il nome del cittadino.
     * @param cognome il cognome del cittadino.
     * @param cf Il cf del cittadino.
     * @param email L'email del cittadino.
     * @param username Lo username del cittadino.
     * @param password La password del cittadino.
     * @param idvaccinazione L'id vaccinazione del cittadino.
     * @param idcentro L'id del centro vaccinale in cui il cittadino è registrato.
     */

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

    /**
     * Metodo che restituisce il nome del cittadino registrato nel DB.
     * @return Il nome del cittadino
     */

    public String getNomeCittadino(){
        return nome;
    }

    /**
     * Metodo che restituisce il cognome del cittadino registrato nel DB.
     * @return Il cognome del cittadino
     */

    public String getCognomeCittadino(){
        return cognome;
    }

    /**
     * Metodo che restituisce il cf del cittadino registrato nel DB.
     * @return Il cf del cittadino
     */

    public String getCFCittadino() {
        return cf;
    }

    /**
     * Metodo che restituisce l'email del cittadino registrato nel DB.
     * @return l'email del cittadino
     */

    public String getEmailCittadino() {
        return email;
    }

    /**
     * Metodo che restituisce lo username del cittadino registrato nel DB.
     * @return Lo username del cittadino
     */

    public String getUsernameCittadino() {
        return username;
    }

    /**
     * Metodo che restituisce la password del cittadino registrato nel DB.
     * @return La password del cittadino
     */

    public String getPasswordCittadino() {
        return password;
    }

    /**
     * Metodo che restituisce l'id vaccinazione del cittadino registrato nel DB.
     * @return l'id vaccinazione
     */

    public String getIdvaccinazione(){return idvaccinazione;}

    /**
     * Metodo che restituisce l'id del centro in cui il cittadino è registrato nel DB.
     * @return L'id del centro vaccinale
     */

    public String getIdcentro(){return idcentro;}
}
