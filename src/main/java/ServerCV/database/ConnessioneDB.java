package ServerCV.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnessioneDB {      //classe che gestisce la connessione al DB
    String jdbcURL="jdbc:postgresql://localhost:5432/";
    String username;
    String password;
    Connection connection;
    Connection conn;

    public ConnessioneDB(String nomeDb,String user, String pwd){
        this.jdbcURL=jdbcURL+nomeDb;
        this.username=user;
        this.password=pwd;
    }

    public Connection Connessione(){
        try {
            connection= DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connessione riuscita");
        } catch (SQLException e) {
            System.out.println("Connessione fallita");
        }
        return connection;
    }
}
