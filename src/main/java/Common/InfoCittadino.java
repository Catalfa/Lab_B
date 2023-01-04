package Common;

import java.io.Serializable;

/**
 * Classe oggetto per le informazioni dei cittadini.
 */

public class InfoCittadino implements Serializable{
    
    private String nome;
    private String cognome;

    /**
     * Costruttore della classe InfoCittadino
     * @param Name Il nome del cittadino.
     * @param Surname Il cognome del cittadino.
     */

    public InfoCittadino(String Name, String Surname) {
        this.nome = Name;
        this.cognome=Surname;
    }

    /**
     * Metodo che restituisce il nome del cittadino.
     * @return Il nome del cittadino.
     */

    public String getUserName(){
        return nome;
    }

    /**
     * Metodo che restituisce il cognome del cittadino.
     * @return Il cognome del cittadino.
     */

    public String getNome(){return cognome;
    }

}
