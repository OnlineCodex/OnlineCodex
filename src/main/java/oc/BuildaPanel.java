package oc;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;


public abstract class BuildaPanel implements BuildaSTK {  // Die Vaterklasse für alle anderen OC-Klassen, da jede oC Klasse ein weißes JPanel brauch^^

    public static String reflectionKennung = ""; // wird vor jeden Klassennamen, der im chooser ausgewählt wird, drangehängt
    public static String nameDerArtDerArmee = "";
    public static JTextField budget = new JTextField();
    public final JLabel kostenLabel = new JLabel();
    public Vector<BuildaVater> myBuilderz = new Vector<BuildaVater>();
    public RefreshListener refreshListener = new RefreshListener((byte) 15) {
        public void refresh() {
            refreshAction();
        }
    };
    protected JPanel panel = new JPanel(null, false); // kein LayoutManager für ALLE Panels, aber doubleBuffered

    public BuildaPanel() {
        panel.setBackground(Color.WHITE);
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public String getReflectionKennung() {
        return reflectionKennung;
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
