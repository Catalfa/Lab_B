package ClientCV.AccessoLibero.View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class TableExample {
  public TableExample() {
    String[] columnNames = { "Colonna 1", "Colonna 2", "Colonna 3", "Colonna 4", "Colonna 5",
        "Colonna 6", "Colonna 7", "Colonna 8", "Colonna 9", "Colonna 10",
        "Colonna 11", "Colonna 12", "Colonna 13", "Colonna 14", "Colonna 15" };
    Object[][] data = {
        { "ID Centro", "Nome", "Tipologia",
            "Provincia", "Comune", "Indirizzo", "Civico", "Mal di testa", "Mal di pancia",
            "Febbre", "Dolori articolari - muscolari", "Linfoadenopatia", "Tachicardia ",
            "Crisi ipertensiva", "segnalazioni" },
        { "riga 2, colonna 1", "riga 2, colonna 2", "riga 2, colonna 3", "riga 2, colonna 4", "riga 2, colonna 5",
            "riga 2, colonna 6", "riga 2, colonna 7", "riga 2, colonna 8", "riga 2, colonna 9", "riga 2, colonna 10",
            "riga 2, colonna 11", "riga 2, colonna 12", "riga 2, colonna 13", "riga 2, colonna 14",
            "riga 2, colonna 15" },
        { "riga 2, colonna 1", "riga 2, colonna 2", "riga 2, colonna 3", "riga 2, colonna 4", "riga 2, colonna 5",
            "riga 2, colonna 6", "riga 2, colonna 7", "riga 2, colonna 8", "riga 2, colonna 9", "riga 2, colonna 10",
            "riga 2, colonna 11", "riga 2, colonna 12", "riga 2, colonna 13", "riga 2, colonna 14",
            "riga 2, colonna 15" },

        // ... altre righe
    };

    JTable table = new JTable(data, columnNames);
    table.setPreferredScrollableViewportSize(new Dimension(1000, 600));

    JButton button = new JButton("Indietro");

    JPanel panel = new JPanel();
    panel.add(table);
    panel.add(button);
    table.setPreferredSize(new Dimension(1200, 100));

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
// ...
