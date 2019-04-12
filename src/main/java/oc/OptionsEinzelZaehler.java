package oc;

import java.awt.event.MouseEvent;

public class OptionsEinzelZaehler extends OptionsVater {

    private String unikatName;
    protected boolean unikat;
    private final OptionsButtonZaehler myZaehler;
    private boolean aktiv = true;

    public OptionsEinzelZaehler(int ID, int lX, int lY, String verzierung, String name, int maxAnzahl, double preis) {
        myZaehler = new OptionsButtonZaehler(ID, 0, 0, verzierung, name, maxAnzahl, preis);
        myZaehler.getButton().addMouseListener(this);

        panel = myZaehler.getPanel();
        panel.setLocation(lX, lY);

        unikatName = this.getClass().getName() + name;
        oc.BuildaHQ.addToInformationVectorGlobal(unikatName, 1);
    }

    public OptionsEinzelZaehler(int ID, int lX, int lY, String verzierung, String kurzerName, String name, int maxAnzahl, double preis) {
        myZaehler = new OptionsButtonZaehler(ID, 0, 0, verzierung, name, maxAnzahl, preis);
        myZaehler.getButton().addMouseListener(this);
        myZaehler.setKurzerName(kurzerName);

        panel = myZaehler.getPanel();
        panel.setLocation(lX, lY);

        unikatName = this.getClass().getName() + name;
        oc.BuildaHQ.addToInformationVectorGlobal(unikatName, 1);
    }

    @Override
	public double getCost() {
        return myZaehler.getCost() * this.modelle;
    }

    public int getAnzahl() {
        return myZaehler.getAnzahl();
    }

    public void setAnzahl(int i) {
        myZaehler.setAnzahl(i);
    }

    public int getMaxAnzahl() {
        return myZaehler.getMaxAnzahl();
    }

    public void setMaxAnzahl(int max) {
        myZaehler.setControlledMaxAnzahl(max);
    }

    public void setAktiv(boolean b) {
        aktiv = b;
        myZaehler.setAktiv(b);
    }

    @Override
	public void mouseReleased(MouseEvent event) {
        if (!aktiv) {
            return;
        }

        boolean mitMausradVeraenderbar = true;
        boolean erhoehbar = true;
        if (event.getButton() == MouseEvent.BUTTON1 && erhoehbar) {
            myZaehler.feuerErhoehen();
        } else if (event.getButton() == MouseEvent.BUTTON2 && mitMausradVeraenderbar) {
            if (this.getAnzahl() == this.getMaxAnzahl() || !erhoehbar) {
                myZaehler.feuerLeermachen();
            } else {
                myZaehler.feuerVollmachen();
            }
        } else if (event.getButton() == MouseEvent.BUTTON3) {
            myZaehler.feuerVermindern();
        }
        RefreshListener.fireRefresh();
    }

    @Override
	public boolean isSelected() {
        return myZaehler.getAnzahl() > 0;
    }

    @Override
	public boolean isLegal() {
        return myZaehler.isLegal();
    }

    @Override
	public void setLegal(boolean b) {
        myZaehler.setLegal(b);
    }

    @Override
	public String getText() {
        if (!aktiv) {
            return "";
        }
        String text = BuildaHQ.abstand;
        String kosten = "";
        if (BuildaHQ.allePunktkosten) {
            kosten = punkteAbstandHalter + ((int) getCost()) + " " + "Pkt.";
        }
        text += BuildaHQ.anfang + getAnzahl() + " x " + myZaehler.getName() + kosten;
        return text;
    }

    @Override
	public String getSaveText() {
        return String.valueOf(this.getAnzahl());
    }

    @Override
	public void load(String s) {
        try {
            setAnzahl(Integer.parseInt(s));
        } catch (final NumberFormatException e) {
            setAnzahl(-88);
        }
    }
}