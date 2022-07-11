package ClientCV.Cittadino.View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import ClientCV.Cittadino.Controller.LoginCittadinoController;

public class LoginCittadinoView extends JFrame {
    
    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 15);
    private final int WIDTH = 400;
    private final int HIGHT = 300;
    private JTextField usernamField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    private JButton loginButton = new JButton("LOGIN");
    private JButton backButton = new JButton("BACK");
    private JButton signinButton = new JButton("SIGN-IN");

    public LoginCittadinoView() {

        LoginCittadinoController controller = new LoginCittadinoController(this);

        JPanel mainPanel = new JPanel();
        JPanel usernamePanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        usernamePanel.setBackground(Color.WHITE);
        passwordPanel.setBackground(Color.WHITE);
        buttonPanel.setBackground(Color.WHITE);

        usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
        passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));

        JLabel loginCittadino = new JLabel("LOGIN CITTADINO", SwingConstants.CENTER);
        JLabel username = new JLabel("Username");
        JLabel password = new JLabel("Password");

        loginCittadino.setFont(mainFont);

        mainPanel.setLayout(new GridLayout(4, 1));
        mainPanel.setBackground(Color.WHITE);

        mainPanel.add(loginCittadino);

        usernamePanel.add(username);
        usernamePanel.add(usernamField);
        mainPanel.add(usernamePanel);
        
        passwordPanel.add(password);
        passwordPanel.add(passwordField);
        mainPanel.add(passwordPanel);

        buttonPanel.add(backButton);
        buttonPanel.add(signinButton);
        buttonPanel.add(loginButton);
        mainPanel.add(buttonPanel);

        add(mainPanel);

        setSize(WIDTH, HIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.goBack();                
            }

        });

        signinButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.signinCittadino();            
            }

        });

        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernamField.getText();
                char[] password = passwordField.getPassword();
                controller.loginCittadino(username, password);
                // TODO Auto-generated method stub
                
            }

        });
        
    }
}
