package ClientCV.AccessoLibero.View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ClientCV.client.ServerSingleton;
import Common.*;
import ServerCV.interfaccia.Server;

public class Tabella_centri extends JFrame {
    private JTable table = null;
    private DefaultTableModel model;
    private Server server;
    private String[] aux;
    private int i = 1;

    public Tabella_centri(List<InfoCentriVaccinali> listaCentri) throws RemoteException {
        server = ServerSingleton.getInstance();
        String[] columnNames = { "Colonna 1", "Colonna 2", "Colonna 3", "Colonna 4", "Colonna 5",
                "Colonna 6", "Colonna 7", "Colonna 8", "Colonna 9", "Colonna 10",
                "Colonna 11", "Colonna 12", "Colonna 13", "Colonna 14", "colonna 15" };

        aux = new String[listaCentri.size() + 1];
        aux[0] = "ID Centro" + "," + "Nome" + "," + "Tipologia" + "," +
                "Provincia" + "," + "Comune" + "," + "Indirizzo" + "," + "Civico" + "," + "Mal di testa" + ","
                + "Mal di pancia" + "," + "Febbre" + "," + "Dolori articolari" + "," + "Linfoadenopatia"
                + "," + "Tachicardia " + "," + "Crisi ipertensiva" + "," + "segnalazioni";

        for (InfoCentriVaccinali centro : listaCentri) {
            aux[i] = centro.toArray(centro);
            i++;
        }

        String[][] matrix = new String[aux.length][];
        for (int j = 0; j < aux.length; j++) {
            matrix[j] = aux[j].split(",");
        }

        JTable table = new JTable(matrix, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 600));

        JButton button = new JButton("Indietro");

        JPanel panel = new JPanel();
        panel.add(table);
        panel.add(button);
        table.setPreferredSize(new Dimension(1440, 100));

        JFrame frame = new JFrame("Risultati ricerca");
        frame.add(panel);
        frame.setSize(new Dimension(1500, 400));
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Ricerca_CentroVaccinale_View().setVisible(true);
            }
        });
    }

}
