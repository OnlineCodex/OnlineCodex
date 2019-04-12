package oc;

import static oc.RefreshListener.addRefreshListener;
import static oc.RefreshListener.Priority.ONLINE_CODEX;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public abstract class BuildaPanel implements BuildaSTK {

    static JTextField budget = new JTextField();
    final JLabel kostenLabel = new JLabel();
    protected JPanel panel = new JPanel(null, false);

    public BuildaPanel() {
        addRefreshListener(ONLINE_CODEX, this::refreshAction);
        panel.setBackground(Color.WHITE);
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public int getHeight() {
        return panel.getSize().height;
    }

    public double getCost() {
        return 0;
    }

    public void refreshAction() {}
}
