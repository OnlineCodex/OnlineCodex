package oc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import org.w3c.dom.Element;


public abstract class OptionsVater extends BuildaPanel implements BuildaSTK, MouseListener {


    int modelle = 1;  // wenn keine übergeben werden veränderts so nix (bei 1)


    public void setModelle(int modelle) {
        this.modelle = modelle;
    }


    public abstract String getText();

    public abstract String getSaveText();

    public abstract Element getSaveElement();

    public abstract void load(String s);

    public abstract void loadElement(Element e);

    public abstract boolean isLegal();

    public abstract void setLegal(boolean b);

    @Override
	public abstract double getKosten();

    public abstract boolean isSelected();

    public abstract String getLabel();


    public int getSelectedAsInt() { // übersetzt den boolean zu 0 oder 1

        if (this.isSelected()) {
            return 1;
        } else {
            return 0;
        }

    }


    @Override
	public int getHoehe() {
        return panel.getSize().height;
    }

    public int getBreite() {
        return panel.getSize().width;
    }

    public void setHeadline(String s) {
    }


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


    public void refresh() {
    }

    //protected void finalize(){LOGGER.info("Object in OptionsVater gelöscht");}


}