package ClientCV.CentroVaccinale.View;

import ClientCV.AccessoLibero.Controller.InfCvController;
import ClientCV.AccessoLibero.View.InfCvView;
import ClientCV.CentriVaccinali.View.MainAccLibFrameView;
import ClientCV.CentroVaccinale.Controller.RegistraVaccinatoController;
import ClientCV.Utility;
import ClientCV.client.ServerSingleton;
import ServerCV.interfaccia.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraVaccinatoView extends JFrame{

    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 15);
    private final int WIDTH = 520;
    private final int HIGHT = 600;

    private String[] labelNames = {"Nome", "Cognome","Data vaccino", "Vaccino somministrato", "Id vaccinazione", "Id centro"};

    private String[] buttonNames = {"BACK", "INVIO"};
    private JButton[] buttons = new JButton[2];
    public JTextField[] textFields = new JTextField[3];
    private JLabel[] labels = new JLabel[3];
    //public JPasswordField passwordField;

    public RegistraVaccinatoView() {

        RegistraVaccinatoController controller = new RegistraVaccinatoController(this);

        JPanel mainPanel = new JPanel();

        mainPanel.setBackground(Color.WHITE);

        mainPanel.setLayout(null);

        JLabel registraVaccinato = new JLabel("Registra Vaccinato", SwingConstants.CENTER);
        registraVaccinato.setFont(mainFont);
        registraVaccinato.setBounds((WIDTH/2)-150, 2, 300, 25);

        mainPanel.add(registraVaccinato);

        int y = 50;
        for(int i=0; i<3; i++) {
            labels[i] = new JLabel(labelNames[i], SwingConstants.LEFT);
            //primo valore della pos rispetto x, secondo valore della pos rispetto y, terzo ?, quarto sipra ?
            labels[i].setBounds(30, y, 200, 25);
            mainPanel.add(labels[i]);
            y += 50;
        }

        y = 50;
        for(int i=0; i<3; i++) {
            textFields[i] = new JTextField(20);
            textFields[i].setBounds(220, y, 250, 25);
            //textFields[i] = new JTextField(labelNames[i]);
            mainPanel.add(textFields[i]);
            y += 50;
        }

        int x = 0;
        for(int i=0; i<2; i++){
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setBounds((WIDTH/2)-150+x, 505, 90, 25);
            mainPanel.add(buttons[i], JButton.BOTTOM);
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

                /*
                metodo per fare il controllo di un int
                */
                int s;
                String k = textFields[3].getText();
                if (k.isEmpty()){
                    s=0;
                }else{
                    try {
                        s = Integer.parseInt(k);
                    } catch (Exception ex) {
                        s = -1;
                    }
                }
                //se il seguente metodo restituisce 1 la reggistrazione è avvenuta con successo, altrimenti se restituisce 2 esiste già un Centro con quel nome

            }

        });

        buttons[2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.goBack();
            }

        });
    }
}
