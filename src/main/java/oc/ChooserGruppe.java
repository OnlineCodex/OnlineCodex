package oc;

import static oc.RefreshListener.addRefreshListener;
import static oc.RefreshListener.Priority.CHOOSER_GRUPPE;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChooserGruppe extends BuildaPanel {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChooserGruppe.class);

    private int kategorie;
    private String reflectionKennung;
    public String allyString = "";
    private Object[] statischeEinträge;
    Object[] alleEinträge;
    private JLabel Lueberschrift = new JLabel("");
    private JPanel chooserPanel = new JPanel(null, true);
    public Vector<Chooser> mC = new Vector<>();
    int maxAnzahl = 0;
    int minAnzahl = 0;
    private BuildaVater buildaVater;
    private Vector<String> spezialEinträge = new Vector<>(); // wenn 2 Waaghbosse, werden auch 2 mal "Garbgosse" hinzugefügt, und erst wenn beide waaghbosse abgewählt werden sind beide "Garbgosse" Stirngs aus dem Vector draussen.
    private ActionListener cloneListener = event -> {
        final Object source = event.getSource();

        for (int i = 0; i < mC.size(); ++i) { // zum rausfinden von welchem chooser der Button stammt
            if (mC.elementAt(i).getCloneButton() == source) {
                erstelleEintrag(mC.elementAt(i).getComboBox().getSelectedObjects()[0] + SAVETEXT_UEBERSCHRIFTTRENNER1 + mC.elementAt(i).getEintrag().getSaveText(SAVETEXT_TRENNER2), i);
                break;
            }
        }
    };

    public ChooserGruppe(BuildaVater bv, String reflectionKennung, int lX, int lY, int kategorie, Object[] statischeEinträge) {
        //LOGGER.info("ChooserGruppe-Konstruktor");
        this.buildaVater = bv;
        this.kategorie = kategorie;
        this.reflectionKennung = reflectionKennung;
        this.statischeEinträge = statischeEinträge;
        this.alleEinträge = statischeEinträge;
        panel.setBounds(lX, lY + 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
        panel.add(Lueberschrift);

        Lueberschrift.setFont(new Font("arial", Font.BOLD, 12));
        Lueberschrift.setBounds(randAbstand, randAbstand, auswahlBreite + (randAbstand * 3), 20);

        chooserPanel.setBounds(0, lY + 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y - 25);  // +30 -30 is halt der BuildaHQ.abstand
        chooserPanel.setBackground(Color.WHITE);
        panel.add(chooserPanel);

        final Chooser c = new Chooser(buildaVater, randAbstand, randAbstand, reflectionKennung, alleEinträge, kategorie, cloneListener);
        c.setStatischeEinträge(statischeEinträge);
        c.setSpezialEinträge(spezialEinträge);
        add(c);
        überschriftLabelSetzen();

        addRefreshListener(CHOOSER_GRUPPE, () -> {
            chooserLocationCheck();
            überschriftLabelSetzen();
            panel.repaint(); // damit es keine überlappenden Einträge beim Eintrags-Wechsel gibt, wenn beide genau gleichgroß sind. Also wichtig!!
        });

        BuildaHQ.registerNewChooserGruppe(this, kategorie);
    }

    Vector<Chooser> getmC() {
        return mC;
    }

    public double getAnzahl(boolean includeMinIgnoreUnits, boolean includeMaxIgnoreUnits) {
        if (kategorie == 6) return mC.size() - 1;

        double anzahl = 0;

        for (int i = 0; i < mC.size(); ++i) {
            final Eintrag entry = mC.elementAt(i).getEintrag();
            if (entry == null) continue; // step over empty entries

            if (!includeMaxIgnoreUnits || !includeMinIgnoreUnits) { // special treatment required?
                if (!includeMinIgnoreUnits) {
                    anzahl += (entry.getEintragsCNT());
                }
                if (!includeMaxIgnoreUnits) {
                    anzahl += (entry.getEintragsCNT());
                }
            } else {
                anzahl += entry.getEintragsCNT();
            }
        }

        return anzahl;
    }

    public double getAnzahl() {
        return getAnzahl(true, true);
    }

    int getKategorie() {
        return this.kategorie;
    }

    @Override
    public JPanel getPanel() {
        //LOGGER.info("ChooserGruppe-getPanel");
        return this.panel;
    }

    public void addSpezialAuswahl(String s) {
        //LOGGER.info("ChooserGruppe-addSpezialAuswahl");
        try {
            //LOGGER.info(Thread.currentThread().getStackTrace().length);
            //String volk = Thread.currentThread().getStackTrace()[2].getClassName().toString().split("\\.")[3];
            //LOGGER.info(volk);

            if (!spezialEinträge.contains(s)) spezialEinträge.addElement(s);
            aktualisiereComboBoxAuswahlen();


        } catch (final ArrayIndexOutOfBoundsException e) {
            LOGGER.error("", e);
        }
    }

    public void removeSpezialAuswahl(String s) {
        //LOGGER.info("ChooserGruppe-removeSpezialAuswahl");

        for (int i = 0; i < spezialEinträge.size(); ++i) {
            if (spezialEinträge.elementAt(i).equals(s)) {
                spezialEinträge.remove(i);
                break; // nur ein String wird gelöscht! es wurde ja auch nur ein Vatereintrag geschlossen!
            }
        }


        aktualisiereComboBoxAuswahlen();
    }

    void refreshAllEntries() {
        for (Chooser chooser : mC) {
            if (chooser.getEintrag() == null) continue;
            chooser.getEintrag().refreshen();
        }
    }

    public void changeComboBoxAuswahlen(String s[]) {
        spezialEinträge.clear();
        statischeEinträge = s;
        alleEinträge = s;
        aktualisiereComboBoxAuswahlen();
    }

    private void aktualisiereComboBoxAuswahlen() {
        final Vector<Object> auswahlen = new Vector<>();

        Collections.addAll(auswahlen, statischeEinträge);

        if (spezialEinträge.size() != 0) {
            for (int i = 0; i < spezialEinträge.size(); ++i) {
                if (!auswahlen.contains(spezialEinträge.elementAt(i))) {
                    auswahlen.add(spezialEinträge.elementAt(i));
                }
            }
        }

        alleEinträge = auswahlen.toArray();

        // aktualisiert die Auswahlen von allen Choosern, die es bereits gibt.
        for (int i = 0; i < mC.size(); ++i) {
            if (!mC.elementAt(i).aktualisierungIgnorieren) { //Für spezielle Formations-Einträge dürfen Änderungen nicht zurückgesetzt werden.
                mC.elementAt(i).setAuswahlen(auswahlen);
            }
        }
    }

    String kategorieText() {
        //LOGGER.info("ChooserGruppe-kategorieText");
        if (getAnzahl() < 2) {
            if (BuildaHQ.getSprache() == Sprache.German) {
                return gerSg[kategorie];
            } else {
                return engSg[kategorie];
            }
        } else {
            if (BuildaHQ.getSprache() == Sprache.German) {
                return gerPl[kategorie];
            } else {
                return engPl[kategorie];
            }
        }
    }

    String getAnzahlText(boolean textErlaubt) {
        //LOGGER.info("ChooserGruppe-getAnzahlText");
        double anzahl = getAnzahl();

        if (anzahl <= 0 && textErlaubt) {
            if (BuildaHQ.getSprache() == Sprache.German) {
                return gerNullText[kategorie];
            } else {
                return engNullText[kategorie];
            }
        } else { // returnt die anzahl ohne .0   aber mit .5
        	Double double1 = Math.floor(anzahl);
            final int letzteGanzzahl = double1.intValue();
            final double diff = anzahl - letzteGanzzahl;

            // Floating point Ungenauigkeit umgehen - aber nur fuer Werte die sehr
            // nahe an der naechsten Ganzzahl sind, damit sowas wie 0.5 weiterhin
            // moeglich ist.
            if (diff > 0.9) {
                anzahl = Math.ceil(anzahl);
            } else if (diff < 0.1) {
                anzahl = Math.floor(anzahl);
            }

            if (anzahl == ((int) anzahl)) {
                return String.valueOf((int) anzahl);
            } else {
                return String.valueOf(anzahl).replace(".", ",");
            }
        }
    }

    void überschriftLabelSetzen() {
        final FontMetrics fm = Lueberschrift.getFontMetrics(Lueberschrift.getFont());
        final StringBuilder abstandshalter = new StringBuilder();

        final String punkteString = BuildaHQ.translate("Insgesamt") + " " + ((int) getCost()) + " " + BuildaHQ.translate("Punkte");
        final String kategorieString = " " + getAnzahlText(true) + " " + kategorieText() + " (" + minAnzahl + "-" + maxAnzahl + ")";

        final int cnt = (Lueberschrift.getSize().width - (fm.stringWidth(kategorieString + punkteString) + 30)) / fm.stringWidth(" ");

        for (int i = 0; i < cnt; ++i) {
            abstandshalter.append(" ");
        }

        Lueberschrift.setText(kategorieString + abstandshalter.toString() + punkteString);

        if (getAnzahl(true, false) > maxAnzahl
                || getAnzahl(false, true) < minAnzahl) {
            Lueberschrift.setForeground(Color.RED);
        } else {
            Lueberschrift.setForeground(Color.BLACK);
        }
    }

    @Override
    public double getCost() {
        double kosten = 0;

        for (int i = 0; i < mC.size(); ++i) {
            final Eintrag entry = mC.elementAt(i).getEintrag();
            if (entry == null) continue; // step over empty entries
            kosten += entry.getCost();
        }
        return kosten;
    }

    private void chooserLocationCheck() {
        for (int i = 0; i < mC.size() - 1; ++i) {
            if (mC.elementAt(i).getComboBox().getSelectedObjects()[0].equals("")) {
                remove(i);
                --i;
            }
        }
        if (mC.size() == 0) {
            final Chooser c = new Chooser(buildaVater, randAbstand, 109, reflectionKennung, alleEinträge, kategorie, cloneListener);
            c.setStatischeEinträge(statischeEinträge);
            c.setSpezialEinträge(spezialEinträge);
            add(c);
        } else if (!mC.lastElement().getComboBox().getSelectedObjects()[0].equals("")) {
            final Chooser c = new Chooser(buildaVater, randAbstand, 109, reflectionKennung, alleEinträge, kategorie, cloneListener);
            c.setStatischeEinträge(statischeEinträge);
            c.setSpezialEinträge(spezialEinträge);
            add(c);
        }

        for (int i = 0; i < mC.size(); ++i) {
            int höhe = randAbstand;

            for (int e = 0; e < i; ++e) {
                höhe += mC.elementAt(e).getPanel().getSize().height + randAbstand;
            }

            mC.elementAt(i).getPanel().setLocation(randAbstand, höhe);
        }

        überschriftLabelSetzen();
    }

    public void add(Chooser c) {
        mC.addElement(c);
        chooserPanel.add(mC.lastElement().getPanel());
    }

    public void add(Chooser c, int index) {
        mC.add(index, c);
        chooserPanel.add(mC.elementAt(index).getPanel(), index);
    }

    public void remove(int i) {
        mC.remove(i);
        chooserPanel.remove(i);
    }

    public String getText() {
        StringBuilder text;
        final String sterne = BuildaHQ.sterneAnzeigen ? "***************  " : "";

        if (BuildaHQ.kurzerText) {
            text = new StringBuilder(BuildaHQ.formatierItalic(sterne + getAnzahlText(true) + " " + kategorieText() + " " + sterne) + ZEILENUMBRUCH);
        } else {
            text = new StringBuilder(ZEILENUMBRUCH + BuildaHQ.formatierItalic(sterne + getAnzahlText(true) + " " + kategorieText() + "  " + sterne) + ZEILENUMBRUCH + ZEILENUMBRUCH);
        }

        boolean leereGruppe = true;

        for (int i = 0; i < mC.size(); ++i) {
            final String nächsterText = mC.elementAt(i).getText();
            final String allyPrefix = "";

            if (!nächsterText.equals("")) {
                leereGruppe = false;
            }

            text.append(allyPrefix).append(nächsterText);
        }

        if (leereGruppe) return "";
        return text.toString();
    }

    public void load(String saveText) {
        final String[] splittet = saveText.split(SAVETEXT_TRENNER3);

        for (int i = 0; i < BuildaHQ.countStringsInString(saveText, SAVETEXT_TRENNER3); ++i) {
            erstelleEintrag(splittet[i], i);
        }
    }

    private void erstelleEintrag(String saveText, int index) {
        final String klassenname = saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER1));

        if (mC.size() <= index + 1 || !(mC.elementAt(index + 1).getEintrag() instanceof LeererEintrag)) { // an der Stelle index+1 wird ein neuer chooser geaddet
            final Chooser c = new Chooser(buildaVater, randAbstand, 109, reflectionKennung, alleEinträge, kategorie, cloneListener);
            c.setStatischeEinträge(statischeEinträge);
            c.setSpezialEinträge(spezialEinträge);
            add(c, index + 1);
        }

        final Chooser c = mC.elementAt(index + 1); // WICHTIG!!!!!!!!"!!  WENN MANS 2mal mit elementAt(index+1) geht NIX mehr!
        c.getComboBox().setSelectedItem(klassenname);
        c.load(saveText.substring(saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER1) + SAVETEXT_UEBERSCHRIFTTRENNER1.length()), SAVETEXT_TRENNER2);

        RefreshListener.fireRefresh();  // für die setActive() dinger bei Bossen, Sergeants usw.    wichtig!
    }

    public double getPower() {
        double kosten = 0;

        for (int i = 0; i < mC.size(); ++i) {
            final Eintrag entry = mC.elementAt(i).getEintrag();
            if (entry == null) continue; // step over empty entries
            kosten += entry.getPower();
        }
        return kosten;
    }

}
