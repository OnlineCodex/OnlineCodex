package oc;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class OptionsButton extends BuildaPanel implements BuildaSTK {

    protected String name;
    protected String kurzerName = null;
    protected double preis;
    protected boolean aktiv = true;
    protected boolean jeweils;
    protected boolean legal;
    protected Icon icon = null;
    protected Vector<JLabel> ico = new Vector<JLabel>();
    protected JButton button = new JButton("");

    public OptionsButton() {
        panel.setLayout(null);
        panel.add(button);
        BuildaHQ.newGUIComponent(button);
        legal = true;
        aktiv = true;
        jeweils = false;
    }

    public void setKurzerName(String s) {
        this.kurzerName = s;
        labelSetzen();
    }

    public void setPreis(double i) {
        this.preis = i;
        labelSetzen();
    }

    public double getPreisAuchOhneSelected() {
        return preis;
    }

    public boolean getJeweils() {
        return this.jeweils;
    }

    public void setJeweils(boolean jeweils) {
        this.jeweils = jeweils;
        labelSetzen();
    }

    public int getLocationY() {
        return (int) (panel.getLocation().getY());
    }

    @Override
	public JPanel getPanel() {
        return this.panel;
    }

    public String getName() {
        return this.name;
    }

    public JButton getButton() {
        return this.button;
    }

    public boolean isLegal() {
        return legal;
    }

    public void setLegal(boolean b) {
        legal = b;
        if (b == false) {
            button.setForeground(Color.RED);
        } else {
            button.setForeground(Color.BLACK);
        }
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean b) {
        aktiv = b;
        button.setEnabled(aktiv);
        for (int i = 0; i < ico.size(); ++i) {
            ico.elementAt(i).setEnabled(aktiv);
        }
    }

    public void setVerzierung(String s) {
        int buttonNachRechtsRücken = 0;
        int panelSizeX = buttonBreite;

        if (s.contains("einrücken")) {
            buttonNachRechtsRücken += einrueckAbstand;
            panelSizeX += einrueckAbstand;
        }

        if (s.contains("option")) {
            ico.addElement(BuildaHQ.createPictureJLabel("oc/sysimages/einruecken.jpg"));
            panel.add(ico.lastElement());
            ico.lastElement().setLocation(2 + buttonNachRechtsRücken, 7);
            panelSizeX += (ico.lastElement().getSize().width + 3);
            buttonNachRechtsRücken += ico.lastElement().getSize().width + 3;
        } // +3 als BuildaHQ.abstand

        if (s.contains("kammer")) {
            ico.addElement(BuildaHQ.createPictureJLabel("oc/sysimages/RuestkammerIcon.jpg"));
            panel.add(ico.lastElement());
            ico.lastElement().setLocation(2 + buttonNachRechtsRücken, 7);
            panelSizeX += (ico.lastElement().getSize().width + 3);
            buttonNachRechtsRücken += ico.lastElement().getSize().width - 4;
        } // +3 als BuildaHQ.abstand

        if (!s.contains("gruppe")) {
            buttonNachRechtsRücken += 9;
            panelSizeX += 9;
        } // um gleichhlch mit den gruppeneinträgen zu sein. == .getSize().width bei GruppeAnfang

        if (s.contains("gruppe")) {
            ico.addElement(BuildaHQ.createPictureJLabel("oc/sysimages/GruppenAnfang.jpg"));
            panel.add(ico.lastElement());
            ico.lastElement().setLocation(3 + buttonNachRechtsRücken, 0);
            panelSizeX += (ico.lastElement().getSize().width);
            buttonNachRechtsRücken += ico.lastElement().getSize().width;
            ico.addElement(BuildaHQ.createPictureJLabel("oc/sysimages/GruppenEnde.jpg"));
            panel.add(ico.lastElement());
            ico.lastElement().setLocation(buttonBreite + buttonNachRechtsRücken, 0);
            panelSizeX += (ico.lastElement().getSize().width);
        }

        button.setLocation(buttonNachRechtsRücken, buttonAbstandY / 2);
        panel.setSize(panelSizeX, buttonHoehe + buttonAbstandY);
    }

    public int getBreite() {
        return panel.getSize().width;
    }

    @Override
	public int getHoehe() {
        return panel.getSize().height;
    }

    public void produceButton() {
        button.setToolTipText(name);
        button.setSize(buttonBreite, buttonHoehe);
        button.setFont(new Font("arial", Font.PLAIN, 12));
        button.setBorder(null);
        labelSetzen();
    }

    public void fontSetzen(int art) { // 0 is Plain, 1 Bold Italic 2
        button.setFont(new Font("arial", art, 12));
    }

    public abstract void labelSetzen();
}