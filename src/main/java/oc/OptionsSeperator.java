package oc;

import java.awt.event.MouseEvent;

import org.w3c.dom.Element;


public class OptionsSeperator extends OptionsVater {


    private int höhe = 0;

    public OptionsSeperator(int höhe) {

        this.höhe = höhe;
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
        return true;
    }

    @Override
	public void setLegal(boolean b) {
    }

    @Override
	public double getKosten() {
        return 0;
    }

    @Override
	public boolean isSelected() {
        return false;
    }

    @Override
	public String getLabel() {
        return "";
    }

    @Override
	public void mouseReleased(MouseEvent event) {
    }

    @Override

    public int getHoehe() {

        return höhe;

    }


}