package ClientCV.CentroVaccinale.View;

import ClientCV.CentroVaccinale.Controller.Login_CentroVaccinale_Controller;
import ClientCV.Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_CentroVaccinale_View extends JFrame {

    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 15);
    private final int WIDTH = 450;
    private final int HIGHT = 500;

    private JTextField tf_user = new JTextField(20);

    private JTextField tf_password = new JTextField(20);
    private JButton loginButton = new JButton("LOGIN");
    private JButton backButton = new JButton("BACK");
    private JButton signinButton = new JButton("SIGN-IN");

    private Utility utility=new Utility();

    public Login_CentroVaccinale_View() {

        Login_CentroVaccinale_Controller controller = new Login_CentroVaccinale_Controller(this);

        JPanel mainPanel = new JPanel();
        JPanel userPanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        userPanel.setLayout(new GridLayout(1, 2));
        userPanel.setBackground(Color.WHITE);
        userPanel.setBounds(5, 5, 5, 5);
        userPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 45, 20));

        passwordPanel.setLayout(new GridLayout(1, 2));
        passwordPanel.setBackground(Color.WHITE);
        passwordPanel.setBounds(5, 5, 5, 5);
        passwordPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 45, 20));
        
        buttonPanel.setBackground(Color.WHITE);

        /* usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
        passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25)); */
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));

        JLabel label_loginCittadino = new JLabel("LOGIN Centro Vaccinale", SwingConstants.CENTER);
        JLabel label_user = new JLabel("Username", SwingConstants.CENTER);
        JLabel label_password = new JLabel("Password", SwingConstants.CENTER);

        label_loginCittadino.setFont(mainFont);

        mainPanel.setLayout(new GridLayout(6, 1));
        mainPanel.setBackground(Color.WHITE);

        mainPanel.add(label_loginCittadino);

        userPanel.add(label_user);
        userPanel.add(tf_user);
        mainPanel.add(userPanel);

        passwordPanel.add(label_password);
        passwordPanel.add(tf_password);
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
                controller.signIn();
            }

        });


        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String user = tf_user.getText();
                String password = tf_password.getText();
                switch (controller.loginCentroVaccinale( user, password)){
                    //TODO @Andre implementare frame successivi
                    case 1:
                        utility.showConfirmationPopUp("Successo!","Login effettuato");
                        //login effettuato con successo
                        break;

                    case 2:
                        utility.showWarningPopUp("Attenzione!","Lo username non è corretto");
                        //username non esistente
                        break;
                    case 3:
                        utility.showWarningPopUp("Attenzione!","La passowrd non è corretta");
                        //password errata
                        break;
                }
            }

        });

    }
}
