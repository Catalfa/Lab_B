package ClientCV.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

/**
 * Classe che gestisce il formato delle date.
 */
public class DateLabelFormatter extends AbstractFormatter {

    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
	
    /**
     * Metodo che converte una stringa in un oggetto.
     */
	@Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }
	
	/**
	 * Metodo che converte un oggetto in una stringa.
	 */
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

}
