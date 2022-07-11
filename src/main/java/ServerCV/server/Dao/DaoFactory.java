package ServerCV.server.Dao;

/**
 * Nicolo' Ferrari, Mat. 732707, Varese
 * Alessandro Formenti, Mat. 734465, Varese
 * Luigi Mucciarone, Mat. 732714, Varese
 * Luca Alberti, Mat. 733096, Varese
 */

/**
 * Classe contenente i metodi per la creazione del DAO.
 */
public class DaoFactory {

	static String databaseType = "";
	
	/**
	 * Metodo che imposta il tipo di DB.
	 * @param dBType	Il tipo di DB.
	 */
	public static void setDatabaseType(String dBType) {
		
		databaseType = dBType;
	}
	
	/**
	 * Metodo che crea il DAO in base al tipo di DB.
	 * @param nome		Il nome del DB.
	 * @return			Crea una nuova implementazione per ogni interfaccia del DAO.
	 */
	public static GeneralDao getDao(String nome) {
		
		switch(nome) {
			case "CentriVaccinaliDao":
				if(databaseType.equals("PostgreSQL"))
					return new CentriVaccinaliDaoImpl();
				break;
			case "CittadiniRegistratiDao":
				if(databaseType.equals("PostgreSQL"))
					return new CittadiniRegistratiDaoImpl();
				break;
			case "EventiAvversiDao":
				if(databaseType.equals("PostgreSQL"))
					return new EventiAvversiDaoImpl();
				break;
			case "RegistrazioniVaccinazioniDao":
				if(databaseType.equals("PostgreSQL"))
					return new RegistrazioniVaccinazioniDaoImpl();
				break;
		}
		
		return null;
			
	}
}
