package ServerCV.server.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Nicolo' Ferrari, Mat. 732707, Varese
 * Alessandro Formenti, Mat. 734465, Varese
 * Luigi Mucciarone, Mat. 732714, Varese
 * Luca Alberti, Mat. 733096, Varese
 */

/**
 * Classe contenente metodi per gestire la connessione col DB.
 */
public class GeneralDao {
	
	private static String DB_URL;
	private static String DB_USERNAME;
	private static String DB_PASSWORD;
	
	/**
	 * Metodo che imposta i parametri di connession col DB.
	 * @param url		L'URL del DB nel formato: jdbc:postgresql://localhost:numero_porta/nome_database.
	 * @param username	Lo username per accedere al DB.
	 * @param password	La password per accedere al DB.
	 */
	public  void setDatabaseParams(String url, String username, String password) {
		DB_URL = url;
		DB_USERNAME = username;
		DB_PASSWORD = password;
	}

	/**
	 * Metodo che avvia la connessione col DB.
	 * @return		Se la connessione non va a termine restituisce null.
	 */
	public Connection openConnection() {
		try {
			Connection connection=DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.println("connesso al db");
			return  connection;

		} catch (SQLException ex) {
			System.err.println("ERRORE DI CONNESSIONE AL DATABASE, CONTROLLARE I DATI INSERITI O IL CORRETTO FUNZIONAMENTO DEL DATABASE");
		}
		return null;
	}
	
	/**
	 * Metodo che chiude la connessione col DB.
	 * @param connection	La connessione col DB.
	 */
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
