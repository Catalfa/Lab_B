package ServerCV.database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreazioneTabelle { //Classe che usiamo per creare le tabelle nel DB
    String sql;
    public void Create_CentroVaccinale(Connection conn){
        sql= """
                CREATE TABLE IF NOT EXISTS CentriVaccinali (
                \tid_centro VARCHAR(20) PRIMARY KEY,
                \tnome_centro VARCHAR(60) NOT NULL,                                 
                \ttipologia VARCHAR(20) NOT NULL,
                \tqualificatore VARCHAR(20) NOT NULL,
                \tnome_via VARCHAR(60) NOT NULL,
                \tnum_civ INT NOT NULL,
                \tcomune VARCHAR(60) NOT NULL,
                \tprovincia VARCHAR(60) NOT NULL,
                \tsigla  VARCHAR(10) NOT NULL,
                \tcap INT NOT NULL
                );""";
        InvioCreateTable(sql,conn);
    }

    public void Create_Vaccinato(Connection conn,String nomeCentro){
        sql="CREATE TABLE IF NOT EXISTS Vacccinati_"+nomeCentro+ " (\n" +
                "\tcf VARCHAR(30),\n" +
                "\tnome VARCHAR(20) NOT NULL,\n" +
                "\tcognome VARCHAR(20) NOT NULL,\n" +
                "\tdata_vaccinazione DATE,\n" +
                "\tvaccino_somministrato VARCHAR(30) NOT NULL,\n" +
                "\tidvaccinazione VARCHAR(20) UNIQUE NOT NULL,\n" +
                "\tid_centro VARCHAR(20) NOT NULL,\n" +
                "\tPRIMARY KEY(cf,data_vaccinazione),\n" +
                "\tFOREIGN KEY (id_centro) REFERENCES CentriVaccinali(id_centro)\n" +
                ");";
        InvioCreateTable(sql,conn);
    }


    public void Create_CittadinoRegistrato(Connection conn){
        sql= """
                CREATE TABLE IF NOT EXISTS Cittadini_Registrati (
                \tcf VARCHAR(30) PRIMARY KEY,
                \tnome VARCHAR(20) NOT NULL,
                \tcognome VARCHAR(20) NOT NULL,
                \tindirizzo_posta VARCHAR(80) UNIQUE NOT NULL,
                \tuserid VARCHAR(40) UNIQUE NOT NULL,
                \tpassword VARCHAR(40) NOT NULL,
                \tidvaccinazione VARCHAR(20) UNIQUE,
                \tid_centro VARCHAR(20) NOT NULL,
                \tFOREIGN KEY (id_centro) REFERENCES CentriVaccinali(id_centro)
                );""";
        InvioCreateTable(sql,conn);
    }

    public void Create_EventiAvversi(Connection conn){
        sql= """
                CREATE TABLE IF NOT EXISTS Eventi_Avversi (
                \tid_evento VARCHAR(20) PRIMARY KEY,
                \tnome_centro VARCHAR(60) NOT NULL,
                \tnome_evento VARCHAR(60) NOT NULL,
                \tnote_opzionali VARCHAR(256) NOT NULL,
                \tseverita INT NOT NULL,
                \tuserid VARCHAR(40) UNIQUE NOT NULL,
                \tpassword VARCHAR(40) NOT NULL,
                \tcf VARCHAR(30) NOT NULL,
                \tFOREIGN KEY (cf) REFERENCES Cittadini_Registrati(cf)
                );""";
        InvioCreateTable(sql,conn);
    }

    public void InvioCreateTable(String sql, Connection conn){
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Tabella creata correttamente");
        } catch (SQLException e) {
            System.out.println("Errore nella creazione della tabella");
            throw new RuntimeException(e);
        }

    }
}
