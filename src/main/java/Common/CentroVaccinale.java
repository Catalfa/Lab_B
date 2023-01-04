package Common;

import java.io.Serializable;
import java.rmi.RemoteException;

import ClientCV.client.ServerSingleton;
import ServerCV.interfaccia.Server;

/**
 * Classe oggetto per i dati dei centri vaccinali registrati.
 */

public class CentroVaccinale implements Serializable {

    private String idCentro;
    private String nomeCentroVaccinale;
    private String tipologiaCentro;
    private String qualificatore;
    private String indirizzo;
    private int numeroCivico;
    private String comune;
    private String provincia;
    private int cap;
    private Server server;

    /**
     * Costruttore della classe centro vaccinale
     * @param idCentro L'id del centro vaccinale.
     * @param nomeCentroVaccinale Il nome del centro vaccinale.
     * @param tipologiaCentro La tipologia del centro vaccinale.
     * @param qualificatore Il qualificatore della via del centro vaccinale.
     * @param indirizzo L'indirizzo del centro vaccinale.
     * @param numeroCivico Il numero civico della via del centro vaccinale.
     * @param comune Il comune del centro vaccinale.
     * @param provincia La provincia del centro vaccinale.
     * @param cap Il cap del centro vaccinale.
     */

    public CentroVaccinale(String idCentro, String nomeCentroVaccinale, String tipologiaCentro, String qualificatore,
            String indirizzo, int numeroCivico, String comune, String provincia, int cap) {
        this.idCentro = idCentro;
        this.nomeCentroVaccinale = nomeCentroVaccinale;
        this.tipologiaCentro = tipologiaCentro;
        this.qualificatore = qualificatore;
        this.indirizzo = indirizzo;
        this.numeroCivico = numeroCivico;
        this.comune = comune;
        this.provincia = provincia;
        this.cap = cap;
    }

    /**
     * Metodo che ritorna l'id del centro vacccinale registrato nel DB.
     * @return L'id del centro vaccinale
     */

    public String getIdCentro() {
        return idCentro;
    }

    /**
     * Metodo che ritorna il nome del centro vaccinale registrato nel DB.
     * @return Il nome del centro vaccinale
     */

    public String getnomeCentroVaccinale() {
        return nomeCentroVaccinale;
    }

    /**
     * Metodo che ritorna la tipologia del centro vaccinale registrato nel DB.
     * @return La tipologia del centro vaccinale
     */

    public String getTipologiaCentro() {
        return tipologiaCentro;
    }

    /**
     * Metodo che ritorna il qualificatore della via del centro vaccinale registrato nel DB.
     * @return Il qualificatore della via del centro vaccinale
     */

    public String getQualificatore() {
        return qualificatore;
    }

    /**
     * Metodo che ritorna l'indirizzo del centro vaccinale registrato nel DB.
     * @return L'indirizzo del centro vaccinale
     */

    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Metodo che ritorna il numero civico della via del centro vaccinale registrato nel DB.
     * @return Il numero civico della via del centro vaccinale.
     */

    public int getNumeroCivico() {
        return numeroCivico;
    }

    /**
     * Metodo che ritorna il comune di appartenenza del centro vaccinale registrato nel DB.
     * @return Il comune di appartrenenza del centro vaccinale.
     */

    public String getComune() {
        return comune;
    }

    /**
     * Metodo che ritorna la provincia di appartenenza del centro vaccinale  registrato nel DB.
     * @return La provincia di appartenenza del centro vaccinale
     */

    public String getProvincia() {
        return provincia;
    }

    /**
     * Metodo che ritorna il cap del centro vaccinale registrato nel DB.
     * @return Il cap del centro vaccinale
     */

    public int getCap() {
        return cap;
    }

    /**
     * Metodo per stampare i dati del centro vaccinale registrato nel DB a video.
     * @param centro La lista con i dati del centro vaccinale.
     * @return La stringa contenente i dati del centro vaccinale.
     * @throws RemoteException
     */

    public String toString(CentroVaccinale centro) throws RemoteException {
        server = ServerSingleton.getInstance();
        String Centro = centro.idCentro + "," + centro.nomeCentroVaccinale + "," + centro.tipologiaCentro + ","
                + centro.provincia + "," + centro.comune + "," + centro.indirizzo + ","
                + Integer.toString(centro.numeroCivico) + ","
                + Double.toString(server.getImportanzaEvento(centro.getIdCentro(), "Mal di testa")) + "," +
                Double.toString(server.getImportanzaEvento(centro.getIdCentro(), "Mal di pancia")) + "," +
                Double.toString(server.getImportanzaEvento(centro.getIdCentro(), "Febbre")) + "," +
                Double.toString(server.getImportanzaEvento(centro.getIdCentro(), "Dolori articolari - muscolari")) + ","
                +
                Double.toString(server.getImportanzaEvento(centro.getIdCentro(), "Linfoadenopatia")) + "," +
                Double.toString(server.getImportanzaEvento(centro.getIdCentro(), "Tachicardia")) + "," +
                Double.toString(server.getImportanzaEvento(centro.getIdCentro(), "Crisi ipertensiva")) + ","
                + Integer.toString(server.ottieniNumSegnalazioni(centro.nomeCentroVaccinale));
        return Centro;

    }

}
