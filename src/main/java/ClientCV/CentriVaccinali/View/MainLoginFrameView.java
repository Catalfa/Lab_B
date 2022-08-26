package ClientCV.CentriVaccinali.View;

import ClientCV.CentriVaccinali.Controller.MainLoginFrameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainLoginFrameView extends JFrame {

    //todo
    //Modificare in modo che nel frame non appaia Dottore ma Centro Vaccinale

    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 18);
    private final Font secondMainFont = new Font("Segoeo print", Font.BOLD, 16);
    private final int WIDTH = 600;
    private final int HIGHT = 250;

    public MainLoginFrameView(){

        MainLoginFrameController controller = new MainLoginFrameController(this);

        JLabel lbWelcomeLogFrame = new JLabel("Desideri fare il login come cittadino oppure come Centro Vaccinale?");
        JButton btnLogCittadino = new JButton("Cittadino");
        JButton btnLoginDottore = new JButton("Centro Vaccinale");
        JButton btnBack = new JButton("Indietro");

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

        btnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.backToHomePage();
            }

        });

        btnLogCittadino.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.createLoginCittadinoFrame();
            }

        });

        btnLoginDottore.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.createLoginDottoreFrame();
            }

        });


    }
}
