package ClientCV.Cittadino.View;

import ClientCV.Cittadino.Controller.SignInCittadinoController;
import Common.DatiCittadino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInCittadinoView extends JFrame{

    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 18);
    private final int WIDTH = 400;
    private final int HIGHT = 550;

    private String[] labelNames = {"Nome", "Cognome", "CF", "Email", "Username", "Password", "ID-Vaccinazione", "ID-Centro"};
    private String[] buttonNames = {"BACK", "SIGN-IN", "RESET"};
    private JButton[] buttons = new JButton[3];
    public JTextField[] textFields = new JTextField[8];
    private JLabel[] labels = new JLabel[8];
    public JPasswordField passwordField;
    private SignInCittadinoController controller;

    public SignInCittadinoView() {

        this.controller = new SignInCittadinoController(this);

        JPanel mainPanel = new JPanel();

        mainPanel.setBackground(Color.WHITE);

        mainPanel.setLayout(null);

        JLabel signinCittadino = new JLabel("REGISTRAZIONE CITTADINO", SwingConstants.CENTER);
        signinCittadino.setFont(mainFont);
        signinCittadino.setBounds((WIDTH / 2) - 150, 2, 300, 25);

        mainPanel.add(signinCittadino);

        int y = 50;
        for (int i = 0; i < 8; i++) {
            labels[i] = new JLabel(labelNames[i], SwingConstants.RIGHT);
            labels[i].setBounds(7, y, 105, 25);
            mainPanel.add(labels[i]);
            y += 50;
        }

        y = 50;
        for (int i = 0; i <= 7; i++) {
            if (i == 5) {
                passwordField = new JPasswordField(20);
                passwordField.setBounds(120, y, 250, 25);
                mainPanel.add(passwordField);
                textFields[i] = new JTextField(20);
                textFields[i].setBounds(120, y, 250, 25);
                mainPanel.add(textFields[i]);
                y += 50;
            } else {
                textFields[i] = new JTextField(20);
                textFields[i].setBounds(120, y, 250, 25);
                mainPanel.add(textFields[i]);
                y += 50;
            }
        }

        int x = 0;
        for (int i = 0; i < 3; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setBounds((WIDTH / 2) - 150 + x, 450, 90, 25);
            mainPanel.add(buttons[i]);
            x += 100;
        }


        add(mainPanel);

        setSize(WIDTH, HIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        buttons[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.goBack();
            }

        });

        //0 ci ritorna l'id_vaccinazione nel controller
        buttons[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.signIn(new DatiCittadino(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(),
                        textFields[3].getText(), textFields[4].getText(), (passwordField.getPassword()).toString(), (textFields[5].getText()), (textFields[6].getText())));
            }

        });

        buttons[2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.reset();
            }

        });
    }}


