package ClientCV.CentriVaccinali.View;

import ClientCV.CentriVaccinali.Controller.MainLoginFrameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Classe che permette esecuzione del programma tramite Login, contiene bottoni back, login Cittadino e login Centro
 */
public class MainLoginFrameView extends JFrame {


    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 18);
    private final Font secondMainFont = new Font("Segoeo print", Font.BOLD, 16);
    private final int WIDTH = 600;
    private final int HIGHT = 250;


    /**
     * Costruttore della classe
     */
    public MainLoginFrameView(){

        MainLoginFrameController controller = new MainLoginFrameController(this);

        JLabel lbWelcomeLogFrame = new JLabel("Desideri fare il login come cittadino oppure come Centro Vaccinale?");
        JButton btnLogCittadino = new JButton("Cittadino");
        JButton btnLoginDottore = new JButton("Centro Vaccinale");
        JButton btnBack = new JButton("Back");

        btnLogCittadino.setFont(mainFont);
        btnLoginDottore.setFont(mainFont);
        btnBack.setFont(mainFont);
        lbWelcomeLogFrame.setFont(secondMainFont);

        JPanel upperPanel = new JPanel();
            upperPanel.setBackground(Color.WHITE);
            upperPanel.add(lbWelcomeLogFrame);

        JPanel lowerPanel = new JPanel();
            lowerPanel.setLayout(new FlowLayout());
            lowerPanel.setBackground(Color.WHITE);
            lowerPanel.add(btnBack);
            lowerPanel.add(btnLoginDottore);
            lowerPanel.add(btnLogCittadino);

        JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new GridLayout(2, 1));
            mainPanel.add(upperPanel);
            mainPanel.add(lowerPanel);


        add(mainPanel);

        setSize(WIDTH, HIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        /**
         * metodo bottone Back chiude frame corrente e apre frame precedente HomePage
         */
        btnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.backToHomePage();
            }

        });


        /**
         * metodo bottone LoginCittadino chiude frame corrente e apre frame successivo Login Cittadino
         */
        btnLogCittadino.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.createLoginCittadinoFrame();
            }

        });


        /**
         * metodo bottone LoginCentro chiude frame corrente e apre frame successivo Login Centro
         */
        btnLoginDottore.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.createLoginDottoreFrame();
            }

        });


    }
}
