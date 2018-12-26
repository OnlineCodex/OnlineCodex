package oc;

import org.w3c.dom.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class NamePanel extends OptionsVater implements KeyListener {

    private boolean legal = true;
    private String wert;
    private String name = "Name";
    private JTextField tName;
    private JLabel lName;

    public NamePanel(int ID, int lX, int lY, String wert) {
        this.wert = wert;

        produceButton();

        this.panel.setLocation(lX, lY);
        tName.addKeyListener(this);
    }

    public NamePanel(int ID, int lX, int lY, String wert, String name) {
        this.wert = wert;
        this.name = name;

        produceButton();

        this.panel.setLocation(lX, lY);
        tName.addKeyListener(this);
    }

    @Override
    public boolean isLegal() {
        return this.legal;
    }

    @Override
    public void setLegal(boolean b) {
    }

    @Override
    public boolean isSelected() {
        return modelle > 0;
    }

    public String getName() {
        return this.tName.getText();
    }

    @Override
    public double getKosten() {
        try {
            return Integer.parseInt(tName.getText());
        } catch (Exception e) {
            return 0.0;
        }
    }

    public void produceButton() {
        panel.setSize(auswahlBreite - (randAbstand * 2) - (int) (panel.getLocation().getX()), buttonHoehe);  // *2 weils ja vorne und hinten den BuildaHQ.abstand hat

        tName = new JTextField(wert);

        BuildaHQ.newGUIComponent(tName);

        lName = new JLabel(name);
        lName.setFont(new Font("arial", Font.PLAIN, 12));
        lName.setBackground(Color.WHITE);


        tName.setBounds(0, 0, 113, 18);

        lName.setBounds(125, 2, auswahlBreite, 18);
        panel.add(tName);
        panel.add(lName);
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    @Override
    public String getText() {
        if (BuildaHQ.equals(tName.getText(), "", " ")) return "";
        return BuildaHQ.formatierFett(name + ": " + tName.getText());
    }

    @Override
    public String getSaveText() {
        return tName.getText();
    }

    @Override
    public void load(String s) {
        tName.setText(s);
    }

    @Override
    public String getLabel() {
        return "";
    }

    public void mouseReleased(MouseEvent e) {
    }
}
