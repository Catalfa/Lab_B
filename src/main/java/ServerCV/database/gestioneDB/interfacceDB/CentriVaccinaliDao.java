package ServerCV.database.gestioneDB.interfacceDB;

import Common.InfoCentriVaccinali;
import Common.RegistrazioniVaccinati;

import java.sql.ResultSet;
import java.util.List;

public interface CentriVaccinaliDao {

	public void insertDatiCentroVaccinale(InfoCentriVaccinali infoCentroVaccinale);
	public List<InfoCentriVaccinali> findCentroVaccinale(String researchText);
	public Boolean existCentroVaccinale(String nomeCentro);
	//public Boolean existCentro(String username);
//	public Boolean checkLoginCentro(String username, String password);
	public void createVaccinati_(String nomeCentro);
	//public void alterVaccinati_(String nomeCentro);
	public InfoCentriVaccinali convertToInfoCentro(ResultSet rs);
	public Boolean existCf(String nomeCentro, String cf);
	public Boolean existIdVaccinazione(String nomeCentro, int id);
	public void insertVaccinato(RegistrazioniVaccinati registrazioneVaccinato);
	public int countCentriVaccinali();
}
