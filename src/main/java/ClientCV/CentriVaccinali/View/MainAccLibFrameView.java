package ClientCV.CentriVaccinali.View;

import ClientCV.CentriVaccinali.Controller.MainAccLibFrameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAccLibFrameView extends JFrame {

    public JFrame frame;
    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 18);
    private final Font secondMainFont = new Font("Segoeo print", Font.BOLD, 16);
    private final int WIDTH = 450;
    private final int HIGHT = 300;

    public MainAccLibFrameView(){


        MainAccLibFrameController controller = new MainAccLibFrameController(this);

        JLabel lbAccLibFrame = new JLabel("Accesso Libero");
        JButton btnConsultaInfoCv = new JButton("Consulta Informazioni Centro Vaccinale");
        JButton btnBack = new JButton("Back");

        btnConsultaInfoCv.setFont(mainFont);

        btnBack.setFont(mainFont);
        lbAccLibFrame.setFont(secondMainFont);

        JPanel upperPanel = new JPanel();
        upperPanel.setBackground(Color.WHITE);
        upperPanel.add(lbAccLibFrame);

        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout());
        lowerPanel.setBackground(Color.WHITE);
        lowerPanel.add(btnBack);
        lowerPanel.add(btnConsultaInfoCv);


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

        btnConsultaInfoCv.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.createConsultaInfoCvFrame();
            }

        });


    }

}
