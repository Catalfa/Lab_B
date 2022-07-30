package ServerCV.database.gestioneDB.interfacceDB;

import Common.InfoCentriVaccinali;
import Common.RegistrazioniVaccinati;

import java.sql.ResultSet;
import java.util.List;

public interface CentriVaccinaliDao {

	public void insertDatiCentroVaccinale(InfoCentriVaccinali infoCentroVaccinale);
	public List<InfoCentriVaccinali> findCentroVaccinale(String researchText);
	public boolean existCentroVaccinale(String nomeCentro);
	public void createVaccinati_(String nomeCentro);
	public void alterVaccinati_(String nomeCentro);
	public InfoCentriVaccinali convertToInfoCentro(ResultSet rs);
	public boolean existCf(String nomeCentro, String cf);
	public boolean existId(String nomeCentro, int id);
	public void insertVaccinato(RegistrazioniVaccinati registrazioneVaccinato);
	public int countCentriVaccinali();
}
