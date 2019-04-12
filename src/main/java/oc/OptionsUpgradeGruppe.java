package oc;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class OptionsUpgradeGruppe extends OptionsVater {

    boolean showKosten = true;
    private final Vector<OptionsButtonUpgrade> myUpgrades = new Vector<OptionsButtonUpgrade>();
    private boolean aktiv = true;
    private boolean erhoehbar = true;
    private int maxAnzahl = 1;
    private boolean punkteLimitGruppe = false;

    public OptionsUpgradeGruppe(int ID, int lX, int lY, String verzierung, Vector<OptionsGruppeEintrag> e) {
        panel.setLocation(lX, lY);
        this.showKosten = true;
        // ID wegwerfen!!!
        for (int i = 0; i < e.size(); ++i) {
            myUpgrades.addElement(new OptionsButtonUpgrade(ID, 0, i * (buttonAbstandY + buttonHoehe), verzierung + " gruppe", e.elementAt(i).getName(), false, e.elementAt(i).getPreis()));
            panel.add(myUpgrades.lastElement().getPanel());
            myUpgrades.lastElement().getButton().addMouseListener(this);
            if (e.elementAt(i).getKurzerName() != null) {
                myUpgrades.lastElement().setKurzerName(e.elementAt(i).getKurzerName());
            }
            myUpgrades.lastElement().setUnique(e.elementAt(i).isUnique());
            myUpgrades.lastElement().setRelic(e.elementAt(i).isRelic());
        }
        panel.setSize(myUpgrades.elementAt(0).getBreite(), myUpgrades.size() * (myUpgrades.elementAt(0).getHoehe()));
    }

    public OptionsUpgradeGruppe(int ID, int lX, int lY, String verzierung, Vector<OptionsGruppeEintrag> e, boolean showKosten) {
        panel.setLocation(lX, lY);
        this.showKosten = showKosten;
        // ID wegwerfen!!!
        for (int i = 0; i < e.size(); ++i) {
            myUpgrades.addElement(new OptionsButtonUpgrade(ID, 0, i * (buttonAbstandY + buttonHoehe), verzierung + " gruppe", e.elementAt(i).getName(), false, e.elementAt(i).getPreis(), showKosten));
            panel.add(myUpgrades.lastElement().getPanel());
            myUpgrades.lastElement().getButton().addMouseListener(this);
            if (e.elementAt(i).getKurzerName() != null) {
                myUpgrades.lastElement().setKurzerName(e.elementAt(i).getKurzerName());
            }
            myUpgrades.lastElement().setUnique(e.elementAt(i).isUnique());
            myUpgrades.lastElement().setRelic(e.elementAt(i).isRelic());
        }
        panel.setSize(myUpgrades.elementAt(0).getBreite(), myUpgrades.size() * (myUpgrades.elementAt(0).getHoehe()));
    }

    public OptionsUpgradeGruppe(int ID, int lX, int lY, String verzierung, Vector<OptionsGruppeEintrag> e, int maxAnzahl) {
        this.maxAnzahl = maxAnzahl;
        this.showKosten = true;
        // ID wegwerfen!!!
        panel.setLocation(lX, lY);
        for (int i = 0; i < e.size(); ++i) {
            myUpgrades.addElement(new OptionsButtonUpgrade(ID, 0, i * (buttonAbstandY + buttonHoehe), verzierung + " gruppe", e.elementAt(i).getName(), false, e.elementAt(i).getPreis()));
            panel.add(myUpgrades.lastElement().getPanel());
            myUpgrades.lastElement().getButton().addMouseListener(this);
            if (e.elementAt(i).getKurzerName() != null) {
                myUpgrades.lastElement().setKurzerName(e.elementAt(i).getKurzerName());
            }
            myUpgrades.lastElement().setUnique(e.elementAt(i).isUnique());
            myUpgrades.lastElement().setRelic(e.elementAt(i).isRelic());
        }
        panel.setSize(myUpgrades.elementAt(0).getBreite(), myUpgrades.size() * (myUpgrades.elementAt(0).getHoehe()));
    }

    public OptionsUpgradeGruppe(int ID, int lX, int lY, String verzierung, Vector<OptionsGruppeEintrag> e, int maxAnzahl, boolean showKosten) {
        this.maxAnzahl = maxAnzahl;
        this.showKosten = showKosten;
        // ID wegwerfen!!!
        panel.setLocation(lX, lY);
        for (int i = 0; i < e.size(); ++i) {
            myUpgrades.addElement(new OptionsButtonUpgrade(ID, 0, i * (buttonAbstandY + buttonHoehe), verzierung + " gruppe", e.elementAt(i).getName(), false, e.elementAt(i).getPreis(), showKosten));
            panel.add(myUpgrades.lastElement().getPanel());
            myUpgrades.lastElement().getButton().addMouseListener(this);
            if (e.elementAt(i).getKurzerName() != null) {
                myUpgrades.lastElement().setKurzerName(e.elementAt(i).getKurzerName());
            }
            myUpgrades.lastElement().setUnique(e.elementAt(i).isUnique());
            myUpgrades.lastElement().setRelic(e.elementAt(i).isRelic());
        }
        panel.setSize(myUpgrades.elementAt(0).getBreite(), myUpgrades.size() * (myUpgrades.elementAt(0).getHoehe()));
    }

    public boolean isShowKosten() {
        return showKosten;
    }

    public void setShowKosten(boolean showKosten) {
        this.showKosten = showKosten;
    }

    public void setPunkteLimitGruppe(boolean b) {
        this.punkteLimitGruppe = b;
    }

    public void setErhoehbar(boolean b) {
        this.erhoehbar = b;
    }

    @Override
	public void setModelle(int i) {
        this.modelle = i;
    }

    public void alwaysSelected() {
        if (!this.isSelected()) {
            for (int i = 0; i < this.getNumberOfOptions(); i++) {
                if (this.isAktiv(i)) {
                    this.setSelected(i, true);
                    break;
                }
            }
        }
    }

    public int getNumberOfOptions() {
        return myUpgrades.size() + 1;
    }

    @Override
	public double getKosten() {
        double kosten = 0;
        for (int i = 0; i < myUpgrades.size(); ++i) {
            kosten += myUpgrades.elementAt(i).getKosten();
        }
        return kosten * modelle;
    }

    public String getCurrentName() {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).isSelected()) {
                return myUpgrades.elementAt(i).getName();
            }
        }
        return "";
    }

    /**
     * Check if an item with the given name is contained in this OptionsUpgradeGroup
     *
     * @param name Name of the item
     * @return TRUE if item is contained, FALSE otherwise
     */
    public boolean contains(String name) {
        for (int i = 0; i < myUpgrades.size(); i++) {
            final String foundName = myUpgrades.elementAt(i).getName();
            if (name.equals(foundName)) return true;
        }
        return false;
    }

    public boolean isSelected(String s) {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).getName().equals(s)) {
                return myUpgrades.elementAt(i).isSelected();
            }
        }
        return false;
    }

    public boolean isSelected(Integer index) {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (i == index) {
                return myUpgrades.elementAt(i).isSelected();
            }
        }
        return false;
    }

    public int getSelectedIndex() {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).isSelected()) {
                return i;
            }
        }
        return -1;
    }

    public boolean isAktiv(String s) {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).getName().equals(s)) {
                return myUpgrades.elementAt(i).isAktiv();
            }
        }
        return false;
    }

    public boolean isAktiv(int index) {
        return myUpgrades.elementAt(index).isAktiv();
    }

    public boolean isAktiv() {
        return this.aktiv;
    }

    public void setAktiv(boolean b) {
        for (int i = 0; i < this.myUpgrades.size(); ++i) {
            this.myUpgrades.elementAt(i).setAktiv(b);
        }
        aktiv = b;
    }

    public void setLegal(String s, boolean b) {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).getName().equals(s)) {
                myUpgrades.elementAt(i).setLegal(b);
            }
        }
    }

    @Override
	public void setHeadline(String s) {
        final JLabel label = new JLabel(s);
        label.setBounds(20, 0, buttonBreite + 30, 20);
        label.setFont(new Font("Lucida Blackletter", Font.BOLD, 16));
        panel.add(label);

        for (int i = 0; i < myUpgrades.size(); ++i) {
            final JPanel p = myUpgrades.elementAt(i).panel;
            p.setLocation((int) p.getLocation().getX(), (int) p.getLocation().getY() + headlineAbstand);
        }

        this.panel.setSize(this.panel.getSize().width, this.panel.getSize().height + headlineAbstand);
    }

    @Override
	public boolean isLegal() {
        return myUpgrades.elementAt(0).isLegal();
    }  // MIT ÄNDERN WENN LEGAL GEÄNDERT WIRD!!

    @Override
	public void setLegal(boolean b) {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            myUpgrades.elementAt(i).setLegal(b);
        }
    }

    public void setAktiv(String s, boolean b) {
        for (int i = 0; i < this.myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).getName().equals(s)) {
                if (!b && isSelected(s)) { //selected options that become inactive should be deselected
                    myUpgrades.elementAt(i).switsch();
                }
                if (b == false)
                    myUpgrades.elementAt(i).setSelected(b); // muss so geloest werden, denn sonst wuerde ein auf "true" gesetzter Eintrag *immer* ausgewählt werden, auch wenn er das vorher nicht war
                myUpgrades.elementAt(i).setAktiv(b);
            }
        }
    }

    public void setAktiv(int i, boolean b) {
        if (b == false)
            myUpgrades.elementAt(i).setSelected(b); // muss so geloest werden, denn sonst wuerde ein auf "true" gesetzter Eintrag *immer* ausgewählt werden, auch wenn er das vorher nicht war
        myUpgrades.elementAt(i).setAktiv(b);
    }

    public void deactivateOthers(String s) {
        for (int i = 0; i < myUpgrades.size(); ++i) {
        	myUpgrades.elementAt(i).setSelected(false);
            myUpgrades.elementAt(i).setAktiv(false);
        }
        setAktiv(s, true);
    }

    public void deactivateOthers(int idx) {
        for (int i = 0; i < myUpgrades.size(); ++i) {
        	myUpgrades.elementAt(i).setSelected(false);
            myUpgrades.elementAt(i).setAktiv(false);
        }
        setAktiv(idx, true);
    }

    public void setPreis(String s, double preis) {
        for (int i = 0; i < this.myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).getName().equals(s)) {
                myUpgrades.elementAt(i).setPreis(preis);
            }
        }
    }

    public void setPreis(int index, double preis) {
        myUpgrades.elementAt(index).setPreis(preis);
    }

    public void deselectAll() {
        for (int i = 0; i < this.myUpgrades.size(); ++i) {
            myUpgrades.elementAt(i).setSelected(false);
        }
    }

    public void setSelected(String s, boolean b) {
        for (int i = 0; i < this.myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).getName().equals(s)) {
                myUpgrades.elementAt(i).setSelected(b);
            }
        }
    }

    public void setSelected(int index, boolean b) {
        myUpgrades.elementAt(index).setSelected(b);
    }

    public void clear() {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).isSelected()) {
                myUpgrades.elementAt(i).switsch();
            }
        }
    }

    @Override
	public String getLabel() {
        final StringBuilder b = new StringBuilder();

        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).isSelected()) {
                b.append(myUpgrades.elementAt(i).getButton().getText() + ZEILENUMBRUCH);
            }
        }

        return b.toString();
    }

    public int getAnzahl() {
        int cnt = 0;
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).isSelected()) {
                ++cnt;
            }
        }
        return cnt;
    }

    @Override
	public void mouseReleased(MouseEvent event) {
        if (!aktiv) {
            return;
        }

        OptionsButtonUpgrade button = null;

        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).getButton().getText().equals(((JButton) event.getSource()).getText())) {
                button = myUpgrades.elementAt(i);
            }
        }

        if (punkteLimitGruppe) {
            if (button.isSelected()) {
                button.switsch();
            } else if (button.getPreisAuchOhneSelected() + getKosten() <= maxAnzahl) {  // der angeklickte button ist ja noch net bei getKosten() dabei
                button.switsch();
            } else {
                return;
            }
        } else {
            if (button.isSelected()) {
                button.switsch();
                if (getAnzahl() == 0) {
                }
            } else if (maxAnzahl == 1 && erhoehbar) {
                for (int i = 0; i < myUpgrades.size(); ++i) {
                    if (myUpgrades.elementAt(i).isSelected()) {
                        myUpgrades.elementAt(i).switsch();
                    }
                }
                button.switsch();
            } else {
                if (getAnzahl() < maxAnzahl && erhoehbar) {
                    button.switsch();
                }
            }
        }

        RefreshListener.fireRefresh();
    }

    @Override
	public boolean isSelected() {
        return getAnzahl() > 0;
    }

    @Override
	public String getText() {
        if (!aktiv) {
            return "";
        }

        final StringBuilder text = new StringBuilder();

        for (int i = 0; i < myUpgrades.size(); ++i) {
            final OptionsButtonUpgrade o = myUpgrades.elementAt(i);
            if (o.isSelected()) {
                text.append(BuildaHQ.abstand);
                String kosten = "";

                if (BuildaHQ.allePunktkosten) {
                    kosten = punkteAbstandHalter + (entferneNullNachkomma(o.getKosten() * modelle)) + " " + BuildaHQ.translate("Pkt.");
                    if (!isShowKosten()) {
                        kosten = "";
                    }
                    //					else if (o.getKosten() * modelle == 0) {
                    //						kosten = punkteAbstandHalter + BuildaHQ.translate("kostenlos");
                    //					}
                }

                text.append(BuildaHQ.anfang + o.getName() + kosten);
            }
        }

        return text.toString();
    }

    public void setMaxAnzahl(int value) {
        this.maxAnzahl = value;
    }

    @Override
	public String getSaveText() {
        final StringBuilder s = new StringBuilder();

        for (int i = 0; i < myUpgrades.size(); ++i) {
            s.append((myUpgrades.elementAt(i).isSelected() ? "y" : "n"));
            s.append(SAVETEXT_TRENNER1);
        }

        return s.toString();
    }

    @Override
    public void load(String s) {
        final String[] splittet = s.split(SAVETEXT_TRENNER1);

        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (splittet[i].equals("y")) {
                myUpgrades.elementAt(i).switsch();
            } else {
            	myUpgrades.elementAt(i).setSelected(false);
            }
        }
    }

    public void setToolTipText(int i, String s) {
        myUpgrades.elementAt(i).getButton().setToolTipText(s);
    }

    public void deleteYourself() {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).isSelected()) {
                if (myUpgrades.elementAt(i).isUnique() || myUpgrades.elementAt(i).isRelic()) {
                    myUpgrades.elementAt(i).switsch();
                }
            }
        }
    }

    public OptionsButtonUpgrade getChosenRelic() {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).isSelected() && myUpgrades.elementAt(i).isRelic()) {
                return myUpgrades.elementAt(i);
            }
        }
        return null;
    }

    public void enableRelics() {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).isRelic()) {
                myUpgrades.elementAt(i).setAktiv(true);
            }
        }
    }

    public void disableOtherRelics(OptionsButtonUpgrade obu) {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).isRelic()) {
                myUpgrades.elementAt(i).setAktiv(obu.equals(myUpgrades.elementAt(i)));
            }
        }
    }

}