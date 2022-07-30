package ClientCV.Cittadino.View;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowInfo_CV_CittadinoView {

    private static final int WHIDTH = 450;
    private static final int HIGHT = 550;

    public JDialog dialog_mostraInfoCvCittadinoView;
    public JFrame frame_showInfoCvCittadino;
    public JPanel panel_showInfoCvCittadino;
    public JLabel label_infoNomeCentro;
	public JLabel label_infoIndirizzo;
	public JLabel label_infoTipoCentro;
	public JLabel label_numeroSegnalazioni;
    private JTable table;
    public DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    //private ShowInfo_CV_CittadinoController contorller;

    public ShowInfo_CV_CittadinoView(){
        //this.controller = new ShowInfo_CV_CittadinoController(this);

        frame_showInfoCvCittadino = new JFrame();
        panel_showInfoCvCittadino = new JPanel();

        panel_showInfoCvCittadino.setLayout(null);
        panel_showInfoCvCittadino.setBackground(Color.WHITE);

        JLabel titolo = new JLabel("Info Centro Vaccinale");
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

        JLabel tipoCentro = new JLabel("Tipo centro:");
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
