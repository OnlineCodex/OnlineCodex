package oc;

import java.awt.*;

public class OptionsButtonZaehler extends OptionsButton {

    private int anzahl = 0;
    private int maxAnzahl;
    private double syncPreis = 0;

    public OptionsButtonZaehler(int ID, int lX, int lY, String verzierung, String name, int maxAnzahl, double preis) {
        this.name = name;
        this.maxAnzahl = maxAnzahl;
        this.preis = preis;

        produceButton();
        setVerzierung(verzierung);

        panel.setLocation(lX, lY);
    }

    public OptionsButtonZaehler(int ID, int lX, int lY, String verzierung, OptionsGruppeEintrag e, int maxAnzahl) {
        this.syncPreis = e.getSyncPreis();
        this.name = e.getName();
        this.preis = e.getPreis();
        this.maxAnzahl = maxAnzahl;

        produceButton();
        setVerzierung(verzierung);

        panel.setLocation(lX, lY);
    }

    public double getKosten() {
        if (!aktiv || preis == -88) {
            return 0;
        }

        if (syncPreis != 0 && anzahl == 2) {
            return syncPreis;
        }

        return anzahl * preis;
    }

    public int getAnzahl() {
        if (aktiv) {
            return this.anzahl;
        } else {
            return 0;
        }
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
        fontKontrolle();
        labelSetzen();
    }

    public int getRealAnzahl() { // einfach die Variable. Wichtig für clon- und speicherfunktion
        return this.anzahl;
    }

    public int getMaxAnzahl() {
        return this.maxAnzahl;
    }

    public void setMaxAnzahl(int maxAnzahl) {
        this.maxAnzahl = maxAnzahl;
        fontKontrolle();
        labelSetzen();
    }

    public void setControlledMaxAnzahl(int maxAnzahl) {
        this.maxAnzahl = maxAnzahl;

        if (this.anzahl > this.maxAnzahl || this.maxAnzahl == -88) {
            this.anzahl = 0;
        }

        fontKontrolle();
        labelSetzen();
    }

    public void erhoeheAnzahl() {
        if (aktiv) {
            ++anzahl;
            fontKontrolle();
            labelSetzen();
        }
    }

    public void verminderAnzahl() {
        if (aktiv) {
            --anzahl;
            fontKontrolle();
            labelSetzen();
        }
    }

    public void feuerErhoehen() {
        if (aktiv) {
            if (anzahl < maxAnzahl || maxAnzahl == -88) {
                ++anzahl;
                fontKontrolle();
                labelSetzen();
            }
        }
    }

    public void feuerVermindern() {
        if (aktiv) {
            if (anzahl > 0) {
                --anzahl;
                fontKontrolle();
                labelSetzen();
            }
        }
    }

    public void feuerVollmachen() {
        if (aktiv && maxAnzahl != -88) {
            anzahl = maxAnzahl;
            fontKontrolle();
            labelSetzen();
        }
    }

    public void feuerVollmachen(int i) {
        if (aktiv) {
            anzahl += i;
            fontKontrolle();
            labelSetzen();
        }
    }

    public void feuerLeermachen() {
        if (aktiv) {
            anzahl = 0;
            fontKontrolle();
            labelSetzen();
        }
    }

    public void fontKontrolle() {
        if (maxAnzahl != -88) {
            int bold = (anzahl > 0 ? Font.BOLD : Font.PLAIN);

            if (anzahl == maxAnzahl && maxAnzahl != 0) {
                fontSetzen(bold + Font.ITALIC);
            } else if (anzahl == 0 && maxAnzahl == 0) {
                fontSetzen(Font.ITALIC);
            } else {
                fontSetzen(bold + Font.PLAIN);
            }
        }
    }

    @Override
    public void labelSetzen() {
        FontMetrics fm = button.getFontMetrics(button.getFont());
        StringBuilder abstandshalter = new StringBuilder("");
        String punkteString = "";

//		if (preis == 0) {
//			punkteString = "kostenlos";
//		} else 
        if (preis == -88) {
            punkteString = "";
        } else if (jeweils) {
            punkteString = "jeweils" + " " + entferneNullNachkomma(preis) + " " + "Pkt.";
        } else {
            punkteString = entferneNullNachkomma(preis) + " " + "Pkt.";
        }

        int cnt = 0;
        if (maxAnzahl == -88) {
            cnt = (buttonBreite - (fm.stringWidth(anzahl + "  " + (kurzerName != null ? kurzerName : name) + punkteString) + 30)) / fm.stringWidth(" .");
        } else {
            cnt = (buttonBreite - (fm.stringWidth(anzahl + "/" + maxAnzahl + "  " + (kurzerName != null ? kurzerName : name) + punkteString) + 30)) / fm.stringWidth(" .");
        }
        for (int i = 0; i < cnt; ++i) {
            abstandshalter.append(" .");
        }
        if (maxAnzahl == -88) {
            button.setText(anzahl + "  " + (kurzerName != null ? kurzerName : name) + abstandshalter.toString() + punkteString);
        } else
            button.setText(anzahl + "/" + maxAnzahl + "  " + (kurzerName != null ? kurzerName : name) + abstandshalter.toString() + punkteString);
    }

}