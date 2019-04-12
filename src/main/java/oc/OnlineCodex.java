package oc;

import com.github.zafarkhaja.semver.Version;
import oc.persistence.oc.OCWriter;
import oc.utils.ManifestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.*;
import java.util.Optional;
import java.util.Vector;
import java.util.prefs.Preferences;

import static oc.RefreshListener.addRefreshListener;


public class OnlineCodex extends BuildaPanel {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnlineCodex.class);

    private static final int MENU_HEIGHT = 23;
    private final static int FRAME_MIN_WIDTH = 750;
    static final String ARMY_PACKAGE = "oc.wh40k.";

    private static OnlineCodex onlineCodex;
    private final JButton openMenu = new JButton();
    private final JButton openCredits = new JButton();
    private final JButton saveButton = new JButton();
    private final JButton loadButton = new JButton();
    private final JFrame myWindow = new JFrame("OnlineCodex powered by OnlineCodex.de");
    private SaveTextWindow saveTextWindow;
    private final Object[] buildazWh40k = new Object[]{
            "",
            new IconedText("Aeldari"),
            new IconedText("Chaos"),
            new IconedText("Imperium"),
            new IconedText("Necrons"),
            new IconedText("Orks"),
            new IconedText("Tyraniden"),
            new IconedText("Tau Empire"),
    };
    private JTabbedPane tab = new JTabbedPane();
    private final JComboBox<Object> buildaChooser;
    private final Vector<BuildaVater> myBuilderz = new Vector<>();

    private final BuildaTextArea myBuilderTextArea;
    private JDialog myDialog = new JDialog(myWindow, "Fehler", true);
    private int clickXWindow = 0;
    private int clickYWindow = 0;
    private final LoadWindow loadWindow;
    private final BuildaMenu menu;
    private final Credits credits;

    private final Preferences prefs = Preferences.userNodeForPackage(oc.OnlineCodex.class);
    private final MouseListener dragAndDropMouseListener = new MouseListener() {

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
    private final MouseMotionListener dragAndDropMouseMotionListener = new MouseMotionListener() {

        @Override
        public void mouseDragged(MouseEvent event) {
            JScrollPane sp = (JScrollPane) tab.getSelectedComponent();
            sp.getVerticalScrollBar().setValue(sp.getVerticalScrollBar().getValue() + (clickYWindow - event.getY()));
            sp.getHorizontalScrollBar().setValue(sp.getHorizontalScrollBar().getValue() + (clickXWindow - event.getX()));
            clickYWindow = event.getY();
            clickXWindow = event.getX();
        }

        @Override
        public void mouseMoved(MouseEvent event) {
        }
    };

    private void refresh() {
        final double kosten = getCost();
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
            kostenLabel.setText(BuildaHQ.translate("Insgesamt") + " " + ((int) kosten) + " " + BuildaHQ.translate("Pkt.") + " / " + ((int) cp) + " CP");
            kostenLabel.setForeground(Color.BLACK);
        } else {
            kostenLabel.setText("");
        }
    }

    public OnlineCodex(Optional<Version> version, String[] args) {
        addRefreshListener(RefreshListener.Priority.ONLINE_CODEX, this::refresh);

        final String windowTitle = "powered by OnlineCodex.de" + version
                .map(v -> " – Version " + v)
                .orElse("");

        onlineCodex = this;

        BuildaHQ.setSprache(Sprache.German);
        ToolTipManager.sharedInstance().setDismissDelay(8000); // wie lange ein tooltip angezeigt wird, bis er wieder weggeht
        BuildaHQ.machTextStrings(false);

        myWindow.setBounds(0, 0, FRAME_MIN_WIDTH, 600);
        myWindow.setLayout(null);
        myWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
        myWindow.getContentPane().setBackground(Color.WHITE);
        myWindow.setIconImage(BuildaHQ.oCLogo);

        myWindow.setTitle("OnlineCodex Wh40k - " + windowTitle);
        buildaChooser = new JComboBox<>(buildazWh40k);


        buildaChooser.setBounds(5, 3, 290, 18);
        buildaChooser.setFocusable(false); // sie hat nie den Focus und wird deshalb nie durch die Pfeil-Unten-Taste geöffnet
        // switch to new active army
        //Es soll kein Leerer Tab eingefügt werden
        ActionListener volkChangeListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                String name = "";
                try {
                    BuildaVater myBuilder;

                    budget.setEnabled(true);
                    name = BuildaHQ.formZuKlassenName((buildaChooser.getSelectedObjects()[0]).toString());

                    if (name.equals("")) {
                        return;//Es soll kein Leerer Tab eingefügt werden
                    } else {
                        myBuilder = (BuildaVater) (Class.forName(ARMY_PACKAGE + "armies.VOLK" + name).getDeclaredConstructor().newInstance());
                    }

                    if (event.getSource() == buildaChooser) {
                        final JPanel buildaPanel = myBuilder.getPanel();
                        buildaPanel.setPreferredSize(new Dimension(3500, 8000));
                        buildaPanel.setSize(3500, 8000);
                        myBuilder.setTextArea(myBuilderTextArea);
                        myBuilder.volk = (buildaChooser.getSelectedObjects()[0]).toString();
                        myBuilderTextArea.addBuildaVater(myBuilder);
                        myBuilderz.add(myBuilder);
                        final JScrollPane sp = new JScrollPane(buildaPanel);
                        sp.addMouseMotionListener(dragAndDropMouseMotionListener);
                        sp.addMouseListener(dragAndDropMouseListener);
                        sp.setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - MENU_HEIGHT - 28));
                        sp.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - MENU_HEIGHT - 28));
                        tab.addTab(name, null, sp);
                        tab.setTabComponentAt(myBuilderz.size(), new ButtonTabComponent(tab, onlineCodex));
                        myBuilderTextArea.textAreaRefresh();
                    }
                    myWindow.repaint();
                } catch (final Exception e) {
                    fehler("VOLK" + name + ".class nicht gefunden.\nBitte melden!!");
                    LOGGER.error("", e);
                }
            }
        };
        buildaChooser.addActionListener(volkChangeListener);
        BuildaHQ.newGUIComponent(buildaChooser);
        buildaChooser.setMaximumRowCount(30);
        buildaChooser.setToolTipText(BuildaHQ.translate("Hier können Sie Ihr Volk auswählen. Die Einträge des alten Volkes bleiben im Arbeitsspeicher und werden geladen, sobald sie es wieder auswählen."));

        kostenLabel.setBounds(300, 4, 180, 16);
        kostenLabel.setFont(new Font("arial", Font.BOLD + Font.ITALIC, 14));
        kostenLabel.setBackground(Color.GREEN);

        menu = new BuildaMenu();
        credits = new Credits();

        final JPanel menuPanel = new JPanel();
        menuPanel.add(buildaChooser);

        menuPanel.add(kostenLabel);
        menuPanel.setLayout(null);
        menuPanel.setBounds(-1, -1, 2500 + 1, MENU_HEIGHT + 1); // -1 damit border oben net sichtbar ist    soll nur den unterens schwarzen Trennstrich machen
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setBorder(BorderFactory.createLineBorder(new Color(10, 40, 160)));

        openMenu.setText(BuildaHQ.translate("Menü"));
        openMenu.setBounds(BILDSCHIRMBREITE - 75, 4, 65, 16);
        BuildaHQ.newGUIComponent(openMenu);
        openMenu.addActionListener(event -> menu.setVisible(true));
        menuPanel.add(openMenu);

        openCredits.setText(BuildaHQ.translate("Credits"));
        openCredits.setBounds(BILDSCHIRMBREITE - 155, 4, 75, 16);
        BuildaHQ.newGUIComponent(openCredits);
        openCredits.addActionListener(event -> credits.setVisible(true));
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
                saveTextWindow.setSaveText(new OCWriter().getSaveText(myBuilderz, tab));
                final String armyListHumanReadable = myBuilderTextArea.getText(); //neuGerri
                saveTextWindow.setArmyList(armyListHumanReadable.replaceAll("\n", System.getProperty("line.separator")));//neuGerri
                saveTextWindow.save();
            }
        });
        menuPanel.add(saveButton);

        loadButton.setText(BuildaHQ.translate("Laden"));
        loadButton.setBounds(BILDSCHIRMBREITE - 305, 4, 60, 16);
        loadButton.setBorder(null);
        loadButton.setMargin(new Insets(0, 0, 0, 0));
        loadButton.addActionListener(event -> {
            loadWindow.load();
            loadWindow.setVisible(true);

            if (!loadWindow.getLoadText().trim().equals("")) {
                load(loadWindow.getLoadText());
            }
        });
        menuPanel.add(loadButton);

        final Color dunkelgrau = new Color(90, 90, 90);

        loadButton.setForeground(dunkelgrau);
        saveButton.setForeground(dunkelgrau);
        openMenu.setForeground(dunkelgrau);
        openCredits.setForeground(dunkelgrau);


        myBuilderTextArea = new BuildaTextArea();
        JPanel textPanel = myBuilderTextArea.getPanel();
        tab.addTab("Liste", null, textPanel);
        tab.setLocation(5, MENU_HEIGHT + 5);
        tab.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 25, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 55);
        tab.addChangeListener(this::onTabChange);
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
                        } catch (final Exception e) {
                            LOGGER.error("", e);
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
                        } catch (final Exception e) {
                            LOGGER.error("", e);
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
            loadWindow.loadFile(new java.io.File(args[0]));
            if (!loadWindow.getLoadText().trim().equals("")) {
                load(loadWindow.getLoadText());
            }
        }

    }

    public static void main(String[] args) {
        final Optional<Version> version = ManifestUtils.getVersion();
        version.ifPresent(VersionChecker::execute);
        new OnlineCodex(version, args); // neuGerrig
    }

    static OnlineCodex getInstance() {
        return onlineCodex;
    }

    BuildaMenu getMenu() {
        return this.menu;
    }

    JPanel getBuildaPanel() {
        return panel;
    }

    MouseListener getDragAndDropMouseListener() {
        return dragAndDropMouseListener;
    }

    MouseMotionListener getDragAndDropMouseMotionListener() {
        return dragAndDropMouseMotionListener;
    }

    final void fehler(String s) {
        myDialog = new JDialog(myWindow, "Fehler", true);
        final JTextPane myTextPane = new JTextPane();

        final int i = BuildaHQ.countStringsInString(s, "\n") + 1;

        myTextPane.setBounds(2, 2, BuildaHQ.maxStringWidth(myTextPane, s.split("\n")) + 15, i * 16);
        myTextPane.setVisible(true);
        myTextPane.setText(s);
        myTextPane.setEditable(false);

        final JButton myButton = new JButton("OK");

        final ActionListener listener = e -> myDialog.setVisible(false);

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
    public double getCost() {
        double kostenD = 0.0;
        for (BuildaVater buildaVater : myBuilderz) {
            kostenD += buildaVater.getCost();
        }
        return kostenD;
    }

    private double getCP() {
        double kostenD = 0.0;
        for (BuildaVater buildaVater : myBuilderz) {
            kostenD += buildaVater.getCP();
        }
        return kostenD;
    }

    public void load(String saveText) {
        if (saveText.trim().equals("")) {
            return;
        }

        try {


            BuildaHQ.leereStatischeInformationen();
            while (myBuilderz.size() > 0) {
                myBuilderTextArea.removeBuildaVater(myBuilderz.get(0));
                myBuilderz.remove(0);
                tab.remove(1);
            }

            if (saveText.contains(SAVETEXT_DETACHMENTTRENNER)) {
                final String[] armies = saveText.split(SAVETEXT_DETACHMENTTRENNER);
                for (int i = 0; i < armies.length; i++) {
                    LOGGER.info(armies[i]);
                    myBuilderz.add((BuildaVater) (Class.forName(ARMY_PACKAGE + "armies.VOLK" + BuildaHQ.formZuKlassenName(armies[i].substring(0, armies[i].indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2)))).getDeclaredConstructor().newInstance()));
                    final JPanel buildaPanel = myBuilderz.get(i).getPanel();
                    buildaPanel.setPreferredSize(new Dimension(3500, 8000));
                    buildaPanel.setSize(3500, 8000);
                    myBuilderz.get(i).setTextArea(myBuilderTextArea);
                    myBuilderz.get(i).volk = armies[i].substring(0, armies[i].indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2));
                    myBuilderTextArea.addBuildaVater(myBuilderz.get(i));
                    final JScrollPane sp = new JScrollPane(buildaPanel);
                    sp.addMouseMotionListener(dragAndDropMouseMotionListener);
                    sp.addMouseListener(dragAndDropMouseListener);
                    sp.setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - MENU_HEIGHT - 28));
                    sp.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - MENU_HEIGHT - 28));
                    final String name = armies[i].substring(0, armies[i].indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2));
                    tab.addTab(name, null, sp);
                    tab.setTabComponentAt(i + 1, new ButtonTabComponent(tab, onlineCodex));

                    myBuilderz.get(i).isLoading = true;
                    ////////////////
                    for (int j = 0; j < myBuilderz.get(i).getChooserAnzahl(); j++) {
                        BuildaHQ.registerNewChooserGruppe(myBuilderz.get(i).getChooserGruppe(j), j + 1);
                    }
                    BuildaHQ.aktBuildaVater = myBuilderz.get(i);
                    /////////////////
                    final String kontingent = armies[i].substring(armies[i].indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2) + SAVETEXT_UEBERSCHRIFTTRENNER2.length(), armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER1));
                    final String formation = armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER1) + SAVETEXT_DETACHMENTTYPTRENNER1.length(), armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER2));
                    final String haupt = armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER2) + SAVETEXT_DETACHMENTTYPTRENNER2.length(), armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3));
                    if (!kontingent.equals("")) {
                        if (myBuilderz.get(i).getId().equals("CM")) {
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
                    if (armies[i].contains(SAVETEXT_FARSIGHT)) {
                        myBuilderz.get(i).load(armies[i].substring(armies[i].indexOf(SAVETEXT_FARSIGHT) + SAVETEXT_FARSIGHT.length()));
                    } else if (armies[i].contains(SAVETEXT_CADIANS)) {
                        myBuilderz.get(i).load(armies[i].substring(armies[i].indexOf(SAVETEXT_CADIANS) + SAVETEXT_CADIANS.length()));
                    } else if (armies[i].contains(SAVETEXT_SOT) && armies[i].contains(SAVETEXT_RAUKAAN)) {
                        myBuilderz.get(i).load(armies[i].substring(armies[i].indexOf(SAVETEXT_SOT) + SAVETEXT_SOT.length()));
                    } else if (armies[i].contains(SAVETEXT_RAUKAAN)) {
                        myBuilderz.get(i).load(armies[i].substring(armies[i].indexOf(SAVETEXT_RAUKAAN) + SAVETEXT_RAUKAAN.length()));
                    } else {
                        myBuilderz.get(i).load(armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length()));
                    }
                    myBuilderz.get(i).isLoading = false;
                }
            } else {
                LOGGER.info(saveText);
                myBuilderz.add((BuildaVater) (Class.forName(ARMY_PACKAGE + "armies.VOLK" + BuildaHQ.formZuKlassenName(saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2)))).getDeclaredConstructor().newInstance()));
                final JPanel buildaPanel = myBuilderz.get(0).getPanel();
                buildaPanel.setPreferredSize(new Dimension(3500, 8000));
                buildaPanel.setSize(3500, 8000);
                myBuilderz.get(0).setTextArea(myBuilderTextArea);
                myBuilderz.get(0).volk = saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2));
                myBuilderTextArea.addBuildaVater(myBuilderz.get(0));
                final JScrollPane sp = new JScrollPane(buildaPanel);
                sp.addMouseMotionListener(dragAndDropMouseMotionListener);
                sp.addMouseListener(dragAndDropMouseListener);
                sp.setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - MENU_HEIGHT - 28));
                sp.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - MENU_HEIGHT - 28));
                final String name = saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2));
                tab.addTab(name, null, sp);
                tab.setTabComponentAt(1, new ButtonTabComponent(tab, onlineCodex));

                myBuilderz.get(0).isLoading = true;
                ////////////////
                for (int j = 0; j < myBuilderz.get(0).getChooserAnzahl(); j++) {
                    BuildaHQ.registerNewChooserGruppe(myBuilderz.get(0).getChooserGruppe(j), j + 1);
                }
                BuildaHQ.aktBuildaVater = myBuilderz.get(0);
                /////////////////
                final String kontingent = saveText.substring(saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2) + SAVETEXT_UEBERSCHRIFTTRENNER2.length(), saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER1));
                final String formation = saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER1) + SAVETEXT_DETACHMENTTYPTRENNER1.length(), saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER2));
                final String haupt = saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER2) + SAVETEXT_DETACHMENTTYPTRENNER2.length(), saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3));
                if (!kontingent.equals("")) {
                    myBuilderz.get(0).kontingentBox.setSelectedItem(kontingent);
                }
                if (!formation.equals("")) {
                    myBuilderz.get(0).formationBox.setSelectedItem(formation);
                }
                if (haupt.equals("y")) {
                    myBuilderz.get(0).Hauptkontingent.doClick();
                }
                if (saveText.contains(SAVETEXT_FARSIGHT)) {
                    myBuilderz.get(0).load(saveText.substring(saveText.indexOf(SAVETEXT_FARSIGHT) + SAVETEXT_FARSIGHT.length()));
                } else if (saveText.contains(SAVETEXT_CADIANS)) {
                    myBuilderz.get(0).load(saveText.substring(saveText.indexOf(SAVETEXT_CADIANS) + SAVETEXT_CADIANS.length()));
                } else if (saveText.contains(SAVETEXT_SOT) && saveText.contains(SAVETEXT_RAUKAAN)) {
                    myBuilderz.get(0).load(saveText.substring(saveText.indexOf(SAVETEXT_SOT) + SAVETEXT_SOT.length()));
                } else if (saveText.contains(SAVETEXT_RAUKAAN)) {
                    myBuilderz.get(0).load(saveText.substring(saveText.indexOf(SAVETEXT_RAUKAAN) + SAVETEXT_RAUKAAN.length()));
                } else {
                    myBuilderz.get(0).load(saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length()));
                }
                myBuilderz.get(0).isLoading = false;
            }
            BuildaHQ.loadWindow = false;
            loadWindow.setVisible(false);
        } catch (final Exception e) {
            LOGGER.error("", e);
            JOptionPane.showMessageDialog(null, BuildaHQ.translate("Datei konnte nicht gelesen werden."));
        }

    }

    private void onTabChange(ChangeEvent changeEvent) {
        final JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
        final int index = sourceTabbedPane.getSelectedIndex();

        if (index != 0) {
            final BuildaVater bV = myBuilderz.get(index - 1);
            for (int i = 0; i < bV.getChooserAnzahl(); i++) {
                BuildaHQ.registerNewChooserGruppe(bV.getChooserGruppe(i), i + 1);
            }
            BuildaHQ.aktBuildaVater = bV;
        }
    }


    void dokumentLeeren() {
        setSelectedItemInBuildaChooser(buildaChooser.getSelectedItem()); // ruft actionPerformed(ActionEvent event) auf
    }

    private void setSelectedItemInBuildaChooser(Object s) {
        for (Object o : buildazWh40k) {
            if (o.toString().equals(s.toString())) {
                buildaChooser.setSelectedItem(o);
            }
        }
    }

    Preferences getPrefs() {
        return prefs;
    }

    private void savePreferences() {
        prefs.put(PREFERENCES_SAVE_DIRECTORY, saveTextWindow.getCurrentDir());
        prefs.put(PREFERENCES_LOAD_DIRECTORY, loadWindow.getCurrentDir());

        menu.savePrefs();
    }

    void removeBuilda(int i) {
        final BuildaVater bV = myBuilderz.get(i);
        for (int j = 0; j < bV.getChooserAnzahl(); j++) {
            final ChooserGruppe cg = bV.getChooserGruppe(j);
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
        myBuilderz.remove(i);
        RefreshListener.fireRefresh();
    }

    static class IconedText {

        String text;

        IconedText(String t) {
            this.text = t;
        }

        @Override
        public String toString() {  // fürn Reflection-ActionListener unten wichtig
            return text;
        }
    }

}


