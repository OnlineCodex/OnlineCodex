package oc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class BuildaTextArea extends BuildaPanel implements ActionListener, ItemListener, BuildaSTK {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuildaTextArea.class);

    public Vector<String> triedAllies = new Vector<String>();
    public Vector<String> noAllies = new Vector<String>();
    protected boolean nurBeiLeerenBuilderTrue = false;
    protected int cnt = 0;
    protected String textAreaUeberschrift = "";
    protected String nameDerArtDerArmee = "";
    protected String nameDerArtDerArmeeDekliniert = "";
    protected String anfangDerTextarea = ""; // s. ImperialeArmee
    String orden = "";
    int mainCnt = 0;
    private Vector<BuildaVater> myBuildaVaterVec = new Vector<BuildaVater>();
    private JScrollPane textAreaScrollPane;
    private JTextAreaWithPopup textArea = new JTextAreaWithPopup(true, false);
    private Sonstige[] sonstige;
    private JButton markieren = new JButton(BuildaHQ.translate("Alles markieren"));
    private JCheckBox htmlStyleCheckBox = new JCheckBox(BuildaHQ.translate("Easy-HTML Formatierung"), BuildaHQ.formatierung == 1);
    private JCheckBox alleKostenCheckBox = new JCheckBox(BuildaHQ.translate("Alle Punktkosten"), BuildaHQ.allePunktkosten);
    private JCheckBox kurzerTextCheckBox = new JCheckBox(BuildaHQ.translate("Kurze Armeeliste"), BuildaHQ.kurzerText);
    private JCheckBox sterneAnzeigenCheckBox = new JCheckBox(BuildaHQ.translate("Sterne anzeigen"), BuildaHQ.sterneAnzeigen);
    private JCheckBox zusatzInfosCheckBox = new JCheckBox(BuildaHQ.translate("Zusätzliche Informationen"), BuildaHQ.zusatzInfos);
    private JCheckBox excelModeCheckBox = new JCheckBox(BuildaHQ.translate("Führende Leerzeichen"), BuildaHQ.excelMode);
    private JLabel fehlerLabel = new JLabel();
    private boolean geaddet = false;
    public BuildaTextArea() {
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 1000, CHOOSER_Y + 100);
        complete();
    }

    public String getText() {
        return textArea.getText();
    }

    public void addBuildaVater(BuildaVater bV) {
        myBuildaVaterVec.add(bV);
    }

    public void removeBuildaVater(BuildaVater bV) {
        if (myBuildaVaterVec.contains(bV)) {
            myBuildaVaterVec.remove(bV);
        }
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public JTextAreaWithPopup getTextArea() {
        return this.textArea;
    }

    public void complete() {
        cnt = 10;
        if (!nurBeiLeerenBuilderTrue) {
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setToolTipText(BuildaHQ
                    .translate("Zum rauskopieren Strg+C benutzen")); // oder
            // Rechtsklick
            // ->
            // Kopieren
            BuildaHQ.newGUIComponent(textArea);
            textArea.removeMouseWheelListener(BuildaHQ.defaultMouseWheelListener);
            textAreaScrollPane = new JScrollPane(textArea);
            textAreaScrollPane.setBounds(cnt, 90, 690, 390);
            textAreaScrollPane.setBorder(BorderFactory.createTitledBorder(null,
                    textAreaUeberschrift.replace("Meine",
                            BuildaHQ.translate("Meine")), TitledBorder.CENTER,
                    TitledBorder.BELOW_TOP, new Font("Viner Hand ITC",
                            Font.BOLD, 16)));
            textAreaScrollPane.setBackground(Color.WHITE);
            panel.add(textAreaScrollPane);
            markieren.setBounds(cnt, 12, 135, 20);
            markieren.addActionListener(this);
            BuildaHQ.newGUIComponent(markieren);
            markieren.setToolTipText(BuildaHQ
                    .translate("Zum rauskopieren Strg+C benutzen"));
            panel.add(markieren);
            htmlStyleCheckBox.setBounds(cnt + 160, 10, 185, 20);
            htmlStyleCheckBox.setBackground(Color.WHITE);
            htmlStyleCheckBox.addItemListener(this);
            BuildaHQ.newGUIComponent(htmlStyleCheckBox);
            htmlStyleCheckBox
                    .setToolTipText(BuildaHQ
                            .translate("Unbedingt anhaken, wenn die Armeeliste in ein Forum kopiert werden soll"));

            panel.add(htmlStyleCheckBox);
            alleKostenCheckBox.setBounds(cnt + 160, 40, 185, 20);
            alleKostenCheckBox.setBackground(Color.WHITE);
            alleKostenCheckBox.addItemListener(this);
            BuildaHQ.newGUIComponent(alleKostenCheckBox);
            alleKostenCheckBox.setVisible(false);
            panel.add(alleKostenCheckBox);

            kurzerTextCheckBox.setBounds(cnt + 350, 10, 120, 20);
            kurzerTextCheckBox.setBackground(Color.WHITE);
            kurzerTextCheckBox.addItemListener(this);
            kurzerTextCheckBox.setMargin(new Insets(0, 0, 0, 0));
            kurzerTextCheckBox.setSelected(true);
            BuildaHQ.newGUIComponent(kurzerTextCheckBox);
            panel.add(kurzerTextCheckBox);

            sterneAnzeigenCheckBox.setBounds(cnt + 350, 40, 120, 20);
            sterneAnzeigenCheckBox.setBackground(Color.WHITE);
            sterneAnzeigenCheckBox.addItemListener(this);
            BuildaHQ.newGUIComponent(sterneAnzeigenCheckBox);
            panel.add(sterneAnzeigenCheckBox);

            zusatzInfosCheckBox.setBounds(cnt + 510, 10, 185, 20);
            zusatzInfosCheckBox.setBackground(Color.WHITE);
            zusatzInfosCheckBox.addItemListener(this);
            BuildaHQ.newGUIComponent(zusatzInfosCheckBox);
            panel.add(zusatzInfosCheckBox);

            excelModeCheckBox.setBounds(cnt + 510, 40, 185, 20);
            excelModeCheckBox.setBackground(Color.WHITE);
            excelModeCheckBox.addItemListener(this);
            BuildaHQ.newGUIComponent(excelModeCheckBox);
            panel.add(excelModeCheckBox);

            fehlerLabel.setBounds(cnt, 70, 600, 20);
            fehlerLabel.setBackground(Color.WHITE);
            fehlerLabel.setForeground(Color.RED);
            panel.add(fehlerLabel);

            armeelistenFormatAnpassen(true);
            new RefreshListener((byte) 13) {
                public void refresh() {
                    textAreaRefresh();
                }
            };
        }
    }

    public void setTextAreaBound(int height) {
        textAreaScrollPane.setBounds(cnt, 90, 690, height - 210);
    }

    protected String getVolksSpezifischeInfos() {
        return anfangDerTextarea; // kann in einer Sohnklasse overridet werden.
    }

    @SuppressWarnings("unchecked")
    public void textAreaRefresh() {
        ChooserGruppe cg;
        BuildaVater bV;
        StringBuilder text = new StringBuilder(getVolksSpezifischeInfos());
        int mainCnt = 0;
        noAllies.clear();
        triedAllies.clear();
        boolean allyError = false;

        int kosten = 0;
        int cp = 3;
        int power = 0;
        for (int i = 0; i < myBuildaVaterVec.size(); i++) {
            kosten += myBuildaVaterVec.get(i).getKosten();
            cp += myBuildaVaterVec.get(i).getCP();
            power += myBuildaVaterVec.get(i).getPower();
        }

        int relics = BuildaHQ.getCountFromInformationVectorGlobal("Relic");
        int relicdiff = 0;
        if (relics == 2) {
            relicdiff = 1;
            cp -= 1;
        } else if (relics == 3) {
            relicdiff = 3;
            cp -= 3;
        }

        text.append(BuildaHQ.formatierFettItalicUnderline(BuildaHQ.translate("Gesamtpunkte") + " "
//				+ nameDerArtDerArmeeDekliniert + " : "
                + BuildaHQ.translate("der Armee : ")
                + entferneNullNachkomma(kosten)));

        text.append(BuildaHQ.formatierFettItalicUnderline(ZEILENUMBRUCH
                + BuildaHQ.translate("Powerlevel") + " "
                + BuildaHQ.translate("der Armee : ")
                + entferneNullNachkomma(power)));

        text.append(BuildaHQ.formatierFettItalicUnderline(ZEILENUMBRUCH
                + BuildaHQ.translate("Relikte") + " " + relics + " "
                + BuildaHQ.translate("CP-Abzug") + ": " + relicdiff));

        text.append(BuildaHQ.formatierFettItalicUnderline(ZEILENUMBRUCH
                + BuildaHQ.translate("Kommandopunkte") + " "
                + BuildaHQ.translate("der Armee : ")
                + entferneNullNachkomma(cp) + ZEILENUMBRUCH + ZEILENUMBRUCH));

        for (int k = 0; k < myBuildaVaterVec.size(); k++) {
            bV = myBuildaVaterVec.get(k);
            mainCnt += bV.Hauptkontingent.isSelected() ? 1 : 0;
            if (bV.superformation != null) {
                if (bV.reflectionKennungLokal.equals("SM")) {
                } else if (bV.reflectionKennungLokal.equals("AM")) {
                    text.append(bV.nameDerArtDerArmee + ": " + ((String) bV.kontingentBox.getSelectedItem()).toUpperCase() + ": START");
                } else if (bV.reflectionKennungLokal.equals("TA")) {
                    text.append(bV.nameDerArtDerArmee + ": " + ((String) bV.kontingentBox.getSelectedItem()).toUpperCase() + ": START");
                } else {
                    text.append(bV.nameDerArtDerArmee + ": " + ((String) bV.kontingentBox.getSelectedItem()).toUpperCase() + ": START");
                }
                text.append(" - ");
                text.append((int) bV.getKosten());
                text.append(" Punkte");
                text.append(ZEILENUMBRUCH);
                if (bV.Hauptkontingent.isSelected()) {
                    text.append("(Hauptkontingent)");
                    text.append(ZEILENUMBRUCH);
                }
                text.append(ZEILENUMBRUCH);
                for (int i = 0; i < bV.superformation.formationen.size(); i++) {
                    text.append(getBuildaVaterText(bV.superformation.formationen.get(i)));
                }
                text.append(bV.nameDerArtDerArmee + ": " + ((String) bV.kontingentBox.getSelectedItem()).toUpperCase() + ": ENDE");
                text.append(ZEILENUMBRUCH);
                text.append(ZEILENUMBRUCH);
            } else {
                text.append(getBuildaVaterText(bV));
            }

        }

            if (BuildaHQ.zusatzInfos) {
                boolean waffenbrueder = false;
                boolean zweckbuendnis = false;
                boolean verzweifelt = false;
                boolean niemals = false;
                if (myBuildaVaterVec.size() > 1) {
                    for (int i = 0; i < myBuildaVaterVec.size(); i++) {
                        BuildaVater bV1 = myBuildaVaterVec.get(i);
                        for (int j = 0; j < myBuildaVaterVec.size(); j++) {
                            BuildaVater bV2 = myBuildaVaterVec.get(j);
                            if (bV1.battleBrothers.contains(bV2.reflectionKennungLokal)) {
                                waffenbrueder = true;
                            } else if (bV1.alliesOfConvenience.contains(bV2.reflectionKennungLokal)) {
                                zweckbuendnis = true;
                            } else if (bV1.desperateAllies.contains(bV2.reflectionKennungLokal)) {
                                verzweifelt = true;
                            } else if (bV1.comeTheApocalypse.contains(bV2.reflectionKennungLokal)) {
                                niemals = true;
                            }
                        }
                    }
                }
                text.append(ZEILENUMBRUCH);
                text.append("[" + (myBuildaVaterVec.size() > 1 ? " " : "x") + "] Kein Bündnis\n");
                text.append("[" + (waffenbrueder ? "x" : " ") + "] Waffenbrüder\n");
                text.append("[" + (zweckbuendnis ? "x" : " ") + "] Zweckbündnis\n");
                text.append("[" + (verzweifelt ? "x" : " ") + "] Verzweifelte Verbündete\n");
                text.append("[" + (niemals ? "x" : " ") + "] Niemals\n");
            }

            for (int i = 0; i < noAllies.size(); i++) {
                LOGGER.info("No Allies: " + noAllies.get(i));
            }
            for (int i = 0; i < triedAllies.size(); i++) {
                LOGGER.info("Tried Ally: " + triedAllies.get(i));
                if (noAllies.contains(triedAllies.get(i))) {
                    allyError = true;
                    break;
                }
            }
            if (allyError == true) {
                fehlerLabel.setText("Es wurde ein verbotenes Alliiertes Kontingent gewählt.");
            } else if (mainCnt == 0) {
                fehlerLabel.setText("Ein Kontingent muss als Haupt-Kontingent ausgewählt werden.");
            } else if (mainCnt > 1) {
                fehlerLabel.setText("Nur ein Kontingent darf als Haupt-Kontingent ausgewählt werden.");
            } else {
                fehlerLabel.setText("");
            }

        textArea.setText(text.toString());


        boolean vielText = textArea.getText().split(ZEILENUMBRUCH).length > BUILDAVATER_TEXTAREA_MAXROWS;

        if (geaddet && vielText) {
            textArea.removeMouseWheelListener(BuildaHQ.defaultMouseWheelListener);
            geaddet = false;
        } else if (!geaddet && !vielText) {
            textArea.addMouseWheelListener(BuildaHQ.defaultMouseWheelListener);
            geaddet = true;
        }

        try {
            textArea.select(0, 0);
        } catch (Exception e) {
        }
    }


    public StringBuilder getBuildaVaterText(BuildaVater bV) {
        ChooserGruppe cg;
        StringBuilder text = new StringBuilder();
            if (bV.getKontingentTyp().startsWith("Alliiertes Kontingent")) {
                String ordenLokal = "";
                if (bV.reflectionKennungLokal.equals("SM")) {
                    if (bV.getCountFromInformationVector("SMUltramarines") > 0) {
                        ordenLokal = "SMUltramarines";
                    } else if (bV.getCountFromInformationVector("SMWhiteScars") > 0) {
                        ordenLokal = "SMWhiteScars";
                    } else if (bV.getCountFromInformationVector("SMImperialFists") > 0) {
                        ordenLokal = "SMImperialFists";
                    } else if (bV.getCountFromInformationVector("SMBlackTemplars") > 0) {
                        ordenLokal = "SMBlackTemplars";
                    } else if (bV.getCountFromInformationVector("SMIronHands") > 0) {
                        ordenLokal = "SMIronHands";
                    } else if (bV.getCountFromInformationVector("SMSalamanders") > 0) {
                        ordenLokal = "SMSalamanders";
                    } else if (bV.getCountFromInformationVector("SMRavenGuard") > 0) {
                        ordenLokal = "SMRavenGuard";
                    } else if (bV.getCountFromInformationVector("SMRedScorpions") > 0) {
                        ordenLokal = "SMRedScorpions";
                    } else if (bV.getCountFromInformationVector("SMCarcharodons") > 0) {
                        ordenLokal = "SMCarcharodons";
                    } else if (bV.getCountFromInformationVector("SMExorcists") > 0) {
                        ordenLokal = "SMExorcists";
                    } else if (bV.getCountFromInformationVector("SMMantisWarriors") > 0) {
                        ordenLokal = "SMMantisWarriors";
                    } else if (bV.getCountFromInformationVector("SMRedScorpions") > 0) {
                        ordenLokal = "SMRedScorpions";
                    } else if (bV.getCountFromInformationVector("SMExecutioners") > 0) {
                        ordenLokal = "SMExecutioners";
                    } else if (bV.getCountFromInformationVector("SMRedHunters") > 0) {
                        ordenLokal = "SMRedHunters";
                    } else if (bV.getCountFromInformationVector("SMStarPhantoms") > 0) {
                        ordenLokal = "SMStarPhantoms";
                    } else if (bV.getCountFromInformationVector("SMMinotaurus") > 0) {
                        ordenLokal = "SMMinotaurus";
                    } else if (bV.getCountFromInformationVector("SMNovamarines") > 0) {
                        ordenLokal = "SMNovamarines";
                    } else if (bV.getCountFromInformationVector("SMFireHawks") > 0) {
                        ordenLokal = "SMFireHawks";
                    } else if (bV.getCountFromInformationVector("SMAstralClaws") > 0) {
                        ordenLokal = "SMAstralClaws";
                    }
                } else {
                    ordenLokal = "";
                }
                if (orden.equals(ordenLokal)) {
                    triedAllies.add(bV.reflectionKennungLokal);
                }
            }
            text.append(/*bV.volk + " " +*/ bV.getFormationType());
            text.append(": " + bV.getKontingentTyp());
            if (bV.Hauptkontingent.isSelected()) {
                nameDerArtDerArmeeDekliniert = bV.nameDerArtDerArmeeDekliniert;
                noAllies = (Vector<String>) bV.noAllies.clone();

                text.append(" (Hauptkontingent)");
                if (bV.reflectionKennungLokal.equals("SM")) {
                    if (bV.getCountFromInformationVector("SMUltramarines") > 0) {
                        orden = "SMUltramarines";
                    } else if (bV.getCountFromInformationVector("SMWhiteScars") > 0) {
                        orden = "SMWhiteScars";
                    } else if (bV.getCountFromInformationVector("SMImperialFists") > 0) {
                        orden = "SMImperialFists";
                    } else if (bV.getCountFromInformationVector("SMBlackTemplars") > 0) {
                        orden = "SMBlackTemplars";
                    } else if (bV.getCountFromInformationVector("SMIronHands") > 0) {
                        orden = "SMIronHands";
                    } else if (bV.getCountFromInformationVector("SMSalamanders") > 0) {
                        orden = "SMSalamanders";
                    } else if (bV.getCountFromInformationVector("SMRavenGuard") > 0) {
                        orden = "SMRavenGuard";
                    } else if (bV.getCountFromInformationVector("SMRedScorpions") > 0) {
                        orden = "SMRedScorpions";
                    } else if (bV.getCountFromInformationVector("SMCarcharodons") > 0) {
                        orden = "SMCarcharodons";
                    } else if (bV.getCountFromInformationVector("SMExorcists") > 0) {
                        orden = "SMExorcists";
                    } else if (bV.getCountFromInformationVector("SMMantisWarriors") > 0) {
                        orden = "SMMantisWarriors";
                    } else if (bV.getCountFromInformationVector("SMRedScorpions") > 0) {
                        orden = "SMRedScorpions";
                    } else if (bV.getCountFromInformationVector("SMExecutioners") > 0) {
                        orden = "SMExecutioners";
                    } else if (bV.getCountFromInformationVector("SMRedHunters") > 0) {
                        orden = "SMRedHunters";
                    } else if (bV.getCountFromInformationVector("SMStarPhantoms") > 0) {
                        orden = "SMStarPhantoms";
                    } else if (bV.getCountFromInformationVector("SMMinotaurus") > 0) {
                        orden = "SMMinotaurus";
                    } else if (bV.getCountFromInformationVector("SMNovamarines") > 0) {
                        orden = "SMNovamarines";
                    } else if (bV.getCountFromInformationVector("SMFireHawks") > 0) {
                        orden = "SMFireHawks";
                    } else if (bV.getCountFromInformationVector("SMAstralClaws") > 0) {
                        orden = "SMAstralClaws";
                    }
                } else {
                    orden = "";
                }
            }
            text.append(" - ");
            text.append((int) bV.getKosten());
            text.append(" Punkte");
            text.append(ZEILENUMBRUCH);
        if (BuildaHQ.zusatzInfos) {
            if (text.toString().length() != 0) {
                text.append(ZEILENUMBRUCH);
            }

            for (int i = 0; i < bV.getChooserAnzahl(); ++i) {
                cg = bV.getChooserGruppe(i);
                LOGGER.info("cg.getKosten()" + cg.getKosten());
                LOGGER.info("getKosten()" + getKosten());
                text.append(cg.getAnzahlText(false)
                        + " "
                        + cg.kategorieText()
                        + ((cg.getAnzahl()) > 0 ? ": "
                        + entferneNullNachkomma(cg.getKosten())
                        + " "
                        + BuildaHQ.translate("Pkt.")
                        + "   "
                        + BuildaHQ.formatDouble(
                        ((double) cg.getKosten())
                                / ((double) getKosten())
                                * 100, 1) + "%"
                        + ZEILENUMBRUCH : ZEILENUMBRUCH));
            }

            if (BuildaHQ.kurzerText) {
                text.append(ZEILENUMBRUCH);
            }
        }

        final String lzpzu = " " + ZEILENUMBRUCH; // leerzeichen plus zeilenumbruch

        for (int i = 0; i < bV.getChooserAnzahl(); ++i) {
            String str = bV.getChooserGruppe(i).getText();

            // ExcelMode
            if (BuildaHQ.excelMode && !str.equals("")) {
                // das ist eine Programmierkruecke, da sonst Zeilen, die nur aus Leerzeichen bestehen, ignoriert werden.
                str = str.replaceAll(ZEILENUMBRUCH, lzpzu);
                String[] tokens = str.split(ZEILENUMBRUCH);

                for (int j = 0; j < tokens.length; ++j) {
                    String token = tokens[j];
                    String trimtok = token.trim();
                    if (trimtok.startsWith("-")) {
                        token = token.replaceFirst("-", " -");
                    } else if (trimtok.startsWith("+")) {
                        token = token.replaceFirst("\\+", " \\'+");
                    }
                    text.append(token);

                    // beim letzten lauf keinen Zeilenumbruch hinzufuegen.
                    if (j < tokens.length - 1) {
                        text.append(ZEILENUMBRUCH);
                    }
                }
                text.append(ZEILENUMBRUCH);
            } else {
                text.append(str);
            }
        }
        return text;
    }

    public void itemStateChanged(ItemEvent event) {

        armeelistenFormatAnpassen((JCheckBox) event.getSource() == kurzerTextCheckBox);

    }

    public void armeelistenFormatAnpassen(boolean kurzeTextAnpassen) {

        if (htmlStyleCheckBox.isSelected()) {
            BuildaHQ.formatierung = 1;
        } else {
            BuildaHQ.formatierung = 0;
        }

        BuildaHQ.allePunktkosten = alleKostenCheckBox.isSelected();
        BuildaHQ.sterneAnzeigen = sterneAnzeigenCheckBox.isSelected();
        BuildaHQ.zusatzInfos = zusatzInfosCheckBox.isSelected();
        BuildaHQ.excelMode = excelModeCheckBox.isSelected();

        if (kurzeTextAnpassen) {
            BuildaHQ.machTextStrings(kurzerTextCheckBox.isSelected());
        } // machTextStrings() verändert auch den boolean

        textAreaRefresh();

    }

    public void actionPerformed(ActionEvent event) {

        textArea.selectAll();

        textArea.requestFocusInWindow();

    }

    public double getKosten() {
        double kosten = 0.0;
        for (int i = 0; i < myBuildaVaterVec.size(); i++) {
            kosten += myBuildaVaterVec.get(i).getKosten();
        }
        LOGGER.info("TextArea-Kosten: " + kosten);
        return kosten;
    }

    protected String getTextSonstige() {
        StringBuilder text = new StringBuilder("");

        String sterne = BuildaHQ.sterneAnzeigen ? "***************  " : "";

        String überschrift = (BuildaHQ.kurzerText ? "" : ZEILENUMBRUCH)
                + ZEILENUMBRUCH + sterne + "Sonstiges" + sterne + ZEILENUMBRUCH;

        text.append(überschrift);

        for (int i = 0; i < sonstige.length; i++) {

            text.append(sonstige[i].getText());

        }

        if (text.toString().endsWith(", ")) {

            text = text.deleteCharAt(text.lastIndexOf(","));

        }

        text.append((BuildaHQ.kurzerText ? ZEILENUMBRUCH : "") + ZEILENUMBRUCH);

        return text.toString();
    }

}