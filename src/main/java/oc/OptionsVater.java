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

    @Override
	public abstract double getCost();

    public abstract boolean isSelected();

    @Override
	public int getHeight() {
        return panel.getSize().height;
    }

    public void setHeadline(String s) {}


    @Override
	public JPanel getPanel() {
        return this.panel;
    }


    @Override
	public void mouseExited(MouseEvent event) {
    }

    @Override
	public void mouseEntered(MouseEvent event) {
    }

    @Override
	public void mouseClicked(MouseEvent event) {
    }

    @Override
	public void mousePressed(MouseEvent event) {
    }

    @Override
	public void mouseReleased(MouseEvent event) {
    }

}