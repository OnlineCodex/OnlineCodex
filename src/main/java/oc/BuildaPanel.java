package oc;

import static oc.RefreshListener.addRefreshListener;
import static oc.RefreshListener.Priority.ONLINE_CODEX;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public abstract class BuildaPanel implements BuildaSTK {

    public static JTextField budget = new JTextField();
    public final JLabel kostenLabel = new JLabel();
    public Vector<BuildaVater> myBuilderz = new Vector<BuildaVater>();

    protected JPanel panel = new JPanel(null, false); // kein LayoutManager für ALLE Panels, aber doubleBuffered

    public BuildaPanel() {
        addRefreshListener(ONLINE_CODEX, this::refreshAction);
        panel.setBackground(Color.WHITE);
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public int getHoehe() {
        return panel.getSize().height;
    }

    public String entferneNullNachkomma(double kosten) {
        return Integer.toString((int) kosten);
    }

    public double getKosten() {
        return myBuilderz.stream()
                .mapToDouble(BuildaVater::getKosten)
                .sum();
    }

    public void refreshAction() {}
}
