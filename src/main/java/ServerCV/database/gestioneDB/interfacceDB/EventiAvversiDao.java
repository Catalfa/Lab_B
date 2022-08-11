package ServerCV.database.gestioneDB.interfacceDB;

public interface EventiAvversiDao {
	
	public void insertEventoAvverso(String idVaccinazione, String nomeCentro, String evento, Integer severita, String note);
	public int getSegnalazioni(String nomeCentro);
	public double getImportanzaEvento(String nomeCentro, String evento);
	public boolean existId(String id);
	
}
