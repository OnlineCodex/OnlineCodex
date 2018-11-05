package oc;

import com.github.zafarkhaja.semver.Version;
import oc.utils.ManifestUtils;
import oc.wh40k.armies.VOLKAstraMilitarum;
import oc.wh40k.armies.VOLKSpaceMarines;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.Optional;
import java.util.Vector;
import java.util.prefs.Preferences;

//import oc.wh40k.armies.VOLKSternenreichderTau;


public class OnlineCodex extends BuildaPanel {

    public final static int menuHöhe = 23;
    public final static int FRAME_MIN_WIDTH = 750;
    public static int WH40K = 0;
    public static int WHFB = 1;
    public static int NECROMUNDA = 2;
    public static int WH40K_LEGACY = 3;
    public static int WHFB_LEGACY = 4;
    public static int WH40K_FANDEX = 5;
    public static String armyPackage;
    public static String allyArmyPackage;
    //boolean scrollLock = true;
    private static OnlineCodex onlineCodex;
    private final JButton openMenu = new JButton();
    private final JButton openCredits = new JButton();
    private final JButton saveButton = new JButton();
    private final JButton loadButton = new JButton();
    private final JPanel menuPanel = new JPanel();
    private final Hashtable<String, String> dokumente = new Hashtable<String, String>();
    private final Optional<Version> version;
    private final String windowTitle;
    private final JFrame myWindow = new JFrame("OnlineCodex powered by OnlineCodex.de");
    public SaveTextWindow saveTextWindow;
    int refreshX = 0;
    int refreshY = 0;
    Object[] buildazWh40k = new Object[]{
            "",
            new IconedText("Aeldari", "oc/images/VSOrks.gif"),
            new IconedText("Chaos", "oc/images/VSOrks.gif"),
            new IconedText("Imperium", "oc/images/VSOrks.gif"),
            new IconedText("Necrons", "oc/images/VSOrks.gif"),
            new IconedText("Orks", "oc/images/VSOrks.gif"),
            new IconedText("Tyraniden", "oc/images/VSOrks.gif"),
            new IconedText("Tau Empire", "oc/images/VSOrks.gif"),
    };
    JTabbedPane tab = new JTabbedPane();
    //private final JComboBox buildaChooser = new JComboBox(buildazWh40k);
    private JComboBox buildaChooser;
    private JPanel textPanel;
    private Vector<BuildaVater> myBuilderz = new Vector<BuildaVater>();
    public ChangeListener tabChangeListener = new ChangeListener() {
        public void stateChanged(ChangeEvent changeEvent) {
            JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
            int index = sourceTabbedPane.getSelectedIndex();

            //System.out.println("Tab changed to: " + index +":"+sourceTabbedPane.getTitleAt(index));
            if (index != 0) {
                BuildaVater bV = myBuilderz.get(index - 1);
                for (int i = 0; i < bV.getChooserAnzahl(); i++) {
                    BuildaHQ.registerNewChooserGruppe(bV.getChooserGruppe(i), i + 1);
                }
                BuildaHQ.aktBuildaVater = bV;
                reflectionKennung = bV.reflectionKennungLokal;
            }
        }
    };
    private Vector<JPanel> buildaPanelz = new Vector<JPanel>();
    private BuildaTextArea myBuilderTextArea;
    private JDialog myDialog = new JDialog(myWindow, "Fehler", true);
    private int clickXWindow = 0;
    private int clickYWindow = 0;
    private boolean loadWithDokumenteHashtable = true; // siehe load und actionPerformed.
    private String aktVolk = "";
    private LoadWindow loadWindow;
    private BuildaMenu menu;
    private Credits credits;

