package oc;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionsZaehlerGruppe extends OptionsVater {

    private Vector<OptionsButtonZaehler> myZaehlers = new Vector<OptionsButtonZaehler>();
    private int maxAnzahl;
    private boolean mitMausradVeraenderbar = true;
    private boolean aktiv = true;
    private boolean erhoehbar = true;
    private boolean maxPunkteGruppe = false;
    private int maxKosten;

    public OptionsZaehlerGruppe(int ID, int lX, int lY, String verzierung, Vector<OptionsGruppeEintrag> e) {
        panel.setLocation(lX, lY);
        this.maxAnzahl = -88;

        for (int i = 0; i < e.size(); ++i) {
            myZaehlers.addElement(new OptionsButtonZaehler(ID, 0, i * (buttonAbstandY + buttonHoehe), verzierung + " gruppe", e.elementAt(i), maxAnzahl));
            panel.add(myZaehlers.lastElement().getPanel());
            myZaehlers.lastElement().getButton().addMouseListener(this);

            if (e.elementAt(i).getKurzerName() != null) {
                myZaehlers.lastElement().setKurzerName(e.elementAt(i).getKurzerName());
            }
        }

        panel.setSize(myZaehlers.elementAt(0).getBreite(), myZaehlers.size() * (myZaehlers.elementAt(0).getHeight()));
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public OptionsZaehlerGruppe(int ID, int lX, int lY, String verzierung, Vector e, int maxAnzahl) {
        myZaehlers = new Vector();
        mitMausradVeraenderbar = true;
        aktiv = true;
        erhoehbar = true;
        panel.setLocation(lX, lY);
        this.maxAnzahl = maxAnzahl;
        for (int i = 0; i < e.size(); i++) {
            myZaehlers.addElement(new OptionsButtonZaehler(ID, 0, i * 20, (new StringBuilder(String.valueOf(verzierung))).append(" gruppe").toString(), (OptionsGruppeEintrag) e.elementAt(i), maxAnzahl));
            panel.add(myZaehlers.lastElement().getPanel());
            myZaehlers.lastElement().getButton().addMouseListener(this);
            if (((OptionsGruppeEintrag) e.elementAt(i)).getKurzerName() != null) {
                myZaehlers.lastElement().setKurzerName(((OptionsGruppeEintrag) e.elementAt(i)).getKurzerName());
            }
        }

        panel.setSize(myZaehlers.elementAt(0).getBreite(), myZaehlers.size() * myZaehlers.elementAt(0).getHeight());
    }

    public void setMaxKosten(int maxKosten) {
        if (maxKosten <= 0) maxPunkteGruppe = false;
        else maxPunkteGruppe = true;
        this.maxKosten = maxKosten;
    }

    public int getMaxAnzahl() {
        return this.maxAnzahl;
    }

    public void setMaxAnzahl(int max) {
        maxAnzahl = max;

        for (int i = 0; i < myZaehlers.size(); ++i) {
            myZaehlers.elementAt(i).setMaxAnzahl(max);
        }

        if (getAnzahl() > maxAnzahl) {
            for (int i = 0; i < myZaehlers.size(); ++i) {
                myZaehlers.elementAt(i).setAnzahl(0);
            }
        }

        fontKontrolle();
    }

    public void setmitMausradVeraenderbar(boolean b) {
        this.mitMausradVeraenderbar = b;
    }

    public void setErhoehbar(boolean b) {
        this.erhoehbar = b;
    }

    public int getAnzahl(String name) {
        for (int i = 0; i < myZaehlers.size(); ++i) {
            if (myZaehlers.elementAt(i).getName().equals(name)) {
                return myZaehlers.elementAt(i).getAnzahl();
            }
        }
        return 0;
    }

    public int getAnzahl(int index) {
        return myZaehlers.elementAt(index).getAnzahl();
    }

    public int getAnzahl() {
        int cnt = 0;
        for (int i = 0; i < myZaehlers.size(); ++i) {
            cnt += myZaehlers.elementAt(i).getAnzahl();
        }
        return cnt;
    }

    public boolean isSelected(String s) {
        for (int i = 0; i < myZaehlers.size(); ++i) {
            if (myZaehlers.elementAt(i).getName().equals(s)) {
                return myZaehlers.elementAt(i).getAnzahl() > 0;
            }
        }
        return false;
    }

    public void setAnzahl(int index, int count) {
        myZaehlers.get(index).setAnzahl(count);
    }

    @Override
	public double getCost() {
        int kosten = 0;

        for (int i = 0; i < myZaehlers.size(); ++i) {
            kosten += myZaehlers.elementAt(i).getCost();
        }

        return kosten * modelle;
    }

    public void setButtonMaxAnzahl(int max) {
        for (int i = 0; i < myZaehlers.size(); ++i) {
            myZaehlers.elementAt(i).setMaxAnzahl(max);
        }
    }

    public void setButtonMaxAnzahl(String name, int max) {
        for (int i = 0; i < myZaehlers.size(); ++i) {
            if (myZaehlers.elementAt(i).getName().equals(name)) {
                myZaehlers.elementAt(i).setMaxAnzahl(max); // da kein controll wirds nicht innehalb vcom Button kontrolliert ob max kleiner ist als anzahl
                if (myZaehlers.elementAt(i).getAnzahl() > max) {
                    myZaehlers.elementAt(i).setAnzahl(0);
                }
            }
        }
    }

    public void setPreis(String name, double preis) {
        for (int i = 0; i < myZaehlers.size(); ++i) {
            if (myZaehlers.elementAt(i).getName().equals(name)) {
                myZaehlers.elementAt(i).setCost(preis);
            }
        }
    }

    @Override
	public void setHeadline(String s) {  // genauso wie in upgradeGruppe....
        final JLabel label = new JLabel(s);
        label.setBounds(20, 0, buttonBreite + 30, 20);
        label.setFont(new Font("Lucida Blackletter", Font.BOLD, 16));
        panel.add(label);

        for (int i = 0; i < myZaehlers.size(); ++i) {
            final JPanel p = myZaehlers.elementAt(i).panel;
            p.setLocation((int) p.getLocation().getX(), (int) p.getLocation().getY() + headlineAbstand);
        }

        this.panel.setSize(this.panel.getSize().width, this.panel.getSize().height + headlineAbstand);
    }

    public void setLegal(String name, boolean b) {
        for (int i = 0; i < myZaehlers.size(); ++i) {
            if (myZaehlers.elementAt(i).getName().equals(name)) {
                myZaehlers.elementAt(i).setLegal(b);
            }
        }
    }

    @Override
	public boolean isLegal() {
        return myZaehlers.elementAt(0).isLegal();
    }  // MIT ÄNDERN WENN LEGAL GEÄNDERT WIRD!!

    @Override
	public void setLegal(boolean b) {
        for (int i = 0; i < myZaehlers.size(); ++i) {
            myZaehlers.elementAt(i).setLegal(b);
        }
    }

    public void setAktiv(boolean b) {
        aktiv = b;
        for (int i = 0; i < myZaehlers.size(); ++i) {
            myZaehlers.elementAt(i).setAktiv(b);
        }
    }

    public void setAktiv(String name, boolean b) {
        for (int i = 0; i < myZaehlers.size(); ++i) {
            if (myZaehlers.elementAt(i).getName().equals(name)) {
                myZaehlers.elementAt(i).setAktiv(b);
            }
        }
    }

    public void setAktiv(int i, boolean b) {
        myZaehlers.elementAt(i).setAktiv(b);
    }

    @Override
	public void mouseReleased(MouseEvent event) {
        if (!aktiv) return;

        OptionsButtonZaehler button = null;

        for (int i = 0; i < myZaehlers.size(); ++i) {
            if (myZaehlers.elementAt(i).getButton().getText().equals(((JButton) event.getSource()).getText())) {
                button = myZaehlers.elementAt(i);
                break;
            }
        }

        if (event.getButton() == MouseEvent.BUTTON1) {
            if (erhoehbar && getAnzahl() < maxAnzahl && button.getAnzahl() < button.getMaxAnzahl() || maxAnzahl == -88) {
                if (!maxPunkteGruppe || (button.getPreisAuchOhneSelected() + getCost() <= maxKosten)) {
                    button.erhoeheAnzahl();
                    fontKontrolle();
                }
            }
        } else if (event.getButton() == MouseEvent.BUTTON2 && mitMausradVeraenderbar) {
            if (button.getAnzahl() == button.getMaxAnzahl() || this.maxAnzahl == this.getAnzahl() && maxAnzahl != -88) {
                button.feuerLeermachen();
            } else if (erhoehbar && maxAnzahl != -88) {
                final int thisDifferenz = this.maxAnzahl - this.getAnzahl();
                final int buttonDifferenz = button.getMaxAnzahl() - button.getAnzahl();
                if (thisDifferenz < buttonDifferenz) {
                    button.feuerVollmachen(thisDifferenz);
                } else {
                    button.feuerVollmachen();
                }
            } else {
                button.feuerLeermachen();
            }

            fontKontrolle();
        } else if (event.getButton() == MouseEvent.BUTTON3) {
            if (button.getAnzahl() > 0) {
                button.verminderAnzahl();
                fontKontrolle();
            }
        }

        RefreshListener.fireRefresh();
    }

    public void fontKontrolle() {
        int italicNumber = 0;   // wenss 0 bleibt isses plain oda bold anstatt italic oda bold+italic

        if (getAnzahl() == maxAnzahl) {
            italicNumber = Font.ITALIC;
        }

        for (int i = 0; i < myZaehlers.size(); ++i) {
            if (myZaehlers.elementAt(i).getAnzahl() > 0) {
                myZaehlers.elementAt(i).fontSetzen(Font.BOLD + italicNumber);
            } else {
                myZaehlers.elementAt(i).fontSetzen(italicNumber);
            }
        }
    }

    @Override
	public boolean isSelected() {
        return getAnzahl() > 0;
    }

    @Override
	public String getText() {
        if (!aktiv) return "";

        final StringBuilder text = new StringBuilder();

        for (int i = 0; i < myZaehlers.size(); ++i) {
            final OptionsButtonZaehler o = myZaehlers.elementAt(i);
            if (o.getAnzahl() > 0) {
                text.append(BuildaHQ.abstand);
                String kosten = "";

                if (BuildaHQ.allePunktkosten) {
                    kosten = punkteAbstandHalter + ((int) (o.getCost() * modelle)) + " " + BuildaHQ.translate("Pkt.");
                }

                text.append(BuildaHQ.anfang).append(o.getAnzahl()).append(" x ").append(o.getName()).append(kosten);
            }
        }

        return text.toString();
    }

    @Override
	public String getSaveText() {
        final StringBuilder s = new StringBuilder();

        for (int i = 0; i < myZaehlers.size(); ++i) {
            s.append(String.valueOf(myZaehlers.elementAt(i).getRealAnzahl())); // realAnzahl wird nicht von aktiv behindert
            s.append(SAVETEXT_TRENNER1);
        }

        return s.toString();
    }

    @Override
	public void load(String s) {
        final String[] splittet = s.split(SAVETEXT_TRENNER1);

        for (int i = 0; i < myZaehlers.size(); ++i) {
            myZaehlers.elementAt(i).setAnzahl(Integer.parseInt(splittet[i]));
        }

        fontKontrolle();
    }
}
