package ServerCV.database.gestioneDB.interfacceDB;

import Common.DatiCittadino;

public interface CittadiniRegistratiDao {
	
	public void insertCittadino(DatiCittadino citizenData);

	public DatiCittadino getDatiCittadino(String cf) ;

	public boolean checkPwCittadino(String username, String password);
	public boolean existCittadino(String username);
	public DatiCittadino getCfCittadino(String username);
	public boolean existCfCittadino(String cf);
	public void updateIdCittadino(int id, String cf);
	public boolean existIdCittadino(int id);
	public int getIdCittadino(String cf);
	public int countCittadiniVaccinati();
}