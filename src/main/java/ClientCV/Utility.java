package ClientCV;

import javax.swing.JOptionPane;

public class Utility {
    
    public static void showErrorPopUp(String titolo, String messaggio) {
        JOptionPane.showMessageDialog(null, messaggio, titolo, JOptionPane.ERROR_MESSAGE);
    }

    public void showWarningPopUp(String titolo, String messaggio) {
        JOptionPane.showMessageDialog(null, messaggio, titolo, JOptionPane.WARNING_MESSAGE);
    }

    public void showConfirmationPopUp(String titolo, String messaggio) {
        JOptionPane.showMessageDialog(null, messaggio, titolo, JOptionPane.PLAIN_MESSAGE);
    }

    public static void showInformationPopUp(String titolo, String messaggio) {
        JOptionPane.showMessageDialog(null, messaggio, titolo, JOptionPane.INFORMATION_MESSAGE);
    }
}
