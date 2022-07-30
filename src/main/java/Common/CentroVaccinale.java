package Common;

public class CentroVaccinale {
    
    private String idCentro;
    private String nomeCentroVaccinale;
    private String tipologiaCentro;
    private String qualificatore;
    private String indirizzo;
    private int numeroCivico;
    private String comune;
    private String provincia;
    private String cap;

    public CentroVaccinale(String idCentro, String nomeCentroVaccinale, String tipologiaCentro, String qualificatore, String indirizzo, int numeroCivico, String comune, String provincia, String cap) {
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

    public String getIdCentro(){
        return idCentro;
    }

    public String getnomeCentroVaccinale() {
        return nomeCentroVaccinale;
    }

    public String getTipologiaCentro() {
        return tipologiaCentro;
    }

    public String getQualificatore(){
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

    public String getCap() {
        return cap;
    }

}
