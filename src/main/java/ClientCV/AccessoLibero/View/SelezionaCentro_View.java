package ClientCV.AccessoLibero.View;

import ClientCV.AccessoLibero.Controller.Ricerca_CentroVaccinale_Controller;
import ClientCV.AccessoLibero.Controller.SelezionaCentro_Controller;
import Common.InfoCentriVaccinali;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class SelezionaCentro_View extends JFrame{


                                                                      /** RIGUARDO CONTROLLER **/
    SelezionaCentro_Controller controller;


    private static final int WIDTH = 450;
    private static final int HIGHT = 550;

    public JFrame frame;

    public JFrame frame_showInfoCvCittadino;
    public JPanel panel_showInfoCvCittadino;
    public JLabel label_infoNomeCentro;
    public JLabel label_infoIndirizzo;
    public JLabel label_infoTipoCentro;

    public JLabel label_Comune;

    public JLabel label_siglaProvincia;

    public JLabel label_cap;
    public JLabel label_numeroSegnalazioni;

    public JLabel label_severitàMedia;
    private JTable table;
    public DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    
    public SelezionaCentro_View(List <InfoCentriVaccinali> listaCentri) {

        controller = new SelezionaCentro_Controller(this);

        frame_showInfoCvCittadino = new JFrame();
        panel_showInfoCvCittadino = new JPanel();

        panel_showInfoCvCittadino.setLayout(null);
        panel_showInfoCvCittadino.setPreferredSize(new Dimension(WIDTH, 70));
        panel_showInfoCvCittadino.setBackground(Color.WHITE);
        panel_showInfoCvCittadino.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 20));

        JLabel titolo = new JLabel("Informazioni Centro Vaccinale");
        titolo.setForeground(Color.BLACK);
        titolo.setBounds(0, 15, 400, 25);
        titolo.setHorizontalAlignment(JLabel.CENTER);
        titolo.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(titolo);

        JLabel nomeCentro = new JLabel("Nome Centro");
        nomeCentro.setForeground(Color.BLACK);
        nomeCentro.setBounds(0, 50, 400, 25);
        nomeCentro.setHorizontalAlignment(JLabel.CENTER);
        nomeCentro.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(nomeCentro);

        label_infoNomeCentro = new JLabel("");
        label_infoNomeCentro.setBounds(0, 80, 400, 25);
        label_infoNomeCentro.setHorizontalAlignment(JLabel.CENTER);
        label_infoNomeCentro.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(label_infoNomeCentro);

        JLabel indirizzo = new JLabel("Indirizzo: ");
        indirizzo.setForeground(Color.RED);
        indirizzo.setBounds(0, 110, 400, 25);
        indirizzo.setHorizontalAlignment(JLabel.CENTER);
        indirizzo.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(indirizzo);

        label_infoIndirizzo = new JLabel("");
        label_infoIndirizzo.setBounds(0, 140, 400, 25);
        label_infoIndirizzo.setHorizontalAlignment(JLabel.CENTER);
        label_infoIndirizzo.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(label_infoIndirizzo);

        JLabel tipoCentro = new JLabel("Tipologia centro:");
        tipoCentro.setForeground(Color.RED);
        tipoCentro.setBounds(0, 170, 400, 25);
        tipoCentro.setHorizontalAlignment(JLabel.CENTER);
        tipoCentro.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(tipoCentro);

        label_infoTipoCentro = new JLabel("");
        label_infoTipoCentro.setBounds(0, 200, 400, 25);
        label_infoTipoCentro.setHorizontalAlignment(JLabel.CENTER);
        label_infoTipoCentro.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(label_infoTipoCentro);

        JLabel Comune = new JLabel("Comune:");
        Comune.setForeground(Color.RED);
        Comune.setBounds(0, 170, 400, 25);
        Comune.setHorizontalAlignment(JLabel.CENTER);
        Comune.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(Comune);

        label_Comune = new JLabel("");
        label_Comune.setBounds(0, 200, 400, 25);
        label_Comune.setHorizontalAlignment(JLabel.CENTER);
        label_Comune.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(label_Comune);

        JLabel siglaProvincia = new JLabel("Provincia:");
        siglaProvincia.setForeground(Color.RED);
        siglaProvincia.setBounds(0, 170, 400, 25);
        siglaProvincia.setHorizontalAlignment(JLabel.CENTER);
        siglaProvincia.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(siglaProvincia);

        label_siglaProvincia = new JLabel("");
        label_siglaProvincia.setBounds(0, 200, 400, 25);
        label_siglaProvincia.setHorizontalAlignment(JLabel.CENTER);
        label_siglaProvincia.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(label_siglaProvincia);

        JLabel cap = new JLabel("Cap:");
        cap.setForeground(Color.RED);
        cap.setBounds(0, 170, 400, 25);
        cap.setHorizontalAlignment(JLabel.CENTER);
        cap.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(cap);

        label_cap = new JLabel("");
        label_cap.setBounds(0, 200, 400, 25);
        label_cap.setHorizontalAlignment(JLabel.CENTER);
        label_cap.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(label_cap);

        JLabel numeroSegnalazioni = new JLabel("Numero segnalazioni:");
        numeroSegnalazioni.setForeground(Color.RED);
        numeroSegnalazioni.setBounds(0, 230, 400, 25);
        numeroSegnalazioni.setHorizontalAlignment(JLabel.CENTER);
        numeroSegnalazioni.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(numeroSegnalazioni);

        label_numeroSegnalazioni = new JLabel("");
        label_numeroSegnalazioni.setBounds(0, 260, 400, 25);
        label_numeroSegnalazioni.setHorizontalAlignment(JLabel.CENTER);
        label_numeroSegnalazioni.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(label_numeroSegnalazioni);

        JLabel severitàMedia = new JLabel("Severità media:");
        severitàMedia.setForeground(Color.RED);
        severitàMedia.setBounds(0, 230, 400, 25);
        severitàMedia.setHorizontalAlignment(JLabel.CENTER);
        severitàMedia.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(severitàMedia);

        label_severitàMedia = new JLabel("");
        label_severitàMedia.setBounds(0, 260, 400, 25);
        label_severitàMedia.setHorizontalAlignment(JLabel.CENTER);
        label_severitàMedia.setVerticalAlignment(JLabel.CENTER);
        panel_showInfoCvCittadino.add(label_severitàMedia);

        setSize(WIDTH, HIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        tableModel = new DefaultTableModel(new String[] {"Evento", "Intensità"}, 0);

        table = new JTable(tableModel) {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        table.getTableHeader().setReorderingAllowed(false);


        table.setRowSelectionAllowed(false);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(1, 290, 400, 120);
        panel_showInfoCvCittadino.add(scrollPane);
    }


}
