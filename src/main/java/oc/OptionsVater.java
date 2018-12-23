package oc;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class OptionsVater extends BuildaPanel implements BuildaSTK, MouseListener {

    int modelle = 1;  // wenn keine übergeben werden veränderts so nix (bei 1)

    public void setModelle(int modelle) {
        this.modelle = modelle;
    }

    public abstract String getText();

    public abstract String getSaveText();

    public abstract void load(String s);

    public abstract boolean isLegal();

    public abstract void setLegal(boolean b);

    public abstract double getKosten();

    public abstract boolean isSelected();

    public abstract String getLabel();

    public int getHoehe() {
        return panel.getSize().height;
    }

    public int getBreite() {
        return panel.getSize().width;
    }

    public void setHeadline(String s) {}

    public JPanel getPanel() {
        return this.panel;
    }

    public void mouseExited(MouseEvent event) {}

    public void mouseEntered(MouseEvent event) {}

    public void mouseClicked(MouseEvent event) {}

    public void mousePressed(MouseEvent event) {}

    public void mouseReleased(MouseEvent event) {}

    public void refresh() {}
}