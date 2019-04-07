package oc;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;

import org.w3c.dom.Element;

public class Picture extends OptionsVater {

    JLabel iconLabel;

    public Picture(String path) {
        init(path);
    }

    public Picture(Eintrag e) {
        init(getImagePackage() + "/" + e.getClass().getSimpleName());
    }

    private void init(String path) {
        iconLabel = BuildaHQ.createPictureJLabel(path);
        panel.add(iconLabel);
    }

    private String getImagePackage() {
        return OnlineCodex.ARMY_PACKAGE.replace(".", "/") + "images";
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

    public void changeIcon(String path) {
        panel.remove(iconLabel);
        iconLabel = BuildaHQ.createPictureJLabel(path);
        panel.add(iconLabel);
    }

    public Point getLocation() {
        return panel.getLocation();
    }

    public Dimension getSize() {
        return panel.getSize();
    }

    public void setSize(int width, int height) {
        iconLabel.setSize(width, height);
    }

    public void setIcon(String path) {
        changeIcon(path);
    }

    public void updateSize() {
        iconLabel.setSize(iconLabel.getIcon().getIconWidth(), iconLabel.getIcon().getIconHeight());
    }
}
