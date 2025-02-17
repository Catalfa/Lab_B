package ServerCV.database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe oggetto per la creazione delle tabelle nel DB.
 */

public class CreazioneTabelle { //Classe che usiamo per creare le tabelle nel DB
    String sql;

    /**
     * Metodo che realizza la query per creazione della tabella dei centri vaccinali nel DB.
     * @param conn La connessione con il DB
     */
    public void Create_CentroVaccinale(Connection conn){
        sql= """
                CREATE TABLE IF NOT EXISTS CentriVaccinali (
                \tid_centro VARCHAR(20) PRIMARY KEY,
                \tnome_centro VARCHAR(60) NOT NULL,                                 
                \ttipologia VARCHAR(20) NOT NULL,
                \tqualificatore VARCHAR(20) NOT NULL,
                \tnome_via VARCHAR(60) NOT NULL,
                \tnum_civ VARCHAR(10) NOT NULL,
                \tcomune VARCHAR(60) NOT NULL,
                \tprovincia VARCHAR(10) NOT NULL,  
                \tcap INT NOT NULL,
                \tusername VARCHAR(20) UNIQUE NOT NULL,
                \tpassword VARCHAR(20) NOT NULL
                );""";
        InvioCreateTable(sql,conn);

    }

    /**
     * Metodo che realizza la query per la creazione della tabella vaccinati di un determinato centro nel DB.
     * @param conn La connessione al DB.
     * @param nomeCentro Il nome del centro vaccinale
     */
    public void Create_Vaccinato(Connection conn,String nomeCentro){
        String aux=nomeCentro.toLowerCase();
        String trimmedString = aux.trim();
        String nome = trimmedString.replaceAll("\\s", "");
        
        sql="CREATE TABLE IF NOT EXISTS Vaccinati_"+nome+ " (\n" +
                "\tcf VARCHAR(30),\n" +
                "\tnome VARCHAR(20) NOT NULL,\n" +
                "\tcognome VARCHAR(20) NOT NULL,\n" +
                "\tdata_vaccinazione VARCHAR(20) ,\n" +
                "\tvaccino_somministrato VARCHAR(30) NOT NULL,\n" +
                "\tidvaccinazione VARCHAR(20) UNIQUE NOT NULL,\n" +
                "\tid_centro VARCHAR(20) NOT NULL,\n" +
                "\tPRIMARY KEY(cf,data_vaccinazione),\n" +
                "\tFOREIGN KEY (id_centro) REFERENCES CentriVaccinali(id_centro)\n" +
                ");";
        InvioCreateTable(sql,conn);
    }

    /**
     * Metodo che realizza la query per la creazione della tabella dei cittadini registrati ad un centro nel DB.
     * @param conn La connessione al DB
     */

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

    /**
     * Metodo che realizza la query per la creazione della tabella degli eventi avversi nel DB.
     * @param conn La connessione al DB
     */

    public void Create_EventiAvversi(Connection conn){
        sql= """
                CREATE TABLE IF NOT EXISTS Eventi_Avversi (
                \tid_vaccinazione VARCHAR(20) NOT NULL,
                \tid_centro VARCHAR(60) NOT NULL,
                \tnome_evento VARCHAR(60) NOT NULL,
                \tnote_opzionali VARCHAR(256),
                \tseverita INT NOT NULL,
                \tcf VARCHAR(16) NOT NULL,
                \tPRIMARY KEY(id_vaccinazione, id_centro, nome_evento),
                \tFOREIGN KEY (cf) REFERENCES Cittadini_Registrati(cf)
                );""";
        InvioCreateTable(sql,conn);
    }

    /**
     * Metodo che crea nel DB la tabella specificata nella query.
     * @param sql La query per la creazione della tabella.
     * @param conn La connessione al DB
     */
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

    /**
     * Metodo per realizzare le tabelle nel DB.
     * @param conn Connessione al DB
     * @throws SQLException
     */

    public void CreateTables(Connection conn) throws SQLException{
        Statement stm=conn.createStatement();
        
        sql= "SELECT * FROM centrivaccinali";

        ResultSet rs=stm.executeQuery(sql);
        DatabaseMetaData metaData = conn.getMetaData();
        
        while(rs.next()){
            String name=rs.getString("nome_centro");
            ResultSet ResultSet = metaData.getTables(null, null, "vaccinati_" + name, null);
            if(ResultSet.next()){
                return;
            }else{
                Create_Vaccinato(conn, name);
            }
        }

    }

}
