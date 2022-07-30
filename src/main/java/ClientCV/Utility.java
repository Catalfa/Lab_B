package ClientCV;

import javax.swing.*;
/* import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
 */
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