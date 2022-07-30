package Common;

import java.io.Serializable;

public class InfoCentriVaccinali implements Serializable{
    
    private String nome_centro;
   // private String password;

    private String tipologia;

    private String qualificatore;

    private String nomevia;

    private int numciv;

    private String comune;

    private String provincia;

    private String sigla;

    private int cap;

    private String idcentro;


    public InfoCentriVaccinali(String idcentro, String nome_centro) {
        this.nome_centro = nome_centro;
        this.idcentro=idcentro;

    }
    public InfoCentriVaccinali(String idcentro, String nome_centro, String tipologia, String qualificatore, String nomevia, int numciv, String comune, String provincia, String sigla, int cap ) {
        this.nome_centro = nome_centro;
        this.idcentro=idcentro;
        this.tipologia=tipologia;
        this.qualificatore=qualificatore;
        this.nomevia=nomevia;
        this.numciv=numciv;
        this.comune=comune;
        this.provincia=provincia;
        this.sigla=sigla;
        this.cap=cap;

    }



    public String getIdCentro(){return idcentro;}

    /**
	 * Metodo che restituisce il nome del centro vaccinale.
	 * @return		Il nome del centro vaccinale.
	 */
    public String getNomeCentro() {
        return nome_centro;
    }

   /* public String getPassword() {
        return password; 
    }
*/

    /**
     * Metodo che restituisce la tipologia dell'ospedale
     * @return tipologia
     */
    public String getTipologia() {
        return tipologia;
    }

    /**
     * Metodo che restitusce il qualificatore della via
     * @return qualificatore
     */
    public String getQualificatore() {
        return qualificatore;
    }

    /**
     * Metodo che restituisce il nome della via
     * @return nomevia
     */
    public String getNomeVia() {
        return nomevia;
    }

    /**
     * Metodo che restituisce il numero civico della via
     * @return numciv
     */
    public int getNumCiv() {
        return numciv;
    }

    /**
     * Metodo che resituisce il comune
     * @return comune
     */
    public String getComune(){return comune;}

    /**
     * Metodo che restituisce la provincia
     * @return provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Metodo che restituisce la sigla della provincia
     * @return sigla
     */

    public String getSigla() {
        return sigla;
    }

    /**
     * Metodo che restituisce il cap del comune
     * @return
     */
    public int getCap() {
        return cap;
    }
}
