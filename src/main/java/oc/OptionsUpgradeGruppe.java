package oc;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionsUpgradeGruppe extends OptionsVater {

    private boolean showCost;
    private final Vector<OptionsButtonUpgrade> myUpgrades = new Vector<>();
    private boolean active = true;
    private int maxAmount;

    public OptionsUpgradeGruppe(int lX, int lY, String decoration, Vector<OptionsGruppeEintrag> e) {
        this(lX, lY, decoration, e, 1, true);
    }

    public OptionsUpgradeGruppe(int lX, int lY, String decoration, Vector<OptionsGruppeEintrag> e, boolean showCost) {
        this(lX, lY, decoration, e, 1, showCost);
    }

    public OptionsUpgradeGruppe(int lX, int lY, String decoration, Vector<OptionsGruppeEintrag> e, int maxAmount) {
        this(lX, lY, decoration, e, maxAmount, true);
    }

    public OptionsUpgradeGruppe(int lX, int lY, String decoration, Vector<OptionsGruppeEintrag> e, int maxAmount, boolean showCost) {
        this.maxAmount = maxAmount;
        this.showCost = showCost;
        panel.setLocation(lX, lY);
        for (int i = 0; i < e.size(); ++i) {
            myUpgrades.addElement(new OptionsButtonUpgrade(0, i * (buttonAbstandY + buttonHoehe), decoration + " gruppe", e.elementAt(i).getName(), false, e.elementAt(i).getPreis(), showCost));
            panel.add(myUpgrades.lastElement().getPanel());
            myUpgrades.lastElement().getButton().addMouseListener(this);
            if (e.elementAt(i).getKurzerName() != null) {
                myUpgrades.lastElement().setKurzerName(e.elementAt(i).getKurzerName());
            }
            myUpgrades.lastElement().setUnique(e.elementAt(i).isUnique());
            myUpgrades.lastElement().setRelic(e.elementAt(i).isRelic());
        }
        panel.setSize(myUpgrades.elementAt(0).getBreite(), myUpgrades.size() * (myUpgrades.elementAt(0).getHeight()));
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

    private int getNumberOfOptions() {
        return myUpgrades.size() + 1;
    }

    @Override
	public double getCost() {
        double kosten = 0;
        for (int i = 0; i < myUpgrades.size(); ++i) {
            kosten += myUpgrades.elementAt(i).getCost();
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

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean b) {
        for (int i = 0; i < this.myUpgrades.size(); ++i) {
            this.myUpgrades.elementAt(i).setAktiv(b);
        }
        active = b;
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
                    myUpgrades.elementAt(i).toggle();
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
                myUpgrades.elementAt(i).setCost(preis);
            }
        }
    }

    public void setPreis(int index, double preis) {
        myUpgrades.elementAt(index).setCost(preis);
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
                myUpgrades.elementAt(i).toggle();
            }
        }
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
        if (!active) {
            return;
        }

        OptionsButtonUpgrade button = null;

        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).getButton().getText().equals(((JButton) event.getSource()).getText())) {
                button = myUpgrades.elementAt(i);
            }
        }

        boolean punkteLimitGruppe = false;
        if (punkteLimitGruppe) {
            if (button.isSelected()) {
                button.toggle();
            } else if (button.getPreisAuchOhneSelected() + getCost() <= maxAmount) {  // der angeklickte button ist ja noch net bei getKosten() dabei
                button.toggle();
            } else {
                return;
            }
        } else {
            boolean erhoehbar = true;
            if (button.isSelected()) {
                button.toggle();
                if (getAnzahl() == 0) {
                }
            } else if (maxAmount == 1 && erhoehbar) {
                for (int i = 0; i < myUpgrades.size(); ++i) {
                    if (myUpgrades.elementAt(i).isSelected()) {
                        myUpgrades.elementAt(i).toggle();
                    }
                }
                button.toggle();
            } else {
                if (getAnzahl() < maxAmount && erhoehbar) {
                    button.toggle();
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
        if (!active) {
            return "";
        }

        final StringBuilder text = new StringBuilder();

        for (int i = 0; i < myUpgrades.size(); ++i) {
            final OptionsButtonUpgrade o = myUpgrades.elementAt(i);
            if (o.isSelected()) {
                text.append(BuildaHQ.abstand);
                String kosten = "";

                if (BuildaHQ.allePunktkosten) {
                    kosten = punkteAbstandHalter + ((int) (o.getCost() * modelle)) + " " + BuildaHQ.translate("Pkt.");
                    if (!showCost) {
                        kosten = "";
                    }
                }

                text.append(BuildaHQ.anfang).append(o.getName()).append(kosten);
            }
        }

        return text.toString();
    }

    public void setMaxAmount(int value) {
        this.maxAmount = value;
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
                myUpgrades.elementAt(i).toggle();
            } else {
            	myUpgrades.elementAt(i).setSelected(false);
            }
        }
    }

    public void deleteYourself() {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).isSelected()) {
                if (myUpgrades.elementAt(i).isUnique() || myUpgrades.elementAt(i).isRelic()) {
                    myUpgrades.elementAt(i).toggle();
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

    void enableRelics() {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).isRelic()) {
                myUpgrades.elementAt(i).setAktiv(true);
            }
        }
    }

    void disableOtherRelics(OptionsButtonUpgrade obu) {
        for (int i = 0; i < myUpgrades.size(); ++i) {
            if (myUpgrades.elementAt(i).isRelic()) {
                myUpgrades.elementAt(i).setAktiv(obu.equals(myUpgrades.elementAt(i)));
            }
        }
    }

}