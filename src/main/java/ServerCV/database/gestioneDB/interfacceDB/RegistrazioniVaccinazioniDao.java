package ServerCV.database.gestioneDB.interfacceDB;

import Common.PrenotazioniVaccini;

public interface RegistrazioniVaccinazioniDao {

	public void insertPrenotazioneVaccinazione(PrenotazioniVaccini prenotazioneVaccino);
	public boolean existCf(String cf);
	public PrenotazioniVaccini getInfoPrenotazione(String cf);
	
}
