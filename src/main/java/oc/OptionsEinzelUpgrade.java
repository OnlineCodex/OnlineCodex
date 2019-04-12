package oc;

import java.awt.event.MouseEvent;

public class OptionsEinzelUpgrade extends OptionsVater {

    private OptionsButtonUpgrade myUpgrade;

    private boolean aktiv = true;

    private boolean showKosten;

    public OptionsEinzelUpgrade(int ID, int lX, int lY, String verzierung, String name, double preis) {
        konstruktorDerFuerAlleGilt(lX, lY, verzierung, name, preis);
    }

    public OptionsEinzelUpgrade(int ID, int lX, int lY, String verzierung, String name, double preis, boolean showKosten) {
        konstruktorDerFuerAlleGilt(lX, lY, verzierung, name, preis, showKosten);
    }

    public OptionsEinzelUpgrade(int ID, int lX, int lY, String verzierung, String name, double preis, int modelle) {
        konstruktorDerFuerAlleGilt(lX, lY, verzierung, name, preis);
        this.modelle = modelle;
        myUpgrade.setJeweils(true);
    }

    public OptionsEinzelUpgrade(int ID, int lX, int lY, String verzierung, String name) {
        konstruktorDerFuerAlleGilt(lX, lY, verzierung, name, -88);
    }

    public OptionsEinzelUpgrade(int ID, int lX, int lY, String verzierung, String kurzerName, String name, double preis) {
        konstruktorDerFuerAlleGilt(lX, lY, verzierung, name, preis);
        myUpgrade.setKurzerName(kurzerName);
    }

    public OptionsEinzelUpgrade(int ID, int lX, int lY, String verzierung, String kurzerName, String name, double preis, int modelle) {
        konstruktorDerFuerAlleGilt(lX, lY, verzierung, name, preis);
        this.modelle = modelle;
        myUpgrade.setJeweils(true);
        myUpgrade.setKurzerName(kurzerName);
    }

    public boolean isShowKosten() {
        return showKosten;
    }

    @Override
	public double getCost() {
        return myUpgrade.getCost() * this.modelle;
    }

    public void setPreis(double i) {
        myUpgrade.setCost(i);
    }

    public boolean isAktiv() {
        return myUpgrade.isAktiv();
    }

    public void setAktiv(boolean b) {
        aktiv = b;
        if (!aktiv && isSelected()) { //selected options that become inactive should be deselected
            myUpgrade.toggle();
        }
        myUpgrade.setAktiv(b);

    }

    public void konstruktorDerFuerAlleGilt(int lX, int lY, String verzierung, String name, double preis) {
        myUpgrade = new OptionsButtonUpgrade(0, 0, verzierung, name, false, preis);
        myUpgrade.getButton().addMouseListener(this);
        panel = myUpgrade.getPanel();
        panel.setLocation(lX, lY);
    }

    public void konstruktorDerFuerAlleGilt(int lX, int lY, String verzierung, String name, double preis, boolean showKosten) {
        myUpgrade = new OptionsButtonUpgrade(0, 0, verzierung, name, false, preis, showKosten);
        myUpgrade.getButton().addMouseListener(this);
        panel = myUpgrade.getPanel();
        panel.setLocation(lX, lY);
        this.showKosten = showKosten;
    }

    //@OVERRIDE
    @Override
	public void mouseReleased(MouseEvent event) {
        if (!aktiv) {
            return;
        }
        myUpgrade.toggle();
        RefreshListener.fireRefresh();
    }

    @Override
	public boolean isSelected() {
        return myUpgrade.isSelected();
    }

    public void setSelected(boolean b) {
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
            if (!isShowKosten()) {
                kosten = punkteAbstandHalter + ((int) getCost()) + " " + BuildaHQ.translate("Pkt.");   // NET myUpgrade.getKosten() !!! das is was anderes!
            }
        }

        text.append(BuildaHQ.anfang + myUpgrade.getName() + kosten);

        return text.toString();
    }

    @Override
	public String getSaveText() {
        return (this.isSelected() ? "y" : "n");
    }

    @Override
	public void load(String s) {
        if (s.equals("y")) {
            myUpgrade.toggle();
        }
    }

    public OptionsEinzelUpgrade setRelic(boolean relic) {
        myUpgrade.unique = relic;
        myUpgrade.relic = relic;
        return this;
    }

    public void deleteYourself() {
        if (myUpgrade.isSelected()) {
            if (myUpgrade.isUnique() || myUpgrade.isRelic()) {
                myUpgrade.toggle(myUpgrade.getName());
            }
        }
    }

    public OptionsButtonUpgrade getChosenRelic() {
        if (myUpgrade.isSelected() && myUpgrade.isRelic()) {
            return myUpgrade;
        } else {
            return null;
        }
    }

    public void enableRelics() {
        if (myUpgrade.isRelic()) {
            myUpgrade.setAktiv(true);
        }
    }

    public void disableOtherRelics(OptionsButtonUpgrade obu) {
        if (myUpgrade.isRelic()) {
            myUpgrade.setAktiv(obu.equals(myUpgrade));
        }
    }
}
