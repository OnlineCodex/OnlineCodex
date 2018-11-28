package oc;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

import static oc.RefreshListener.Priority.ONLINE_CODEX;
import static oc.RefreshListener.addRefreshListener;


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
