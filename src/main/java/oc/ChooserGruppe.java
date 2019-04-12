package oc;

import static oc.RefreshListener.addRefreshListener;
import static oc.RefreshListener.Priority.CHOOSER_GRUPPE;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ChooserGruppe extends BuildaPanel {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChooserGruppe.class);

    int kategorie;
    String reflectionKennung;
    String allyString = "";
    Object[] statischeEinträge;
    Object[] alleEinträge;
    JLabel Lueberschrift = new JLabel("");
    JPanel chooserPanel = new JPanel(null, true);
    Vector<Chooser> mC = new Vector<Chooser>();
    int maxAnzahl = 0;
    int minAnzahl = 0;
    BuildaVater buildaVater;
    Vector<String> spezialEinträge = new Vector<String>(); // wenn 2 Waaghbosse, werden auch 2 mal "Garbgosse" hinzugefügt, und erst wenn beide waaghbosse abgewählt werden sind beide "Garbgosse" Stirngs aus dem Vector draussen.
    ActionListener cloneListener = new ActionListener() {
        @Override
		public void actionPerformed(ActionEvent event) {
            final Object source = event.getSource();

            for (int i = 0; i < mC.size(); ++i) { // zum rausfinden von welchem chooser der Button stammt
                if (mC.elementAt(i).getCloneButton() == source) {
                    erstelleEintrag(mC.elementAt(i).getComboBox().getSelectedObjects()[0] + SAVETEXT_UEBERSCHRIFTTRENNER1 + mC.elementAt(i).getEintrag().getSaveText(SAVETEXT_TRENNER2), i);
                    break;
                }
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
        adden(c);
        überschriftLabelSetzen();

        addRefreshListener(CHOOSER_GRUPPE, () -> {
            chooserLocationCheck();
            überschriftLabelSetzen();
            panel.repaint(); // damit es keine überlappenden Einträge beim Eintrags-Wechsel gibt, wenn beide genau gleichgroß sind. Also wichtig!!
        });

        BuildaHQ.registerNewChooserGruppe(this, kategorie);
    }

    public Vector<Chooser> getmC() {
        //LOGGER.info("ChooserGruppe-getmC");
        return mC;
    }

    public void setmC(Vector<Chooser> mC) {
        //LOGGER.info("ChooserGruppe-setmC");
        this.mC = mC;
    }

    public double getAnzahl(boolean includeMinIgnoreUnits, boolean includeMaxIgnoreUnits) {
        //LOGGER.info("ChooserGruppe-getAnzahl");
        if (kategorie == 6) return mC.size() - 1;

        double anzahl = 0;

        for (int i = 0; i < mC.size(); ++i) {
            final Eintrag entry = mC.elementAt(i).getEintrag();
            if (entry == null) continue; // step over empty entries

            if (!includeMaxIgnoreUnits || !includeMinIgnoreUnits) { // special treatment required?
                if (!includeMinIgnoreUnits) {
                    anzahl += (entry.isCountToMinimum() ? entry.getEintragsCNT() : 0);
                }
                if (!includeMaxIgnoreUnits) {
                    anzahl += (entry.isCountToMaximum() ? entry.getEintragsCNT() : 0);
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

    public int getKategorie() {
//		LOGGER.info("ChooserGruppe-getKategorie");
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

    public void refreshAllEntries() {
        //LOGGER.info("ChooserGruppe-refreshAllEntries");
        for (int i = 0; i < mC.size(); i++) {
            if (mC.get(i).getEintrag() == null) continue;
            mC.get(i).getEintrag().refreshen();
        }
    }

    public void changeComboBoxAuswahlen(String s[]) {
        spezialEinträge.clear();
        statischeEinträge = s;
        alleEinträge = s;
        aktualisiereComboBoxAuswahlen();
    }

    public void removeComboBoxAuswahl(String s) {
        int remCount = 0;
        for (int i = 0; i < statischeEinträge.length; i++) {
            if (statischeEinträge[i].equals(s)) {
                statischeEinträge[i] = "";
                remCount++;
            }
        }
        if (remCount > 0) {
            final String temp[] = new String[statischeEinträge.length - remCount];
            int addCnt = 1;
            temp[0] = "";
            for (int i = 1; i < statischeEinträge.length; i++) {
                if (!statischeEinträge[i].equals("")) {
                    temp[addCnt] = (String) statischeEinträge[i];
                    addCnt++;
                }
            }
            statischeEinträge = temp;
            alleEinträge = temp;
            aktualisiereComboBoxAuswahlen();
        }
    }

    public void addComboBoxAuswahl(String s) {
        for (int i = 0; i < statischeEinträge.length; i++) {
            if (statischeEinträge[i].equals(s)) {
                return;
            }
        }
        final String temp[] = new String[statischeEinträge.length + 1];
        for (int i = 0; i < statischeEinträge.length; i++) {
            temp[i] = (String) statischeEinträge[i];
        }
        temp[statischeEinträge.length] = s;
        statischeEinträge = temp;
        alleEinträge = temp;
        aktualisiereComboBoxAuswahlen();

    }

    public void aktualisiereComboBoxAuswahlen() {
//		LOGGER.info("ChooserGruppe-aktualisiereComboBoxAuswahlen");
        final Vector<Object> auswahlen = new Vector<Object>();

        for (int i = 0; i < statischeEinträge.length; ++i) {
            auswahlen.add(statischeEinträge[i]);
        }

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

    public String kategorieText() {
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

    public String getAnzahlText(boolean textErlaubt) {
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

    public void überschriftLabelSetzen() {
        final FontMetrics fm = Lueberschrift.getFontMetrics(Lueberschrift.getFont());
        final StringBuilder abstandshalter = new StringBuilder();

        final String punkteString = BuildaHQ.translate("Insgesamt") + " " + entferneNullNachkomma(getKosten()) + " " + BuildaHQ.translate("Punkte");
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
    public double getKosten() {
        return getKosten(true, true);
    }

    public double getKosten(boolean includeMinIgnoreUnits, boolean includeMaxIgnoreUnits) {
        double kosten = 0;

        for (int i = 0; i < mC.size(); ++i) {
            final Eintrag entry = mC.elementAt(i).getEintrag();
            if (entry == null) continue; // step over empty entries
            if (!includeMaxIgnoreUnits || !includeMinIgnoreUnits) { // special treatment required?
                if (!includeMinIgnoreUnits) {
                    kosten += (entry.isCountToMinimum() ? entry.getKosten() : 0);
                }
                if (!includeMaxIgnoreUnits) {
                    kosten += (entry.isCountToMaximum() ? entry.getKosten() : 0);
                }
            } else {
                kosten += entry.getKosten();
            }
        }
        return kosten;
    }

    public void chooserLocationCheck() {
        //LOGGER.info("ChooserGruppe-chooserLocationCheck");
        for (int i = 0; i < mC.size() - 1; ++i) {
            if (mC.elementAt(i).getComboBox().getSelectedObjects()[0].equals("")) {
                //LOGGER.info("ChooserGruppe-chooserLocationCheck - if 1");
                removen(i);
                --i;
            }
        }
        //LOGGER.info("ChooserGruppe-chooserLocationCheck - mC.size: "+mC.size());
        if (mC.size() == 0) {
            //LOGGER.info("ChooserGruppe-chooserLocationCheck - if 2");
            final Chooser c = new Chooser(buildaVater, randAbstand, 109, reflectionKennung, alleEinträge, kategorie, cloneListener);
            c.setStatischeEinträge(statischeEinträge);
            c.setSpezialEinträge(spezialEinträge);
            adden(c);
        } else if (!mC.lastElement().getComboBox().getSelectedObjects()[0].equals("")) {
            //LOGGER.info("ChooserGruppe-chooserLocationCheck - if 2");
            final Chooser c = new Chooser(buildaVater, randAbstand, 109, reflectionKennung, alleEinträge, kategorie, cloneListener);
            c.setStatischeEinträge(statischeEinträge);
            c.setSpezialEinträge(spezialEinträge);
            adden(c);
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

    public void adden(Chooser c) {
        //LOGGER.info("ChooserGruppe-adden Choser c");
        mC.addElement(c);
        chooserPanel.add(mC.lastElement().getPanel());
    }

    public void adden(Chooser c, int index) {
        //LOGGER.info("ChooserGruppe-adden Choser c int index");
        mC.add(index, c);
        chooserPanel.add(mC.elementAt(index).getPanel(), index);
    }

    public void removen(int i) {
        //LOGGER.info("ChooserGruppe-removen");
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

            text.append(allyPrefix + nächsterText);
        }

        if (leereGruppe) return "";
        return text.toString();
    }

    public String getSaveText() {
        //LOGGER.info("ChooserGruppe-getSaveText");
        final StringBuilder sammler = new StringBuilder();

        for (int i = 0; i < mC.size(); ++i) {
            if (!allyString.equals("") && mC.elementAt(i).selectedEntry().contains(allyString)) {

            } else {
                sammler.append(mC.elementAt(i).getComboBox().getSelectedObjects()[0] + SAVETEXT_UEBERSCHRIFTTRENNER1 + mC.elementAt(i).getSaveText(SAVETEXT_TRENNER2));
                sammler.append(SAVETEXT_TRENNER3);
            }
        }

        return sammler.toString();
    }

    public void load(String saveText) {
        //LOGGER.info("ChooserGruppe-load");
        final String[] splittet = saveText.split(SAVETEXT_TRENNER3);

        for (int i = 0; i < BuildaHQ.countStringsInString(saveText, SAVETEXT_TRENNER3); ++i) {
            erstelleEintrag(splittet[i], i);
        }
    }

    public void erstelleEintrag(String saveText, int index) {
        //LOGGER.info("ChooserGruppe-erstelleEintrag");
        final String klassenname = saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER1));

        if (mC.size() <= index + 1 || !(mC.elementAt(index + 1).getEintrag() instanceof LeererEintrag)) { // an der Stelle index+1 wird ein neuer chooser geaddet
            final Chooser c = new Chooser(buildaVater, randAbstand, 109, reflectionKennung, alleEinträge, kategorie, cloneListener);
            c.setStatischeEinträge(statischeEinträge);
            c.setSpezialEinträge(spezialEinträge);
            adden(c, index + 1);
        }

        final Chooser c = mC.elementAt(index + 1); // WICHTIG!!!!!!!!"!!  WENN MANS 2mal mit elementAt(index+1) geht NIX mehr!
        c.getComboBox().setSelectedItem(klassenname);
        c.load(saveText.substring(saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER1) + SAVETEXT_UEBERSCHRIFTTRENNER1.length(), saveText.length()), SAVETEXT_TRENNER2);

        RefreshListener.fireRefresh();  // für die setAktiv() dinger bei Bossen, Sergeants usw.    wichtig!
    }

    public void addUnit(String s) {
        mC.lastElement().selectEntry(s);
    }

    public void addUnitNotLocked(String s) {
        mC.lastElement().selectEntryNotLocked(s);
    }

    public void addUnitSemiLocked(String s) {
        mC.lastElement().aktualisierungIgnorieren = true;
        mC.lastElement().selectEntryNotLocked(s);
        mC.lastElement().removeEmptyEntry();
    }

    public void setUnitList(String[] units) {
        mC.lastElement().aktualisierungIgnorieren = true;
        mC.lastElement().changeEntries(units);
    }

    public void setReflectionKennung(String s) {
        reflectionKennung = s;
        for (int i = 0; i < mC.size(); i++) {
            mC.get(i).setReflectionKennung("CU");
        }
    }

    public double getPower() {
        return getPower(true, true);
    }

    public double getPower(boolean includeMinIgnoreUnits, boolean includeMaxIgnoreUnits) {
        double kosten = 0;

        for (int i = 0; i < mC.size(); ++i) {
            final Eintrag entry = mC.elementAt(i).getEintrag();
            if (entry == null) continue; // step over empty entries
            if (!includeMaxIgnoreUnits || !includeMinIgnoreUnits) { // special treatment required?
                if (!includeMinIgnoreUnits) {
                    kosten += (entry.isCountToMinimum() ? entry.getPower() : 0);
                }
                if (!includeMaxIgnoreUnits) {
                    kosten += (entry.isCountToMaximum() ? entry.getPower() : 0);
                }
            } else {
                kosten += entry.getPower();
            }
        }
        return kosten;
    }

}
