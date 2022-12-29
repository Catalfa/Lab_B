package Common;

import java.io.Serializable;
import java.rmi.RemoteException;

public class InfoCentriVaccinali implements Serializable {
    private CentroVaccinale dati;
    private String username;
    private String password;

    public InfoCentriVaccinali(String idcentro, String nome_centro, String tipologia, String qualificatore,
            String nomevia, int numciv, String comune, String provincia, int cap) {
        dati = new CentroVaccinale(idcentro, nome_centro, tipologia, qualificatore, nomevia, numciv, comune, provincia,
                cap);
    }

    public InfoCentriVaccinali(String username, String password, String idcentro, String nome_centro, String tipologia,
            String qualificatore, String nomevia, int numciv, String comune, String provincia, int cap) {
        this.username = username;
        this.password = password;
        dati = new CentroVaccinale(idcentro, nome_centro, tipologia, qualificatore, nomevia, numciv, comune, provincia,
                cap);
    }

    public InfoCentriVaccinali() {
    }

    public String getIdCentro() {
        return dati.getIdCentro();
    }

    /**
     * Metodo che restituisce il nome del centro vaccinale.
     * 
     * @return Il nome del centro vaccinale.
     */
    public String getNomeCentro() {
        return dati.getnomeCentroVaccinale();
    }

    /**
     * Metodo che restituisce la tipologia dell'ospedale
     * 
     * @return tipologia
     */
    public String getTipologia() {
        return dati.getTipologiaCentro();
    }

    /**
     * Metodo che restitusce il qualificatore della via
     * 
     * @return qualificatore
     */
    public String getQualificatore() {
        return dati.getQualificatore();
    }

    /**
     * Metodo che restituisce il nome della via
     * 
     * @return nomevia
     */
    public String getNomeVia() {
        return dati.getIndirizzo();
    }

    /**
     * Metodo che restituisce il numero civico della via
     * 
     * @return numciv
     */
    public int getNumCiv() {
        return dati.getNumeroCivico();
    }

    /**
     * Metodo che resituisce il comune
     * 
     * @return comune
     */
    public String getComune() {
        return dati.getComune();
    }

    /**
     * Metodo che restituisce la provincia
     * 
     * @return provincia
     */
    public String getProvincia() {
        return dati.getProvincia();
    }

    /**
     * Metodo che restituisce il cap del comune
     * 
     * @return
     */
    public int getCap() {
        return dati.getCap();
    }

    public String toArray(InfoCentriVaccinali centro) throws RemoteException {
        return dati.toString(centro.dati);
    }

    /**
     * Metodo che restituisce lo username del centro
     * 
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metodo che restituisce la password del centro
     * 
     * @return
     */
    public String getPassword() {
        return password;
    }
}
