package oc;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Objects.requireNonNull;
import static oc.utils.ResourceUtils.sanitizeKey;

public abstract class BuildaVater extends BuildaPanel implements ActionListener, ItemListener, BuildaSTK {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuildaVater.class);

    private final String id;

    public Vector<ChooserGruppe> myChooserGruppen = new Vector<ChooserGruppe>();
    boolean isLoading = false;
    private int outOfPanel = -CHOOSERGRUPPEN_X_ABSTAND;
    JCheckBox Hauptkontingent = new JCheckBox("Hauptkontingent");

    Hashtable<String, Integer> informationList = new Hashtable<String, Integer>();  // anzahl der vorkommen des Strings
    private Hashtable<String, int[]> minAuswahlen = new Hashtable<String, int[]>();  // Mindestauswahlen pro kategorie
    private Hashtable<String, int[]> maxAuswahlen = new Hashtable<String, int[]>();  // Mindestauswahlen pro kategorie

    Superformation superformation;
    public Formation formation;
    boolean fcountBool = false; // Im Falle einer Subformation mit nur einer Auswahl, kann die Auswahl mehrmals gewählt werden und zählt mehrfach.
    int fcount = 1; // so
    private final Map<String, Integer> pointValues;
    private Map<String, Integer> CP = new HashMap<String, Integer>();
    private BuildaTextArea buildatextArea;
    boolean nurBeiLeerenBuilderTrue = false;
    protected int cnt = 0;
    protected String textAreaUeberschrift = "";
    protected String nameDerArtDerArmee = "";
    protected String nameDerArtDerArmeeDekliniert = "";
    private String anfangDerTextarea = ""; // s. ImperialeArmee
    protected String volk = "";
    private Vector<String> supplements = new Vector<String>();
    protected Vector<String> kontingente = new Vector<String>();
    protected Vector<String> formationen = new Vector<String>();
    JComboBox supplementBox = new JComboBox();
    protected JComboBox kontingentBox = new JComboBox();
    JComboBox formationBox = new JComboBox();
    private Sonstige[] sonstige;

    private ActionListener refreshActionListenerKon = event -> {
        if (!(kontingentBox.getSelectedItem()).equals("")) {
            formationBox.setSelectedIndex(formationBox.getSelectedIndex());
            if (getKontingentTyp().startsWith("Alliiertes Kontingent")) {
                Hauptkontingent.setSelected(false);
                Hauptkontingent.setEnabled(false);
                setInformationVectorValue("Ally", 1);
            } else {
                Hauptkontingent.setEnabled(true);
                setInformationVectorValue("Ally", 0);
            }


            setMinMax();
            volkRefresh();
            RefreshListener.fireRefresh();
            textAreaRefresh();
        }
    };
    private ActionListener refreshActionListenerSupplements = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent event) {
            refreshSupplements();

            if (supplementBox.getSelectedItem() != null && id.equals("IA")) {
                setMinMaxSupplement();
            }

            RefreshListener.fireRefresh();
            textAreaRefresh();
        }

    };
    private ActionListener refreshActionListenerForm = event -> {
        if (!(formationBox.getSelectedItem()).equals("")) {
            if (getKontingentTyp().startsWith("Alliiertes Kontingent")) {
                Hauptkontingent.setSelected(false);
                Hauptkontingent.setEnabled(false);
                setInformationVectorValue("Ally", 1);
            } else {
                Hauptkontingent.setEnabled(true);
                setInformationVectorValue("Ally", 0);
            }

            volkRefresh();

            int[] min = minAuswahlen.get(getKontingentTyp());
            int[] max = maxAuswahlen.get(getKontingentTyp());

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).minAnzahl = min[i];
                myChooserGruppen.get(i).maxAnzahl = max[i];
                myChooserGruppen.get(i).überschriftLabelSetzen();
            }
            RefreshListener.fireRefresh();
            textAreaRefresh();
        }
    };
    private ActionListener cbActionListener = event -> {
        if (Hauptkontingent.isSelected()) {
            setInformationVectorValue("Main", 1);
        } else {
            setInformationVectorValue("Main", 0);
        }
        RefreshListener.fireRefresh();
        textAreaRefresh();
    };

    public BuildaVater(String id, Map<String, Integer> pointValues) {
        this.id = requireNonNull(id);
        this.pointValues = ImmutableMap.copyOf(pointValues);
        panel.setBackground(Color.WHITE);

        adden(new ChooserGruppe(this, getId(), cnt, 0, AI, ImmutableList.of()));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, HQ, ImmutableList.of()));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, TROOPS, ImmutableList.of()));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, ELITE, ImmutableList.of()));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FAST_ATTACK, ImmutableList.of()));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, HEAVY_SUPPORT, ImmutableList.of()));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, DEDICATED_TRANSPORT, ImmutableList.of()));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FLIER, ImmutableList.of()));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, FORTIFICATION, ImmutableList.of()));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, getId(), cnt, 0, LORD_OF_WAR, ImmutableList.of()));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return buildatextArea.getText();
    }

    public void setTextArea(BuildaTextArea tA) {
        this.buildatextArea = tA;
        tA.textAreaUeberschrift = textAreaUeberschrift;
        tA.nameDerArtDerArmee = nameDerArtDerArmee;
        tA.nameDerArtDerArmeeDekliniert = nameDerArtDerArmeeDekliniert;
        tA.anfangDerTextarea = anfangDerTextarea;
        textAreaRefresh();
    }

    public String getKontingentTyp() {
        if (!((String) kontingentBox.getSelectedItem()).equals("")) {
            return ((String) kontingentBox.getSelectedItem());
        } else {
            return "";
        }
    }

    public String getFormationType() {
        if (!((String) formationBox.getSelectedItem()).equals("")) {
            return ((String) formationBox.getSelectedItem());
        } else {
            return "";
        }
    }

    public int getCP() {

        if (((String) kontingentBox.getSelectedItem()).equals("Super-Heavy Detachment") && (getCountFromInformationVector("Armiger selected") > 0)) {
            return 0;
        } else {
            if (!((String) kontingentBox.getSelectedItem()).equals("")) {
                return CP.get(((String) kontingentBox.getSelectedItem()));
            } else if (!((String) formationBox.getSelectedItem()).equals("")) {
                return CP.get(((String) formationBox.getSelectedItem()));
            } else {
                return 0;
            }
        }
    }

    public String getSupplementTyp() {
        return ((String) supplementBox.getSelectedItem());
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void complete() {
        if (!(this instanceof LeererBuilder)) {
                kontingente.add(0, "Auxiliary Support Detachment"); //-1CP
                kontingente.add(0, "Fortification Network"); //+0CP
                kontingente.add(0, "Super-Heavy Auxiliary Detachment"); //+0CP
                kontingente.add(0, "Air Wing Detachment"); //+1CP
                kontingente.add(0, "Super-Heavy Detachment"); //+3CP
                kontingente.add(0, "Supreme Command Detachment"); //+1CP
                kontingente.add(0, "Outrider Detachment"); //+1CP
                kontingente.add(0, "Spearhead Detachment"); //+1CP
                kontingente.add(0, "Vanguard Detachment"); //+1CP
                kontingente.add(0, "Vanguard Detachment (Assassins)"); //+0CP
                kontingente.add(0, "Brigade Detachment"); //+9CP
                kontingente.add(0, "Battalion Detachment"); //+3CP
                kontingente.add(0, "Patrol Detachment"); //+0CP
                kontingente.add(0, "");

                CP.put("Auxiliary Support Detachment", -1); //-1CP
                CP.put("Fortification Network", 0); //+0CP
                CP.put("Super-Heavy Auxiliary Detachment", 0); //+0CP
                CP.put("Air Wing Detachment", 1); //+1CP
                CP.put("Super-Heavy Detachment", 3); //+3CP
                CP.put("Supreme Command Detachment", 1); //+1CP
                CP.put("Outrider Detachment", 1); //+1CP
                CP.put("Spearhead Detachment", 1); //+1CP
                CP.put("Vanguard Detachment", 1); //+1CP
                CP.put("Vanguard Detachment (Assassins)", 0); //+1CP
                CP.put("Brigade Detachment", 12); //+12CP
                CP.put("Battalion Detachment", 5); //+5CP
                CP.put("Patrol Detachment", 0); //+0CP

                kontingentBox = new JComboBox(kontingente);
                kontingentBox.setMaximumRowCount(25);

                supplementBox = new JComboBox(supplements);
                supplementBox.setMaximumRowCount(25);

                if (id.equals("CM") || id.equals("IA")) {
                    panel.add(supplementBox);
                    supplementBox.addActionListener(refreshActionListenerSupplements);
                    supplementBox.setBounds(5, 5, 280, 20);
                    supplementBox.setBackground(Color.WHITE);
                } else {
                    panel.add(kontingentBox);
                    kontingentBox.addActionListener(refreshActionListenerKon);
                    kontingentBox.setBounds(5, 5, 280, 20);
                    kontingentBox.setBackground(Color.WHITE);
                }

                formationBox = new JComboBox(formationen);
                formationBox.setMaximumRowCount(25);

                panel.add(formationBox);
                formationBox.addActionListener(refreshActionListenerForm);
                formationBox.setBounds(290, 5, 280, 20);
                formationBox.setBackground(Color.WHITE);

                panel.add(Hauptkontingent);
                Hauptkontingent.addActionListener(cbActionListener);
                Hauptkontingent.setBounds(575, 5, 130, 20);
                Hauptkontingent.setBackground(Color.WHITE);

                minAuswahlen.put("Patrol Detachment", new int[]{0, 1, 1, 0, 0, 0, 0, 0, 0, 0});
                maxAuswahlen.put("Patrol Detachment", new int[]{3, 2, 3, 2, 2, 2, 13, 2, 0, 0});

                minAuswahlen.put("Battalion Detachment", new int[]{0, 2, 3, 0, 0, 0, 0, 0, 0, 0});
                maxAuswahlen.put("Battalion Detachment", new int[]{3, 3, 6, 6, 3, 3, 23, 2, 0, 0});

                minAuswahlen.put("Brigade Detachment", new int[]{0, 3, 6, 3, 3, 3, 0, 0, 0, 0});
                maxAuswahlen.put("Brigade Detachment", new int[]{3, 5, 12, 8, 5, 5, 37, 2, 0, 0});

                minAuswahlen.put("Vanguard Detachment", new int[]{0, 1, 0, 3, 0, 0, 0, 0, 0, 0});
                maxAuswahlen.put("Vanguard Detachment", new int[]{3, 2, 3, 6, 2, 2, 17, 2, 0, 0});

                minAuswahlen.put("Vanguard Detachment (Assassins)", new int[]{0, 0, 0, 3, 0, 0, 0, 0, 0, 0});
                maxAuswahlen.put("Vanguard Detachment (Assassins)", new int[]{3, 2, 3, 6, 2, 2, 17, 2, 0, 0});

                minAuswahlen.put("Spearhead Detachment", new int[]{0, 1, 0, 0, 0, 3, 0, 0, 0, 0});
                maxAuswahlen.put("Spearhead Detachment", new int[]{3, 2, 3, 2, 2, 6, 17, 2, 0, 0});

                minAuswahlen.put("Outrider Detachment", new int[]{0, 1, 0, 0, 3, 0, 0, 0, 0, 0});
                maxAuswahlen.put("Outrider Detachment", new int[]{3, 2, 3, 2, 6, 2, 17, 2, 0, 0});

                minAuswahlen.put("Supreme Command Detachment", new int[]{0, 3, 0, 0, 0, 0, 0, 0, 0, 0});
                maxAuswahlen.put("Supreme Command Detachment", new int[]{3, 5, 0, 1, 0, 0, 7, 0, 0, 1});

                minAuswahlen.put("Super-Heavy Detachment", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 3});
                maxAuswahlen.put("Super-Heavy Detachment", new int[]{3, 0, 0, 0, 0, 0, 0, 0, 0, 5});

                minAuswahlen.put("Air Wing Detachment", new int[]{0, 0, 0, 0, 0, 0, 0, 3, 0, 0});
                maxAuswahlen.put("Air Wing Detachment", new int[]{3, 0, 0, 0, 0, 0, 0, 5, 0, 0});

                minAuswahlen.put("Super-Heavy Auxiliary Detachment", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
                maxAuswahlen.put("Super-Heavy Auxiliary Detachment", new int[]{3, 0, 0, 0, 0, 0, 0, 0, 0, 1});

                minAuswahlen.put("Fortification Network", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 0});
                maxAuswahlen.put("Fortification Network", new int[]{3, 0, 0, 0, 0, 0, 0, 0, 3, 0});

                minAuswahlen.put("Auxiliary Support Detachment", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
                maxAuswahlen.put("Auxiliary Support Detachment", new int[]{3, 1, 1, 1, 1, 1, 1, 1, 0, 0});

                kontingentBox.setSelectedIndex(1);
            fillChooserSpace();
        }
    }

    private void setMinMaxSupplement() {
        int[] min = minAuswahlen.get(getSupplementTyp());
        int[] max = maxAuswahlen.get(getSupplementTyp());

        for (int i = 0; i < myChooserGruppen.size(); i++) {
            myChooserGruppen.get(i).minAnzahl = min[i];
            myChooserGruppen.get(i).maxAnzahl = max[i];
            myChooserGruppen.get(i).überschriftLabelSetzen();
        }
    }

    private void setMinMax() {
        int[] min = minAuswahlen.get(getKontingentTyp());
        int[] max = maxAuswahlen.get(getKontingentTyp());

        LOGGER.info("BUildvater {}", getKontingentTyp());

        for (int i = 0; i < myChooserGruppen.size(); i++) {
            myChooserGruppen.get(i).minAnzahl = min[i];
            myChooserGruppen.get(i).maxAnzahl = max[i];
            myChooserGruppen.get(i).überschriftLabelSetzen();
        }
    }

    //Spezieller Refresh aus der Volk-Datei. Muss dort überschrieben werden.
    public void volkRefresh() {}

    //Bei Subformationen von Superformationen werden die Checkboxes für spezielle Armeevarianten versteckt. Muss in der Volk-Datei überschrieben werden
    public void hideVolkCheckboxes() {}

    //Fügt die Formationen ein, die nur in Superformationen sichtbar sind. Muss in der Volk-Datei überschrieben werden
    public void changeFormations() {}

    public double getKosten() {
        double kosten = 0.0;
        for (int i = 0; i < myChooserGruppen.size(); ++i) {
            kosten += myChooserGruppen.elementAt(i).getKosten();
        }
        if (superformation != null) {
            kosten += superformation.getKosten();
        }
        return kosten;
    }

    public double getPower() {
        double kosten = 0.0;
        for (int i = 0; i < myChooserGruppen.size(); ++i) {
            kosten += myChooserGruppen.elementAt(i).getPower();
        }
        if (superformation != null) {
            kosten += superformation.getPower();
        }
        return kosten;
    }

    protected String getVolksSpezifischeInfos() {
        return anfangDerTextarea; // kann in einer Sohnklasse overridet werden.
    }

    public void textAreaRefresh() {
        if (buildatextArea != null) {
            buildatextArea.textAreaRefresh();
        }
    }

    public void adden(ChooserGruppe c) {
        myChooserGruppen.addElement(c);

        panel.add(myChooserGruppen.lastElement().getPanel());

        LOGGER.info("adden {}", c.getKategorie());
    }

    public void itemStateChanged(ItemEvent event) {
        LOGGER.info("itemStateChanged");
        buildatextArea.itemStateChanged(event);

    }

    public void actionPerformed(ActionEvent event) {
        LOGGER.info("actionPerformed");
        buildatextArea.actionPerformed(event);
    }

    public String getSaveText() {

        if (superformation == null) {
            StringBuilder sammler = new StringBuilder();

            for (int i = 0; i < myChooserGruppen.size(); ++i) {
                sammler.append(myChooserGruppen.elementAt(i).getSaveText());
                sammler.append(SAVETEXT_TRENNER4);
            }

            return sammler.toString();
        } else {
            return superformation.getSaveText();
        }

    }

    public void load(String saveText) {

        if (saveText.contains(SAVETEXT_SUBDETACHMENTTRENNER)) {
            superformation.load(saveText);
        } else {
            String[] teile = {saveText};

            String[] splittet = teile[0].split(SAVETEXT_TRENNER4);

            for (int i = 0; i < myChooserGruppen.size(); ++i) {

                if (myChooserGruppen.elementAt(i).getKategorie() == 7
                        || myChooserGruppen.elementAt(i).getKategorie() == 1) { // lädt erst HQ und Heroes

                    myChooserGruppen.elementAt(i).load(splittet[i]);
                }
            }

            for (int i = 0; i < myChooserGruppen.size(); ++i) {

                if (myChooserGruppen.elementAt(i).getKategorie() != 7
                        && myChooserGruppen.elementAt(i).getKategorie() != 1) { // danach den Rest.
                    // Lädt erst die Einträge, die Spezialauswahlen aktivieren, danach die Standard-Kategorie.
                    // Ich weiß, ist dreckig^^

                    myChooserGruppen.elementAt(i).load(splittet[i]);
                }
            }
        }

    }

    ChooserGruppe getChooserGruppe(int i) {
        return myChooserGruppen.elementAt(i);
    }

    int getChooserAnzahl() {
        return myChooserGruppen.size();
    }

    public void addToInformationVector(String s, int count) { // um wieviel der key s erhöht/vermindert wird
        legKeyAn(s);
        informationList.put(s, informationList.get(s) + count);
    }

    private void legKeyAn(String s) {
        if (!informationList.containsKey(s)) {
            informationList.put(s, Integer.valueOf(0));
        } // muss immer aufgerufen werden, ansonsten nullPointerException falls der key nicht vorhanden war...
    }

    public int getCountFromInformationVector(String s) {
        legKeyAn(s);
        return informationList.get(s).intValue();
    }

    void setInformationVectorValue(String s, int value) {
        legKeyAn(s);
        informationList.put(s, value);
    }

    protected static String[] uniteUnitList(String[]... list) {
        int length = 0;
        for (int i = 0; i < list.length; i++) {
            length += list[i].length;
        }
        String[] sRet = new String[length];

        int cnt = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++, cnt++) {
                sRet[cnt] = list[i][j];
            }
        }

        return sRet;
    }

    protected static String[] uniteUnitList(String[] sAr1, String[] sAr2) {
        String[] sRet = new String[sAr1.length + sAr2.length];

        for (int i = 0; i < sAr1.length; i++) {
            sRet[i] = sAr1[i];
        }

        for (int i = 0; i < sAr2.length; i++) {
            sRet[i + sAr1.length] = sAr2[i];
        }

        return sRet;
    }

    protected void fillChooserSpace() {
        if (superformation == null) {
            if (formation != null) {
                cnt = 265;
            } else {
                cnt = 0;
            }

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                ChooserGruppe chooserGruppe = myChooserGruppen.get(i);

                if (chooserGruppe.alleEinträge.size() == 1 || (chooserGruppe.minAnzahl == 0 && chooserGruppe.maxAnzahl == 0)) {//Falls die Gruppe nur einen leeren Eintrag enthält, wird sie aus dem Bild geschoben
                    chooserGruppe.panel.setLocation(outOfPanel, chooserGruppe.panel.getLocation().y);
                } else {
                    chooserGruppe.panel.setLocation(cnt, chooserGruppe.panel.getLocation().y);
                    cnt += CHOOSERGRUPPEN_X_ABSTAND;
                }
            }
            panel.setPreferredSize(new Dimension(cnt + 10, panel.getSize().height));
            panel.setSize(cnt + 10, panel.getSize().height);
        }

    }

    public int getPts(String key) {
        return Optional.ofNullable(pointValues.get(sanitizeKey(key)))
                .orElseGet(() -> {
                    LOGGER.error("could not determine points for key {}", key);
                    return 0;
                });
    }

    public void refreshAction() {
        super.refreshAction();
        if (formation != null) {
            formation.refresh();
        }
        if (superformation != null) {
            superformation.refreshCounts();
        }
    }

    protected void clearCombo() {
        for (int i = 0; i < myChooserGruppen.size(); i++) {
            myChooserGruppen.get(i).changeComboBoxAuswahlen(ImmutableList.of());
        }
    }

    private void refreshSupplements() {}
}