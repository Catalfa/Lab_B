package ClientCV.CentriVaccinali.View;

import ClientCV.CentriVaccinali.Controller.HomePageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Classe view HomePage contiene bottoni per scegliere eseguire programma tramite accesso libero o login
 */
public class HomePageView extends JFrame {


    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 15);
    private final int WIDTH = 400;
    private final int HIGHT = 300;


    /**
     * Costruttore della classe
     */
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
        btnAccessoLibero.setBounds(30, HIGHT-120, 150, 25);
        btnLogin.setBounds(WIDTH-192, HIGHT-120, 150, 25);


        /**
         * Metodo crea bottone per eseguire tramite login, crea collegamento classe Login e chiude frame corrente
         */
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.createLoginFrame();
            }
        });


        /**
         * Metodo crea bottone per eseguire tramite accesso libero, crea collegamento classe AccessoLibero e chiude frame corrente
         */
        btnAccessoLibero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.createAccLibFrame();
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