    private Preferences prefs = Preferences.userNodeForPackage(oc.OnlineCodex.class);
    private MouseListener dragAndDropMouseListener = new MouseListener() {

        @Override

        public void mousePressed(MouseEvent event) {
            clickXWindow = event.getX();
            clickYWindow = event.getY();
        }

        @Override
        public void mouseExited(MouseEvent event) {
        }

        @Override
        public void mouseEntered(MouseEvent event) {
        }

        @Override
        public void mouseClicked(MouseEvent event) {
        }

        @Override
        public void mouseReleased(MouseEvent event) {
        }
    };
    private MouseMotionListener dragAndDropMouseMotionListener = new MouseMotionListener() {

        @Override
        public void mouseDragged(MouseEvent event) {
            JScrollPane sp;
            if (myBuilderz.get(tab.getSelectedIndex() - 1).superformation != null) {
                sp = (JScrollPane) myBuilderz.get(tab.getSelectedIndex() - 1).superformation.tab.getSelectedComponent();
            } else {
                sp = (JScrollPane) tab.getSelectedComponent();
            }
            sp.getVerticalScrollBar().setValue(sp.getVerticalScrollBar().getValue() + (clickYWindow - event.getY()));
            sp.getHorizontalScrollBar().setValue(sp.getHorizontalScrollBar().getValue() + (clickXWindow - event.getX()));
            clickYWindow = event.getY();
            clickXWindow = event.getX();
        }

        @Override
        public void mouseMoved(MouseEvent event) {
        }
    };
    private ActionListener volkChangeListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent event) {
            String name = "";
            try {
                BuildaVater myBuilder = new LeererBuilder();

                budget.setEnabled(true);
                name = BuildaHQ.formZuKlassenName((buildaChooser.getSelectedObjects()[0]).toString());
                if (getGame() != WH40K) {
                    dokumente.put(aktVolk, getSaveText());
                }

                aktVolk = name; // switch to new active army

                if (getGame() != WH40K) {
                    BuildaHQ.leereStatischeInformationen();
                    if (tab.getComponentCount() > 1) {
                        tab.remove(1);
                        removeBuilda(0);
                    }
                }

                if (name.equals("")) {
                    return;//Es soll kein Leerer Tab eingefügt werden
                } else {
                    System.out.println(Class.forName(armyPackage + "armies.VOLK" + name));
                    myBuilder = (BuildaVater) (Class.forName(armyPackage + "armies.VOLK" + name).newInstance());
                }
                if (getGame() != WH40K) {
                    if (loadWithDokumenteHashtable && dokumente.get(name) != null) {
                        load(dokumente.get(name), false);
                    }
                }

                if (event.getSource() == buildaChooser) {
                    JPanel buildaPanel = myBuilder.getPanel();
                    buildaPanel.setPreferredSize(new Dimension(3500, 8000));
                    buildaPanel.setSize(3500, 8000);
                    buildaPanelz.add(buildaPanel);
                    myBuilder.setTextArea(myBuilderTextArea);
                    myBuilder.volk = (buildaChooser.getSelectedObjects()[0]).toString();
                    myBuilderTextArea.addBuildaVater(myBuilder);
                    myBuilderz.add(myBuilder);
                    JScrollPane sp = new JScrollPane(buildaPanel);
                    sp.addMouseMotionListener(dragAndDropMouseMotionListener);
                    sp.addMouseListener(dragAndDropMouseListener);
                    sp.setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - menuHöhe - 28));
                    sp.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - menuHöhe - 28));
                    tab.addTab(name, null, sp);
                    if (getGame() == WH40K) {
                        tab.setTabComponentAt(myBuilderz.size(), new ButtonTabComponent(tab, onlineCodex));
                    }
                    myBuilderTextArea.textAreaRefresh();
                }
                myWindow.repaint();
            } catch (Exception e) {
                fehler("VOLK" + name + ".class nicht gefunden.\nBitte melden!!");
                e.printStackTrace();
            }
        }
    };
    private RefreshListener refreshListener = new RefreshListener((byte) 15) {

        @Override
        public void refresh() {

            double kosten = getKosten();
            double cp = 3 + getCP();

            switch (BuildaHQ.getCountFromInformationVectorGlobal("Relic")) {
                case 2:
                    cp -= 1;
                    break;
                case 3:
                    cp -= 3;
                    break;
                default:
                    break;
            }

            if (kosten != 0) {
                kostenLabel.setText(BuildaHQ.translate("Insgesamt") + " " + entferneNullNachkomma(kosten) + " " + BuildaHQ.translate("Pkt.") + " / " + entferneNullNachkomma(cp) + " CP");
                try {
                    if (getGame() == WHFB && (budget.getText().equals("") || getKosten() > Integer.valueOf(budget.getText()))) {
                        kostenLabel.setForeground(Color.RED);
                    } else {
                        kostenLabel.setForeground(Color.BLACK);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, BuildaHQ.translate("Bitte nur Zahlen eingeben."));
                }
            } else {
                kostenLabel.setText("");
            }
        }
    };
    private KeyListener budgetChangeListener = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            refreshListener.refresh();
        }
    };

    public OnlineCodex(Optional<Version> version, String[] args) {
        this.version = version;
        this.windowTitle = "powered by OnlineCodex.de" + version
                .map(v -> " – Version " + v)
                .orElse("");
        boolean gameFound = false;

        try {
            Class.forName("oc.wh40k.armies.VOLKBloodAngels");
            setGame(WH40K);
            gameFound = true;
        } catch (ClassNotFoundException ex) {
        }

        if (!gameFound) {
            try {
                Class.forName("oc.whfb.armies.VOLKHochelfen");
                setGame(WHFB);
                gameFound = true;
            } catch (ClassNotFoundException ex) {
            }
        }

        if (!gameFound) {
            try {
                Class.forName("oc.necro.armies.VOLKEscher");
                setGame(NECROMUNDA);
                gameFound = true;
            } catch (ClassNotFoundException ex) {
            }
        }

        if (!gameFound) {
            try {
                Class.forName("oc.legacy.wh40k.armies.VOLKBloodAngelsCodex2007");
                setGame(WH40K_LEGACY);
                gameFound = true;
            } catch (ClassNotFoundException ex) {
            }
        }
        if (!gameFound) {
            try {
                Class.forName("oc.legacy.whfb.armies.VOLKChaosZwerge2000");
                setGame(WHFB_LEGACY);
                gameFound = true;
            } catch (ClassNotFoundException ex) {
            }
        }

        if (!gameFound) {
            try {
                Class.forName("oc.fan.wh40k.armies.VOLKBadMoonsTheWaaagh");
                setGame(WH40K_FANDEX);
                gameFound = true;
            } catch (ClassNotFoundException ex) {
            }
        }

        if (!gameFound) {
            fehler("Es konnte nicht bestimmt werden, welches Spiel geladen werden soll.");
            System.out.println("Es konnte nicht bestimmt werden, welches Spiel geladen werden soll.");
            System.exit(0);
        }

        /**** Please do NOT commit the following line with WHFB enabled. ****/
        /**** Will cause release packaging to fail!                     ****/
        //setGame(WHFB);
        //setGame(WH40K_LEGACY);
        //setGame(WH40K_FANDEX);
        //setGame(NECROMUNDA);

        armyPackage = "oc.wh40k.";
        if (getGame() == WH40K_LEGACY) {
            armyPackage = "oc.legacy.wh40k.";
        } else if (getGame() == WHFB) {
            armyPackage = "oc.whfb.";
        } else if (getGame() == WHFB_LEGACY) {
            armyPackage = "oc.legacy.whfb.";
        } else if (getGame() == NECROMUNDA) {
            armyPackage = "oc.necro.";
        } else if (getGame() == WH40K_FANDEX) {
            armyPackage = "oc.fan.wh40k.";
        }

        onlineCodex = this;

        BuildaHQ.setSprache(Sprache.German);
        ToolTipManager.sharedInstance().setDismissDelay(8000); // wie lange ein tooltip angezeigt wird, bis er wieder weggeht
        BuildaHQ.machTextStrings(false);

        myWindow.setBounds(0, 0, FRAME_MIN_WIDTH, 600);
        myWindow.setLayout(null);
        myWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myWindow.getContentPane().setBackground(Color.WHITE);
        myWindow.setIconImage(BuildaHQ.oCLogo);

        myWindow.setTitle("OnlineCodex Wh40k - " + windowTitle);
        buildaChooser = new JComboBox(buildazWh40k);


        buildaChooser.setBounds(5, 3, 290, 18);
        buildaChooser.setFocusable(false); // sie hat nie den Focus und wird deshalb nie durch die Pfeil-Unten-Taste geöffnet
        buildaChooser.addActionListener(volkChangeListener);
        BuildaHQ.newGUIComponent(buildaChooser);
        buildaChooser.setMaximumRowCount(30);
        buildaChooser.setToolTipText(BuildaHQ.translate("Hier können Sie Ihr Volk auswählen. Die Einträge des alten Volkes bleiben im Arbeitsspeicher und werden geladen, sobald sie es wieder auswählen."));

        if (getGame() == WHFB) {
            budget.setEnabled(false);
            budget.setBounds(300, 4, 40, 18);
            budget.addKeyListener(budgetChangeListener);
            budget.setFont(new Font("arial", Font.BOLD, 12));
            budget.setBackground(Color.WHITE);
            budget.setAlignmentY(JComponent.CENTER_ALIGNMENT);
            budget.setText("2000");

            kostenLabel.setBounds(295, 4, 180, 16);
            kostenLabel.setFont(new Font("arial", Font.BOLD + Font.ITALIC, 14));
            kostenLabel.setBackground(Color.GREEN);
        } else {
            kostenLabel.setBounds(300, 4, 180, 16);
            kostenLabel.setFont(new Font("arial", Font.BOLD + Font.ITALIC, 14));
            kostenLabel.setBackground(Color.GREEN);
        }

        menu = new BuildaMenu();
        credits = new Credits();

        menuPanel.add(buildaChooser);

        if (getGame() == WHFB) {
            menuPanel.add(budget);
        }
        menuPanel.add(kostenLabel);
        menuPanel.setLayout(null);
        menuPanel.setBounds(-1, -1, 2500 + 1, menuHöhe + 1); // -1 damit border oben net sichtbar ist    soll nur den unterens schwarzen Trennstrich machen
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setBorder(BorderFactory.createLineBorder(new Color(10, 40, 160)));

        openMenu.setText(BuildaHQ.translate("Menü"));
        openMenu.setBounds(BILDSCHIRMBREITE - 75, 4, 65, 16);
        BuildaHQ.newGUIComponent(openMenu);
        openMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                menu.setVisible(true);
            }
        });
        menuPanel.add(openMenu);

        openCredits.setText(BuildaHQ.translate("Credits"));
        openCredits.setBounds(BILDSCHIRMBREITE - 155, 4, 75, 16);
        BuildaHQ.newGUIComponent(openCredits);
        openCredits.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                credits.setVisible(true);
            }
        });
        menuPanel.add(openCredits);

        saveTextWindow = new SaveTextWindow(myWindow, prefs.get(PREFERENCES_SAVE_DIRECTORY, null));
        loadWindow = new LoadWindow(prefs.get(PREFERENCES_LOAD_DIRECTORY, null));

        saveButton.setText(BuildaHQ.translate("Speichern"));
        saveButton.setBounds(BILDSCHIRMBREITE - 240, 4, 80, 16);
        saveButton.setBorder(null);
        saveButton.setMargin(new Insets(0, 0, 0, 0));
        BuildaHQ.newGUIComponent(saveButton);
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                saveTextWindow = new SaveTextWindow(myWindow, prefs.get(PREFERENCES_SAVE_DIRECTORY, null));
                saveTextWindow.setSaveText(getSaveText());
                String armyListHumanReadable = myBuilderTextArea.getText(); //neuGerri
                saveTextWindow.setArmyList(armyListHumanReadable.replaceAll("\n", System.getProperty("line.separator")));//neuGerri
                saveTextWindow.save();
            }
        });
        menuPanel.add(saveButton);

        loadButton.setText(BuildaHQ.translate("Laden"));
        loadButton.setBounds(BILDSCHIRMBREITE - 305, 4, 60, 16);
        loadButton.setBorder(null);
        loadButton.setMargin(new Insets(0, 0, 0, 0));
        loadButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                loadWindow.load(getGame());
                loadWindow.setVisible(true);

                if (loadWindow.getLoadElement() != null) {
                    loadElement(loadWindow.getLoadElement(), true);
                } else if (!loadWindow.getLoadText().trim().equals("")) {
                    load(loadWindow.getLoadText(), true);
					/*if(getGame()==WH40K){
						//Speichern der Hauptarmee
						aktVolk=BuildaHQ.formZuKlassenName(loadWindow.getLoadText().substring(0, loadWindow.getLoadText().indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2)));
						dokumente.put(aktVolk, getSaveText());
					}*/
                }

            }
        });
        menuPanel.add(loadButton);

        final Color dunkelgrau = new Color(90, 90, 90);

        loadButton.setForeground(dunkelgrau);
        saveButton.setForeground(dunkelgrau);
        openMenu.setForeground(dunkelgrau);
        openCredits.setForeground(dunkelgrau);


        myBuilderTextArea = new BuildaTextArea();
        textPanel = myBuilderTextArea.getPanel();
        tab.addTab("Liste", null, textPanel);
        tab.setLocation(5, menuHöhe + 5);
        tab.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 25, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 55);
        tab.addChangeListener(tabChangeListener);
        myWindow.add(tab);
        myWindow.add(menuPanel);

        myWindow.addWindowListener(
                new WindowListener() {

                    @Override
                    public void windowClosing(WindowEvent event) {

                        savePreferences();

                        myWindow.dispose();
                        try {
                            System.exit(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } // WICHTIG! sonst bleibt der Thread bestehen   (im Task Manager beenden).   Online: Acces denid...

                    @Override
                    public void windowDeactivated(WindowEvent event) {
                    }

                    @Override
                    public void windowDeiconified(WindowEvent event) {
                    }

                    @Override
                    public void windowIconified(WindowEvent event) {
                    }

                    @Override
                    public void windowOpened(WindowEvent event) {
                    }

                    @Override
                    public void windowActivated(WindowEvent event) {
                    }

                    @Override
                    public void windowClosed(WindowEvent event) {
                        myWindow.dispose();

                        try {
                            System.exit(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } // WICHTIG! sonst bleibt der Thread bestehen   (im Task Manager beenden).   Online: Acces denid...
                });

        myWindow.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent event) {
                int BILDSCHIRMBREITE = myWindow.getSize().width;

                if (BILDSCHIRMBREITE < FRAME_MIN_WIDTH) {
                    myWindow.setSize(FRAME_MIN_WIDTH, myWindow.getSize().height);
                    BILDSCHIRMBREITE = FRAME_MIN_WIDTH;
                }

                openMenu.setLocation(BILDSCHIRMBREITE - 75, 4);
                openCredits.setLocation(BILDSCHIRMBREITE - 155, 4);
                saveButton.setLocation(BILDSCHIRMBREITE - 240, 4);
                loadButton.setLocation(BILDSCHIRMBREITE - 305, 4);
                tab.setSize(myWindow.getSize().width - 25, myWindow.getSize().height - 75);
                for (int i = 0; i < myBuilderz.size(); i++) {
                    if (myBuilderz.get(i).superformation != null) {
                        myBuilderz.get(i).superformation.tab.setSize(myWindow.getSize().width - 38, myWindow.getSize().height - 129);
                    }
                }
                myBuilderTextArea.setTextAreaBound(myWindow.getSize().height);
            }

            @Override
            public void componentHidden(ComponentEvent event) {
            }

            @Override
            public void componentShown(ComponentEvent event) {
            }

            @Override
            public void componentMoved(ComponentEvent event) {
            }
        });

        BuildaHQ.newGUIComponent(myWindow);

        myWindow.setVisible(true);

        // neuGerri
        if (args.length > 0) {
            loadWindow.loadFile(new java.io.File(args[0]), getGame());
            if (!loadWindow.getLoadText().trim().equals("")) {
                load(loadWindow.getLoadText(), true);
            }
        }

    }

    public static void main(String[] args) {
        Optional<Version> version = ManifestUtils.getVersion();
        version.ifPresent(VersionChecker::execute);
        new OnlineCodex(version, args); // neuGerrig
    }

    public static OnlineCodex getInstance() {
        return onlineCodex;
    }

    public BuildaMenu getMenu() {
        return this.menu;
    }

    public int getBudget() {
        return Integer.parseInt(budget.getText());
    }

    public boolean isApo() {
        return this.menu.isApo();
    }

    public JPanel getBuildaPanel() {
        return panel;
    }

    public JPanel getTextPanel() {
        return this.textPanel;
    }

    public MouseListener getDragAndDropMouseListener() {
        return dragAndDropMouseListener;
    }

    public MouseMotionListener getDragAndDropMouseMotionListener() {
        return dragAndDropMouseMotionListener;
    }

    public boolean dokumenteContains(String s) {
        s = BuildaHQ.formZuKlassenName(s);
        return dokumente.get(s) != null;
    }

    public final void fehler(String s) {
        myDialog = new JDialog(myWindow, "Fehler", true);
        JTextPane myTextPane = new JTextPane();

        int i = BuildaHQ.countStringsInString(s, "\n") + 1;

        myTextPane.setBounds(2, 2, BuildaHQ.maxStringWidth(myTextPane, s.split("\n")) + 15, i * 16);
        myTextPane.setVisible(true);
        myTextPane.setText(s);
        myTextPane.setEditable(false);

        JButton myButton = new JButton("OK");

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myDialog.setVisible(false);
            }
        };

        myButton.addActionListener(listener);
        myButton.setBounds(myTextPane.getWidth() / 2 - 75 / 2, myTextPane.getHeight() + 15, 75, 25);
        myButton.setVisible(true);

        myDialog.getContentPane().setBackground(Color.white);
        myDialog.setLayout(null);
        myDialog.setResizable(false);

        myDialog.add(myTextPane);
        myDialog.add(myButton);

        myDialog.setSize(myTextPane.getWidth() + 10, myTextPane.getHeight() + 90);
        myDialog.setLocation(BILDSCHIRMBREITE / 2 - myDialog.getWidth() / 2, BILDSCHIRMHÖHE / 2 - myDialog.getHeight() / 2);
        myDialog.setVisible(true);
    }

    @Override
    public double getKosten() {
        double kostenD = 0.0;
        for (int i = 0; i < myBuilderz.size(); i++) {
            kostenD += myBuilderz.get(i).getKosten();
        }
        //System.out.println("OC: " + kostenD);
        return kostenD;
    }

    public double getCP() {
        double kostenD = 0.0;
        for (int i = 0; i < myBuilderz.size(); i++) {
            kostenD += myBuilderz.get(i).getCP();
        }
        //System.out.println("OC: " + kostenD);
        return kostenD;
    }

    public String getSaveText() {
        //System.out.println(buildaChooser.getSelectedObjects()[0].toString() + SAVETEXT_UEBERSCHRIFTTRENNER2 + myBuilder.getSaveText());
        String s = "";
        for (int i = 0; i < myBuilderz.size(); i++) {
            s += tab.getTitleAt(i + 1) + SAVETEXT_UEBERSCHRIFTTRENNER2 +
                    (myBuilderz.get(i).getReflectionKennung().equals("CM") ? myBuilderz.get(i).supplementBox.getSelectedItem() : myBuilderz.get(i).kontingentBox.getSelectedItem()) + SAVETEXT_DETACHMENTTYPTRENNER1 +
                    myBuilderz.get(i).formationBox.getSelectedItem() + SAVETEXT_DETACHMENTTYPTRENNER2 +
                    (myBuilderz.get(i).Hauptkontingent.isSelected() ? "y" : "n") + SAVETEXT_DETACHMENTTYPTRENNER3 +
//					 ((myBuilderz.get(i) instanceof VOLKSternenreichderTau)?(((VOLKSternenreichderTau)myBuilderz.get(i)).Farsight.isSelected()?"y":"n") + SAVETEXT_FARSIGHT:"") +
                    ((myBuilderz.get(i) instanceof VOLKAstraMilitarum) ? (((VOLKAstraMilitarum) myBuilderz.get(i)).Cadian.isSelected() ? "y" : "n") + SAVETEXT_CADIANS : "") +
                    ((myBuilderz.get(i) instanceof VOLKSpaceMarines) ? (((VOLKSpaceMarines) myBuilderz.get(i)).Raukaan.isSelected() ? "y" : "n") + SAVETEXT_RAUKAAN : "") +
                    ((myBuilderz.get(i) instanceof VOLKSpaceMarines) ? (((VOLKSpaceMarines) myBuilderz.get(i)).SoT.isSelected() ? "y" : "n") + SAVETEXT_SOT : "") +
                    myBuilderz.get(i).getSaveText() + SAVETEXT_DETACHMENTTRENNER;
        }
        return s;
    }

    public Element getSaveElement() {
        Element root = myBuilderz.get(tab.getSelectedIndex() - 1).getSaveElement();
        //Element root = myBuilder.getSaveElement();
        root.setAttribute("choice", buildaChooser.getSelectedObjects()[0].toString());
        if (budget != null && budget.isEnabled() && !budget.getText().equals("")) {
            root.setAttribute("budget", Integer.toString(getBudget()));
        }

        return root;
    }

    public BuildaVater getBuilder() {
        //return myBuilder;
        return myBuilderz.get(tab.getSelectedIndex() + 1);
    }

    public JComboBox getChooser() {
        return buildaChooser;
    }

    public void loadElement(Element e, boolean chooserUmstellen) {
        try {
            if (chooserUmstellen) {
                loadWithDokumenteHashtable = false;
                setSelectedItemInBuildaChooser(e.getAttribute("choice"));
                loadWithDokumenteHashtable = true;
            }

            myBuilderz.get(tab.getSelectedIndex() - 1).loadElement(e);

            if (!e.getAttribute("budget").equals("")) {
                budget.setText(e.getAttribute("budget"));
            }

            BuildaHQ.loadWindow = false;
            loadWindow.setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, BuildaHQ.translate("Datei konnte nicht gelesen werden"));
        }
    }

    public void load(String saveText, boolean chooserUmstellen) {
        if (saveText.trim().equals("")) {
            return;
        }

        try {


            BuildaHQ.leereStatischeInformationen();
//				System.out.println("myBuilderz.size()"+myBuilderz.size());
            while (myBuilderz.size() > 0) {
                myBuilderTextArea.removeBuildaVater(myBuilderz.get(0));
                buildaPanelz.remove(0);
                myBuilderz.remove(0);
                tab.remove(1);
            }

            if (saveText.contains(SAVETEXT_DETACHMENTTRENNER)) {
                String armies[] = saveText.split(SAVETEXT_DETACHMENTTRENNER);
                for (int i = 0; i < armies.length; i++) {
					/*if (chooserUmstellen) {
						loadWithDokumenteHashtable = false;
						setSelectedItemInBuildaChooser(armies[i].substring(0, armies[i].indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2)));
						loadWithDokumenteHashtable = true;
					}*/
                    System.out.println(armies[i]);
                    myBuilderz.add((BuildaVater) (Class.forName(armyPackage + "armies.VOLK" + BuildaHQ.formZuKlassenName(armies[i].substring(0, armies[i].indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2)))).newInstance()));
//					System.out.println(myBuilderz.size());
                    JPanel buildaPanel = myBuilderz.get(i).getPanel();
                    buildaPanel.setPreferredSize(new Dimension(3500, 8000));
                    buildaPanel.setSize(3500, 8000);
                    buildaPanelz.add(buildaPanel);
                    myBuilderz.get(i).setTextArea(myBuilderTextArea);
                    myBuilderz.get(i).volk = armies[i].substring(0, armies[i].indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2));
                    myBuilderTextArea.addBuildaVater(myBuilderz.get(i));
                    //myBuilderz.add(myBuilderz.get(i));
                    JScrollPane sp = new JScrollPane(buildaPanel);
                    sp.addMouseMotionListener(dragAndDropMouseMotionListener);
                    sp.addMouseListener(dragAndDropMouseListener);
                    sp.setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - menuHöhe - 28));
                    sp.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - menuHöhe - 28));
                    String name = armies[i].substring(0, armies[i].indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2));
                    tab.addTab(name, null, sp);
                    if (getGame() == WH40K) {
                        tab.setTabComponentAt(i + 1, new ButtonTabComponent(tab, onlineCodex));
                    }

                    myBuilderz.get(i).isLoading = true;
                    ////////////////
                    for (int j = 0; j < myBuilderz.get(i).getChooserAnzahl(); j++) {
                        BuildaHQ.registerNewChooserGruppe(myBuilderz.get(i).getChooserGruppe(j), j + 1);
                    }
                    BuildaHQ.aktBuildaVater = myBuilderz.get(i);
                    /////////////////
                    String kontingent = armies[i].substring(armies[i].indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2) + SAVETEXT_UEBERSCHRIFTTRENNER2.length(), armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER1));
                    String formation = armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER1) + SAVETEXT_DETACHMENTTYPTRENNER1.length(), armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER2));
                    String haupt = armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER2) + SAVETEXT_DETACHMENTTYPTRENNER2.length(), armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3));
                    String farsight = "";
                    String cadians = "";
                    String raukaan = "";
                    String sot = "";
                    if (armies[i].contains(SAVETEXT_FARSIGHT)) {
                        farsight = armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), armies[i].indexOf(SAVETEXT_FARSIGHT));
                    } else if (armies[i].contains(SAVETEXT_CADIANS)) {
                        cadians = armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), armies[i].indexOf(SAVETEXT_CADIANS));
                    } else if (armies[i].contains(SAVETEXT_SOT) && armies[i].contains(SAVETEXT_RAUKAAN)) {
                        sot = armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), armies[i].indexOf(SAVETEXT_SOT));
                        raukaan = armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), armies[i].indexOf(SAVETEXT_RAUKAAN));
                    } else if (armies[i].contains(SAVETEXT_RAUKAAN)) {
                        raukaan = armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), armies[i].indexOf(SAVETEXT_RAUKAAN));
                    }
                    if (!kontingent.equals("")) {
                        if (myBuilderz.get(i).getReflectionKennung().equals("CM")) {
                            myBuilderz.get(i).supplementBox.setSelectedItem(kontingent);
                        } else {
                            myBuilderz.get(i).kontingentBox.setSelectedItem(kontingent);
                        }
                    }
                    if (!formation.equals("")) {
                        myBuilderz.get(i).formationBox.setSelectedItem(formation);
                    }
                    if (haupt.equals("y")) {
                        myBuilderz.get(i).Hauptkontingent.doClick();
                    }
