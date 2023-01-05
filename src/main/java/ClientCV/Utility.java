package ClientCV;

import javax.swing.*;

/**
 * Classe che contiene metodi utili utilizzati nel programma
 */
public class Utility {
    /**
     * metodo che mostra un pop up di errore
     * @param titolo titolo pop-up
     * @param messaggio messaggio pop-up
     */
    public static void showErrorPopUp(String titolo, String messaggio) {
        JOptionPane.showMessageDialog(null, messaggio, titolo, JOptionPane.ERROR_MESSAGE);
    }
    /**
     * metodo che mostra un pop up di attenzione
     * @param titolo titolo pop-up
     * @param messaggio messaggio pop-up
     */
    public void showWarningPopUp(String titolo, String messaggio) {
        JOptionPane.showMessageDialog(null, messaggio, titolo, JOptionPane.WARNING_MESSAGE);
    }
    /**
     * metodo che mostra un pop up di errconfermaore
     * @param titolo titolo pop-up
     * @param messaggio messaggio pop-up
     */
    public void showConfirmationPopUp(String titolo, String messaggio) {
        JOptionPane.showMessageDialog(null, messaggio, titolo, JOptionPane.PLAIN_MESSAGE);
    }
    /**
     * metodo che mostra un pop up di informazione
     * @param titolo titolo pop-up
     * @param messaggio messaggio pop-up
     */
    public static void showInformationPopUp(String titolo, String messaggio) {
        JOptionPane.showMessageDialog(null, messaggio, titolo, JOptionPane.INFORMATION_MESSAGE);
    }
}