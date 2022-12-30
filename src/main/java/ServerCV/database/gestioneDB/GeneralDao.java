package ServerCV.database.gestioneDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GeneralDao {
	private static String DB_URL = "jdbc:postgresql://localhost:5433/";
	private static String DB_USERNAME;
	private static String DB_PASSWORD;

	public static void setDatabaseParams(String url, String username, String password) {
		DB_URL = DB_URL + url;
		DB_USERNAME = username;
		DB_PASSWORD = password;
	}

	/**
	 * Metodo che avvia la connessione col DB.
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