//					if(farsight.equals("y")){
//						((VOLKSternenreichderTau)myBuilderz.get(i)).Farsight.doClick();
//					}
                    if (cadians.equals("y")) {
                        ((VOLKAstraMilitarum) myBuilderz.get(i)).Cadian.doClick();
                    }
                    if (raukaan.equals("y")) {
                        ((VOLKSpaceMarines) myBuilderz.get(i)).Raukaan.doClick();
                    }
                    if (sot.equals("y")) {
                        ((VOLKSpaceMarines) myBuilderz.get(i)).SoT.doClick();
                    }
                    if (armies[i].contains(SAVETEXT_FARSIGHT)) {
                        myBuilderz.get(i).load(armies[i].substring(armies[i].indexOf(SAVETEXT_FARSIGHT) + SAVETEXT_FARSIGHT.length(), armies[i].length()));
                    } else if (armies[i].contains(SAVETEXT_CADIANS)) {
                        myBuilderz.get(i).load(armies[i].substring(armies[i].indexOf(SAVETEXT_CADIANS) + SAVETEXT_CADIANS.length(), armies[i].length()));
                    } else if (armies[i].contains(SAVETEXT_SOT) && armies[i].contains(SAVETEXT_RAUKAAN)) {
                        myBuilderz.get(i).load(armies[i].substring(armies[i].indexOf(SAVETEXT_SOT) + SAVETEXT_SOT.length(), armies[i].length()));
                    } else if (armies[i].contains(SAVETEXT_RAUKAAN)) {
                        myBuilderz.get(i).load(armies[i].substring(armies[i].indexOf(SAVETEXT_RAUKAAN) + SAVETEXT_RAUKAAN.length(), armies[i].length()));
                    } else {
                        myBuilderz.get(i).load(armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), armies[i].length()));
                    }
                    myBuilderz.get(i).isLoading = false;
                }
            } else {
				/*if (chooserUmstellen) {
					loadWithDokumenteHashtable = false;
					setSelectedItemInBuildaChooser(saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2)));
					loadWithDokumenteHashtable = true;
				}*/

                System.out.println(saveText);
                myBuilderz.add((BuildaVater) (Class.forName(armyPackage + "armies.VOLK" + BuildaHQ.formZuKlassenName(saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2)))).newInstance()));
