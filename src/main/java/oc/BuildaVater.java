package oc;

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

import static java.util.Objects.requireNonNull;
import static oc.utils.ResourceUtils.sanitizeKey;

public abstract class BuildaVater extends BuildaPanel implements ActionListener, ItemListener, BuildaSTK {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuildaVater.class);

    private final String id;

    public Vector<ChooserGruppe> myChooserGruppen = new Vector<>();
    boolean isLoading = false;
    public JCheckBox Hauptkontingent = new JCheckBox("Hauptkontingent");
    protected Vector<String> noAllies = new Vector<>();
    protected Vector<String> battleBrothers = new Vector<>();
    protected Vector<String> alliesOfConvenience = new Vector<>();
    protected Vector<String> desperateAllies = new Vector<>();
    protected Vector<String> comeTheApocalypse = new Vector<>();
    Hashtable<String, Integer> informationList = new Hashtable<>();  // anzahl der vorkommen des Strings
    private Hashtable<String, int[]> minAuswahlen = new Hashtable<>();  // Mindestauswahlen pro kategorie
    private Hashtable<String, int[]> maxAuswahlen = new Hashtable<>();  // Mindestauswahlen pro kategorie
    protected String[] AdditionalInformation;
    protected String[] HQeinträge;
    protected String[] Eliteeinträge;
    protected String[] Standardeinträge;
    protected String[] Sturmeinträge;
    protected String[] Unterstützungeinträge;
    protected String[] Transporteinträge;
    protected String[] Fliegereinträge;
    protected String[] Befestigungen = new String[]{"", "[BK] Aegis-Verteidigungslinie", "[BK] Himmelsschild-Landeplattform", "[BK] Imperiale Bastion", "[BK] Festung der Erlösung", "[BK] Vergelter Waffenbatterie", "[BK] Feuersturm Abwehrstellung",
            "[BK] Aquilla-Artilleriebunker", "[BK] Deflektor-Relaisnetzwerk", "[BK] Deflektor-Schildgenerator", "[BK] Ehrwürdiges Imperium 1", "[BK] Befestigte Stellung", "[BK] Imperialer Bunker",
            "[BK] Imperiale Verteidigungslinie", "[BK] Imperiale Verteidigungsstellung", "[BK] Promethium-Relaisleitungen", "[BK] Imperiales Verteidigungsnetzwerk",
            "", "Plasma Obliterator"};
    protected String[] LordofWar;
    public Formation formation;
    boolean fcountBool = false; // Im Falle einer Subformation mit nur einer Auswahl, kann die Auswahl mehrmals gewählt werden und zählt mehrfach.
    int fcount = 1; // so
    private final Map<String, Integer> pointValues;
    private Map<String, Integer> CP = new HashMap<>();
    private BuildaTextArea buildatextArea;
    boolean nurBeiLeerenBuilderTrue = false;
    protected int cnt = 0;
    protected String textAreaUeberschrift = "";
    protected String nameDerArtDerArmee = "";
    protected String nameDerArtDerArmeeDekliniert = "";
    protected String volk = "";
    private Vector<String> supplements = new Vector<>();
    protected Vector<String> kontingente = new Vector<>();
    protected Vector<String> formationen = new Vector<>();
    protected Vector<String> specialDetachments = new Vector<>();
    JComboBox<String> supplementBox = new JComboBox<>();
    public JComboBox<String> kontingentBox = new JComboBox<>();
    public JComboBox<String> formationBox = new JComboBox<>();
    JComboBox<String> specialDetachmentBox = new JComboBox<>();
    private final ActionListener refreshActionListenerKon = event -> {
        if (!"".equals(kontingentBox.getSelectedItem())) {
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
    private final ActionListener refreshActionListenerSupplements = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (!"".equals(supplementBox.getSelectedItem())) {
                if ("IA".equals(id)) setMinMaxSupplement();
            }
            RefreshListener.fireRefresh();
            textAreaRefresh();
        }
    };
    private final ActionListener refreshActionListenerForm = event -> {
        if (!"".equals(formationBox.getSelectedItem())) {
            if (getKontingentTyp().startsWith("Alliiertes Kontingent")) {
                Hauptkontingent.setSelected(false);
                Hauptkontingent.setEnabled(false);
                setInformationVectorValue("Ally", 1);
            } else {
                Hauptkontingent.setEnabled(true);
                setInformationVectorValue("Ally", 0);
            }

            volkRefresh();

            final int[] min = minAuswahlen.get(getKontingentTyp());
            final int[] max = maxAuswahlen.get(getKontingentTyp());

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                myChooserGruppen.get(i).minAnzahl = min[i];
                myChooserGruppen.get(i).maxAnzahl = max[i];
                myChooserGruppen.get(i).überschriftLabelSetzen();
            }
            RefreshListener.fireRefresh();
            textAreaRefresh();
        }
    };
    private final ActionListener cbActionListener = event -> {
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
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return buildatextArea.getText();
    }

    void setTextArea(BuildaTextArea tA) {
        this.buildatextArea = tA;
        tA.textAreaUeberschrift = textAreaUeberschrift;
        tA.nameDerArtDerArmee = nameDerArtDerArmee;
        tA.nameDerArtDerArmeeDekliniert = nameDerArtDerArmeeDekliniert;
        // s. ImperialeArmee
        tA.anfangDerTextarea = "";
        textAreaRefresh();
    }

    String getKontingentTyp() {
        if (!"".equals(kontingentBox.getSelectedItem())) {
            return ((String) kontingentBox.getSelectedItem());
        } else {
            return "";
        }
    }

    public String getFormationType() {
        if (!"".equals(formationBox.getSelectedItem())) {
            return ((String) formationBox.getSelectedItem());
        } else {
            return "";
        }
    }
    
    public String getSpecialDetachmentType() {
        if (specialDetachments.size() > 0 && !"".equals(specialDetachmentBox.getSelectedItem())) {
            return ((String) specialDetachmentBox.getSelectedItem());
        } else {
            return "";
        }
    }

    int getCP() {

    	int additionalCP = 0;

        if(!getSpecialDetachmentType().equals("")){
        	additionalCP -= 1;
        }
        
        additionalCP += getCountFromInformationVector("AdditionalCPAbaddon");

    	// Handle questor imperialis cp for super heavy detachement FAQ
    	//Page 106 – Knight Lances ability Change the last sentence to read: ‘The Command Benefit of each Imperial Knights Super-heavy Detachment
    	//is changed to ‘None’ if it does not contain at least one Imperial Knights Titanic unit, and is changed to ‘+6 Command Points’ if it contains at
    	//least three Imperial Knights Titanic units.’
        if (("Super-Heavy Detachment").equals(kontingentBox.getSelectedItem())){
        	if(getCountFromInformationVector("Knight selected") >= 3){
        		return 6;
        	} else if(getCountFromInformationVector("Knight selected") == 0){
            	return 0;
        	} else {
        		return CP.get(kontingentBox.getSelectedItem());
        	}
        } else {
            if (!"".equals(kontingentBox.getSelectedItem())) {
                return CP.get(kontingentBox.getSelectedItem()) + additionalCP;
            } else if (!"".equals(formationBox.getSelectedItem())) {
                return CP.get(formationBox.getSelectedItem()) + additionalCP;
            } else {
                return 0;
            }
        }
    }

    private String getSupplementTyp() {
        return ((String) supplementBox.getSelectedItem());
    }

    @Override
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

                kontingentBox = new JComboBox<>(kontingente);
                kontingentBox.setMaximumRowCount(25);

                supplementBox = new JComboBox<>(supplements);
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

                formationBox = new JComboBox<>(formationen);
                formationBox.setMaximumRowCount(25);

                panel.add(formationBox);
                formationBox.addActionListener(refreshActionListenerForm);
                formationBox.setBounds(290, 5, 280, 20);
                formationBox.setBackground(Color.WHITE);

                specialDetachmentBox = new JComboBox<>(specialDetachments);
                specialDetachmentBox.setMaximumRowCount(25);

                panel.add(specialDetachmentBox);
                specialDetachmentBox.addActionListener(refreshActionListenerForm);
                specialDetachmentBox.setBounds(575, 5, 280, 20);
                specialDetachmentBox.setBackground(Color.WHITE);
                
                panel.add(Hauptkontingent);
                Hauptkontingent.addActionListener(cbActionListener);
                Hauptkontingent.setBounds(855, 5, 130, 20);
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
        final int[] min = minAuswahlen.get(getSupplementTyp());
        final int[] max = maxAuswahlen.get(getSupplementTyp());

        for (int i = 0; i < myChooserGruppen.size(); i++) {
            myChooserGruppen.get(i).minAnzahl = min[i];
            myChooserGruppen.get(i).maxAnzahl = max[i];
            myChooserGruppen.get(i).überschriftLabelSetzen();
        }
    }

    private void setMinMax() {
        final int[] min = minAuswahlen.get(getKontingentTyp());
        final int[] max = maxAuswahlen.get(getKontingentTyp());

        LOGGER.info("BUildvater" + getKontingentTyp());

        for (int i = 0; i < myChooserGruppen.size(); i++) {
            myChooserGruppen.get(i).minAnzahl = min[i];
            myChooserGruppen.get(i).maxAnzahl = max[i];
            myChooserGruppen.get(i).überschriftLabelSetzen();
        }
    }

    //Spezieller Refresh aus der Volk-Datei. Muss dort überschrieben werden.
    public void volkRefresh() {

    }

    //Bei Subformationen von Superformationen werden die Checkboxes für spezielle Armeevarianten versteckt. Muss in der Volk-Datei überschrieben werden
    void hideVolkCheckboxes() {
    }

    //Fügt die Formationen ein, die nur in Superformationen sichtbar sind. Muss in der Volk-Datei überschrieben werden
    public void changeFormations() {

    }

    @Override
	public double getKosten() {
        double kosten = 0.0;
        for (int i = 0; i < myChooserGruppen.size(); ++i) {
            kosten += myChooserGruppen.elementAt(i).getKosten();
        }
        return kosten;
    }

    public double getPower() {
        double kosten = 0.0;
        for (int i = 0; i < myChooserGruppen.size(); ++i) {
            kosten += myChooserGruppen.elementAt(i).getPower();
        }
        return kosten;
    }

    private void textAreaRefresh() {
        if (buildatextArea != null) {
            buildatextArea.textAreaRefresh();
        }
    }

    public void adden(ChooserGruppe c) {
        myChooserGruppen.addElement(c);
        panel.add(myChooserGruppen.lastElement().getPanel());
        LOGGER.info("adden" + c.getKategorie());
    }

    @Override
	public void itemStateChanged(ItemEvent event) {
        LOGGER.info("itemStateChanged");
        buildatextArea.itemStateChanged(event);
    }

    @Override
	public void actionPerformed(ActionEvent event) {
        LOGGER.info("actionPerformed");
        buildatextArea.actionPerformed(event);
    }

    public void load(String saveText) {
        final String[] teile = {saveText};
        final String[] splittet = teile[0].split(SAVETEXT_TRENNER4);
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
            informationList.put(s, 0);
        } // muss immer aufgerufen werden, ansonsten nullPointerException falls der key nicht vorhanden war...
    }

    public int getCountFromInformationVector(String s) {
        legKeyAn(s);
        return informationList.get(s);
    }

    public void setInformationVectorValue(String s, int value) {
        legKeyAn(s);
        informationList.put(s, value);
    }

    protected static String[] uniteUnitList(String[]... list) {
        int length = 0;
        for (String[] strings : list) {
            length += strings.length;
        }
        final String[] sRet = new String[length];

        int cnt = 0;
        for (String[] strings : list) {
            for (int j = 0; j < strings.length; j++, cnt++) {
                sRet[cnt] = strings[j];
            }
        }

        return sRet;
    }

    protected static String[] uniteUnitList(String[] sAr1, String[] sAr2) {
        final String[] sRet = new String[sAr1.length + sAr2.length];
        System.arraycopy(sAr1, 0, sRet, 0, sAr1.length);
        System.arraycopy(sAr2, 0, sRet, sAr1.length, sAr2.length);
        return sRet;
    }

    protected void fillChooserSpace() {
        if (formation != null) {
            cnt = 265;
        } else {
            cnt = 0;
        }

        for (ChooserGruppe chooserGruppe : myChooserGruppen) {
            if (chooserGruppe.alleEinträge.length == 1 || (chooserGruppe.minAnzahl == 0 && chooserGruppe.maxAnzahl == 0)) {//Falls die Gruppe nur einen leeren Eintrag enthält, wird sie aus dem Bild geschoben
                int outOfPanel = -CHOOSERGRUPPEN_X_ABSTAND;
                chooserGruppe.panel.setLocation(outOfPanel, chooserGruppe.panel.getLocation().y);
            } else {
                chooserGruppe.panel.setLocation(cnt, chooserGruppe.panel.getLocation().y);
                cnt += CHOOSERGRUPPEN_X_ABSTAND;
            }
        }
        panel.setPreferredSize(new Dimension(cnt + 10, panel.getSize().height));
        panel.setSize(cnt + 10, panel.getSize().height);
    }

    public int getPts(String key) {
        return Optional.ofNullable(pointValues.get(sanitizeKey(key)))
                .orElseGet(() -> {
                    LOGGER.error("could not determine points for key {}", key);
                    return 0;
                });
    }

    @Override
	public void refreshAction() {
        super.refreshAction();
        if (formation != null) {
            formation.refresh();
        }
    }

    protected void clearCombo() {
        for (ChooserGruppe chooserGruppe : myChooserGruppen) {
            chooserGruppe.changeComboBoxAuswahlen(new String[]{""});
        }
    }
}