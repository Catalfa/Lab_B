package ClientCV.Cittadino.View;

import ClientCV.Cittadino.Controller.SignInCittadinoController;
import Common.DatiCittadino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInCittadinoView extends JFrame{

    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 18);
    private final int WIDTH = 350;
    private final int HIGHT = 450;

    private String[] labelNames = {"Nome", "Cognome", "CF", "Email", "Username", "Password"};
    private String[] buttonNames = {"BACK", "SIGN-IN", "RESET"};
    private JButton[] buttons = new JButton[3];
    public JTextField[] textFields = new JTextField[5];
    private JLabel[] labels = new JLabel[6];
    public JPasswordField passwordField;
    private SignInCittadinoController controller;

    public SignInCittadinoView() {

        this.controller = new SignInCittadinoController(this);

        JPanel mainPanel = new JPanel();

        mainPanel.setBackground(Color.WHITE);

        mainPanel.setLayout(null);

        JLabel signinCittadino = new JLabel("REGISTRAZIONE CITTADINO", SwingConstants.CENTER);
        signinCittadino.setFont(mainFont);
        signinCittadino.setBounds((WIDTH/2)-150, 2, 300, 25);

        mainPanel.add(signinCittadino);
        
        int y = 50;
        for(int i=0; i<6; i++) {
            labels[i] = new JLabel(labelNames[i], SwingConstants.RIGHT);
            labels[i].setBounds(5, y, 75, 25);
            mainPanel.add(labels[i]);
            y += 50;
        }

        y = 50;
        for(int i=0; i<6; i++) {
            if(i==5) {
                passwordField = new JPasswordField(20);
                passwordField.setBounds(100, y, 200, 25);
                mainPanel.add(passwordField);
            } else {
                textFields[i] = new JTextField(20);
                textFields[i].setBounds(100, y, 200, 25);
                mainPanel.add(textFields[i]);
                y += 50;
            }
        }

        int x = 0;
        for(int i=0; i<3; i++){
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setBounds((WIDTH/2)-150+x, 350, 90, 25);
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
                textFields[3].getText(), textFields[4].getText(), (passwordField.getPassword()).toString()));
            }
            
        });

        buttons[2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.reset();
            }

        });
    }
    
}
