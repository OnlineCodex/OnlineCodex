package oc;

import static oc.RefreshListener.addRefreshListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Hashtable;
import java.util.Optional;
import java.util.Vector;
import java.util.prefs.Preferences;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.ToolTipManager;
import javax.swing.event.ChangeEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import com.github.zafarkhaja.semver.Version;

import oc.utils.ManifestUtils;


public class OnlineCodex extends BuildaPanel {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnlineCodex.class);

    static final int menuHöhe = 23;
    private final static int FRAME_MIN_WIDTH = 750;
    static final String ARMY_PACKAGE = "oc.wh40k.";
    private static OnlineCodex onlineCodex;
    private final JButton openMenu = new JButton();
    private final JButton openCredits = new JButton();
    private final JButton saveButton = new JButton();
    private final JButton loadButton = new JButton();
    private final Hashtable<String, String> dokumente = new Hashtable<String, String>();
    private final JFrame myWindow = new JFrame("OnlineCodex powered by OnlineCodex.de");
    public SaveTextWindow saveTextWindow;
    private final Object[] buildazWh40k = new Object[]{
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
    private final JComboBox buildaChooser;
    private final JPanel textPanel;
    private final Vector<BuildaVater> myBuilderz = new Vector<BuildaVater>();

    private final Vector<JPanel> buildaPanelz = new Vector<JPanel>();
    private final BuildaTextArea myBuilderTextArea;
    private JDialog myDialog = new JDialog(myWindow, "Fehler", true);
    private int clickXWindow = 0;
    private int clickYWindow = 0;
    private String aktVolk = "";
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
    private final ActionListener volkChangeListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent event) {
            String name = "";
            try {
                BuildaVater myBuilder = new LeererBuilder();

                budget.setEnabled(true);
                name = BuildaHQ.formZuKlassenName((buildaChooser.getSelectedObjects()[0]).toString());

                aktVolk = name; // switch to new active army

                if (name.equals("")) {
                    return;//Es soll kein Leerer Tab eingefügt werden
                } else {
                    myBuilder = (BuildaVater) (Class.forName(ARMY_PACKAGE + "armies.VOLK" + name).getDeclaredConstructor().newInstance());
                }

                if (event.getSource() == buildaChooser) {
                    final JPanel buildaPanel = myBuilder.getPanel();
                    buildaPanel.setPreferredSize(new Dimension(3500, 8000));
                    buildaPanel.setSize(3500, 8000);
                    buildaPanelz.add(buildaPanel);
                    myBuilder.setTextArea(myBuilderTextArea);
                    myBuilder.volk = (buildaChooser.getSelectedObjects()[0]).toString();
                    myBuilderTextArea.addBuildaVater(myBuilder);
                    myBuilderz.add(myBuilder);
                    final JScrollPane sp = new JScrollPane(buildaPanel);
                    sp.addMouseMotionListener(dragAndDropMouseMotionListener);
                    sp.addMouseListener(dragAndDropMouseListener);
                    sp.setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - menuHöhe - 28));
                    sp.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - menuHöhe - 28));
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
    private final RefreshListener refreshListener = addRefreshListener(RefreshListener.Priority.ONLINE_CODEX, this::refresh);

    private void refresh() {
        final double kosten = getKosten();
        double cp = 0 + getCP();
        
        if(kosten <= 500){
        	cp += 3;
        } else if(kosten <= 1000){
        	cp += 6;
        } else if(kosten <= 2000){
        	cp += 12;
        } else if(kosten > 2000){
        	cp += 18;
        }

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
        
		int kj = BuildaHQ.getCountFromInformationVectorGlobal("KustomJobs");
		if (kj < 0) kj = 0;
		
		cp -= kj;

        if (kosten != 0) {
            kostenLabel.setText(BuildaHQ.translate("Insgesamt") + " " + entferneNullNachkomma(kosten) + " " + BuildaHQ.translate("Pkt.") + " / " + entferneNullNachkomma(cp) + " CP");
            kostenLabel.setForeground(Color.BLACK);
        } else {
            kostenLabel.setText("");
        }
    }

