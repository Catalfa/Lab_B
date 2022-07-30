package Common;

import java.io.Serializable;
import java.sql.Date;

public class PrenotazioniVaccini implements Serializable{

    private String nomeCentro;
    private String CF;
    private Date data;

    public PrenotazioniVaccini(String nomeCentro, String CF, Date data){
        this.nomeCentro = nomeCentro;
        this.CF = CF;
        this.data = data;
    }

    public String getNomeCentro(){ 
        return nomeCentro; }

    public String getCF(){ 
        return CF; }

    public Date getData(){
        return data; }
    
}
