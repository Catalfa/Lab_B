package Common;

public class CentroVaccinale {
    
    private String nome;
    private String cognome;
    private String matricola;
    private String email;
    private char[] password;

    //todo
    //Essendo ora un centro vaccinale e non piu un dottore, modificare i dati richiesti e i getter/setter
    //in modo da rispettare le caratteristiche del centro vaccinale

    public CentroVaccinale(String nome, String cognome, String matricola, String email, char[] password) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.email = email;
        this.password = password;
    }

    public String GetNome() {
        return nome;
    }

    public String GetCognome() {
        return cognome;
    }

    public String GetMatricola() {
        return matricola;
    }

    public String GetEmail() {
        return email;
    }

    public char[] GetPassword() {
        return password;
    }

}