//    private final KeyListener budgetChangeListener = new KeyListener() {
//
//        @Override
//        public void keyTyped(KeyEvent e) {
//        }
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//        }
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//            refreshListener.run();
//        }
//    };

    public OnlineCodex(Optional<Version> version, String[] args) {
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
        buildaChooser = new JComboBox(buildazWh40k);


        buildaChooser.setBounds(5, 3, 290, 18);
        buildaChooser.setFocusable(false); // sie hat nie den Focus und wird deshalb nie durch die Pfeil-Unten-Taste geöffnet
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
        loadButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                loadWindow.load();
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
            loadWindow.loadFile(new java.io.File(args[0]));
            if (!loadWindow.getLoadText().trim().equals("")) {
                load(loadWindow.getLoadText(), true);
            }
        }

    }

    public static void main(String[] args) {
        final Optional<Version> version = ManifestUtils.getVersion();
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

    public JPanel getBuildaPanel() {
        return panel;
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
        final JTextPane myTextPane = new JTextPane();

        final int i = BuildaHQ.countStringsInString(s, "\n") + 1;

        myTextPane.setBounds(2, 2, BuildaHQ.maxStringWidth(myTextPane, s.split("\n")) + 15, i * 16);
        myTextPane.setVisible(true);
        myTextPane.setText(s);
        myTextPane.setEditable(false);

        final JButton myButton = new JButton("OK");

        final ActionListener listener = new ActionListener() {

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
        return kostenD;
    }

    public double getCP() {
        double kostenD = 0.0;
        int additionalCP = 0;
        boolean supreme = false;
        for (int i = 0; i < myBuilderz.size(); i++) {
            kostenD += myBuilderz.get(i).getCP();
            
            if(((String) myBuilderz.get(i).getKontingentTyp()).equals("Patrol Detachment")) {
				if(additionalCP < 2) {
	            	additionalCP = 2;
				}
			} else if(((String) myBuilderz.get(i).getKontingentTyp()).equals("Battalion Detachment")) {
				if(additionalCP < 3) {
	            	additionalCP = 3;
				}
			} else if(((String) myBuilderz.get(i).getKontingentTyp()).equals("Brigade Detachment")) {
				if(additionalCP < 4) {
	            	additionalCP = 4;
				}
			} else if(((String) myBuilderz.get(i).getKontingentTyp()).equals("Supreme Command Detachment") && myBuilderz.get(i).getCountFromInformationVector("Warlord") > 0) {
				supreme = true;
			}
        }
        
        if(supreme){
        	kostenD += additionalCP;
        }
        
        return kostenD;
    }

    public String getSaveText() {
        String s = "";
        for (int i = 0; i < myBuilderz.size(); i++) {
            s += tab.getTitleAt(i + 1) + SAVETEXT_UEBERSCHRIFTTRENNER2 +
                    (myBuilderz.get(i).getId().equals("CM") ? myBuilderz.get(i).supplementBox.getSelectedItem() : myBuilderz.get(i).kontingentBox.getSelectedItem()) + SAVETEXT_DETACHMENTTYPTRENNER1 +
                    myBuilderz.get(i).formationBox.getSelectedItem() + SAVETEXT_DETACHMENTTYPTRENNER2 +
                    (myBuilderz.get(i).Hauptkontingent.isSelected() ? "y" : "n") + SAVETEXT_DETACHMENTTYPTRENNER3 +
                    myBuilderz.get(i).getSaveText() + SAVETEXT_DETACHMENTTRENNER;
        }
        return s;
    }

    public Element getSaveElement() {
        final Element root = myBuilderz.get(tab.getSelectedIndex() - 1).getSaveElement();
        root.setAttribute("choice", buildaChooser.getSelectedObjects()[0].toString());
        if (budget != null && budget.isEnabled() && !budget.getText().equals("")) {
            root.setAttribute("budget", Integer.toString(getBudget()));
        }

        return root;
    }

    public BuildaVater getBuilder() {
        return myBuilderz.get(tab.getSelectedIndex() + 1);
    }

    public JComboBox getChooser() {
        return buildaChooser;
    }

    public void loadElement(Element e, boolean chooserUmstellen) {
        try {
            if (chooserUmstellen) {
                setSelectedItemInBuildaChooser(e.getAttribute("choice"));
            }

            myBuilderz.get(tab.getSelectedIndex() - 1).loadElement(e);

            if (!e.getAttribute("budget").equals("")) {
                budget.setText(e.getAttribute("budget"));
            }

            BuildaHQ.loadWindow = false;
            loadWindow.setVisible(false);
        } catch (final Exception ex) {
            LOGGER.error("", ex);
            JOptionPane.showMessageDialog(null, BuildaHQ.translate("Datei konnte nicht gelesen werden"));
        }
    }

    public void load(String saveText, boolean chooserUmstellen) {
        if (saveText.trim().equals("")) {
            return;
        }

        try {


            BuildaHQ.leereStatischeInformationen();
            while (myBuilderz.size() > 0) {
                myBuilderTextArea.removeBuildaVater(myBuilderz.get(0));
                buildaPanelz.remove(0);
                myBuilderz.remove(0);
                tab.remove(1);
            }

            if (saveText.contains(SAVETEXT_DETACHMENTTRENNER)) {
                final String armies[] = saveText.split(SAVETEXT_DETACHMENTTRENNER);
                for (int i = 0; i < armies.length; i++) {
                    LOGGER.info(armies[i]);
                    myBuilderz.add((BuildaVater) (Class.forName(ARMY_PACKAGE + "armies.VOLK" + BuildaHQ.formZuKlassenName(armies[i].substring(0, armies[i].indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2)))).getDeclaredConstructor().newInstance()));
                    final JPanel buildaPanel = myBuilderz.get(i).getPanel();
                    buildaPanel.setPreferredSize(new Dimension(3500, 8000));
                    buildaPanel.setSize(3500, 8000);
                    buildaPanelz.add(buildaPanel);
                    myBuilderz.get(i).setTextArea(myBuilderTextArea);
                    myBuilderz.get(i).volk = armies[i].substring(0, armies[i].indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2));
                    myBuilderTextArea.addBuildaVater(myBuilderz.get(i));
                    final JScrollPane sp = new JScrollPane(buildaPanel);
                    sp.addMouseMotionListener(dragAndDropMouseMotionListener);
                    sp.addMouseListener(dragAndDropMouseListener);
                    sp.setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - menuHöhe - 28));
                    sp.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - menuHöhe - 28));
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
                    if (armies[i].contains(SAVETEXT_FARSIGHT)) {
                        armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), armies[i].indexOf(SAVETEXT_FARSIGHT));
                    } else if (armies[i].contains(SAVETEXT_CADIANS)) {
                        armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), armies[i].indexOf(SAVETEXT_CADIANS));
                    } else if (armies[i].contains(SAVETEXT_SOT) && armies[i].contains(SAVETEXT_RAUKAAN)) {
                        armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), armies[i].indexOf(SAVETEXT_SOT));
                        armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), armies[i].indexOf(SAVETEXT_RAUKAAN));
                    } else if (armies[i].contains(SAVETEXT_RAUKAAN)) {
                        armies[i].substring(armies[i].indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), armies[i].indexOf(SAVETEXT_RAUKAAN));
                    }
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
                LOGGER.info(saveText);
                myBuilderz.add((BuildaVater) (Class.forName(ARMY_PACKAGE + "armies.VOLK" + BuildaHQ.formZuKlassenName(saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2)))).getDeclaredConstructor().newInstance()));
                final JPanel buildaPanel = myBuilderz.get(0).getPanel();
                buildaPanel.setPreferredSize(new Dimension(3500, 8000));
                buildaPanel.setSize(3500, 8000);
                buildaPanelz.add(buildaPanel);
                myBuilderz.get(0).setTextArea(myBuilderTextArea);
                myBuilderz.get(0).volk = saveText.substring(0, saveText.indexOf(SAVETEXT_UEBERSCHRIFTTRENNER2));
                myBuilderTextArea.addBuildaVater(myBuilderz.get(0));
                final JScrollPane sp = new JScrollPane(buildaPanel);
                sp.addMouseMotionListener(dragAndDropMouseMotionListener);
                sp.addMouseListener(dragAndDropMouseListener);
                sp.setMaximumSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - menuHöhe - 28));
                sp.setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - menuHöhe - 28));
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
                if (saveText.contains(SAVETEXT_FARSIGHT)) {
                    saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), saveText.indexOf(SAVETEXT_FARSIGHT));
                } else if (saveText.contains(SAVETEXT_CADIANS)) {
                    saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), saveText.indexOf(SAVETEXT_CADIANS));
                } else if (saveText.contains(SAVETEXT_SOT) && saveText.contains(SAVETEXT_RAUKAAN)) {
                    saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), saveText.indexOf(SAVETEXT_SOT));
                    saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), saveText.indexOf(SAVETEXT_RAUKAAN));
                } else if (saveText.contains(SAVETEXT_RAUKAAN)) {
                    saveText.substring(saveText.indexOf(SAVETEXT_DETACHMENTTYPTRENNER3) + SAVETEXT_DETACHMENTTYPTRENNER3.length(), saveText.indexOf(SAVETEXT_RAUKAAN));
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


    public void dokumentLeeren() {
        setSelectedItemInBuildaChooser(buildaChooser.getSelectedItem()); // ruft actionPerformed(ActionEvent event) auf

    }

    public void setSelectedItemInBuildaChooser(Object s) {
        final Object[] buildaz = buildazWh40k;
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

    public void removeBuilda(int i) {
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
        buildaPanelz.remove(i);
        myBuilderz.remove(i);
        RefreshListener.fireRefresh();
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


