package ClientCV.CentroVaccinale.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import ClientCV.CentroVaccinale.Controller.SignIn_CentroVaccinale_Controller;
import Common.CentroVaccinale;

public class SignIn_CentroVaccinale_View extends JFrame {

    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 15);
    private final int WIDTH = 350;
    private final int HIGHT = 450;

    private String[] labelNames = {"Nome", "Cognome", "Matricola", "Email", "Password"};
    private String[] buttonNames = {"BACK", "SIGN-IN", "RESET"};
    private JButton[] buttons = new JButton[3];
    public JTextField[] textFields = new JTextField[4];
    private JLabel[] labels = new JLabel[5];
    public JPasswordField passwordField;

    public SignIn_CentroVaccinale_View() {

        SignIn_CentroVaccinale_Controller controller = new SignIn_CentroVaccinale_Controller(this);

        JPanel mainPanel = new JPanel();

        mainPanel.setBackground(Color.WHITE);

        mainPanel.setLayout(null);

        JLabel signinCentroVaccinale = new JLabel("REGISTRAZIONE Centro Vaccinale", SwingConstants.CENTER);
        signinCentroVaccinale.setFont(mainFont);
        signinCentroVaccinale.setBounds((WIDTH/2)-150, 2, 300, 25);

        mainPanel.add(signinCentroVaccinale);
        
        int y = 50;
        for(int i=0; i<5; i++) {
            labels[i] = new JLabel(labelNames[i], SwingConstants.RIGHT);
            labels[i].setBounds(5, y, 75, 25);
            mainPanel.add(labels[i]);
            y += 50;
        }

        y = 50;
        for(int i=0; i<5; i++) {
            if(i==4) {
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

        buttons[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.signIn(new CentroVaccinale(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), 
                textFields[3].getText(), passwordField.getPassword()));
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
