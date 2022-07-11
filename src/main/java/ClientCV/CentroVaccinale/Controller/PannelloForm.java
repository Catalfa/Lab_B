package ClientCV.CentroVaccinale.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PannelloForm extends JPanel{

    private JLabel labelUsername;
    private JLabel labelPassword;
    private JTextField fieldUsername;
    private JTextField fieldPassword;
    private JButton bottoneInvio;
    private FormListener formListener;
    private JCheckBox checkControlloUsername;
    private JLabel labelControlloUsername;
    private JTextField fieldControlloPassword;
    private JLabel labelControlloPassword;

    PannelloForm(){

        setPreferredSize(new Dimension(400,100));
        setLayout(new GridBagLayout());

        //bordi
        Border bordoInterno = BorderFactory.createTitledBorder("Login centro vaccinale");
        Border bordoEsterno = BorderFactory.createEmptyBorder(0, 5, 5, 5);
        Border bordoFinale = BorderFactory.createCompoundBorder(bordoEsterno, bordoInterno);

        setBorder(bordoFinale);


        //username
        labelUsername = new JLabel("Username: ");
        fieldUsername = new JTextField(20);


        //password
        labelPassword = new JLabel("Password: ");
        fieldPassword = new JTextField(20);


        //controllo username e pw
        labelControlloUsername = new JLabel("username");
        checkControlloUsername = new JCheckBox();

        labelControlloPassword = new JLabel("password");
        fieldControlloPassword = new JTextField(20);

        labelControlloPassword.setEnabled(false);
        fieldControlloPassword.setEnabled(false);

        checkControlloUsername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selezione = checkControlloUsername.isSelected();

                labelControlloPassword.setEnabled(selezione);
                fieldControlloPassword.setEnabled(selezione);

            }
        });


        //bottone invio
        bottoneInvio = new JButton("Invio");
        bottoneInvio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = fieldUsername.getText();             //ci permette ottenere la stringa testo che utente inserisce
                String password = fieldPassword.getText();
                boolean controlloUsername = checkControlloUsername.isSelected();
                String controlloPassword = fieldControlloPassword.getText();

                FormEvent formEvent = new FormEvent(this, username, password, controlloUsername, controlloPassword);

                if (formListener != null){
                    formListener.formEventListener(formEvent);
                }
            }
        });

        //layout
        GridBagConstraints gbc = new GridBagConstraints();

        //riga 1 label username
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.LINE_END;

        add(labelUsername, gbc);

        //riga 1 field username
        gbc.gridx = 1;
        gbc.gridy = 0;

        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(fieldUsername, gbc);

        //riga 2 label password
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.LINE_END;

        add(labelPassword, gbc);

        //riga 2 field password
        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(fieldPassword, gbc);

        //riga 3 label controllo pw
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.LINE_END;

        add(labelControlloPassword, gbc);

        //riga 3 checkbox pw
        gbc.gridx = 1;
        gbc.gridy = 2;

        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(fieldControlloPassword, gbc);

        //riga 4 label controllo username
        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.LINE_END;

        add(labelControlloUsername, gbc);

        //riga 4 field username
        gbc.gridx = 1;
        gbc.gridy = 3;

        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(checkControlloUsername, gbc);


        //riga finale bottone
        gbc.gridx = 0;
        gbc.gridy = 4;

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.gridwidth = 2;

        gbc.anchor = GridBagConstraints.PAGE_START;
        add(bottoneInvio, gbc);
    }

    public void setFormListener(FormListener formListener){               //ci permette impostare il formListener
        this.formListener = formListener;
    }


}
