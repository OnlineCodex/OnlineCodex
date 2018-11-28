package oc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;
import java.util.Vector;

import static oc.RefreshListener.Priority.RUESTKAMMER_STARTER;
import static oc.RefreshListener.addRefreshListener;

public class RuestkammerStarter extends OptionsVater {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RuestkammerStarter.class);

    private static final int ruestkammerIconBreite = 20;
    static final Font bold = new Font("arial", Font.BOLD, 12);
    static final Font plain = new Font("arial", Font.PLAIN, 12);
    public int einrueckIndex = -1;
    boolean abwaehlbar = true;
    private RuestkammerVater myKammer;
    private String name;
    private boolean selected;
    private boolean aktiv = true;
    private boolean legal = true;
    private boolean ueberschriftTrotzNullKostenAusgeben = false;
    private JLabel ico;
    private JButton startButton = new JButton();
    private int seperator = -88; // -88 wichtig um in optionscollection überprüfen zu können obs geändert wurde und das statt dem default zu benutzen
    private Vector<JLabel> textfelder = new Vector<JLabel>();
    private String texte;
    private FocusListener closeListenerFocus = new FocusListener() {
        @Override
        public void focusLost(FocusEvent event) {
            ruestkammerClosed();
        }

        @Override
        public void focusGained(FocusEvent event) {
        }
    };
    private WindowListener closeListenerWindow = new WindowListener() {
        @Override
        public void windowClosing(WindowEvent e) {
            ruestkammerClosed();
            deselectYourself();
        }

        @Override
        public void windowClosed(WindowEvent e) {
            ruestkammerClosed();
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {/*ruestkammerClosed();*/

        } // kommandozug imps...

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowOpened(WindowEvent e) {
        }
    };
    private ActionListener closeListenerAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            ruestkammerClosed();
        }
    };

    public RuestkammerStarter(int ID, int lX, int lY, String kammer, String name) {
        init(ID, lX, lY, kammer, name);
    }

    public RuestkammerStarter(int ID, int lX, int lY, String kammer, String name, int einrueckIndex) {
        this.einrueckIndex = einrueckIndex;
        init(ID, lX, lY, kammer, name);
    }

    public RuestkammerStarter(int ID, int lX, int lY, RuestkammerVater abteilung) {
        init(ID, lX, lY, abteilung);
    }

    public static int vorkommen(String Sa, String b) {  // wie oft b in a vorkommt     Hilfsmethode
        int vorkommen = 0;
        String a = Sa;
        if (a.equals("") || b.equals("")) {
            return 0;
        }

        for (; ; ) {
            if (!a.contains(b)) {
                break;
            }

            a = a.substring(a.indexOf(b) + 1, a.length());

            ++vorkommen;
        }

        return vorkommen;
    }

    public RuestkammerVater getKammer() {
        return this.myKammer;
    }

    public int getEinrueckIndex() {
        return this.einrueckIndex;
    }

    public void setEinrueckIndex(int i) {
        this.einrueckIndex = i;
    }

    public int getSeperator() {
        return this.seperator;
    }

    public void setSeperator(int i) {
        this.seperator = i;
    }

    public void setUeberschriftTrotzNullKostenAusgeben(boolean b) {
        this.ueberschriftTrotzNullKostenAusgeben = b;
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean selected) {
        aktivieren(selected);
    }

    public void setToolTipText(String s) {
        startButton.setToolTipText(s);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String s) {
        this.name = s;
        myKammer.name = s;
    }

    public JButton getButton() {
        return this.startButton;
    }

    public void init(int ID, int lX, int lY, String kammer, String name) {
        this.selected = false;
        this.name = name;
        panel.setLocation(lX - 5, lY);
        ico = BuildaHQ.createPictureJLabel("oc/sysimages/RuestkammerIcon.jpg");
        ico.setBounds(randAbstand - 2, 6, ruestkammerIconBreite, 12);
        panel.add(ico);

        startButton.setBounds(ruestkammerIconBreite + randAbstand, 0, buttonBreite, buttonHoehe + 4);
        startButton.addMouseListener(this);
        BuildaHQ.newGUIComponent(startButton);
        startButton.setBorder(null);
        startButton.setToolTipText(BuildaHQ.translate("Öffnet ein extra Fenster. Rechtsklick: Die Einstellungen bleiben im Rüstkammer-Fenster zwar bestehen, zählen aber NICHT zu den Gesamtkosten."));
        fontSetzen(false);
        panel.add(startButton);

        String kammerName = BuildaHQ.formZuKlassenName(kammer);

        String armyPackage = OnlineCodex.ARMY_PACKAGE;

        try {
            try {
                myKammer = (RuestkammerVater) Class.forName(armyPackage + "units." + kammerName).newInstance();
            } catch (Exception e) {
                try {
                    myKammer = (RuestkammerVater) Class.forName(armyPackage + "units." + reflectionKennung.toLowerCase() + "." + kammerName).newInstance();
                } catch (Exception ex2) {
                    try {
                        myKammer = (RuestkammerVater) Class.forName(armyPackage + "units." + "fo" + "." + kammerName).newInstance();
                    } catch (Exception ex3) {
                        try {
                            myKammer = (RuestkammerVater) Class.forName(armyPackage + "units." + "form" + "." + kammerName).newInstance();
                        } catch (Exception ex4) {
                            try {
                                String autoRef = kammerName.substring(0, 2);
                                LOGGER.info(armyPackage + "units." + autoRef + "." + kammerName);
                                myKammer = (RuestkammerVater) Class.forName(armyPackage + "units." + autoRef.toLowerCase() + "." + kammerName).newInstance();
                            } catch (Exception ex5) {
                                try {
                                    String autoRef = kammerName.substring(0, 3);
                                    LOGGER.info(armyPackage + "units." + autoRef + "." + kammerName);
                                    myKammer = (RuestkammerVater) Class.forName(armyPackage + "units." + autoRef.toLowerCase() + "." + kammerName).newInstance();
                                } catch (Exception ex6) {
                                    try {
                                        String autoRef = kammerName.substring(0, 4);
                                        LOGGER.info(armyPackage + "units." + autoRef + "." + kammerName);
                                        myKammer = (RuestkammerVater) Class.forName(armyPackage + "units." + autoRef.toLowerCase() + "." + kammerName).newInstance();
                                    } catch (Exception ex7) {
                                        String autoRef = kammerName.substring(0, 6);
                                        LOGGER.info(armyPackage + "units." + autoRef + "." + kammerName);
                                        myKammer = (RuestkammerVater) Class.forName(armyPackage + "units." + autoRef.toLowerCase() + "." + kammerName).newInstance();

                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            OnlineCodex.getInstance().fehler(armyPackage + "units." + reflectionKennung.toLowerCase() + "." + kammerName + ".class nicht gefunden. Rüstkammer kann nicht geöffnet werden." + ZEILENUMBRUCH + "Bitte melden!");
            LOGGER.info(kammerName + ".class nicht gefunden. Rüstkammer kann nicht geöffnet werden.");
            LOGGER.error("", e);
        }

        myKammer.setCloseListener(closeListenerWindow, closeListenerFocus, closeListenerAction);
        myKammer.setzteRefreshListener(ID);

        myKammer.setName(name);
        myKammer.setUeberschrift(name);

        if (!name.equals("")) {
            myKammer.setUeberschrift(name + " " + BuildaHQ.translate("Rüstkammer"));
            myKammer.name = name;
        }

        sizeSetzen();

        addRefreshListener(RUESTKAMMER_STARTER, () -> {
            if (isSelected()) {
                textUebernehmen();
                setLegal(legal);
            }
        });
    }

    public void init(int ID, int lX, int lY, RuestkammerVater abteilung) {
        this.selected = false;
        this.name = abteilung.getName();
        panel.setLocation(lX - 5, lY);
        ico = BuildaHQ.createPictureJLabel("oc/sysimages/RuestkammerIcon.jpg");
        ico.setBounds(randAbstand - 2, 6, ruestkammerIconBreite, 12);
        panel.add(ico);

        startButton.setBounds(ruestkammerIconBreite + randAbstand, 0, buttonBreite, buttonHoehe + 4);
        startButton.addMouseListener(this);
        BuildaHQ.newGUIComponent(startButton);
        startButton.setBorder(null);

        fontSetzen(false);
        panel.add(startButton);

        try {
            myKammer = (RuestkammerVater) abteilung;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getPanel(), abteilung.getName() + ".class" + BuildaHQ.translate("nicht gefunden. Rüstkammer kann nicht geöffnet werden:") + " " + e.getMessage());
        }

        myKammer.setCloseListener(closeListenerWindow, closeListenerFocus, closeListenerAction);
        myKammer.setzteRefreshListener(ID);

        if (!abteilung.getName().equals("")) {
            myKammer.setUeberschrift(abteilung.getName() + " " + BuildaHQ.translate("Rüstkammer"));
            myKammer.name = abteilung.getName();
        }

        sizeSetzen();

        addRefreshListener(RUESTKAMMER_STARTER, () -> {
            if (isSelected()) {
                textUebernehmen();
                setLegal(legal);
            }
        });
    }

    public void initKammer(boolean... b) {
        myKammer.initButtons(b);
        labelSetzen();
    }

    public void setGrundkosten(int i) {
        myKammer.grundkosten = i;
        labelSetzen();
    }

    private void labelSetzen() {
        FontMetrics fm = startButton.getFontMetrics(startButton.getFont());
        StringBuilder abstandshalter = new StringBuilder("");

        String punkteString = "";
        punkteString = entferneNullNachkomma(myKammer.grundkosten) + " " + BuildaHQ.translate("Pkt.");

        int cnt = (buttonBreite - (fm.stringWidth(name + punkteString) + 30)) / fm.stringWidth(" .");

        for (int i = 0; i < cnt; ++i) {
            abstandshalter.append(" .");
        }

        startButton.setText(name + abstandshalter.toString() + punkteString);
    }

    public void setButtonText(String s) {
        startButton.setText(s);
        myKammer.name = "";
    }

    public void setButtonText(String s, boolean hideKammerName) {
        startButton.setText(s);
        if (hideKammerName) myKammer.name = "";
    }

    @Override
    public boolean isLegal() {
        return this.legal;
    }

    @Override
    public void setLegal(boolean b) {
        if (b && myKammer.isLegal()) {
            startButton.setForeground(Color.BLACK);
        } else {
            startButton.setForeground(Color.RED);
        }
        legal = b;
    }

    public boolean isAktiv() {
        return this.aktiv;
    }

    public void setAktiv(boolean b) {
        boolean pufferAktiv = aktiv;
        aktiv = b;
        startButton.setEnabled(b);
        ico.setEnabled(b);

        if (!b) {
            textLeeren();
        } else if (selected && !pufferAktiv) {
            textUebernehmen();
        }
    }

    @Override
    public double getKosten() {
        if (aktiv && selected) {
            try {
                return myKammer.getKosten();
            } catch (Exception e) {
            }
        }

        return 0;
    }

    private void sizeSetzen() {
        int textAreaHoehe = 0;

        String arr[] = texte.split(ZEILENUMBRUCH);
        while (textfelder.size() > 0) {
            panel.remove(textfelder.get(0));
            textfelder.remove(textfelder.get(0));
        }
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("")) {
                JLabel ta = new JLabel(arr[i]);
                ta.setLocation(randAbstand + einrueckAbstand + 1, buttonHoehe + 6 + buttonHoehe * i);
                ta.setForeground(Color.GRAY);
                ta.setFocusable(false);
                ta.setSize(buttonBreite + 20, buttonHoehe);
                textAreaHoehe += buttonHoehe;
                textfelder.add(ta);
                panel.add(ta);///iwas mit textarea führt zu scrollverschiebungen
            }
        }

        if (textfelder.size() > 0) {
            panel.setSize(ruestkammerIconBreite + randAbstand + buttonBreite, ((int) (textfelder.get(0).getLocation().getY())) + textAreaHoehe + 5);
        } else {
            panel.setSize(ruestkammerIconBreite + randAbstand + buttonBreite, buttonHoehe + 6);
        }
    }

    @Override
    public String getLabel() {
        return "";
    }

    private void uebernehmen() {
        myKammer.setVisible(false);
        RefreshListener.fireRefresh();
    }

    private void textLeeren() {
        texte = "";
        sizeSetzen();
    }

    public void setAbwaehlbar(boolean b) {  // ACHTUNG: IMMER ALS LETZTES AUFRUFEN!!!! also vor complete erst!!! weil refresh manchmal was benutzt was erst weiter unten initialisiert wird...
        this.abwaehlbar = b;
        if (!b) {
            selected = true;
            fontSetzen(true);
        }
    }

    private void aktivieren(boolean visible) {
        selected = true;
        fontSetzen(true);
        myKammer.setVisible(visible);
        RefreshListener.fireRefresh();
    }

    @Override
    public void mouseReleased(MouseEvent event) { // liegt auf dem RuestkammerStartButton
        if (!aktiv) {
            return;
        }
        setSelected(event.getButton() == MouseEvent.BUTTON1, true);
    }

    private void setSelected(boolean select, boolean visible) {
        if (select) {
            boolean wasSelected = selected;
            aktivieren(visible);
            if (!wasSelected && !BuildaHQ.loadWindow) addSelection();
        } else if (abwaehlbar) {

            if (!(myKammer.toString().indexOf("Abteilung") == -1)) {
                if (myKammer.getKosten() > 0) {
                    JOptionPane op = new JOptionPane("Bitte die Anzahl der Modelle auf '0' setzen.", JOptionPane.WARNING_MESSAGE);
                    JDialog dialog = op.createDialog("Hinweis");
                    dialog.setAlwaysOnTop(true); //<-- this line
                    dialog.setModal(true);
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                    return;
                }
            }

            selected = false;
            fontSetzen(false);
            myKammer.setVisible(false);

            removeSelection();

            textLeeren();
            RefreshListener.fireRefresh();
        }
    }

    private void removeSelection() {
        if (!(myKammer.toString().indexOf("MagicItems") == -1) || !(myKammer.toString().indexOf("Banner") == -1) || !(myKammer.toString().indexOf("Gabe") == -1)
                || !(myKammer.toString().indexOf("GiftsOf") == -1) || !(myKammer.toString().indexOf("Spites") == -1) || !(myKammer.toString().indexOf("Assassin") == -1)) {

            StringTokenizer tokenizer = new StringTokenizer(myKammer.getText(), ",");
            while (tokenizer.hasMoreElements()) {
                String tok = BuildaHQ.translate(tokenizer.nextToken().trim());

                if (BuildaHQ.Items != null && BuildaHQ.Items.contains(tok)) {
                    BuildaHQ.Items.remove(tok);
                }

            }
        }
    }

    private void addSelection() {
        if (!(myKammer.toString().indexOf("MagicItems") == -1) || !(myKammer.toString().indexOf("Banner") == -1) || !(myKammer.toString().indexOf("Gabe") == -1)
                || !(myKammer.toString().indexOf("GiftsOf") == -1) || !(myKammer.toString().indexOf("Spites") == -1) || !(myKammer.toString().indexOf("Assassin") == -1)) {

            StringTokenizer tokenizer = new StringTokenizer(myKammer.getText(), ",");
            while (tokenizer.hasMoreElements()) {
                String tok = BuildaHQ.translate(tokenizer.nextToken().trim());

                if (BuildaHQ.Items != null && BuildaHQ.Items.contains(tok)) {
                    JOptionPane op = new JOptionPane(tok + " " + BuildaHQ.translate("darf nur einmal enthalten sein."), JOptionPane.ERROR_MESSAGE);
                    JDialog dialog = op.createDialog(BuildaHQ.translate("Fehler"));
                    dialog.setAlwaysOnTop(true); //<-- this line
                    dialog.setModal(true);
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                }
                if (BuildaHQ.Items != null) BuildaHQ.Items.add(tok);

            }
        }
    }

    public void deselectYourself() {
        LOGGER.info("RuestkammerStarter-deleteyourself");
        if (this.abwaehlbar) {
            selected = false;
            fontSetzen(false);
            myKammer.setVisible(false);
            myKammer.deleteYourself();
            textLeeren();
            RefreshListener.fireRefresh();
        }
    }

    private void fontSetzen(boolean b) { // 0_Plain  1_Bold  2_Italic    oder einfach die Font.BOLD usw. Konstanten benutzen... ist dasgleiche
        if (b) {
            startButton.setFont(bold);
            textUebernehmen();
        } else {
            startButton.setFont(plain);
            textLeeren();
        }
    }

    private void ruestkammerClosed() {
        textUebernehmen();
        uebernehmen();
    }

    public String getText() {
        String result;

        if (aktiv && selected) {
            StringBuilder textPuffer = new StringBuilder();
            if (myKammer.grundkosten != 0 || ueberschriftTrotzNullKostenAusgeben) {
                if (BuildaHQ.allePunktkosten && myKammer.grundkosten != 0) {
                    textPuffer.append(BuildaHQ.formatierFett(name + punkteAbstandHalter + entferneNullNachkomma(myKammer.grundkosten) + " " + BuildaHQ.translate("Pkt.")));
                } else {
                    textPuffer.append(BuildaHQ.formatierFett(name));
                }
            }

            textPuffer.append(myKammer.getText());

            // If no text is containes, do not append anything
            if (textPuffer.toString().length() == 0) return "";

            if (BuildaHQ.kurzerText) {
                result = textPuffer.toString() + "  -> " + entferneNullNachkomma(getKosten()) + " " + BuildaHQ.translate("Pkt.");
            } else {
                result = textPuffer.toString();
            }

            final String einrueckString = BuildaHQ.getEinrueckString();
            String randabstand = BuildaHQ.getStringXMal(einrueckString, einrueckIndex);
            return "\n" + randabstand + "+ " + result.replace("\n", "\n" + randabstand + einrueckString);  // wenn einrückIndex == 0  dann änderts nix
        } else {
            return "";
        }
    }

    @Override
    public String getSaveText() {
        return (isSelected() ? "Y" : "N") + SAVETEXT_SELECTEDTRENNER + myKammer.getSaveText(einrueckIndex > 0 ? SAVETEXT_TRENNER1_6 : SAVETEXT_TRENNER1_5);
    }

    @Override
    public Element getSaveElement() {
        Element root = myKammer.getSaveElement();
        root.setAttribute("selected", Boolean.toString(isSelected()));
        return root;
    }

    @Override
    public void load(String s) {
        myKammer.load(s.substring(s.indexOf(SAVETEXT_SELECTEDTRENNER) + SAVETEXT_SELECTEDTRENNER.length(), s.length()), einrueckIndex > 0 ? SAVETEXT_TRENNER1_6 : SAVETEXT_TRENNER1_5);
        texte = myKammer.getText().replace(", ", "\n- ").trim();
        sizeSetzen();
        this.setSelected(s.substring(0, 1).equals("Y"), false);
        myKammer.setVisible(false);
    }

    @Override
    public void loadElement(Element e) {
        myKammer.loadElement(e);
        texte = myKammer.getText().replace(", ", "\n- ").trim();
        sizeSetzen();
        this.setSelected(Boolean.parseBoolean(e.getAttribute("selected")), false);
        myKammer.setVisible(false);
    }

    public void deleteYourself() {
        removeSelection();
        myKammer.deleteYourself();
    }

    public void textUebernehmen() {
        texte = myKammer.getText().replace(", ", "\n- ").trim();
        sizeSetzen();
    }

}
