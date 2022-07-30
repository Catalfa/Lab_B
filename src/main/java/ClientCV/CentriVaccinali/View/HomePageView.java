package ClientCV.CentriVaccinali.View;

import ClientCV.CentriVaccinali.Controller.HomePageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageView extends JFrame {

    //todo
    //Modificare in modo che nel frame non appaia Dottore ma Centro Vaccinale

    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 15);
    private final int WIDTH = 400;
    private final int HIGHT = 300;    

    public HomePageView() {

        HomePageController controller = new HomePageController(this);

        JPanel mainPanel = new JPanel();
        JLabel lbCentriVaccinali = new JLabel("CENTRI VACCINALI", SwingConstants.CENTER);
        JButton btnAccessoLibero = new JButton("Accesso libero");
        JButton btnLogin = new JButton("Login");

        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);

        lbCentriVaccinali.setFont(mainFont);
        btnAccessoLibero.setFont(mainFont);
        btnLogin.setFont(mainFont);

        lbCentriVaccinali.setBounds((WIDTH/2)-100, 5, 200, 100);
        btnAccessoLibero.setBounds(20, HIGHT-80, 150, 25);
        btnLogin.setBounds(WIDTH-170, HIGHT-80, 150, 25);
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.createLoginFrame();
            }
        });

        mainPanel.add(lbCentriVaccinali);
        mainPanel.add(btnAccessoLibero);
        mainPanel.add(btnLogin);    

        add(mainPanel);

        setSize(WIDTH, HIGHT);
        setTitle("Centri Vaccinali");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
