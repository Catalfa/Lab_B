package ClientCV.Cittadino.View;

import ClientCV.Cittadino.Controller.SelezionaCentro_Controller;
import Common.InfoCentriVaccinali;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelezionaCentro_View extends JFrame{

    InfoCentriVaccinali infoCentriVaccinali;
    SelezionaCentro_Controller controller;
    AggiungiEventoAvversoView aggiungiEventoAvversoView;

    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 18);
    private final Font secondMainFont = new Font("Segoeo print", Font.BOLD, 14);
    private static final int WIDTH = 600;
    private static final int HIGHT = 350;

    public JFrame frame;
    private JPanel panel_buttons;
    private JPanel panel_welcome;
    private JPanel panel_navigation;
    
    public JLabel welcome_label;

    private JButton btn_back;
    private JButton btn_InserisciEvento;
    private JButton buttons_1;
    private JButton buttons_2;
    private JButton buttons_3;
    private JButton buttons_4;
    private JButton[] buttons;
    private JScrollPane jScrollPane;
    //TODO da passare come stringa il nome del cv (scelto dal cittadino) al bottone, se ce ne sono di uguali
    //allora il bottone conterrà anche il comune in cui sta
    //se non ci sono almeno 4 bottoni allora dev'essere settato a null o stringa vuota
    
    public SelezionaCentro_View(List <InfoCentriVaccinali> listaCentri){

        frame = new JFrame("CentriVaccinali");
        controller = new SelezionaCentro_Controller(this);

        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.setBackground(Color.ORANGE);

        jScrollPane = new JScrollPane();
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setViewportBorder(new LineBorder(Color.RED));
        
        
        panel_navigation = new JPanel();
        panel_buttons = new JPanel();
        panel_welcome = new JPanel();

        welcome_label = new JLabel("Seleziona il Centro Vaccinale Per Cui Inserire l'Evento Avverso");
        welcome_label.setFont(mainFont);
        welcome_label.setSize(WIDTH-10, 40);
        welcome_label.setHorizontalAlignment(JLabel.CENTER);
        welcome_label.setVerticalAlignment(JLabel.CENTER);

        panel_welcome.setLayout(null);
        panel_welcome.setPreferredSize(new Dimension(WIDTH, 60));
        panel_welcome.setBackground(Color.WHITE);
        panel_welcome.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel_welcome.add(welcome_label);

        container.add(panel_welcome, BorderLayout.PAGE_START);


        panel_buttons.setLayout(new GridLayout(0, 2, 20, 20));
        //panel_buttons.setPreferredSize(new Dimension(200, 200));
        panel_buttons.setBackground(Color.CYAN);
        panel_buttons.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); 

        inserisciBottoni(listaCentri);
        jScrollPane.setViewportView(panel_buttons);
        container.add(jScrollPane, BorderLayout.CENTER);
        //container.add(panel_buttons, BorderLayout.CENTER);


        btn_back = new JButton("Back");
        btn_back.setFont(mainFont);
        btn_InserisciEvento = new JButton("Inserisci Evento");
        btn_InserisciEvento.setFont(mainFont);

        panel_navigation.setLayout(new GridLayout(1, 2));
        panel_navigation.setPreferredSize(new Dimension(40, 60));
        panel_navigation.setBackground(Color.RED);

        panel_navigation.add(btn_back);
        panel_navigation.add(btn_InserisciEvento);

        container.add(panel_navigation, BorderLayout.PAGE_END);


        setSize(WIDTH, HIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        add(container);

        btn_back.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.back();                 
            }
    
        });
        
    }

    private void inserisciBottoni(List <InfoCentriVaccinali> listaCentriVaccinali){
        for(int i=0; i<listaCentriVaccinali.size(); i++){
            String nomeCentro = listaCentriVaccinali.get(i).getNomeCentro();
            this.buttons = new JButton[listaCentriVaccinali.size()];
            this.buttons[i] = new JButton(nomeCentro);
            //buttons[i].setSize(30, 45);
            //buttons[i].setText(listaCentriVaccinali.get(i).getNomeCentro());
            this.buttons[i].setHorizontalAlignment(JLabel.CENTER);
            this.buttons[i].setFont(mainFont);
            panel_buttons.add(this.buttons[i]);
            //jScrollPane.add(buttons[i]);
            this.buttons[i].addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    controller.closeWindow();
                    AggiungiEventoAvversoView aggiungiEventoAvversoView = new AggiungiEventoAvversoView(nomeCentro);
                }
        
            });
            
        }
        
    }

    
}
