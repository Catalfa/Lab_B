package ServerCV;
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
    private JPasswordField field4;
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
        field4 = new JPasswordField(20);
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
                try {
                    new ServerStart().start(field2.getText(),field1.getText(),field3.getText(),field4.getText());
                    dispose();
                }catch (Exception ex){
                    dispose();
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

}