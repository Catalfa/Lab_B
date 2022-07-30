package ServerCV.database.gestioneDB;

public class DaoFactory {

	static String databaseType = "";
	
	public static void setDatabaseType(String dBType) {
		
		databaseType = dBType;
	}
	
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