//					System.out.println(myBuilderz.size());
                JPanel buildaPanel = myBuilderz.get(0).getPanel();
                buildaPanel.setPreferredSize(new Dimension(3500, 8000));
                buildaPanel.setSize(3500, 8000);
                buildaPanelz.add(buildaPanel);
                myBuilderz.get(0).setTextArea(myBuilderTextArea);
                myBuilderz.get(0).volk = saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2));
                myBuilderTextArea.addBuildaVater(myBuilderz.get(0));
                JScrollPane sp = new JScrollPane(buildaPanel);
                sp.addMouseMotionListener(dragAndDropMouseMotionListener);
                sp.addMouseListener(dragAndDropMouseListener);
                sp.setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - menuHöhe - 28));
                sp.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - menuHöhe - 28));
                String name = saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2));
                tab.addTab(name, null, sp);
                if (getGame() == WH40K) {
                    tab.setTabComponentAt(1, new ButtonTabComponent(tab, onlineCodex));
                }

                myBuilderz.get(0).isLoading = true;
                ////////////////
                for (int j = 0; j < myBuilderz.get(0).getChooserAnzahl(); j++) {
                    BuildaHQ.registerNewChooserGruppe(myBuilderz.get(0).getChooserGruppe(j), j + 1);
                }
                BuildaHQ.aktBuildaVater = myBuilderz.get(0);
                /////////////////
                String kontingent = saveText.substring(saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2) + SAVETEXT_UEBERSCHRIFTTRENNER2.length(), saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER1));
                String formation = saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER1) + SAVETEXT_DETACHMENTTYPTRENNER1.length(), saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER2));
                String haupt = saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER2) + SAVETEXT_DETACHMENTTYPTRENNER2.length(), saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3));
                String farsight = "";
                String cadians = "";
                String raukaan = "";
                String sot = "";
                if (saveText.contains(SAVETEXT_FARSIGHT)) {
                    farsight = saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), saveText.indexOf(SAVETEXT_FARSIGHT));
                } else if (saveText.contains(SAVETEXT_CADIANS)) {
                    farsight = saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), saveText.indexOf(SAVETEXT_CADIANS));
                } else if (saveText.contains(SAVETEXT_SOT) && saveText.contains(SAVETEXT_RAUKAAN)) {
                    sot = saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), saveText.indexOf(SAVETEXT_SOT));
                    raukaan = saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), saveText.indexOf(SAVETEXT_RAUKAAN));
                } else if (saveText.contains(SAVETEXT_RAUKAAN)) {
                    raukaan = saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), saveText.indexOf(SAVETEXT_RAUKAAN));
                }
                if (!kontingent.equals("")) {
                    myBuilderz.get(0).kontingentBox.setSelectedItem(kontingent);
                }
                if (!formation.equals("")) {
                    myBuilderz.get(0).formationBox.setSelectedItem(formation);
                }
                if (haupt.equals("y")) {
                    myBuilderz.get(0).Hauptkontingent.doClick();
                }
