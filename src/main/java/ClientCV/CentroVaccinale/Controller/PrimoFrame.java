package ClientCV.CentroVaccinale.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PrimoFrame extends JFrame{

    private TextAreaPanel textAreaPanel;

    private BarraStrumenti barraStrumenti;

    private PannelloForm pannelloForm;
    public PrimoFrame(){

        super("Login Centro Vaccinale");

        setLayout(new BorderLayout());    //seleziono tipo layout

        barraStrumenti = new BarraStrumenti();                    //per mettere comunicazione barraStrumenti e textAreaPanel passiamo alla barraStrumenti un riferimento al pannello di testo
        textAreaPanel = new TextAreaPanel();
        pannelloForm = new PannelloForm();

        barraStrumenti.setTextListener(new TextListener() {
            @Override
            public void testoEmesso(String testo) {
                textAreaPanel.appentiTesto(testo);
            }
        });

        pannelloForm.setFormListener(new FormListener() {
            @Override
            public void formEventListener(FormEvent fe) {
                String username = fe.getUsername();
                String password = fe.getPassword();
                boolean controlloUsername = fe.isControlloUsername();
                String controlloPassword = fe.getControlloPassword();

                textAreaPanel.appendiTesto("Username: " + username + "\nPassword: " + password + "\nControllo Username: " + controlloUsername + "\nControllo Password: " + controlloPassword);
            }
        });

        add(textAreaPanel, BorderLayout.CENTER);      //posizione area testo
       // add(barraStrumenti, BorderLayout.PAGE_START);
        add(pannelloForm, BorderLayout.LINE_START);

        setSize( 800, 500);

        setLocationRelativeTo(null);

        //setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }
}
