package oc;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;


public abstract class BuildaPanel implements BuildaSTK {  // Die Vaterklasse für alle anderen OC-Klassen, da jede oC Klasse ein weißes JPanel brauch^^


    public static int game;
    public static int WH40K = 0;
    public static int WHFB = 1;
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
    } // jedes Panel, das ich benutze, hat einen weißen Hintergrund

    public static int getGame() {
        return BuildaPanel.game;
    }

    public static void setGame(int game) {
        BuildaPanel.game = game;
    }

    public static String getFileSuffix() {
        String suffix = new String();
        switch (BuildaPanel.getGame()) {
            case 0: // Wh40k
            case 3: // Wh40k Legacy
            case 5: // Wh40k FanDex
                suffix = "ock";
                break;
            case 1: // WHFB
            case 4: // WHFB Legacy
                suffix = "ocf";
                break;
            case 2: // Necromunda
                suffix = "ocn";
                break;
            default:
                suffix = "oc";
                break;
        }
        return suffix;
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
        String tmp = "";
        try {
            tmp = String.valueOf(kosten);
            if (tmp.endsWith(".0")) {
                tmp = tmp.substring(0, tmp.length() - 2);
            }
        } catch (Exception e) {
        }

        return tmp;
    }

    public double getKosten() {
        double kosten = 0.0;
        for (int i = 0; i < myBuilderz.size(); i++) {
            kosten += myBuilderz.get(i).getKosten();
        }
        System.out.println("TextArea-Kosten: " + kosten);
        return kosten;
    }

    public void refreshAction() {

    }

}
