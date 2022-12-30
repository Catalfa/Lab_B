package Common;

import java.io.Serializable;
import java.rmi.RemoteException;

import ClientCV.client.ServerSingleton;
import ServerCV.interfaccia.Server;

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

    public String getIdCentro() {
        return idCentro;
    }

    public String getnomeCentroVaccinale() {
        return nomeCentroVaccinale;
    }

    public String getTipologiaCentro() {
        return tipologiaCentro;
    }

    public String getQualificatore() {
        return qualificatore;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }

    public String getComune() {
        return comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getCap() {
        return cap;
    }

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