//					if(farsight.equals("y")){
//						((VOLKSternenreichderTau)myBuilderz.get(0)).Farsight.doClick();
//					}
                if (cadians.equals("y")) {
                    ((VOLKAstraMilitarum) myBuilderz.get(0)).Cadian.doClick();
                }
                if (raukaan.equals("y")) {
                    ((VOLKSpaceMarines) myBuilderz.get(0)).Raukaan.doClick();
                }
                if (sot.equals("y")) {
                    ((VOLKSpaceMarines) myBuilderz.get(0)).SoT.doClick();
                }
                if (saveText.contains(SAVETEXT_FARSIGHT)) {
                    myBuilderz.get(0).load(saveText.substring(saveText.indexOf(SAVETEXT_FARSIGHT) + SAVETEXT_FARSIGHT.length(), saveText.length()));
                } else if (saveText.contains(SAVETEXT_CADIANS)) {
                    myBuilderz.get(0).load(saveText.substring(saveText.indexOf(SAVETEXT_CADIANS) + SAVETEXT_CADIANS.length(), saveText.length()));
                } else if (saveText.contains(SAVETEXT_SOT) && saveText.contains(SAVETEXT_RAUKAAN)) {
                    myBuilderz.get(0).load(saveText.substring(saveText.indexOf(SAVETEXT_SOT) + SAVETEXT_SOT.length(), saveText.length()));
                } else if (saveText.contains(SAVETEXT_RAUKAAN)) {
                    myBuilderz.get(0).load(saveText.substring(saveText.indexOf(SAVETEXT_RAUKAAN) + SAVETEXT_RAUKAAN.length(), saveText.length()));
                } else {
                    myBuilderz.get(0).load(saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), saveText.length()));
                }
                myBuilderz.get(0).isLoading = false;
            }


            //BuildaHQ.aktBuildaVater=null;
            BuildaHQ.loadWindow = false;
            loadWindow.setVisible(false);


        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, BuildaHQ.translate("Datei konnte nicht gelesen werden."));
        }

    }

    public void dokumentLeeren() {
        loadWithDokumenteHashtable = false;
        setSelectedItemInBuildaChooser(buildaChooser.getSelectedItem()); // ruft actionPerformed(ActionEvent event) auf
        loadWithDokumenteHashtable = true;

    }

    public void setSelectedItemInBuildaChooser(Object s) {
        Object[] buildaz = buildazWh40k;
        for (int i = 0; i < buildaz.length; ++i) {
            if (buildaz[i].toString().equals(s.toString())) {
                buildaChooser.setSelectedItem(buildaz[i]);
            }
        }
    }

    public String getCurrentArmy() {
        return this.aktVolk;
    }

    public Preferences getPrefs() {
        return prefs;
    }

    public void savePreferences() {
        prefs.put(PREFERENCES_SAVE_DIRECTORY, saveTextWindow.getCurrentDir());
        prefs.put(PREFERENCES_LOAD_DIRECTORY, loadWindow.getCurrentDir());

        menu.savePrefs();
    }

    public boolean isCurrentArmy(Class<?> army) {
        return ("VOLK" + getCurrentArmy()).equals(army.getSimpleName());
    }

    public void removeBuilda(int i) {
        BuildaVater bV = myBuilderz.get(i);
        for (int j = 0; j < bV.getChooserAnzahl(); j++) {
            ChooserGruppe cg = bV.getChooserGruppe(j);
            while (cg.getmC().size() > 0) {
                if (cg.getmC().get(0).getEintrag() != null) {
                    cg.getmC().get(0).aktuellenEintragLöschen();
                    cg.getmC().remove(0);
                } else {
                    break;
                }
            }
        }
        myBuilderTextArea.removeBuildaVater(myBuilderz.get(i));
        buildaPanelz.remove(i);
        myBuilderz.remove(i);
        RefreshListener.fireRefresh();
    }

    @SuppressWarnings("serial")
    static class ComboBoxRenderer extends JLabel implements ListCellRenderer {

        public ComboBoxRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof IconedText && !value.toString().equals("")) {
                IconedText wert = (IconedText) value;

                this.setIcon(wert.icon);
                this.setText(wert.text);
            } else {
                this.setText(" ");
                this.setIcon(null);
            } // "" wird irgendwie ignoriert

            if (isSelected) {
                this.setBackground(list.getSelectionBackground());
                this.setForeground(list.getSelectionForeground());
            } else {
                this.setBackground(list.getBackground());
                this.setForeground(list.getForeground());
            }

            return this;
        }
    }

    static class IconedText {

        ImageIcon icon;
        String text;

        public IconedText(String t, String path) {
            this.text = t;
        }

        @Override
        public String toString() {  // fürn Reflection-ActionListener unten wichtig
            return text;
        }
    }

}


