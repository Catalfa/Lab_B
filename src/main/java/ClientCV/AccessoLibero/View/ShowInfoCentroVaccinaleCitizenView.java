package ClientCV.AccessoLibero.View;

import ClientCV.AccessoLibero.Controller.ShowInfoCentroVaccinaleCitizenController;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Nicolo' Ferrari, Mat. 732707, Varese
 * Alessandro Formenti, Mat. 734465, Varese
 * Luigi Mucciarone, Mat. 732714, Varese
 * Luca Alberti, Mat. 733096, Varese
 */

/**
 * Classe che mostra le informazioni del centro vaccinale selezionato per gli utenti non registrati.
 */
public class ShowInfoCentroVaccinaleCitizenView extends JDialog {
	
	private static final int WIDTH 	= 400;
	private static final int HEIGHT	= 450;
	
	public JDialog				dialog_ShowInfoCentroVaccinaleCitizen;
	public JFrame 			frame_ShowInfoCentroVaccinaleCitizen;
	public JPanel 				panel_ShowInfoCentroVaccinaleCitizen;
	public JLabel 				infoNomeCentro;
	public JLabel 				infoIndirizzo;
	public JLabel 				infoTipoCentro;
	public JLabel 				numSegnalazioni;
	private JTable				table;
	public DefaultTableModel 	tableModel;
	private JScrollPane			scrollPane;
	private ShowInfoCentroVaccinaleCitizenController controller;
	
	public ShowInfoCentroVaccinaleCitizenView() {
		this.controller = new ShowInfoCentroVaccinaleCitizenController(this);
	
		frame_ShowInfoCentroVaccinaleCitizen = new JFrame();
		panel_ShowInfoCentroVaccinaleCitizen = new JPanel();
		
		panel_ShowInfoCentroVaccinaleCitizen.setLayout(null);
		panel_ShowInfoCentroVaccinaleCitizen.setBackground(Color.WHITE);
		
		JLabel titolo = new JLabel("INFORMAZIONI CENTRO VACCINALE");
		titolo.setForeground(Color.RED);
		titolo.setBounds(0, 15, 400, 25);
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setVerticalAlignment(JLabel.CENTER);
		panel_ShowInfoCentroVaccinaleCitizen.add(titolo);
		
		JLabel nomeCentro = new JLabel("Nome centro: ");
		nomeCentro.setForeground(Color.RED);
		nomeCentro.setBounds(0, 50, 400, 25);
		nomeCentro.setHorizontalAlignment(JLabel.CENTER);
		nomeCentro.setVerticalAlignment(JLabel.CENTER);
		panel_ShowInfoCentroVaccinaleCitizen.add(nomeCentro);
		
		infoNomeCentro = new JLabel("");
		infoNomeCentro.setBounds(0, 80, 400, 25);
		infoNomeCentro.setHorizontalAlignment(JLabel.CENTER);
		infoNomeCentro.setVerticalAlignment(JLabel.CENTER);
		panel_ShowInfoCentroVaccinaleCitizen.add(infoNomeCentro);
		
		JLabel indirizzo = new JLabel("Indirizzo: ");
		indirizzo.setForeground(Color.RED);
		indirizzo.setBounds(0, 110, 400, 25);
		indirizzo.setHorizontalAlignment(JLabel.CENTER);
		indirizzo.setVerticalAlignment(JLabel.CENTER);
		panel_ShowInfoCentroVaccinaleCitizen.add(indirizzo);
		
		infoIndirizzo = new JLabel("");
		infoIndirizzo.setBounds(0, 140, 400, 25);
		infoIndirizzo.setHorizontalAlignment(JLabel.CENTER);
		infoIndirizzo.setVerticalAlignment(JLabel.CENTER);
		panel_ShowInfoCentroVaccinaleCitizen.add(infoIndirizzo);
		
		JLabel tipoCentro = new JLabel("Tipo centro:");
		tipoCentro.setForeground(Color.RED);
		tipoCentro.setBounds(0, 170, 400, 25);
		tipoCentro.setHorizontalAlignment(JLabel.CENTER);
		tipoCentro.setVerticalAlignment(JLabel.CENTER);
		panel_ShowInfoCentroVaccinaleCitizen.add(tipoCentro);
		
		infoTipoCentro = new JLabel("");
		infoTipoCentro.setBounds(0, 200, 400, 25);
		infoTipoCentro.setHorizontalAlignment(JLabel.CENTER);
		infoTipoCentro.setVerticalAlignment(JLabel.CENTER);
		panel_ShowInfoCentroVaccinaleCitizen.add(infoTipoCentro);
		
		JLabel numeroSegnalazioni = new JLabel("Numero segnalazioni:");
		numeroSegnalazioni.setForeground(Color.RED);
		numeroSegnalazioni.setBounds(0, 230, 400, 25);
		numeroSegnalazioni.setHorizontalAlignment(JLabel.CENTER);
		numeroSegnalazioni.setVerticalAlignment(JLabel.CENTER);
		panel_ShowInfoCentroVaccinaleCitizen.add(numeroSegnalazioni);
		
		numSegnalazioni = new JLabel("");
		numSegnalazioni.setBounds(0, 260, 400, 25);
		numSegnalazioni.setHorizontalAlignment(JLabel.CENTER);
		numSegnalazioni.setVerticalAlignment(JLabel.CENTER);
		panel_ShowInfoCentroVaccinaleCitizen.add(numSegnalazioni);
		
		tableModel = new DefaultTableModel(new String[] {"Evento", "Intensita'"}, 0);
		
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
        panel_ShowInfoCentroVaccinaleCitizen.add(scrollPane);
	}
}
