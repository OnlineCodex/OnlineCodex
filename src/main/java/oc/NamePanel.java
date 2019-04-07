package oc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.w3c.dom.Element;

public class NamePanel extends OptionsVater implements KeyListener {

    private final boolean legal = true;
    private final String wert;
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
        } catch (final Exception e) {
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

    @Override
	public void keyPressed(KeyEvent e) {
    }

    @Override
	public void keyTyped(KeyEvent e) {
    }

    @Override
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
	public Element getSaveElement() {
        final Element root = BuildaHQ.getNewXMLElement("NamePanel");
        root.setAttribute("name", tName.getText());

        return root;
    }

    @Override
    public void load(String s) {
        tName.setText(s);
    }

    @Override
    public void loadElement(Element e) {
        tName.setText(e.getAttribute("name"));
    }

    @Override
    public String getLabel() {
        return "";
    }

    @Override
	public void mouseReleased(MouseEvent e) {
    }
}
