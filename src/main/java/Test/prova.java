package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class prova {

    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5433/ServerCV";
        String username = "rondo";
        String password = "1234";
        try {
            Connection conn = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            System.err.println("problemi connessione");
            e.printStackTrace();
        }
    }
}
