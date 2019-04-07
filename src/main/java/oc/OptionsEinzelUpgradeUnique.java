package oc;

import java.awt.event.MouseEvent;

import org.w3c.dom.Element;

public class OptionsEinzelUpgradeUnique extends OptionsVater {

    private OptionsButtonUpgrade myUpgrade;
    private boolean aktiv = true;

    public OptionsEinzelUpgradeUnique(int ID, int lX, int lY, String verzierung, String name, double preis) {
        konstruktorDerFuerAlleGilt(lX, lY, verzierung, name, preis);
    }

    public OptionsEinzelUpgradeUnique(int ID, int lX, int lY, String verzierung, String name, double preis, int modelle) {
        konstruktorDerFuerAlleGilt(lX, lY, verzierung, name, preis);
        this.modelle = modelle;
        myUpgrade.setJeweils(true);
    }

    public OptionsEinzelUpgradeUnique(int ID, int lX, int lY, String verzierung, String kurzerName, String name, double preis) {
        konstruktorDerFuerAlleGilt(lX, lY, verzierung, name, preis);
        myUpgrade.setKurzerName(kurzerName);
    }

    public OptionsEinzelUpgradeUnique(int ID, int lX, int lY, String verzierung, String kurzerName, String name, double preis, int modelle) {
        konstruktorDerFuerAlleGilt(lX, lY, verzierung, name, preis);
        this.modelle = modelle;
        myUpgrade.setJeweils(true);
        myUpgrade.setKurzerName(kurzerName);
    }

    @Override
	public double getKosten() {
        return myUpgrade.getKosten() * this.modelle;
    }

    public void setPreis(double i) {
        myUpgrade.setPreis(i);
    }

    public boolean isAktiv() {
        return myUpgrade.isAktiv();
    }

    public void setAktiv(boolean b) {
        aktiv = b;
        if (b == false) {
            setSelected(false);
            myUpgrade.setSelected(false);
        }
        myUpgrade.setAktiv(b);
    }

    public void konstruktorDerFuerAlleGilt(int lX, int lY, String verzierung, String name, double preis) {
        myUpgrade = new OptionsButtonUpgrade(-88, 0, 0, verzierung, name, false, preis);
        myUpgrade.getButton().addMouseListener(this);
        panel = myUpgrade.getPanel();
        panel.setLocation(lX, lY);
    }

    @Override
	public String getLabel() {
        if (myUpgrade.isSelected()) {
            return myUpgrade.getButton().getText() + ZEILENUMBRUCH;
        }
        return "";
    }

    //@OVERRIDE
    @Override
	public void mouseReleased(MouseEvent event) {
        if (!aktiv) {
            return;
        }
        myUpgrade.switsch(myUpgrade.getName());
        RefreshListener.fireRefresh();
    }

    @Override
	public boolean isSelected() {
        return myUpgrade.isSelected();
    }

    public void setSelected(boolean b) {
        if (myUpgrade.isSelected() && b == false) {
            myUpgrade.switsch(myUpgrade.getName());
        }
        myUpgrade.setSelected(b);
    }

    @Override
	public boolean isLegal() {
        return myUpgrade.isLegal();
    }

    @Override
	public void setLegal(boolean b) {
        myUpgrade.setLegal(b);
    }

    @Override
	public String getText() {
        if (!aktiv) {
            return "";
        }
        final StringBuilder text = new StringBuilder(BuildaHQ.abstand);
        String kosten = "";
        if (BuildaHQ.allePunktkosten) {
            kosten = punkteAbstandHalter + entferneNullNachkomma(getKosten()) + " " + BuildaHQ.translate("Pkt.");   // NET myUpgrade.getKosten() !!! das is was anderes!
        }

        text.append(BuildaHQ.anfang + myUpgrade.getName() + kosten);
        return text.toString();
    }

    @Override
	public String getSaveText() {
        return (this.isSelected() ? "y" : "n");
    }

    @Override
	public Element getSaveElement() {
        final Element root = BuildaHQ.getNewXMLElement("UpgradeUnique");
        root.setAttribute("selected", Boolean.toString(isSelected()));
        return root;
    }

    @Override
	public void load(String s) {
        this.setSelected(s.equals("y"));
    }

    @Override
	public void loadElement(Element e) {
        this.setSelected(Boolean.parseBoolean(e.getAttribute("selected")));
    }

    public void deleteYourself() {
        if (myUpgrade.isSelected()) {
            myUpgrade.switsch(myUpgrade.getName());
        }
    }
}
