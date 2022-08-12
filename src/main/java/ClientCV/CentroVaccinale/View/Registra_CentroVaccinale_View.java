package ClientCV.CentroVaccinale.View;

import ClientCV.CentroVaccinale.Controller.Registra_CentroVaccinale_Controller;
import Common.CentroVaccinale;
import Common.InfoCentriVaccinali;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;


//TODO @Andre bisogna aggiungere i campi username e password


public class Registra_CentroVaccinale_View extends JFrame {

    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 15);
    private final int WIDTH = 520;
    private final int HIGHT = 600;

    private String[] labelNames = {"ID Centro", "Nome Centro Vaccinale","Tipologia Centro", "Qualificatore (via/viale/piazza)", "Indirizzo", "Numero Civico", "Comune", "Provincia (sigla)", "CAP"};
    //private String hint = "via/viale/piazza";
    private String[] buttonNames = {"BACK", "SIGN-IN", "RESET"};
    private JButton[] buttons = new JButton[3];
    public JTextField[] textFields = new JTextField[9];
    private JLabel[] labels = new JLabel[9];
    public JPasswordField passwordField;

    public Registra_CentroVaccinale_View() {

        Registra_CentroVaccinale_Controller controller = new Registra_CentroVaccinale_Controller(this);

        JPanel mainPanel = new JPanel();

        mainPanel.setBackground(Color.WHITE);

        mainPanel.setLayout(null);

        JLabel signinCentroVaccinale = new JLabel("REGISTRA NUOVO Centro Vaccinale", SwingConstants.CENTER);
        signinCentroVaccinale.setFont(mainFont);
        signinCentroVaccinale.setBounds((WIDTH/2)-150, 2, 300, 25);

        mainPanel.add(signinCentroVaccinale);
        
        int y = 50;
        for(int i=0; i<9; i++) {
            labels[i] = new JLabel(labelNames[i], SwingConstants.LEFT);
            //primo valore della pos rispetto x, secondo valore della pos rispetto y, terzo ?, quarto sipra ?
            labels[i].setBounds(30, y, 200, 25);
            mainPanel.add(labels[i]);
            y += 50;
        }

        y = 50;
        for(int i=0; i<9; i++) {
            textFields[i] = new JTextField(20);
            textFields[i].setBounds(220, y, 250, 25);
            //textFields[i] = new JTextField(labelNames[i]);
            mainPanel.add(textFields[i]);
            y += 50;
        }

        int x = 0;
        for(int i=0; i<3; i++){
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
                try {
                    controller.signIn(new InfoCentriVaccinali( textFields[0].getText(), textFields[1].getText(),
                        textFields[2].getText(), textFields[3].getText(), textFields[4].getText(), s,
                        textFields[6].getText(), textFields[7].getText(), Integer.parseInt(textFields[8].getText())));
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }

        });

        buttons[2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.reset();
            }

        });
    }
    
}
