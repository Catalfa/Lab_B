package ClientCV.Cittadino.View;

import ClientCV.Cittadino.Controller.AggiungiEventoAvversoController;
import ServerCV.database.gestioneDB.CittadiniRegistratiDaoImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AggiungiEventoAvversoView extends JFrame{

    AggiungiEventoAvversoController controller;

    private final Font mainFont = new Font("Segoeo print", Font.BOLD, 18);
    private final Font secondMainFont = new Font("Segoeo print", Font.BOLD, 14);
    private static final int WIDTH = 930;
    private static final int HIGHT = 800;

    /*
    Creo questi panels in questa posizione perchè mi serviranno
    anche in altre parti di codice e altre classi
    */
    private JFrame frame_aggiungiEventoAvverso;
    private JPanel panel_tipoEvento;
    private JPanel panel_intensitaEvento;
    private JPanel panel_noteEvento;

    private String[] labelNames = {"ID Centro: ", "ID Vaccinazione: ", "Eventi Avversi: ", "Tipo Evento: ", "Intensità: ", "Note: "};
    private String[] buttonNames = {"Salva evento", "Indietro"};
    private ButtonGroup[] buttonGroup = new ButtonGroup[7];
    private JTextField[] noteFields = new JTextField[7];
    private JScrollPane[] scrollPanes = new JScrollPane[7];
    
    private JLabel label_InfoNomeCentro;
    private JLabel label_IdEvento;

    String[] eventiRegistrabili = {
        "Mal di testa",
        "Mal di pancia",
        "Febbre",
        "Dolori articolari - muscolari",
        "Linfoadenopatia",
        "Tachicardia",
        "Crisi ipertensiva",
    };

    public AggiungiEventoAvversoView(String[] id_cittadino){

        //Per poter creare un nuovo frame che ci permetta di inserire eventi avversi
        controller = new AggiungiEventoAvversoController(this);
        frame_aggiungiEventoAvverso = new JFrame();

        //Pannello contenitore
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        //Pannello secondario e altri utili
        JPanel panel_infoCentro = new JPanel();
        panel_tipoEvento = new JPanel();
        panel_intensitaEvento = new JPanel();
        panel_noteEvento = new JPanel();
        JPanel panelButton = new JPanel();

        //Setto le dimensioni del Frame 
        frame_aggiungiEventoAvverso.setSize(WIDTH, HIGHT);
        frame_aggiungiEventoAvverso.setResizable(false);
        frame_aggiungiEventoAvverso.setLocationRelativeTo(null);
        frame_aggiungiEventoAvverso.add(container);
        
        //Inizializzo coi vari parametri i pannelli che ho creato sopra
        panel_infoCentro.setLayout(null);
        panel_infoCentro.setPreferredSize(new Dimension(WIDTH, 200));
        panel_infoCentro.setBackground(Color.WHITE);

        panel_tipoEvento.setLayout(new GridLayout(7, 1, 0, 20));
        panel_tipoEvento.setPreferredSize(new Dimension(WIDTH/3, 400));
        panel_tipoEvento.setBackground(Color.WHITE);

        panel_intensitaEvento.setLayout(new GridLayout(7, 5, 0, 20));
        panel_intensitaEvento.setPreferredSize(new Dimension(WIDTH/3, 400));
        panel_intensitaEvento.setBackground(Color.WHITE);

        panel_noteEvento.setLayout(new GridLayout(7, 2, 0, 20));
        panel_noteEvento.setPreferredSize(new Dimension(WIDTH/3, 400));
        panel_noteEvento.setBackground(Color.WHITE);

        panelButton.setLayout(new GridLayout(1, 2, 10, 30));
        panelButton.setPreferredSize(new Dimension(WIDTH, 100));
        panelButton.setBackground(Color.WHITE);

        //Aggiungo i pannelli inizializzati al Pannello principale
        container.add(panel_infoCentro, BorderLayout.PAGE_START);
        container.add(panel_tipoEvento, BorderLayout.LINE_START);
        container.add(panel_intensitaEvento, BorderLayout.CENTER);
        container.add(panel_noteEvento, BorderLayout.LINE_END);

        //Creo i label che servono per la visione grafica per l'inserimento
        JLabel nomeCentro = new JLabel(labelNames[0]);
        nomeCentro.setFont(mainFont);
        nomeCentro.setForeground(Color.RED);
        nomeCentro.setBounds(0, 20, WIDTH, 25);
        nomeCentro.setHorizontalAlignment(JLabel.CENTER);
        nomeCentro.setVerticalAlignment(JLabel.CENTER);
        panel_infoCentro.add(nomeCentro);
        //frame_aggiungiEventoAvverso.setVisible(true);

        label_InfoNomeCentro = new JLabel(id_cittadino[1]);
        label_InfoNomeCentro.setFont(secondMainFont);
        label_InfoNomeCentro.setBounds(0, 50, WIDTH, 25);
        label_InfoNomeCentro.setHorizontalAlignment(JLabel.CENTER);
        label_InfoNomeCentro.setVerticalAlignment(JLabel.CENTER);
        panel_infoCentro.add(label_InfoNomeCentro);

        JLabel idVaccinazione = new JLabel(labelNames[1]);
        idVaccinazione.setFont(mainFont);
        idVaccinazione.setForeground(Color.RED);
        idVaccinazione.setBounds(0, 80, WIDTH, 25);
        idVaccinazione.setHorizontalAlignment(JLabel.CENTER);
        idVaccinazione.setVerticalAlignment(JLabel.CENTER);
        panel_infoCentro.add(idVaccinazione);

        label_IdEvento = new JLabel(id_cittadino[0]);
        label_IdEvento.setFont(secondMainFont);
        label_IdEvento.setBounds(0, 110, WIDTH, 25);
        label_IdEvento.setHorizontalAlignment(JLabel.CENTER);
		label_IdEvento.setVerticalAlignment(JLabel.CENTER);
        panel_infoCentro.add(label_IdEvento);

        JLabel eventiAvversi = new JLabel(labelNames[2]);
        eventiAvversi.setFont(mainFont);
        eventiAvversi.setForeground(Color.BLACK);
        eventiAvversi.setBounds(0, 140, WIDTH, 25);
        eventiAvversi.setHorizontalAlignment(JLabel.CENTER);
		eventiAvversi.setVerticalAlignment(JLabel.CENTER);
		panel_infoCentro.add(eventiAvversi);

        JLabel tipoEvento = new JLabel(labelNames[3]);
        tipoEvento.setFont(mainFont);
        tipoEvento.setForeground(Color.BLACK);
        tipoEvento.setBounds(0, 170, WIDTH/3, 25);
        tipoEvento.setHorizontalAlignment(JLabel.CENTER);
		tipoEvento.setVerticalAlignment(JLabel.CENTER);
		panel_infoCentro.add(tipoEvento);

        addEventi();

        JLabel intensita = new JLabel(labelNames[4]);
        intensita.setFont(mainFont);
        intensita.setForeground(Color.BLACK);
        intensita.setBounds(WIDTH/3, 170, WIDTH/3, 25);
        intensita.setHorizontalAlignment(JLabel.CENTER);
		intensita.setVerticalAlignment(JLabel.CENTER);
		panel_infoCentro.add(intensita);

        addIntensita();

        JLabel note = new JLabel(labelNames[5]);
        note.setFont(mainFont);
        note.setForeground(Color.BLACK);
        note.setBounds(WIDTH/3*2, 170, WIDTH/3, 25);
        note.setHorizontalAlignment(JLabel.CENTER);
        note.setVerticalAlignment(JLabel.CENTER);
        panel_infoCentro.add(note);

        addNote();

        //Inizializziamo anche i bottoni creati sopra
        JButton btn_backToSignIn = new JButton(buttonNames[1]);
        btn_backToSignIn.setBounds(WIDTH/5, 20, 50, 10);
        panelButton.add(btn_backToSignIn);

        JButton btn_inserisciEventiAvversi = new JButton(buttonNames[0]);
        btn_inserisciEventiAvversi.setBounds((WIDTH/5)*3, 20, 50, 10);
        panelButton.add(btn_inserisciEventiAvversi);

        container.add(panelButton, BorderLayout.PAGE_END);

        btn_inserisciEventiAvversi.addActionListener(new ActionListener(){
            //andre serve che venga passato anche il codice fiscale del cittadino che effettua la segnalazione
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String idEvento = label_IdEvento.getText();
                String nomeCentro = label_InfoNomeCentro.getText();
                Integer intensitaEventi[] = new Integer[7];
                String noteEventi[] = new String[7];

                for(int i=0; i<7; i++){
                    intensitaEventi[i] = Integer.parseInt(buttonGroup[i].getSelection().getActionCommand());
                    noteEventi[i] = noteFields[i].getText();

                }
                controller.inserisciEventiAvversiAction( idEvento, id_cittadino[2], nomeCentro, eventiRegistrabili, intensitaEventi, noteEventi);


            }
        });

        
        
        btn_backToSignIn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.goBack();                
            }

        });
        
    }

    public AggiungiEventoAvversoView() {

    }


    /**
	 * Metodo che crea, per ogni evento una nuova label e la inserisce nel panel.
	 */
    private void addEventi(){
        for(String evt : eventiRegistrabili){
            JLabel evento = new JLabel(evt);
            evento.setHorizontalAlignment(JLabel.CENTER);
            panel_tipoEvento.add(evento);
        }
    }
    
    /*
    *Metodo per inizializzare il ButtonGroup
    */
    private void inizializzaButtonGroup(){
        for(int i=0; i<7; i++){
            buttonGroup[i] = new ButtonGroup();
        }
    }

    /**
	 * Metodo che crea i gruppi di bottoni con determinati valori d'intensita' e li aggiunge nel panel. 
	 */
    private void addIntensita(){
        inizializzaButtonGroup();
        for(int j=0; j<7; j++){
            for(int i=0; i<6; i++){
                JRadioButton rb_intensita = new JRadioButton(""+i, (i==0 ? true : false));


                if(rb_intensita.isSelected()) {rb_intensita.setActionCommand(""+i);   }
                else{
                    //QUI
                    rb_intensita.setActionCommand(Integer.toString(i));
                }


                rb_intensita.setVerticalTextPosition(JRadioButton.BOTTOM);
                rb_intensita.setHorizontalTextPosition(JRadioButton.CENTER);
                buttonGroup[j].add(rb_intensita);
                panel_intensitaEvento.add(rb_intensita);
            }
        }
    }

    /**
	 * Metodo che crea un campo per l'inserimento delle note e una label per indicare il numero di caratteri rimanenti,
     * per poi aggiungerli al panel.
	 */
    private void addNote(){
        int max_numCharNote = 256;
        for(int i=0; i<7; i++){
            scrollPanes[i] = new JScrollPane();
            noteFields[i] = new JTextField();
            scrollPanes[i].add(noteFields[i]);
            scrollPanes[i].setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            panel_noteEvento.add(noteFields[i]);
            JLabel label = new JLabel("256 caratteri disponibili");
            panel_noteEvento.add(label);
            int index = i;
            noteFields[i].addKeyListener(new KeyListener(){

                @Override
                public void keyTyped(KeyEvent arg0) {
                    int count_numCharNote = max_numCharNote - noteFields[index].getText().length();
                    label.setText(count_numCharNote + " caratteri rimanenti.");
                    controller.checkNumCharAction(arg0, noteFields[index].getText().length());
                }
                
                @Override
                public void keyPressed(KeyEvent arg0) {}

                @Override
                public void keyReleased(KeyEvent arg0) {
                       
                }

            });

        }
        frame_aggiungiEventoAvverso.setVisible(true);
    }

    /* 
    *Metodo per chiudere frames di controller
    */
    public void deleteView(){
        frame_aggiungiEventoAvverso.setVisible(false);
        frame_aggiungiEventoAvverso.dispose();
    }

}
