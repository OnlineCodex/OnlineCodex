package oc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;

public abstract class BuildaVater extends BuildaPanel implements ActionListener, ItemListener, BuildaSTK {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuildaVater.class);

    public Vector<ChooserGruppe> myChooserGruppen = new Vector<ChooserGruppe>();
    public boolean isLoading = false;
    public int outOfPanel = -CHOOSERGRUPPEN_X_ABSTAND;
    public String reflectionKennungLokal = ""; // Die reflectionKennung wird global geändert, bei jedem Armeeaufruf. Dieser Wert ist der der zugewiesenen Armee.
    public JCheckBox Hauptkontingent = new JCheckBox("Hauptkontingent");
    public Vector<String> noAllies = new Vector<String>();
    public Vector<String> battleBrothers = new Vector<String>();
    public Vector<String> alliesOfConvenience = new Vector<String>();
    public Vector<String> desperateAllies = new Vector<String>();
    public Vector<String> comeTheApocalypse = new Vector<String>();
    public Hashtable<String, Integer> informationList = new Hashtable<String, Integer>();  // anzahl der vorkommen des Strings
    public Hashtable<String, int[]> minAuswahlen = new Hashtable<String, int[]>();  // Mindestauswahlen pro kategorie
    public Hashtable<String, int[]> maxAuswahlen = new Hashtable<String, int[]>();  // Mindestauswahlen pro kategorie
    public String[] AdditionalInformation;
    public String[] HQeinträge;
    public String[] Eliteeinträge;
    public String[] Standardeinträge;
    public String[] Sturmeinträge;
    public String[] Unterstützungeinträge;
    public String[] Transporteinträge;
    public String[] Fliegereinträge;
    public String[] Befestigungen = new String[]{"", "[BK] Aegis-Verteidigungslinie", "[BK] Himmelsschild-Landeplattform", "[BK] Imperiale Bastion", "[BK] Festung der Erlösung", "[BK] Vergelter Waffenbatterie", "[BK] Feuersturm Abwehrstellung",
            "[BK] Aquilla-Artilleriebunker", "[BK] Deflektor-Relaisnetzwerk", "[BK] Deflektor-Schildgenerator", "[BK] Ehrwürdiges Imperium 1", "[BK] Befestigte Stellung", "[BK] Imperialer Bunker",
            "[BK] Imperiale Verteidigungslinie", "[BK] Imperiale Verteidigungsstellung", "[BK] Promethium-Relaisleitungen", "[BK] Imperiales Verteidigungsnetzwerk",
            "", "Plasma Obliterator"};
    public String[] LordofWar;
    public Superformation superformation;
    public Formation formation;
    public boolean fcountBool = false; // Im Falle einer Subformation mit nur einer Auswahl, kann die Auswahl mehrmals gewählt werden und zählt mehrfach.
    public int fcount = 1; // so
    public HashMap<String, Integer> pointValues = new HashMap<String, Integer>();
    public HashMap<String, Integer> CP = new HashMap<String, Integer>();
    protected BuildaTextArea buildatextArea;
    protected boolean nurBeiLeerenBuilderTrue = false;
    protected int cnt = 0;
    protected String textAreaUeberschrift = "";
    protected String nameDerArtDerArmee = "";
    protected String nameDerArtDerArmeeDekliniert = "";
    protected String anfangDerTextarea = ""; // s. ImperialeArmee
    protected String volk = "";
    protected Vector<String> supplements = new Vector<String>();
    protected Vector<String> kontingente = new Vector<String>();
    protected Vector<String> formationen = new Vector<String>();
    protected JComboBox supplementBox = new JComboBox();
    protected JComboBox kontingentBox = new JComboBox();
    protected JComboBox formationBox = new JComboBox();
    @SuppressWarnings("unused")
    private Information informationClass;
    private Sonstige[] sonstige;
    private ActionListener refreshActionListenerKon = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (!((String) kontingentBox.getSelectedItem()).equals("")) {
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
        }

    };
    private ActionListener refreshActionListenerSupplements = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent event) {
            refreshSupplements();

            if (!((String) supplementBox.getSelectedItem()).equals("")) {

                if (reflectionKennung.equals("IA")) setMinMaxSupplement();
            }

            RefreshListener.fireRefresh();
            textAreaRefresh();
        }

    };
    private ActionListener refreshActionListenerForm = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (!((String) formationBox.getSelectedItem()).equals("")) {
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
        }

    };
    private ActionListener cbActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (Hauptkontingent.isSelected()) {
                setInformationVectorValue("Main", 1);
            } else {
                setInformationVectorValue("Main", 0);
            }
            RefreshListener.fireRefresh();
            textAreaRefresh();
        }

    };

    public BuildaVater() {
        panel.setBackground(Color.WHITE);
        //panel.setBounds(0, 0, 3500, CHOOSER_Y + 100);
    }

    public String getText() {
        return buildatextArea.getText();
    }

    public void setTextArea(BuildaTextArea tA) {
        this.buildatextArea = tA;
        tA.textAreaUeberschrift = textAreaUeberschrift;
        tA.nameDerArtDerArmee = nameDerArtDerArmee;
        tA.nameDerArtDerArmeeDekliniert = nameDerArtDerArmeeDekliniert;
        tA.anfangDerTextarea = anfangDerTextarea; // s. ImperialeArmee
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
                reflectionKennungLokal = reflectionKennung;
                LOGGER.info("reflectionKennungLokal:" + reflectionKennungLokal);

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

                if (reflectionKennung.equals("CM") || reflectionKennung.equals("IA")) {
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
                maxAuswahlen.put("Supreme Command Detachment", new int[]{3, 5, 0, 1, 0, 0, 0, 0, 0, 1});

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

    public void setMinMaxSupplement() {
        int[] min = minAuswahlen.get(getSupplementTyp());
        int[] max = maxAuswahlen.get(getSupplementTyp());

        for (int i = 0; i < myChooserGruppen.size(); i++) {
            myChooserGruppen.get(i).minAnzahl = min[i];
            myChooserGruppen.get(i).maxAnzahl = max[i];
            myChooserGruppen.get(i).überschriftLabelSetzen();
        }
    }

    public void setMinMax() {
        int[] min = minAuswahlen.get(getKontingentTyp());
        int[] max = maxAuswahlen.get(getKontingentTyp());

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
    public void hideVolkCheckboxes() {

    }

    //Fügt die Formationen ein, die nur in Superformationen sichtbar sind. Muss in der Volk-Datei überschrieben werden
    public void changeFormations() {

    }

    public double getKosten() {
        double kosten = 0.0;
        for (int i = 0; i < myChooserGruppen.size(); ++i) {
            kosten += myChooserGruppen.elementAt(i).getKosten();
        }
        if (superformation != null) {
            kosten += superformation.getKosten();
        }
        //LOGGER.info("BuildaVater-Kosten: " + kosten);
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
        //LOGGER.info("BuildaVater-Kosten: " + kosten);
        return kosten;
    }

    protected String getVolksSpezifischeInfos() {
        return anfangDerTextarea; // kann in einer Sohnklasse overridet werden.
    }

    public void textAreaRefresh() {
        //		LOGGER.info("textAreaRefresh");
        if (buildatextArea != null) {
            buildatextArea.textAreaRefresh();
        }
    }

    public void adden(ChooserGruppe c) {

        myChooserGruppen.addElement(c);

        panel.add(myChooserGruppen.lastElement().getPanel());

        LOGGER.info("adden" + c.getKategorie());

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


    public Element getSaveElement() {
        Element root = BuildaHQ.getNewXMLElement(ELEMENT_NAME_ONLINECODEX);

        //            ArrayList<Element> chooserGruppen = new ArrayList<Element>();

        for (int i = 0; i < myChooserGruppen.size(); ++i) {
            if (myChooserGruppen.elementAt(i).getmC().size() <= 1) continue;
            root.appendChild(myChooserGruppen.elementAt(i).getSaveElement());
        }

        //            if(OnlineCodex.getGame() == OnlineCodex.NECROMUNDA) root.appendChild(getSaveElementSonstige());

        if (sonstige != null) {
            Element sonstigeRoot = BuildaHQ.getNewXMLElement(ELEMENT_NAME_SONSTIGESGRUPPE);

            for (int i = 0; i < sonstige.length; i++) {
                sonstigeRoot.appendChild(sonstige[i].getSaveElement());
            }

            root.appendChild(sonstigeRoot);
        }

        return root;
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

    public void loadElement(Element e) {
        NodeList childrenChooserGruppe = e.getElementsByTagName(ELEMENT_NAME_CATEGORY);

        int childrenMax = myChooserGruppen.size() > childrenChooserGruppe.getLength() ? childrenChooserGruppe.getLength() : myChooserGruppen.size();

        for (int i = 0; i < myChooserGruppen.size(); ++i) {

            ChooserGruppe c = myChooserGruppen.elementAt(i);
            if (!(c.getKategorie() == 1 || c.getKategorie() == 7)) continue;

            for (int j = 0; j < childrenMax; j++) {
                Element child = (Element) childrenChooserGruppe.item(j);
                int id = Integer.parseInt(child.getAttribute("id"));

                if (!(id == 1 || id == 7)) continue;

                if (id == c.getKategorie()) {
                    c.loadElement(child);
                }
            }
        }

        for (int i = 0; i < myChooserGruppen.size(); ++i) {

            ChooserGruppe c = myChooserGruppen.elementAt(i);
            if ((c.getKategorie() == 1 || c.getKategorie() == 7)) continue;

            for (int j = 0; j < childrenMax; j++) {
                Element child = (Element) childrenChooserGruppe.item(j);
                int id = Integer.parseInt(child.getAttribute("id"));

                if (id == 1 || id == 7) continue;

                if (id == c.getKategorie()) {
                    c.loadElement(child);
                }
            }
        }
    }


    private String getSaveTextSonstige() {
        StringBuilder text = new StringBuilder("");
        if (sonstige != null) {
            for (int i = 0; i < sonstige.length; i++) {
                text.append(SAVETEXT_TRENNER5);
                text.append(sonstige[i].getSaveText(SAVETEXT_TRENNER6));
            }
        }
        return text.toString();
    }

    private Element getSaveElementSonstige() {
        Element root = BuildaHQ.getNewXMLElement("Sonstige");

        if (sonstige != null) {
            for (int i = 0; i < sonstige.length; i++) {
                root.appendChild(sonstige[i].getSaveElement());
            }
        } else {
            return null;
        }

        return null;
    }


    protected void showModalDialog(String s) {
        final ModalDialog md = new ModalDialog(s, true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                md.setVisible(true);
            }
        });
    }

    public ChooserGruppe getChooserGruppeForChange(int i) {
        return myChooserGruppen.elementAt(i - 1);
    }

    protected ChooserGruppe getChooserGruppe(int i) {
        return myChooserGruppen.elementAt(i);
    }

    protected int getChooserAnzahl() {
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

    public void setInformationVectorValue(String s, int value) {
        legKeyAn(s);
        informationList.put(s, value);
    }

    /**
     * Vorauswahl, die nicht geändert werden kann
     *
     * @param kategorie Schlachtfeldrolle
     * @param unit      Einheitenname
     */
    public void addUnit(int kategorie, String unit) {
        myChooserGruppen.get(kategorie).addUnit(unit);
    }

    /**
     * Vorauswahl, die geändert und abgewählt werden kann
     *
     * @param kategorie Schlachtfeldrolle
     * @param unit      Einheitenname
     */
    public void addUnitNotLocked(int kategorie, String unit) {
        myChooserGruppen.get(kategorie).addUnitNotLocked(unit);
    }

    /**
     * Vorauswahl, die geändert, aber nicht abgewählt werden kann
     *
     * @param kategorie Schlachtfeldrolle
     * @param unit      Einheitenname
     */
    public void addUnitSemiLocked(int kategorie, String unit) {
        myChooserGruppen.get(kategorie).addUnitSemiLocked(unit);
    }

    /**
     * Legtz für den letzten Choser eine eigene Einheitenliste fest, ohne Leereintrag
     *
     * @param kategorie Schlachtfeldrolle
     * @param units     Einheitenliste
     */
    public void setUnitList(int kategorie, String[] units) {
        myChooserGruppen.get(kategorie).setUnitList(units);
    }

    public String[] uniteUnitList(String[]... list) {
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

    public String[] uniteUnitList(String[] sAr1, String[] sAr2) {
        String[] sRet = new String[sAr1.length + sAr2.length];

        for (int i = 0; i < sAr1.length; i++) {
            sRet[i] = sAr1[i];
        }

        for (int i = 0; i < sAr2.length; i++) {
            sRet[i + sAr1.length] = sAr2[i];
        }

        return sRet;
    }

    public void fillChooserSpace() {
        if (superformation == null) {
            if (formation != null) {
                cnt = 265;
            } else {
                cnt = 0;
            }

            for (int i = 0; i < myChooserGruppen.size(); i++) {
                //			LOGGER.info(myChooserGruppen.get(i).alleEinträge.length);
                if (myChooserGruppen.get(i).alleEinträge.length == 1 || (myChooserGruppen.get(i).minAnzahl == 0 && myChooserGruppen.get(i).maxAnzahl == 0)) {//Falls die Gruppe nur einen leeren Eintrag enthält, wird sie aus dem Bild geschoben
                    myChooserGruppen.get(i).panel.setLocation(outOfPanel, myChooserGruppen.get(i).panel.getLocation().y);
                } else {
                    myChooserGruppen.get(i).panel.setLocation(cnt, myChooserGruppen.get(i).panel.getLocation().y);
                    cnt += CHOOSERGRUPPEN_X_ABSTAND;
                }
            }
            //			LOGGER.info(cnt);
            panel.setPreferredSize(new Dimension(cnt + 10, panel.getSize().height));
            panel.setSize(cnt + 10, panel.getSize().height);
        }

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

    public void clearCombo() {
        for (int i = 0; i < myChooserGruppen.size(); i++)
            myChooserGruppen.get(i).changeComboBoxAuswahlen(new String[]{""});
    }

    //Passt Formationen und Kontingente an, die in einem Supplement nutzbar sind. Muss in der Volk-Datei überschrieben werden
    public void refreshSupplements() {

    }

    public void appendPointList(HashMap<String, Integer> appendList) {

        Set<String> pointset = appendList.keySet();
        Object[] pointArray = pointset.toArray();
        for (int i = 0; i < pointArray.length; i++) {
            if (pointValues.containsKey(pointArray[i])) {
//				LOGGER.error("Doppelter Key: " + pointArray[i]);
                LOGGER.error("Doppelter Key: " + pointArray[i] + " - " + appendList.get(pointArray[i]) + " Vorhanden als: " + pointArray[i] + " - " + pointValues.get(pointArray[i]));
            } else {
                pointValues.put((String) pointArray[i], appendList.get(pointArray[i]));
            }
        }
    }
}