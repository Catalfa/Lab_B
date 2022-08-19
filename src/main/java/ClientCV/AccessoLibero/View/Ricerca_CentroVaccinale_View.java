package ClientCV.AccessoLibero.View;

import ClientCV.AccessoLibero.Controller.Ricerca_CentroVaccinale_Controller;
import ClientCV.Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ricerca_CentroVaccinale_View extends JFrame{

    Ricerca_CentroVaccinale_Controller controller;

    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 18);
    private final Font secondMainFont = new Font("Segoeo print", Font.BOLD, 14);
    private static final int WIDTH = 600;
    private static final int HIGHT = 350;

    public JFrame frame;
    private JPanel panel_labels;
    private JPanel panel_navigation;
    private JPanel panel_welcome;

    private JLabel label_cercaPerNomeCentro;
    private JLabel label_cercaPerComune;
    private JLabel label_cercaPerTipologia;
    private JLabel welcome_label;

    private JTextField tf_cercaPerNomeCentro;
    private JTextField tf_cercaPerComune;
    private JTextField tf_cercaPerTipologia;

    private JButton btn_back;
    private JButton btn_cerca;
    private JButton btn_reset;

    public Ricerca_CentroVaccinale_View(){

        frame = new JFrame("Consulta Informazioni Centri Vaccinali");
        controller = new Ricerca_CentroVaccinale_Controller(this);
        
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.setBackground(Color.WHITE);

        panel_labels = new JPanel();
        
        JPanel panel_buttons = new JPanel();
        panel_navigation = new JPanel();
        panel_welcome = new JPanel();


        /*
        Inizializzo coi vari parametri i pannelli che ho creato sopra
        */
        panel_welcome.setLayout(null);
        panel_welcome.setPreferredSize(new Dimension(WIDTH, 70));
        panel_welcome.setBackground(Color.WHITE);
        panel_welcome.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 20));
        
        panel_labels.setLayout(new GridLayout(4, 1, 30, 30));
        panel_labels.setPreferredSize(new Dimension(300, (HEIGHT/6)*5));
        panel_labels.setBackground(Color.WHITE);
        panel_labels.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 20));

        panel_buttons.setLayout(new GridLayout(4, 1, 30, 30));
        panel_buttons.setPreferredSize(new Dimension(WIDTH/4, (HEIGHT/6)*5));
        panel_buttons.setBackground(Color.WHITE);
        panel_buttons.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 20));

        panel_navigation.setLayout(new GridLayout(1, 3));
        panel_navigation.setPreferredSize(new Dimension(30, 50));
        panel_navigation.setBackground(Color.WHITE);

        welcome_label = new JLabel("Digita per Cercare il Centro Vaccinale di tuo interesse");
        welcome_label.setFont(mainFont);
        welcome_label.setHorizontalAlignment(JLabel.CENTER);
        welcome_label.setVerticalAlignment(JLabel.CENTER);
        panel_welcome.add(welcome_label);

        label_cercaPerNomeCentro = new JLabel("Cerca per Nome Centro Vaccinale");
        label_cercaPerNomeCentro.setFont(secondMainFont);
        label_cercaPerNomeCentro.setForeground(Color.BLACK);
        label_cercaPerNomeCentro.setSize(new Dimension(20, 30));
        label_cercaPerNomeCentro.setHorizontalAlignment(JLabel.CENTER);
        label_cercaPerNomeCentro.setVerticalAlignment(JLabel.CENTER);


        label_cercaPerComune = new JLabel("Cerca per Comune");
        label_cercaPerComune.setFont(secondMainFont);
        label_cercaPerComune.setForeground(Color.BLACK);
        label_cercaPerComune.setSize(new Dimension(20, 30));
        label_cercaPerComune.setHorizontalAlignment(JLabel.CENTER);
        label_cercaPerComune.setVerticalAlignment(JLabel.CENTER);


        label_cercaPerTipologia = new JLabel("Cerca per Tipologia");
        label_cercaPerTipologia.setFont(secondMainFont);
        label_cercaPerTipologia.setForeground(Color.BLACK);
        label_cercaPerTipologia.setSize(new Dimension(20, 30));
        label_cercaPerTipologia.setHorizontalAlignment(JLabel.CENTER);
        label_cercaPerTipologia.setVerticalAlignment(JLabel.CENTER);

        panel_labels.add(label_cercaPerNomeCentro);
        panel_labels.add(label_cercaPerComune);
        panel_labels.add(label_cercaPerTipologia);        


        tf_cercaPerNomeCentro = new JTextField("Nome: ");
        tf_cercaPerNomeCentro.setBounds(20, 20, 30, 15);

        tf_cercaPerComune = new JTextField("Comune: ");
        tf_cercaPerComune.setBounds(20, 20, 30, 15);

        tf_cercaPerTipologia = new JTextField("Tipologia: ");
        tf_cercaPerTipologia.setBounds(20, 20, 30, 15);

        panel_buttons.add(tf_cercaPerNomeCentro);
        panel_buttons.add(tf_cercaPerComune);
        panel_buttons.add(tf_cercaPerTipologia);

        btn_back = new JButton("Back");
        btn_cerca = new JButton("Cerca");
        btn_reset = new JButton("Reset");
        
        panel_navigation.add(btn_back);
        panel_navigation.add(btn_cerca);
        panel_navigation.add(btn_reset);

        container.add(welcome_label, BorderLayout.PAGE_START);
        container.add(panel_labels, BorderLayout.LINE_START);
        container.add(panel_buttons, BorderLayout.CENTER);
        container.add(panel_navigation, BorderLayout.PAGE_END);

        frame.add(container);

        
        frame.setSize(WIDTH, HIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btn_back.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.back();                
            }

        });

        btn_cerca.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(!(tf_cercaPerComune.getText().isEmpty() || tf_cercaPerNomeCentro.getText().isEmpty() || tf_cercaPerTipologia.getText().isEmpty())){
                    
                    if(!(tf_cercaPerComune.getText().equals("Comune") && tf_cercaPerNomeCentro.getText().equals("Nome") && tf_cercaPerTipologia.getText().equals("Tipologia"))){
                        frame.dispose();
                        controller.cercaCentro(getTextFieldText());
                        
                    }else {Utility.showInformationPopUp("Attenzione!", "Riempire almeno un campo.");}
                   
                }else {Utility.showInformationPopUp("Attenzione!", "Riempire almeno un campo.");}
            
            }

        });

        btn_reset.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                tf_cercaPerNomeCentro.setText("Nome");
                tf_cercaPerComune.setText("Comune");
                tf_cercaPerTipologia.setText("Tipologia");

                tf_cercaPerComune.setEnabled(true);
                tf_cercaPerTipologia.setEnabled(true);
                tf_cercaPerNomeCentro.setEnabled(true);
            }

        });

        
        tf_cercaPerNomeCentro.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent arg0) {
                tf_cercaPerComune.setEnabled(false);
                tf_cercaPerTipologia.setEnabled(false);
            }
            
            @Override
            public void keyPressed(KeyEvent arg0) {}

            @Override
            public void keyReleased(KeyEvent arg0) {     }

        });
        tf_cercaPerComune.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent arg0) {
                tf_cercaPerNomeCentro.setEnabled(false);
                tf_cercaPerTipologia.setEnabled(false);
            }
            
            @Override
            public void keyPressed(KeyEvent arg0) {}

            @Override
            public void keyReleased(KeyEvent arg0) {     }

        });
        tf_cercaPerTipologia.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent arg0) {
                tf_cercaPerNomeCentro.setEnabled(false);
                tf_cercaPerComune.setEnabled(false);
            }
            
            @Override
            public void keyPressed(KeyEvent arg0) {}

            @Override
            public void keyReleased(KeyEvent arg0) {     }

        });

    }

    public String getTextFieldText(){
        String s = "";

        if (!tf_cercaPerNomeCentro.getText().equals("Nome")){
            s = tf_cercaPerNomeCentro.getText();
        }
        if (!tf_cercaPerComune.getText().equals("Comune")){
            s = tf_cercaPerComune.getText();
        }
        if (!tf_cercaPerTipologia.getText().equals("Tipologia")){
            s = tf_cercaPerTipologia.getText();
        }

        return s;
    }



    public void deleteView(){
        frame.setVisible(false);
        frame.dispose();
    }

}
