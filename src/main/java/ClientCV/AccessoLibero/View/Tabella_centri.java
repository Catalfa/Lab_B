package ClientCV.AccessoLibero.View;

import java.awt.Window;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ClientCV.client.ServerSingleton;
import Common.*;
import ServerCV.interfaccia.Server;

public class Tabella_centri extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private Server server;

    public Tabella_centri(List<InfoCentriVaccinali> listaCentri) throws RemoteException {
        server = ServerSingleton.getInstance();
        // Crea il modello della tabella
        model = new DefaultTableModel();

        // Crea la tabella con il modello
        table = new JTable(model);

        // Aggiungi la tabella a uno scroll pane e aggiungi lo scroll pane al frame
        add(new JScrollPane(table));

        // Imposta le dimensioni del frame
        setSize(1500, 400);
        model.addColumn("ID Centro");
        model.addColumn("Nome");
        model.addColumn("Tipologia");
        model.addColumn("Provincia");
        model.addColumn("Comune");
        model.addColumn("Indirizzo");
        model.addColumn("Civico");
        model.addColumn("Mal di testa");
        model.addColumn("Mal di pancia");
        model.addColumn("Febbre");
        model.addColumn("Dolori articolari - muscolari");
        model.addColumn("Linfoadenopatia");
        model.addColumn("Tachicardia ");
        model.addColumn("Crisi ipertensiva");

        for (InfoCentriVaccinali lista : listaCentri) {
            model.addRow(new Object[] { lista.getIdCentro(), lista.getNomeCentro(), lista.getTipologia(),
                    lista.getProvincia(), lista.getComune(), lista.getNomeVia(), lista.getNumCiv(),
                    (server.getImportanzaEvento(lista.getNomeCentro(), "Mal di testa")),
                    (server.getImportanzaEvento(lista.getNomeCentro(), "Mal di pancia")),
                    (server.getImportanzaEvento(lista.getNomeCentro(), "Febbre")),
                    (server.getImportanzaEvento(lista.getNomeCentro(), "Dolori articolari - muscolari")),
                    (server.getImportanzaEvento(lista.getNomeCentro(), "Linfoadenopatia")),
                    (server.getImportanzaEvento(lista.getNomeCentro(), "Tachicardia")),
                    (server.getImportanzaEvento(lista.getNomeCentro(), "Crisi ipertensiva")) });
        }
    }
}
