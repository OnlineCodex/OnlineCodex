package oc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Vector;


public class Superformation implements BuildaSTK {

    private static final Logger LOGGER = LoggerFactory.getLogger(Superformation.class);


    private static Superformation superformation;
    public String reflectionKennungLokal = "";
    public String volkFile = "";
    public BuildaTextArea tA;
    public Vector<BuildaVater> formationen = new Vector<BuildaVater>();
    public Vector<String> namenCore = new Vector<String>();
    public Vector<String> namenAuxiliary = new Vector<String>();
    public Vector<String> namenCommand = new Vector<String>();
    public Vector<String> namenSupport = new Vector<String>();
    public int minCore, minAuxiliary, minCommand, maxCore, maxAuxiliary, maxCommand, minSupport, maxSupport;
    public boolean multiplyerAuxiliaryByCore = false;
    public boolean multiplyerCommandByCore = false;
    public boolean multiplyerCoreByCommand = false;
    public boolean multiplyerSupportByCore = false;
    public boolean showSupport = false;
    public JComboBox comboCore, comboAuxiliary, comboCommand, comboSupport;
    public BuildaVater buildaVater;


    public Vector<Vector<String>> namenDynamisch;// = new Vector<Vector<String>>();
    public Vector<Integer> minDynamisch;
    public Vector<Integer> maxDynamisch;
    public Vector<JComboBox> comboDynamisch;
    public ChangeListener tabChangeListener = new ChangeListener() {
        public void stateChanged(ChangeEvent changeEvent) {
            JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
            int index = sourceTabbedPane.getSelectedIndex();

            LOGGER.info("Tab changed to: " + index + ":" + sourceTabbedPane.getTitleAt(index));
            if (index == 0) {
                BuildaVater bV = buildaVater;
                for (int i = 0; i < bV.getChooserAnzahl(); i++) {
                    BuildaHQ.registerNewChooserGruppe(bV.getChooserGruppe(i), i + 1);
                }
                BuildaHQ.aktBuildaVater = bV;
                OnlineCodex.reflectionKennung = bV.reflectionKennungLokal;
            }
            if (index != 0) {
                BuildaVater bV = formationen.get(index - 1);
                for (int i = 0; i < bV.getChooserAnzahl(); i++) {
                    BuildaHQ.registerNewChooserGruppe(bV.getChooserGruppe(i), i + 1);
                }
                BuildaHQ.aktBuildaVater = bV;
                OnlineCodex.reflectionKennung = bV.reflectionKennungLokal;
            }
        }
    };
    protected JPanel controlPanel;
    JTabbedPane tab = new JTabbedPane();
    JPanel panel;
    int type;
    JLabel infoCommand = new JLabel("Command: " + minCommand + " - " + maxCommand + " Ausgewählt: " + 0);
    JLabel infoCore = new JLabel("Core: " + minCore + " - " + maxCore + " Ausgewählt: " + 0);
    JLabel infoAuxiliary = new JLabel("Auxiliary: " + minAuxiliary + " - " + maxAuxiliary + " Ausgewählt: " + 0);
    JLabel infoSupport = new JLabel("Support: " + minSupport + " - " + maxSupport + " Ausgewählt: " + 0);
    private ActionListener formChangeListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent event) {
            String name = "";
            try {
                BuildaVater myBuilder = new LeererBuilder();

                if (type == 0) {
                    name = volkFile;

                    if (event.getSource() == comboAuxiliary && comboAuxiliary.getSelectedItem().equals("")) {
                        return;//Es soll kein Leerer Tab eingefügt werden
                    } else if (event.getSource() == comboCommand && comboCommand.getSelectedItem().equals("")) {
                        return;//Es soll kein Leerer Tab eingefügt werden
                    } else if (event.getSource() == comboCore && comboCore.getSelectedItem().equals("")) {
                        return;//Es soll kein Leerer Tab eingefügt werden
                    } else if (event.getSource() == comboSupport && comboSupport.getSelectedItem().equals("")) {
                        return;//Es soll kein Leerer Tab eingefügt werden
                    } else {
                        LOGGER.info(name);
                        myBuilder = (BuildaVater) (Class.forName(name).newInstance());
                    }
                } else if (type == 1) {
                    if (((JComboBox) event.getSource()).getSelectedItem().equals("")) {
                        return;//Es soll kein Leerer Tab eingefügt werden
                    } else {
                        String txt = ((String) ((JComboBox) event.getSource()).getSelectedItem());
                        if (txt.contains(": ")) {
                            String split[] = txt.split(": ");
                            name = "oc.wh40k.armies." + BuildaSTK.volkMap.get(split[0]);
                        } else {
                            name = volkFile;
                        }
                        LOGGER.info(name);
                        myBuilder = (BuildaVater) (Class.forName(name).newInstance());
                    }
                }

                JPanel buildaPanel = myBuilder.getPanel();
                buildaPanel.setPreferredSize(new Dimension(3450, 7950));
                buildaPanel.setSize(3450, 7950);
                formationen.add(myBuilder);
                myBuilder.setTextArea(tA);

                JScrollPane sp = new JScrollPane(buildaPanel);
                sp.addMouseMotionListener(OnlineCodex.getInstance().getDragAndDropMouseMotionListener());
                sp.addMouseListener(OnlineCodex.getInstance().getDragAndDropMouseListener());
                sp.setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - OnlineCodex.getInstance().menuHöhe - 53));
                sp.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - OnlineCodex.getInstance().menuHöhe - 53));

                myBuilder.informationList = (Hashtable<String, Integer>) buildaVater.informationList.clone();

                myBuilder.changeFormations();

                if (type == 0) {
                    if (event.getSource() == comboAuxiliary && !comboAuxiliary.getSelectedItem().equals("")) {
                        tab.addTab((String) comboAuxiliary.getSelectedItem(), null, sp);
                        tab.setSelectedIndex(tab.getTabCount() - 1);
                        myBuilder.formationBox.setSelectedItem(comboAuxiliary.getSelectedItem());
                    } else if (event.getSource() == comboCommand && !comboCommand.getSelectedItem().equals("")) {
                        tab.addTab((String) comboCommand.getSelectedItem(), null, sp);
                        tab.setSelectedIndex(tab.getTabCount() - 1);
                        myBuilder.formationBox.setSelectedItem(comboCommand.getSelectedItem());
                    } else if (event.getSource() == comboCore && !comboCore.getSelectedItem().equals("")) {
                        tab.addTab((String) comboCore.getSelectedItem(), null, sp);
                        tab.setSelectedIndex(tab.getTabCount() - 1);
                        myBuilder.formationBox.setSelectedItem(comboCore.getSelectedItem());
                    } else if (event.getSource() == comboSupport && !comboSupport.getSelectedItem().equals("")) {
                        tab.addTab((String) comboSupport.getSelectedItem(), null, sp);
                        tab.setSelectedIndex(tab.getTabCount() - 1);
                        myBuilder.formationBox.setSelectedItem(comboSupport.getSelectedItem());
                    }
                } else if (type == 1) {
                    String txt = ((String) ((JComboBox) event.getSource()).getSelectedItem());
                    if (txt.contains(": ")) {
                        String split[] = txt.split(": ");
                        tab.addTab(split[1], null, sp);
                        tab.setSelectedIndex(tab.getTabCount() - 1);
                        myBuilder.formationBox.setSelectedItem(split[1]);
                    } else {
                        tab.addTab(txt, null, sp);
                        tab.setSelectedIndex(tab.getTabCount() - 1);
                        myBuilder.formationBox.setSelectedItem(txt);
                    }
                }
                tab.setTabComponentAt(formationen.size(), new ButtonTabComponent(tab, superformation));

                myBuilder.supplementBox.setVisible(false);
                myBuilder.formationBox.setVisible(false);
                myBuilder.kontingentBox.setVisible(false);
                myBuilder.Hauptkontingent.setVisible(false);
                myBuilder.hideVolkCheckboxes();

                for (int i = 0; i < myBuilder.myChooserGruppen.size(); i++) {
                    myBuilder.myChooserGruppen.get(i).getPanel().setLocation(myBuilder.myChooserGruppen.get(i).getPanel().getLocation().x, myBuilder.myChooserGruppen.get(i).getPanel().getLocation().y - 20);
                }

                refreshCounts();
                tA.textAreaRefresh();
                RefreshListener.fireRefresh();
                tab.setSelectedIndex(0);
                LOGGER.info("Formationen1:" + superformation.formationen.size());
                LOGGER.info("Formationen2:" + formationen.size());
            } catch (Exception e) {
//				fehler("VOLK" + name + ".class nicht gefunden.\nBitte melden!!");
                LOGGER.error("", e);
            }
        }
    };

    /**
     * @param panel Panel in dem die Superformation angezeigt werden soll
     * @param type  Typ der Superformation. 0 = Superformationen mit Core, Aux, Command, (Support). 1 = Dynamische Typfestlegung (z.B. CONCLAVE ACQUISITORIUS)
     */

    public Superformation(JPanel panel, int type) {

        this.panel = panel;

        this.type = type;

        superformation = this;

        panel.add(tab);

        ((JScrollPane) panel.getParent().getParent()).setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        ((JScrollPane) panel.getParent().getParent()).setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);


        if (type == 1) {

            namenDynamisch = new Vector<Vector<String>>();

            minDynamisch = new Vector<Integer>();

            maxDynamisch = new Vector<Integer>();

            comboDynamisch = new Vector<JComboBox>();

        }

    }


    public void refreshControlPanel() {


        tab.setLocation(10, 25);

        tab.setSize(OnlineCodex.getInstance().tab.getWidth() - 13, OnlineCodex.getInstance().tab.getHeight() - 54);


        controlPanel = new JPanel(null, false);

        controlPanel.setBackground(Color.white);


        if (type == 0) {

            comboCore = new JComboBox(namenCore);

            comboAuxiliary = new JComboBox(namenAuxiliary);

            comboCommand = new JComboBox(namenCommand);

            comboSupport = new JComboBox(namenSupport);

        } else {

            for (int i = 0; i < namenDynamisch.size(); i++) {

                comboDynamisch.add(new JComboBox(namenDynamisch.get(i)));

            }

        }


        tab.addTab("Auswahl", null, controlPanel);

        tab.addChangeListener(tabChangeListener);


        if (type == 0) {

            JLabel labelCore = new JLabel("Core:");

            controlPanel.add(labelCore);

            labelCore.setBounds(5, 5, 100, 20);

            controlPanel.add(comboCore);

            comboCore.addActionListener(formChangeListener);

            comboCore.setBounds(110, 5, 280, 20);

            comboCore.setBackground(Color.WHITE);


            JLabel labelAuxiliary = new JLabel("Auxiliary:");

            controlPanel.add(labelAuxiliary);

            labelAuxiliary.setBounds(5, 30, 100, 20);

            controlPanel.add(comboAuxiliary);

            comboAuxiliary.addActionListener(formChangeListener);

            comboAuxiliary.setBounds(110, 30, 280, 20);

            comboAuxiliary.setBackground(Color.WHITE);


            JLabel labelCommand = new JLabel("Command:");

            controlPanel.add(labelCommand);

            labelCommand.setBounds(5, 55, 100, 20);

            controlPanel.add(comboCommand);

            comboCommand.addActionListener(formChangeListener);

            comboCommand.setBounds(110, 55, 280, 20);

            comboCommand.setBackground(Color.WHITE);


            if (showSupport) {

                JLabel labelSupport = new JLabel("Support:");

                controlPanel.add(labelSupport);

                labelSupport.setBounds(5, 80, 100, 20);

                controlPanel.add(comboSupport);

                comboSupport.addActionListener(formChangeListener);

                comboSupport.setBounds(110, 80, 280, 20);

                comboSupport.setBackground(Color.WHITE);

            }

        } else if (type == 1) {

            for (int i = 0; i < comboDynamisch.size(); i++) {

                JLabel labelDyn = new JLabel();

                if (minDynamisch.get(i) == maxDynamisch.get(i)) {

                    labelDyn.setText("" + minDynamisch.get(i));

                } else {

                    labelDyn.setText(minDynamisch.get(i) + "-" + maxDynamisch.get(i));

                }

                controlPanel.add(labelDyn);

                labelDyn.setBounds(5, 5 + 25 * i, 100, 20);

                controlPanel.add(comboDynamisch.get(i));

                comboDynamisch.get(i).addActionListener(formChangeListener);

                comboDynamisch.get(i).setBounds(110, 5 + 25 * i, 280, 20);

                comboDynamisch.get(i).setBackground(Color.WHITE);

            }

        }


        refreshCounts();


        if (type == 0) {

            controlPanel.add(infoCore);

            controlPanel.add(infoAuxiliary);

            controlPanel.add(infoCommand);

            infoCore.setBounds(5, showSupport ? 105 : 80, 300, 20);

            infoAuxiliary.setBounds(5, showSupport ? 130 : 105, 300, 20);

            infoCommand.setBounds(5, showSupport ? 155 : 130, 300, 20);

            if (showSupport) {

                controlPanel.add(infoSupport);

                infoSupport.setBounds(5, 180, 300, 20);

            }

        }


    }


    public void refreshCounts() {

        int cntCore = 0;

        int cntAuxiliary = 0;

        int cntCommand = 0;

        int cntSupport = 0;

        //Counterzuweisungen

        for (int i = 0; i < formationen.size(); i++) {

            if (namenAuxiliary.contains(formationen.get(i).formationBox.getSelectedItem())) {

                cntAuxiliary += formationen.get(i).fcount;

            } else if (namenCommand.contains(formationen.get(i).formationBox.getSelectedItem())) {

                cntCommand += formationen.get(i).fcount;

            } else if (namenCore.contains(formationen.get(i).formationBox.getSelectedItem())) {

                if (reflectionKennungLokal == "SM" && formationen.get(i).formationBox.getSelectedItem().equals("Battle Company")) {

                    cntCore += formationen.get(i).fcount;

                }

                cntCore += formationen.get(i).fcount;

            } else if (namenSupport.contains(formationen.get(i).formationBox.getSelectedItem())) {

                cntSupport += formationen.get(i).fcount;

            }

        }


        if (maxCommand == Integer.MAX_VALUE) {

            infoCommand.setText(("Command: " + minCommand * (multiplyerCommandByCore ? cntCore : 1) + "+ Ausgewählt: " + cntCommand));

        } else {

            infoCommand.setText(("Command: " + minCommand * (multiplyerCommandByCore ? cntCore : 1) + " - " + maxCommand * (multiplyerCommandByCore ? cntCore : 1) + " Ausgewählt: " + cntCommand));

        }


        if (maxCore == Integer.MAX_VALUE) {

            infoCore.setText(("Core: " + minCore * (multiplyerCoreByCommand ? cntCommand : 1) + "+ Ausgewählt: " + cntCore));

        } else {

            infoCore.setText(("Core: " + minCore * (multiplyerCoreByCommand ? cntCommand : 1) + " - " + maxCore * (multiplyerCoreByCommand ? cntCommand : 1) + " Ausgewählt: " + cntCore));

        }


        if (maxAuxiliary == Integer.MAX_VALUE) {

            infoAuxiliary.setText(("Auxiliary: " + minAuxiliary * (multiplyerAuxiliaryByCore ? cntCore : 1) + "+ Ausgewählt: " + cntAuxiliary));

        } else {

            infoAuxiliary.setText(("Auxiliary: " + minAuxiliary * (multiplyerAuxiliaryByCore ? cntCore : 1) + " - " + maxAuxiliary * (multiplyerAuxiliaryByCore ? cntCore : 1) + " Ausgewählt: " + cntAuxiliary));

        }


        if (maxSupport == Integer.MAX_VALUE) {

            infoSupport.setText(("Support: " + minSupport * (multiplyerSupportByCore ? cntCore : 1) + "+ Ausgewählt: " + cntSupport));

        } else {

            infoSupport.setText(("Support: " + minSupport * (multiplyerSupportByCore ? cntCore : 1) + " - " + maxSupport * (multiplyerSupportByCore ? cntCore : 1) + " Ausgewählt: " + cntSupport));

        }


        if (cntCommand < minCommand * (multiplyerCommandByCore ? cntCore : 1) || cntCommand > maxCommand * (multiplyerCommandByCore ? cntCore : 1)) {

            infoCommand.setForeground(Color.red);

        } else {

            infoCommand.setForeground(Color.black);

        }


        if (cntCore < minCore * (multiplyerCoreByCommand ? cntCommand : 1) || cntCore > maxCore * (multiplyerCoreByCommand ? cntCommand : 1)) {

            infoCore.setForeground(Color.red);

        } else {

            infoCore.setForeground(Color.black);

        }


        if (cntAuxiliary < minAuxiliary * (multiplyerAuxiliaryByCore ? cntCore : 1) || cntAuxiliary > maxAuxiliary * (multiplyerAuxiliaryByCore ? cntCore : 1)) {

            infoAuxiliary.setForeground(Color.red);

        } else {

            infoAuxiliary.setForeground(Color.black);

        }


        if (cntSupport < minSupport * (multiplyerSupportByCore ? cntCore : 1) || cntSupport > maxSupport * (multiplyerSupportByCore ? cntCore : 1)) {

            infoSupport.setForeground(Color.red);

        } else {

            infoSupport.setForeground(Color.black);

        }


    }


    public String getSaveText() {

        //LOGGER.info(buildaChooser.getSelectedObjects()[0].toString() + SAVETEXT_UEBERSCHRIFTTRENNER2 + myBuilder.getSaveText());

        String s = "";

        for (int i = 0; i < formationen.size(); i++) {

            String title = tab.getTitleAt(i + 1);

            if (type == 1) {

                if (formationen.get(i).reflectionKennungLokal != reflectionKennungLokal) {

                    title = formationen.get(i).reflectionKennungLokal + ": " + title;

                }

            }

            s += title + BuildaSTK.SAVETEXT_UEBERSCHRIFTTRENNER2 +

                    formationen.get(i).kontingentBox.getSelectedItem() + BuildaSTK.SAVETEXT_DETACHMENTTYPTRENNER1 +

                    formationen.get(i).formationBox.getSelectedItem() + BuildaSTK.SAVETEXT_DETACHMENTTYPTRENNER2 +

                    (formationen.get(i).Hauptkontingent.isSelected() ? "y" : "n") + BuildaSTK.SAVETEXT_DETACHMENTTYPTRENNER3 +

                    formationen.get(i).getSaveText() + BuildaSTK.SAVETEXT_SUBDETACHMENTTRENNER;

        }

        return s;

    }


    public void load(String saveText) {

        String armies[] = saveText.split(SAVETEXT_SUBDETACHMENTTRENNER);

        for (int i = 0; i < armies.length; i++) {

            try {

                LOGGER.info(armies[i]);

                BuildaVater myBuilder = new LeererBuilder();

                String name = volkFile;


                if (type == 1) {

                    String txt = armies[i].split(SAVETEXT_UEBERSCHRIFTTRENNER2)[0];

                    if (txt.contains(": ")) {

                        name = "oc.wh40k.armies." + BuildaSTK.volkMap.get(txt.split(": ")[0]);

                    }

                }


                myBuilder = (BuildaVater) (Class.forName(name).newInstance());

                formationen.add(myBuilder);


                JPanel buildaPanel = formationen.get(i).getPanel();

                buildaPanel.setPreferredSize(new Dimension(3450, 7950));

                buildaPanel.setSize(3450, 7950);


                formationen.get(i).setTextArea(tA);


                JScrollPane sp = new JScrollPane(buildaPanel);

                sp.addMouseMotionListener(OnlineCodex.getInstance().getDragAndDropMouseMotionListener());

                sp.addMouseListener(OnlineCodex.getInstance().getDragAndDropMouseListener());

                sp.setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - OnlineCodex.getInstance().menuHöhe - 53));

                sp.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - OnlineCodex.getInstance().menuHöhe - 53));


                tab.addTab(armies[i].substring(0, armies[i].indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2)), null, sp);

                tab.setTabComponentAt(i + 1, new ButtonTabComponent(tab, superformation));


                formationen.get(i).isLoading = true;

                ////////////////

                for (int j = 0; j < formationen.get(i).getChooserAnzahl(); j++) {

                    BuildaHQ.registerNewChooserGruppe(formationen.get(i).getChooserGruppe(j), j + 1);

                }


                formationen.get(i).informationList = (Hashtable<String, Integer>) buildaVater.informationList.clone();

                formationen.get(i).changeFormations();


                BuildaHQ.aktBuildaVater = formationen.get(i);

                /////////////////


                String kontingent = armies[i].substring(armies[i].indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2) + SAVETEXT_UEBERSCHRIFTTRENNER2.length(), armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER1));

                String formation = armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER1) + SAVETEXT_DETACHMENTTYPTRENNER1.length(), armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER2));

                String haupt = armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER2) + SAVETEXT_DETACHMENTTYPTRENNER2.length(), armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3));

                if (!kontingent.equals("")) {

                    formationen.get(i).kontingentBox.setSelectedItem(kontingent);

                }

                if (!formation.equals("")) {

                    formationen.get(i).formationBox.setSelectedItem(formation);

                }

                if (haupt.equals("y")) {

                    formationen.get(i).Hauptkontingent.doClick();

                }

                //myBuilderz.get(i).Hauptkontingent.setSelected(haupt.equals("y"));

                formationen.get(i).load(armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), armies[i].length()));

                formationen.get(i).isLoading = false;

            } catch (Exception e) {

//				fehler("VOLK" + name + ".class nicht gefunden.\nBitte melden!!");

                LOGGER.error("", e);

            }

        }

        refreshCounts();

    }


    public double getKosten() {

        double kosten = 0.0;

        for (int i = 0; i < formationen.size(); i++) {

            kosten += formationen.get(i).getKosten();

        }

        return kosten;

    }


    public void createKategorieDynamisch(int min, int max) {

        namenDynamisch.add(new Vector<String>());

        minDynamisch.add(min);

        maxDynamisch.add(max);

    }


    public void addEintragDynamisch(String volk, String name) {

        if (volk == "") {

            namenDynamisch.lastElement().add(name);

        } else {

            namenDynamisch.lastElement().add(volk + ": " + name);

        }

    }


    public double getPower() {

        // TODO Auto-generated method stub

        return 0;

    }

}