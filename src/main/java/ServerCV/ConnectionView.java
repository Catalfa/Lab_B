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
    private  JLabel titleLabel;
    private final JLabel nomeLabel;
    private final JLabel portaLabel;
    private final JLabel usernameLabel;
    private final JLabel passwordLabel;

    private final JTextField field1;
    private final JTextField field2;
    private final JTextField field3;
    private final JPasswordField field4;
    private final JButton button;

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
        field1.setBounds(220, 50, 250, 25);
        field2.setBounds(220, 100, 250, 25);
        field3.setBounds(220, 150, 250, 25);
        field4.setBounds(220, 200, 250, 25);
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
                    new ServerStart().start(field2.getText(),field1.getText(),field3.getText(),field4.toString());
                    dispose();
                }catch (Exception ex){
                    dispose();
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