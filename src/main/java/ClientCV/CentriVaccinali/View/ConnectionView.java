package ClientCV.CentriVaccinali.View;
import ClientCV.Utility;
import ClientCV.client.ClientStart;
import ServerCV.server.ServerStart;
import jdk.jshell.execution.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionView extends JFrame {
    private JLabel titleLabel;
    private JLabel nomeLabel;
    private JLabel portaLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private JButton button;

    public  ConnectionView() {
        // imposta il titolo del frame
        super("Connessione DB");

        // imposta il layout del frame
        setLayout(new FlowLayout());

        // crea il label per il titolo
        nomeLabel = new JLabel("nome database:");
        portaLabel = new JLabel("porta database:");
        usernameLabel = new JLabel("username: ");
        passwordLabel = new JLabel("password: ");

        // crea i campi di testo
        field1 = new JTextField(20);
        field2 = new JTextField(20);
        field3 = new JTextField(20);
        field4 = new JTextField(20);
        add(nomeLabel);
        add(field1);
        add(portaLabel);
        add(field2);
        add(usernameLabel);
        add(field3);
        add(passwordLabel);
        add(field4);

        // crea il bottone
        button = new JButton("Connetti");
        add(button);

        // imposta l'azione del bottone
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // quando viene premuto il bottone, stampa i valori dei campi di testo
                System.out.println("Valore del campo 1: " + field1.getText());
                System.out.println("Valore del campo 2: " + field2.getText());
                System.out.println("Valore del campo 3: " + field3.getText());
                System.out.println("Valore del campo 4: " + field4.getText());
                try {
                    new ServerStart().start(field1.getText(),field3.getText(),field4.getText());
                    new ClientStart().start();
                }catch (Exception ex){
                    Utility.showErrorPopUp("Attenzione","Errore nella connessione, verifica che i dati inseriti siano corretti");
                    return;
                }
            }
        });

        // imposta le dimensioni del frame e lo rende visibile
        setSize(300, 300);
        // posiziona il frame al centro del monitor
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        ConnectionView frame = new ConnectionView();
    }
}