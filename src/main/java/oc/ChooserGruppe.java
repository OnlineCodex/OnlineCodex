package oc;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.ToDoubleFunction;

import static java.util.stream.Collectors.toList;
import static oc.RefreshListener.Priority.CHOOSER_GRUPPE;
import static oc.RefreshListener.addRefreshListener;

public class ChooserGruppe extends BuildaPanel {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChooserGruppe.class);

    private int kategorie;
    private List<List<Class<? extends Eintrag>>> statischeEinträge;
    List<List<Class<? extends Eintrag>>> alleEinträge;
    private JLabel Lueberschrift = new JLabel("");
    private JPanel chooserPanel = new JPanel(null, true);
    List<Chooser> mC = new LinkedList<>();
    int maxAnzahl = 0;
    int minAnzahl = 0;
    private BuildaVater buildaVater;
    private List<Class<? extends Eintrag>> spezialEinträge = new LinkedList<>();
    // wenn 2 Waaghbosse, werden auch 2 mal "Garbgosse" hinzugefügt, und erst wenn beide waaghbosse abgewählt werden sind beide "Garbgosse" Stirngs aus dem Vector draussen.

    private void cloneEntry(ActionEvent event) {
        // TODO reimplement clone
        throw new UnsupportedOperationException("Can't clone entry. This feature will be restored sood.");
    };

    public ChooserGruppe(
            BuildaVater bv, String reflectionKennung,
            int lX, int lY, int kategorie,
            List<List<Class<? extends Eintrag>>> statischeEinträge) {
        this.buildaVater = bv;
        this.kategorie = kategorie;
        this.statischeEinträge = statischeEinträge;
        this.alleEinträge = statischeEinträge;
        panel.setBounds(lX, lY + 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y);
        panel.add(Lueberschrift);

        Lueberschrift.setFont(new Font("arial", Font.BOLD, 12));
        Lueberschrift.setBounds(randAbstand, randAbstand, auswahlBreite + (randAbstand * 3), 20);

        chooserPanel.setBounds(0, lY + 25, auswahlBreite + (randAbstand * 3), CHOOSER_Y - 25);  // +30 -30 is halt der BuildaHQ.abstand
        chooserPanel.setBackground(Color.WHITE);
        panel.add(chooserPanel);

        Chooser c = new Chooser(buildaVater, randAbstand, randAbstand, alleEinträge, this::cloneEntry);
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

    public List<Chooser> getmC() {
        return mC;
    }

    public double getAnzahl() {
        if (kategorie == 6) {
            return mC.size() - 1;
        } else {
            return sumEintrag(Eintrag::getEintragsCNT);
        }
    }

    @Override
    public double getKosten() {
        return sumEintrag(Eintrag::getKosten);
    }

    public double getPower() {
        return sumEintrag(Eintrag::getPower);
    }

    private double sumEintrag(ToDoubleFunction<Eintrag> toDouble) {
        return mC.stream()
                .filter(Objects::nonNull)
                .map(Chooser::getEintrag)
                .filter(Objects::nonNull)
                .mapToDouble(toDouble)
                .sum();
    }


    public int getKategorie() {
        return this.kategorie;
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }

    public void addSpezialAuswahl(Class<? extends Eintrag> s) {
        try {
            if (!spezialEinträge.contains(s)) spezialEinträge.add(s);
            aktualisiereComboBoxAuswahlen();
        } catch (ArrayIndexOutOfBoundsException e) {
            LOGGER.error("", e);
        }
    }

    public void removeSpezialAuswahl(Class<? extends Eintrag> s) {
        spezialEinträge.remove(s);
        aktualisiereComboBoxAuswahlen();
    }

    public void refreshAllEntries() {
        for (int i = 0; i < mC.size(); i++) {
            if (mC.get(i).getEintrag() == null) continue;
            mC.get(i).getEintrag().refreshen();
        }
    }

    public void changeComboBoxAuswahlen(List<? extends List<Class<? extends Eintrag>>> s) {
        spezialEinträge.clear();
        statischeEinträge = Lists.newArrayList(s);
        alleEinträge = statischeEinträge;
        aktualisiereComboBoxAuswahlen();
    }

    @SuppressWarnings({
            "unchecked", "rawtypes", // generic Arrays are stupid
    })
    private void aktualisiereComboBoxAuswahlen() {
        List<Class<? extends Eintrag>> filteredSpecial = spezialEinträge.stream()
                .filter(e -> statischeEinträge.stream()
                        .anyMatch(grp -> grp.contains(e)))
                .collect(toList());

        List<List<Class<? extends Eintrag>>> auswahlen = ImmutableList.<List<Class<? extends Eintrag>>>builder()
                .addAll(statischeEinträge)
                .add(filteredSpecial)
                .build();

        alleEinträge = auswahlen;
        mC.forEach(c -> c.setAuswahlen(auswahlen));
    }

    String kategorieText() {
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
        double anzahl = getAnzahl();

        if (anzahl <= 0 && textErlaubt) {
            if (BuildaHQ.getSprache() == Sprache.German) {
                return gerNullText[kategorie];
            } else {
                return engNullText[kategorie];
            }
        } else {
            int letzteGanzzahl = new Double(Math.floor(anzahl)).intValue();
            double diff = anzahl - letzteGanzzahl;

            if (diff > 0.9) {
                anzahl = Math.ceil(anzahl);
            } else if (diff < 0.1) {
                anzahl = Math.floor(anzahl);
            }

            if (anzahl == (double) ((int) anzahl)) {
                return String.valueOf((int) anzahl);
            } else {
                return String.valueOf(anzahl).replace(".", ",");
            }
        }
    }

    void überschriftLabelSetzen() {
        FontMetrics fm = Lueberschrift.getFontMetrics(Lueberschrift.getFont());
        StringBuilder abstandshalter = new StringBuilder();

        String punkteString = BuildaHQ.translate("Insgesamt") + " " + entferneNullNachkomma(getKosten()) + " " + BuildaHQ.translate("Punkte");
        String kategorieString = " " + getAnzahlText(true) + " " + kategorieText() + " (" + minAnzahl + "-" + maxAnzahl + ")";

        int cnt = (Lueberschrift.getSize().width - (fm.stringWidth(kategorieString + punkteString) + 30)) / fm.stringWidth(" ");

        for (int i = 0; i < cnt; ++i) {
            abstandshalter.append(" ");
        }

        Lueberschrift.setText(kategorieString + abstandshalter.toString() + punkteString);

        if (getAnzahl() > maxAnzahl || getAnzahl() < minAnzahl) {
            Lueberschrift.setForeground(Color.RED);
        } else {
            Lueberschrift.setForeground(Color.BLACK);
        }
    }

    private void chooserLocationCheck() {
        for (int i = 0; i < mC.size() - 1; ++i) {
            if (mC.get(i).selectedEntry() == null) {
                removen(i);
                --i;
            }
        }
        if (mC.size() == 0) {
            Chooser c = new Chooser(buildaVater, randAbstand, 109, alleEinträge, this::cloneEntry);
            c.setStatischeEinträge(statischeEinträge);
            c.setSpezialEinträge(spezialEinträge);
            adden(c);
        } else if (!Objects.equals(mC.get(mC.size() - 1).selectedEntry(), null)) {
            Chooser c = new Chooser(buildaVater, randAbstand, 109, alleEinträge, this::cloneEntry);
            c.setStatischeEinträge(statischeEinträge);
            c.setSpezialEinträge(spezialEinträge);
            adden(c);
        }

        for (int i = 0; i < mC.size(); ++i) {
            int höhe = randAbstand;

            for (int e = 0; e < i; ++e) {
                höhe += mC.get(e).getPanel().getSize().height + randAbstand;
            }

            mC.get(i).getPanel().setLocation(randAbstand, höhe);
        }

        überschriftLabelSetzen();
    }

    public void adden(Chooser c) {
        mC.add(c);
        chooserPanel.add(c.getPanel());
    }

    public void adden(Chooser c, int index) {
        mC.add(index, c);
        chooserPanel.add(c.getPanel(), index);
    }

    private void removen(int i) {
        mC.remove(i);
        chooserPanel.remove(i);
    }

    public String getText() {
        StringBuilder text;
        String sterne = BuildaHQ.sterneAnzeigen ? "***************  " : "";

        if (BuildaHQ.kurzerText) {
            text = new StringBuilder(BuildaHQ.formatierItalic(sterne + getAnzahlText(true) + " " + kategorieText() + " " + sterne) + ZEILENUMBRUCH);
        } else {
            text = new StringBuilder(ZEILENUMBRUCH + BuildaHQ.formatierItalic(sterne + getAnzahlText(true) + " " + kategorieText() + "  " + sterne) + ZEILENUMBRUCH + ZEILENUMBRUCH);
        }

        boolean leereGruppe = true;

        for (int i = 0; i < mC.size(); ++i) {
            String nächsterText = mC.get(i).getText();
            String allyPrefix = "";

            if (!nächsterText.equals("")) {
                leereGruppe = false;
            }

            text.append(allyPrefix + nächsterText);
        }

        if (leereGruppe) return "";
        return text.toString();
    }

    public String getSaveText() {
        StringBuilder sammler = new StringBuilder();

        for (int i = 0; i < mC.size(); ++i) {
            Chooser chooser = mC.get(i);
            sammler.append(chooser.selectedEntry())
                    .append(SAVETEXT_UEBERSCHRIFTTRENNER1)
                    .append(chooser.getSaveText(SAVETEXT_TRENNER2))
                    .append(SAVETEXT_TRENNER3);
        }

        return sammler.toString();
    }

    public void load(String saveText) {
        String[] splittet = saveText.split(SAVETEXT_TRENNER3);

        for (int i = 0; i < BuildaHQ.countStringsInString(saveText, SAVETEXT_TRENNER3); ++i) {
            erstelleEintrag(splittet[i], i);
        }
    }

    private void erstelleEintrag(String saveText, int index) {
        // TODO refactore creation
        String klassenname = saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER1));
        Class<? extends Eintrag> cls = resolveEintragClass(klassenname);

        if (mC.size() <= index + 1 || !(mC.get(index + 1).getEintrag() instanceof LeererEintrag)) { // an der Stelle index+1 wird ein neuer chooser geaddet
            Chooser c = new Chooser(buildaVater, randAbstand, 109, alleEinträge, this::cloneEntry);
            c.setStatischeEinträge(statischeEinträge);
            c.setSpezialEinträge(spezialEinträge);
            adden(c, index + 1);
        }

        Chooser c = mC.get(index + 1); // WICHTIG!!!!!!!!"!!  WENN MANS 2mal mit elementAt(index+1) geht NIX mehr!
        c.select(cls);
        c.load(saveText.substring(saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER1) + SAVETEXT_UEBERSCHRIFTTRENNER1.length(), saveText.length()), SAVETEXT_TRENNER2);

        RefreshListener.fireRefresh();  // für die setAktiv() dinger bei Bossen, Sergeants usw.    wichtig!
    }

    private Class<? extends Eintrag> resolveEintragClass(String klassenname) {
        throw new UnsupportedOperationException("not yet implemented. Can't resolve class for name " + klassenname);
    }
}