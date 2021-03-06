package oc;

import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public abstract class BuildaHQ implements BuildaSTK { // stellt die ganzen Methoden und globalen Variablen bereit.   Komplett static

    private static final Logger LOGGER = LoggerFactory.getLogger(BuildaHQ.class);

    public final static HashMap<String, String> germanEnglishHashMap = new HashMap<String, String>();
    public static final boolean noErrors = true; // <-- Lamekhs Online Codex
    public static int formatierung = 0;  // defaultEinstellung beim Starten!
    public static boolean allePunktkosten = false;  // defaultEinstellung beim Starten!
    public static boolean sterneAnzeigen = true;  // defaultEinstellung beim Starten!
    public static boolean kurzerText = true;  // defaultEinstellung beim Starten!
    public static boolean zusatzInfos = false;  // defaultEinstellung beim Starten!
    public static boolean excelMode = false;
    public static String abstand = "";
    public static String anfang = "";
    public static Vector<String> Items = new Vector<String>();
    public static Image oCLogo = null;
    public static boolean loadWindow = false;
    public static BuildaVater aktBuildaVater = null;
    public static String IMAGEPFAD = "oc/images/";
    private static boolean strg = false; // siehe den keyListener hier
    static MouseWheelListener defaultMouseWheelListener = new MouseWheelListener() {
        @Override
		public void mouseWheelMoved(MouseWheelEvent event) {
            final JPanel p = OnlineCodex.getInstance().getBuildaPanel();

            if (strg != OnlineCodex.getInstance().getMenu().isVertikalScrolling()) {
                int newX = (int) p.getLocation().getX() + (event.getWheelRotation() * OnlineCodex.getInstance().getMenu().getMausradSpeed() * -1);
                if (newX > 0) {
                    newX = 0;
                }
                p.setLocation(newX, (int) p.getLocation().getY());
            } else {
                int newY = (int) p.getLocation().getY() + (event.getWheelRotation() * OnlineCodex.getInstance().getMenu().getMausradSpeed() * -1);
                if (newY > 0) {
                    newY = 0;
                }
                p.setLocation((int) p.getLocation().getX(), newY);
            }
        }
    };
    private static Sprache sprache = Sprache.German;
    private static ChooserGruppe[] chooserGruppen = new ChooserGruppe[11];
    private static Hashtable<String, Integer> informationListGlobal = new Hashtable<String, Integer>();  // anzahl der vorkommen des Strings(werte aller armeen)
    private static Hashtable<String, ImageIcon> bilda = new Hashtable<String, ImageIcon>();
    private static String lastLoaded;

    private static Document XMLDocument;
    private static MouseListener pictureRefreshMouseListener = new MouseListener() {

        @Override
		public void mouseReleased(MouseEvent event) { // nur um das bildmachen hier machen zu können und hier den listener adden zu können. Siehe bildMachen
            RefreshListener.fireRefresh();
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
		public void mousePressed(MouseEvent event) {
        }
    };
    private static KeyListener defaultKeyListener = new KeyListener() {
        @Override
		public void keyPressed(KeyEvent event) {
            final JPanel p = OnlineCodex.getInstance().getBuildaPanel();

            if (event.getKeyCode() == KeyEvent.VK_CONTROL) {
                strg = true;
            } else if (event.getKeyCode() == KeyEvent.VK_UP) {
                int newY = (int) p.getLocation().getY() - (OnlineCodex.getInstance().getMenu().getPfeiltastenSpeed() * -1);
                if (newY > 0) {
                    newY = 0;
                }
                p.setLocation((int) p.getLocation().getX(), newY);
            } else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
                int newY = (int) p.getLocation().getY() + (OnlineCodex.getInstance().getMenu().getPfeiltastenSpeed() * -1);
                if (newY > 0) {
                    newY = 0;
                }
                p.setLocation((int) p.getLocation().getX(), newY);
            } else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
                int newX = (int) p.getLocation().getX() - (OnlineCodex.getInstance().getMenu().getPfeiltastenSpeed() * -1);
                if (newX > 0) {
                    newX = 0;
                }
                p.setLocation(newX, (int) p.getLocation().getY());
            } else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
                int newX = (int) p.getLocation().getX() + (OnlineCodex.getInstance().getMenu().getPfeiltastenSpeed() * -1);
                if (newX > 0) {
                    newX = 0;
                }
                p.setLocation(newX, (int) p.getLocation().getY());
            }
        }

        @Override
		public void keyTyped(KeyEvent event) {
        }

        @Override
		public void keyReleased(KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.VK_CONTROL) {
                strg = false;
            }
        }
    };

    static {
        try {
            oCLogo = new ImageIcon(OnlineCodex.getInstance().getClass().getClassLoader().getResource("oc/sysimages/oCLogo.png")).getImage();
        } catch (final Exception e) {
            LOGGER.error("", e);
        }

        germanEnglishHashMap.put("Laden", "Load");
        germanEnglishHashMap.put("Speichern", "Save");
        germanEnglishHashMap.put("Menü", "Menu");
        germanEnglishHashMap.put("Alles markieren", "Select all");
        germanEnglishHashMap.put("Easy-HTML Formatierung", "Easy-HTML formatting");
        germanEnglishHashMap.put("Kurze Armeeliste", "Shorter List");
        germanEnglishHashMap.put("Alle Punktkosten", "Show detailed pts.");
        germanEnglishHashMap.put("Meine", "my");
        germanEnglishHashMap.put("Mein", "my");
        germanEnglishHashMap.put("zum", "to");
        germanEnglishHashMap.put("Ja", "Yes");
        germanEnglishHashMap.put("Nein", "No");
        germanEnglishHashMap.put("Insgesamt", "together");
        germanEnglishHashMap.put("Abbrechen", "Cancel");

        germanEnglishHashMap.put("Gesamtpunkte", "points");
        germanEnglishHashMap.put("Unbedingt anhaken, wenn die Armeeliste in ein Forum kopiert werden soll", "You should use this, if you want to copy the army list into a forum");
        germanEnglishHashMap.put("Zum rauskopieren Strg+C benutzen", "Copy: Ctrl+C");
        germanEnglishHashMap.put("Zum Speichern diesen Text rauskopieren (wie immer mit Strg+C)" + ZEILENUMBRUCH + "und irgendwo abspeichern.", "To save the army list: copy (Ctrl+C) the text below and save" + ZEILENUMBRUCH + "the text on your computer.");
        germanEnglishHashMap.put("Zum reinkopieren Strg+V benutzen", "Paste: Ctrl+V");
        germanEnglishHashMap.put("Zum Laden den Speicherstand hier reinkopieren und \"Laden\" drücken.", "To load: Paste your savetext.");
        germanEnglishHashMap.put("Geschwindigkeit des Mausrads:", "Speed of the mouse wheel");
        germanEnglishHashMap.put("Geschwindigkeit der Pfeiltasten:", "Speed of the arrow keys");
        germanEnglishHashMap.put("Scrollrichtung umdrehen", "switch scroll direction");
        germanEnglishHashMap.put("Hier kann man verändern, wie schnell mit den Pfeiltasten gescrollt wird", "How fast you scroll with the arrow keys");
        germanEnglishHashMap.put("Hier kann man verändern, wie schnell mit dem Mausrad gescrollt wird", "How fast you scroll with the mouse wheel");
        germanEnglishHashMap.put("<html>Dreht das scrollen mit dem Mausrad um. Normalerweise wird oben-unten, bei gedrückten STRG links-rechts gescrollt.<br>Wenn angehakt, wird links-rechts gescrollt, wenn STRG gedrückt ist, oben-unten.</html>", "Normaly you sroll from left to right with the mouse wheel. When you press Ctrl while scrolling you scroll from up to down. This option switch this.");
        germanEnglishHashMap.put("Bilder", "Pictures");
        germanEnglishHashMap.put("Verbessert die Performance, da keine NEUEN Bilder mehr vom Server geladen werden. Bilder, die schonmal benutzt wurden, werden weiterhin angezeigt", "Increase the performance because the Online-Codex won't load pictures from the server anymore.");
        germanEnglishHashMap.put("Einstellungen", "Menu");
        germanEnglishHashMap.put("Hier können sie ihr Volk auswählen. Die Einträge des alten Volkes bleiben im Arbeitsspeicher und werden geladen, sobald sie es wieder auswählen.", "When you switch your army: all entrys get saved in your RAM and get load when you choose the army again.");
        germanEnglishHashMap.put("Öffnet ein extra Fenster. Rechtsklick: Die Einstellungen bleiben im Rüstkammer-Fenster zwar bestehen, zählen aber NICHT zu den Gesamtkosten.", "<html>left click: activate this option AND open the armoury window for more options.<br>right click: deactivate this option and the options in the armoury window.</html>");
        germanEnglishHashMap.put("Wollen Sie wirklich alle Einträge des aktiven Volkes löschen?", "Do you want really to delete all entrys of the current army?");
        germanEnglishHashMap.put("Wirklich löschen?", "Delete?");
        germanEnglishHashMap.put("Löscht alle Einträge des aktiven Volkes.", "Delete all entrys of the current army.");
        germanEnglishHashMap.put("Leere aktuelles Dokument", "Delete current army");
        germanEnglishHashMap.put("Hier kann man einstellen, ob Apokalypse-Einheiten ausgewählt werden können oder nicht.", "Here you can elect whether Apocalypse-troops can be chosen or not.");
        germanEnglishHashMap.put("Apokalypse", "Apocalypse");

        germanEnglishHashMap.put("Punkte", "Points");
        germanEnglishHashMap.put("Credits", "Credits");
        germanEnglishHashMap.put("Pkt.", "Pts.");
        germanEnglishHashMap.put("Clonen", "Clone");
        germanEnglishHashMap.put("kostenlos", "free");
        germanEnglishHashMap.put("jeweils", "each with");
        germanEnglishHashMap.put("Rüstkammer", "Armoury");
        germanEnglishHashMap.put("Tyraniden", "Tyranids");
        germanEnglishHashMap.put("Armee", "Army");
        germanEnglishHashMap.put("Kommandopunkte", "Command points");
        germanEnglishHashMap.put("der Armee : ", "of the army : ");
        germanEnglishHashMap.put("", "");
    }

    //private verhindert das kosntruieren eines BuildaHQ-Objectes. BuildaHQ#Object is sinlos weil alles static...
    // wird mit den Boxen unter der Textarea verändert
    private BuildaHQ() {
    }

    public static void addToInformationVectorGlobal(String s, int count) { // um wieviel der key s erhöht/vermindert wird
        legKeyAnGlobal(s);
        informationListGlobal.put(s, informationListGlobal.get(s) + count);
    }

    /**
     * um einzelne Zahlen per initKammer(boolean) zu übergeben
     */
    public static boolean equals(String s, String... args) {
        boolean b = false;
        for (int i = 0; i < args.length; i++) {
            b = b || s.equals(args[i]);
        }
        return b;
    }

    /**
     * um einzelne Zahlen per initKammer(boolean) zu übergeben
     */
    public static boolean[] zahlZuBool(int z) {
        final String s = Integer.toBinaryString(z);
        final boolean[] b = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            b[i] = s.charAt(i) == '1' ? true : false;
        }
        return b;
    }

    public static int boolZuZahl(boolean[] b) {
        final StringBuilder s = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            s.append(b[i] == true ? '1' : '0');
        }
        return Integer.parseInt(s.toString(), 2);

    }

    public static int maxStringWidth(JComponent myComp, String[] s) {
        int cnt = 0;
        final FontMetrics fm = myComp.getFontMetrics(myComp.getFont());
        for (int i = 0; i < s.length; i++) {
            if (fm.stringWidth(s[i]) > cnt) {
                cnt = fm.stringWidth(s[i]);
            }
        }
        return cnt;
    }

    public static int getCountFromInformationVectorGlobal(String s) {
        legKeyAnGlobal(s);
        return informationListGlobal.get(s).intValue();
    }

    public static void setInformationVectorValueGlobal(String s, int value) {
        legKeyAnGlobal(s);
        informationListGlobal.put(s, value);
    }

    private static void legKeyAnGlobal(String s) {
        if (!informationListGlobal.containsKey(s)) {
            informationListGlobal.put(s, Integer.valueOf(0));
        } // muss immer aufgerufen werden, ansonsten nullPointerException falls der key nicht vorhanden war...
    }

    public static ChooserGruppe getChooserGruppe(int index) {
        return chooserGruppen[index];
    }

    public static void registerNewChooserGruppe(ChooserGruppe cG, int index) {
        chooserGruppen[index] = cG;
    }

    public static void refreshEntries(int group) {
        chooserGruppen[group].refreshAllEntries();
    }

    public static void leereStatischeInformationen() {
        for (int i = 0; i < chooserGruppen.length; ++i) {
            chooserGruppen[i] = null;
        }
        informationListGlobal.clear();
    }

    public static Sprache getSprache() {
        return sprache;
    }

    public static void setSprache(Sprache s) {
        sprache = s;
    }

    public static JLabel createPictureJLabel(String path) {  // EIG. überflüssig und alt (da er einen JButton return...), is nurnoch drinnen weil ich sonst 80 codes ändern müsste
        final ImageIcon icon = getImageIcon(path);
        final JLabel ico = new JLabel(icon);
        ico.setBorder(null);
        BuildaHQ.newGUIComponent(ico);
        try {
            ico.setSize(icon.getIconWidth(), icon.getIconHeight());
        } catch (final Exception e) {
        }

        ico.addMouseListener(pictureRefreshMouseListener);
        ico.addMouseListener(OnlineCodex.getInstance().getDragAndDropMouseListener());
        ico.addMouseMotionListener(OnlineCodex.getInstance().getDragAndDropMouseMotionListener());
        return ico;
    }

    public static ImageIcon getImageIcon(String path) {
        ImageIcon icon = null;

        if (!bilda.containsKey(path)) {  // wenns ein noch nicht geladenes Bild ist, wirds geladen und in die Hashtable geschrieben, ansonsten wirds direkt aus der Hashtable (Arbeitsspeicher) geladen. Performance
            if (path.equals("oc/sysimages/smArtwork.gif") // in buildamenu entsteht sonst eine Unendlichschleife
                    || OnlineCodex.getInstance().getMenu().isBildaz() // Der Benutzer stellt im Menü ein, ob überhaupt Bilder geladen werden sollen
                    || path.contains(".jpg")) // Alle GUI-Bilder wie die Einklammerung von Gruppen oder das "option" Einrücken sind *.jpg  , alle andren *.gif
            {
                try {                                                            // jpg werden trotzdem geladen, weil alle jpgs vor Buttons gemalt werden als einrück oder gruppenmarkierung...
                    icon = new ImageIcon(OnlineCodex.getInstance().getClass().getClassLoader().getResource(path));
                    bilda.put(path, icon);
                } catch (final Exception e) {
                    //LOGGER.info("Bild nicht vorhanden. Datei sollte unter : " + path + " abgespeichert sein");
                    //JOptionPane.showConfirmDialog(null, e, "gudden tag", JOptionPane.YES_NO_OPTION); zur fehlerausgabe!
                }
            } else {
            }
        } else {
            if (OnlineCodex.getInstance().getMenu().isBildaz() || path.contains(".jpg")) { // die kleinen Symbole vor Optionen werden trotzdem angezeigt...  isBildaz() schaltet nur die großen fetten Miniaturbilder aus, um Platz zu sparen
                icon = bilda.get(path);
            }
        }

        return icon;
    }

    public static String translate(String s) {
        if (sprache == Sprache.German) {
            return s;
        } else if (sprache == Sprache.English) {
            final String result = germanEnglishHashMap.get(s);
            if (result != null) {
                return result;
            }
        }

        return s;
    }

    public static void machTextStrings(boolean kT) {
        BuildaHQ.kurzerText = kT;

        if (kurzerText) {
            abstand = ", ";
        } else {
            abstand = ZEILENUMBRUCH;
        }                 // ACHTUNG IN RÜSTKAMMER VATER AUCH ÄNDERN WENN HIER WAS GEÄNDERT WIRD! BEI textArea.setText un dann replace(", ",ZEILENUMBRUCH+"- ")

        if (kurzerText) {
            anfang = "";
        } else {
            anfang = "- ";
        }
    }

    public static String getEinrueckString() { // für subKammern als einrückung   siehe einrückIndex in ruestkammerStarter
        if (BuildaHQ.formatierung == 0) {
            return "   ";
        } else {
            return "";
        }
    }

    public static String formatierFett(String s) {    // umschließt einen String mit Easy-HRML Formatierungen. wird von den getText() Methoden in allen möglichen Klassen benutzt, um ihren Text zu formatieren.
        if (BuildaHQ.formatierung == 0) {
            return s;
        }
        return "[B]" + s + "[/B]";
    }

    public static String formatierUnderline(String s) {
        if (BuildaHQ.formatierung == 0) {
            return s;
        }
        return "[U]" + s + "[/U]";
    }

    public static String formatierItalic(String s) {
        if (BuildaHQ.formatierung == 0) {
            return s;
        }
        return "[I]" + s + "[/I]";
    }

    public static String formatierFettItalicUnderline(String s) {
        if (BuildaHQ.formatierung == 0) {
            return s;
        }
        return "[B][U][I]" + s + "[/I][/U][/B]";
    }

    public static String formZuKlassenName(String s) {  // Klassennamen können keine ü, Punkte usw. haben.       Wegen Reflection
        return replaceWithNull(s, " ", "-", "'", ".", ",", "(", ")").replace("ü", "ue").replace("ä", "ae").replace("ö", "oe").replace("ß", "ss");
    }

    public static String replaceWithNull(String s, String... args) {
        for (int i = 0; i < args.length; ++i) {
            s = s.replace(args[i], "");
        }
        return s;
    }

    public static void instancesLeeren() {  // beim wechseln des Volkes

        RefreshListener.removeAll();
    }

    public static void newGUIComponent(Component c) {
        c.addMouseWheelListener(defaultMouseWheelListener);
        c.addKeyListener(defaultKeyListener);
    }

    public static Border createBorder(Color col) {
        return BorderFactory.createLineBorder(col);
    }

    //	public static int wasIstHoeher(int a, int b) {
    //		return (a > b ? a : b);
    //	}
    //
    //	public static int wasIstHoeher(int a, int b, int c) {
    //		if(a > b) {
    //			return (a > c ? a : c);
    //		} else {
    //			return (b > c ? b : c);
    //		}
    //	}

    public static int wasIstHoeher(int... zahl) {
        int max = zahl[0];
        for (int i = 1; i < zahl.length; i++) if (max < zahl[i]) max = zahl[i];
        return max;
    }

    public static String formatDouble(double a, int stellen) {
        final String s = String.valueOf(a);
        if (s.contains(".")) {
            return s.substring(0, s.indexOf(".") + 1 + stellen);
        } else {
            return s;
        }
    }

    public static int countStringsInString(String s, String teilString) {
        s += "ś"; // es muss immer was anderes noch am schluss stehen sonst kommt -1 raus
        return s.split(teilString).length - 1;
    }

    public static String getStringXMal(String s, int x) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; ++i) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void writeTextdatei(String path, String text) {
        try {
            final FileOutputStream out = new FileOutputStream(path);
            for (int i = 0; i < text.length(); i++) {
                out.write((byte) text.charAt(i));
            }
            out.close();
            out.flush();
        } catch (final IOException e) {
            LOGGER.info("Konnte nicht geschrieben werden: " + text + " wegen: ");
            LOGGER.error("", e);
        }
    }

    public static Document getXMLDocument() {
        if (XMLDocument == null) {
            try {
                XMLDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            } catch (final ParserConfigurationException ex) {
                LOGGER.error("", ex);
            }
        }

        return XMLDocument;
    }

    public static Element getNewXMLElement(String name) {
        return getNewXMLElement(getXMLDocument(), name);
    }

    public static Element getNewXMLElement(Document doc, String name) {
        return doc.createElement(name);
    }

    public static String getLastLoaded() {
        return lastLoaded;
    }

    public static void setLastLoaded(String s) {
        lastLoaded = s;
    }

    public static Document loadXMLFile(File file, boolean bereinigen) {
        return loadXMLFile(file.getAbsolutePath(), bereinigen);
    }

    public static Document loadXMLFile(String path, boolean bereinigen) {
        Document doc = null;

        try {
            final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(path);
            doc.getDocumentElement().normalize();
        } catch (final ParserConfigurationException ex) {
        } catch (final SAXException ex) {
        } catch (final IOException ex) {
        }

        if (bereinigen) bereinigeXML(doc);

        return doc;
    }


    public static void bereinigeXML(Document doc) {
        bereinigeElement(doc.getDocumentElement());
    }

    public static void bereinigeElement(Element e) {
        final NodeList children = e.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                bereinigeElement((Element) children.item(i));
            } else {
                e.removeChild(children.item(i));
                bereinigeElement(e);
                break;
            }
        }
    }
}