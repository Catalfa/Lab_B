package ServerCV.server;

/**
 * Classe contenente metodi di utilit� per il package serverCV .
 */
public class Utility {
	
	/**
	 * Metodo che controlla una stringa e se contiene degli spazi li rimuove, creando una parola unica.
	 * @param nome	La stringa da unificare.
	 * @return		La stringa unificata.
	 */
	public static String getNameForQuery(String nome) {
		nome = nome.replaceAll("\\s", "");
		return nome;
	}

}
