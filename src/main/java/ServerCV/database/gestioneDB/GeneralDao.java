package ServerCV.database.gestioneDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe oggetto per la gestione della connessione al DB.
 */

public class GeneralDao {
	private static String DB_URL = "jdbc:postgresql://localhost:5432/";
	private static String DB_USERNAME;
	private static String DB_PASSWORD;

	/**
	 * Metodo per l'assegnazione dei dati di connessione al DB passati da input.
	 * @param url L'url per la connessione al DB.
	 * @param username Lo username per la connessione al DB.
	 * @param password La password per la connessione al DB.
	 */


	public static void setDatabaseParams(String url, String username, String password) {
		DB_URL = DB_URL + url;
		DB_USERNAME = username;
		DB_PASSWORD = password;
	}

	/**
	 * Metodo che avvia la connessione col DB.
	 * @return La connessione al DB
	 */
	public static Connection openConnection() {
		try {
			return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * Metodo che chiude la connessione col DB.
	 */
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
