package oc;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;

import org.w3c.dom.Element;

public class RuestkammerChooser extends OptionsVater {
    JComboBox box;

    public RuestkammerChooser(int x, int y, int width, int height, Vector<String> items) {
        box = new JComboBox(items);
        box.setBounds(x, y, width, height);
        BuildaHQ.newGUIComponent(box);
        box.setBackground(Color.WHITE);
        box.setMaximumRowCount(items.size());
        box.setEditable(false);
        box.setFocusable(false);
        box.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);

        panel.add(box);
        panel.setBounds(x - 20, y, width + 20, height + 10);
    }

    public void addActionListener(ActionListener aL) {
        box.addActionListener(aL);
    }

    public void setSelectedIndex(int index) {
        box.setSelectedIndex(index);
    }

    @Override
    public String getText() {
        return "";
    }

    @Override
    public String getSaveText() {
        return "";
    }

    @Override
	public Element getSaveElement() {
        return null;
    }

    @Override
    public void load(String s) {
    }

    @Override
    public void loadElement(Element e) {
    }

    @Override
    public boolean isLegal() {
        return false;
    }

    @Override
    public void setLegal(boolean b) {
    }

    @Override
    public double getKosten() {
        return 0.0;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public String getLabel() {
        return "";
    }
}
