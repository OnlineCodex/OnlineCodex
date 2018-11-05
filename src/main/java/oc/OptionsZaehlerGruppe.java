package oc;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Vector;

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

        panel.setSize(myZaehlers.elementAt(0).getBreite(), myZaehlers.size() * (myZaehlers.elementAt(0).getHoehe()));
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
            panel.add(((OptionsButtonZaehler) myZaehlers.lastElement()).getPanel());
            ((OptionsButtonZaehler) myZaehlers.lastElement()).getButton().addMouseListener(this);
            if (((OptionsGruppeEintrag) e.elementAt(i)).getKurzerName() != null) {
                ((OptionsButtonZaehler) myZaehlers.lastElement()).setKurzerName(((OptionsGruppeEintrag) e.elementAt(i)).getKurzerName());
            }
        }

        panel.setSize(((OptionsButtonZaehler) myZaehlers.elementAt(0)).getBreite(), myZaehlers.size() * ((OptionsButtonZaehler) myZaehlers.elementAt(0)).getHoehe());
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

    public double getKosten() {
        int kosten = 0;

        for (int i = 0; i < myZaehlers.size(); ++i) {
            kosten += myZaehlers.elementAt(i).getKosten();
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
                myZaehlers.elementAt(i).setPreis(preis);
            }
        }
    }

    public void setHeadline(String s) {  // genauso wie in upgradeGruppe....
        JLabel label = new JLabel(s);
        label.setBounds(20, 0, buttonBreite + 30, 20);
        label.setFont(new Font("Lucida Blackletter", Font.BOLD, 16));
        panel.add(label);

        for (int i = 0; i < myZaehlers.size(); ++i) {
            JPanel p = myZaehlers.elementAt(i).panel;
            p.setLocation((int) p.getLocation().getX(), (int) p.getLocation().getY() + headlineAbstand);
        }

        this.panel.setSize(this.panel.getSize().width, this.panel.getSize().height + headlineAbstand);
    }

    public String getLabel() {
        StringBuilder b = new StringBuilder();

        for (int i = 0; i < myZaehlers.size(); ++i) {
            if (myZaehlers.elementAt(i).getAnzahl() > 0) {
                b.append(myZaehlers.elementAt(i).getButton().getText() + ZEILENUMBRUCH);
            }
        }

        return b.toString();
    }

    public void setLegal(String name, boolean b) {
        for (int i = 0; i < myZaehlers.size(); ++i) {
            if (myZaehlers.elementAt(i).getName().equals(name)) {
                myZaehlers.elementAt(i).setLegal(b);
            }
        }
    }

    public boolean isLegal() {
        return myZaehlers.elementAt(0).isLegal();
    }  // MIT ÄNDERN WENN LEGAL GEÄNDERT WIRD!!

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
                if (!maxPunkteGruppe || (button.getPreisAuchOhneSelected() + getKosten() <= maxKosten)) {
                    button.erhoeheAnzahl();
                    fontKontrolle();
                }
            }
        } else if (event.getButton() == MouseEvent.BUTTON2 && mitMausradVeraenderbar) {
            if (button.getAnzahl() == button.getMaxAnzahl() || this.maxAnzahl == this.getAnzahl() && maxAnzahl != -88) {
                button.feuerLeermachen();
            } else if (erhoehbar && maxAnzahl != -88) {
                int thisDifferenz = this.maxAnzahl - this.getAnzahl();
                int buttonDifferenz = button.getMaxAnzahl() - button.getAnzahl();
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

    public boolean isSelected() {
        return getAnzahl() > 0;
    }

    public String getText() {
        if (!aktiv) return "";

        StringBuilder text = new StringBuilder();

        for (int i = 0; i < myZaehlers.size(); ++i) {
            OptionsButtonZaehler o = myZaehlers.elementAt(i);
            if (o.getAnzahl() > 0) {
                text.append(BuildaHQ.abstand);
                String kosten = "";

                if (BuildaHQ.allePunktkosten) {
                    kosten = punkteAbstandHalter + entferneNullNachkomma((o.getKosten() * modelle)) + " " + BuildaHQ.translate("Pkt.");
//					if (o.getKosten() * modelle == 0) {
//						kosten = punkteAbstandHalter + BuildaHQ.translate("kostenlos");
//					}
                }

                text.append(BuildaHQ.anfang + o.getAnzahl() + " x " + o.getName() + kosten);
            }
        }

        return text.toString();
    }

    public String getSaveText() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < myZaehlers.size(); ++i) {
            s.append(String.valueOf(myZaehlers.elementAt(i).getRealAnzahl())); // realAnzahl wird nicht von aktiv behindert
            s.append(SAVETEXT_TRENNER1);
        }

        return s.toString();
    }

    public Element getSaveElement() {
        Element root = BuildaHQ.getNewXMLElement("CounterGroup");

        for (int i = 0; i < myZaehlers.size(); i++) {
            if (myZaehlers.get(i).getAnzahl() > 0) {
                Element e = BuildaHQ.getNewXMLElement("Counter");
                e.setAttribute("selection", Integer.toString(i));
                e.setAttribute("number", Integer.toString(myZaehlers.elementAt(i).getRealAnzahl()));

                root.appendChild(e);
            }
        }

        return root;
    }

    public void load(String s) {
        String[] splittet = s.split(SAVETEXT_TRENNER1);

        for (int i = 0; i < myZaehlers.size(); ++i) {
            myZaehlers.elementAt(i).setAnzahl(Integer.parseInt(splittet[i]));
        }

        fontKontrolle();
    }

    public void loadElement(Element e) {
        NodeList children = e.getChildNodes();

        for (int i = 0; i < children.getLength(); ++i) {
            Element child = (Element) children.item(i);

            myZaehlers.get(Integer.parseInt(e.getAttribute("selection"))).setAnzahl(Integer.parseInt(child.getAttribute("number")));
        }
    }

}
