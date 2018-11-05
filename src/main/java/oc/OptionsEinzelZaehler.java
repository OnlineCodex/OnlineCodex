package oc;

import org.w3c.dom.Element;

import java.awt.event.MouseEvent;


public class OptionsEinzelZaehler extends OptionsVater {


    protected String unikatName;
    protected boolean unikat;
    protected boolean selectedPuffer;
    private OptionsButtonZaehler myZaehler;
    private boolean aktiv = true;
    private boolean erhoehbar = true;
    private boolean mitMausradVeraenderbar = true;


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

    public double getKosten() {
        return myZaehler.getKosten() * this.modelle;
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

    public void setErhoehbar(boolean b) {
        this.erhoehbar = b;
    }

    public void setMitMausradVeraenderbar(boolean b) {
        this.mitMausradVeraenderbar = b;
    }

    public void setToolTipText(String s) {
        myZaehler.getButton().setToolTipText(s);
    }

    public void setAktiv(boolean b) {

        aktiv = b;

        myZaehler.setAktiv(b);
    }

    public String getLabel() {

        if (myZaehler.getAnzahl() > 0) {
            return myZaehler.getButton().getText() + ZEILENUMBRUCH;
        }

        return "";
    }


    //@OVERRIDE

    public void mouseReleased(MouseEvent event) {

        if (!aktiv) {
            return;
        }


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


    public boolean isSelected() {

        return myZaehler.getAnzahl() > 0;

    }

    public boolean isLegal() {
        return myZaehler.isLegal();
    }

    public void setLegal(boolean b) {
        myZaehler.setLegal(b);
    }

    public String getText() {

        if (!aktiv) {
            return "";
        }

        String text = BuildaHQ.abstand;

        String kosten = "";


        if (BuildaHQ.allePunktkosten) {

            kosten = punkteAbstandHalter + entferneNullNachkomma(getKosten()) + " " + "Pkt.";   // NET myUpgrade.getKosten() !!! das is was anderes!

//			if(getKosten() == 0){
//
//				kosten = punkteAbstandHalter+"kostenlos";}

        }


        text += BuildaHQ.anfang + getAnzahl() + " x " + myZaehler.getName() + kosten;


        return text;

    }


    public String getSaveText() {

        return String.valueOf(this.getAnzahl());

    }

    public Element getSaveElement() {
        Element root = BuildaHQ.getNewXMLElement("Counter");
        root.setAttribute("number", Integer.toString(getAnzahl()));

        return root;
    }

    public void load(String s) {

        try {
            setAnzahl(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            setAnzahl(-88);
        }

    }

    public void loadElement(Element e) {
        try {
            setAnzahl(Integer.parseInt(e.getAttribute("number")));
        } catch (NumberFormatException ex) {
            setAnzahl(-88);
        }
    }


}