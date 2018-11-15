package oc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

public abstract class Eintrag extends OptionsCollection implements BuildaSTK {

    private static final Logger LOGGER = LoggerFactory.getLogger(Eintrag.class);

    protected int kategorie;
    protected double eintragsCNT = 1; // Wieviel dieser Eintrag als Eintrag zählt. Fast alle haben 1 hier stehen, wenn der Eintrag nicht als Eintrag zählt steht hier 0, bei Chaosdämonen HQ'S Heralde 0.5
    protected boolean überschriftSetzen = false; // kann innerhalb der "extends Eintrag" Klasse verändert werden
    protected boolean neuzeile = false; // kann innerhalb der "extends Eintrag" Klasse verändert werden
    protected boolean keineÜberschrift = false; // kann innerhalb der "extends Eintrag" Klasse verändert werden
    protected boolean unikat = false; // kann innerhalb der "extends Eintrag" Klasse verändert werden,
    protected String unikatName;
    protected String auswahl = "Auswahl";
    protected int unikatMin = 0;
    protected int unikatMax = 1;
    protected boolean unikatFehler;
    protected boolean gesamtpunkteImmerAnzeigen = false; //Um bei einigen Einheiten bei der Auswahl von alle Punkte zu verhinern, dass keine Gesamtpunkte angezeigt werden.
    protected boolean ally = false;
    protected BuildaVater buildaVater;
    protected int power = 0;
    protected OptionsButtonUpgrade chosenRelic = null;
    protected boolean uniqueError = false;
    private JLabel lKosten = new JLabel("");
    private JLabel legalerEintragLabel = new JLabel();
    private boolean countToMinimum = true;
    private boolean countToMaximum = true;
    private double prozentKosten = 0.0;

    public Eintrag() {
        lKosten.setSize(150, 17);
        panel.add(lKosten);
        kostenLabelAktualisieren();

        legalerEintragLabel.setFont(new Font("arial", Font.BOLD, 12));
        legalerEintragLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        legalerEintragLabel.setForeground(Color.RED);
        legalerEintragLabel.setSize(150, 17);

        panel.add(legalerEintragLabel);
        panel.setBorder(blackBorder);
        panel.setLayout(null);

        unikatName = this.getClass().getName();

        oc.BuildaHQ.addToInformationVectorGlobal(unikatName, 1);

        RefreshListener rl = new RefreshListener((byte) 7) {
            @Override
            public void refresh() {
                refreshen();
                uniqueError = false;
                chosenRelic = null;
                for (int i = 0; i < optionen.size(); ++i) {
                    if (optionen.elementAt(i) instanceof OptionsUpgradeGruppe) {
                        chosenRelic = ((OptionsUpgradeGruppe) optionen.elementAt(i)).getChosenRelic();
                        if (chosenRelic != null) {
                            uniqueError = uniqueError || chosenRelic.uniqueError;
                            break;
                        }
                    } else if (optionen.elementAt(i) instanceof OptionsEinzelUpgrade) {
                        chosenRelic = ((OptionsEinzelUpgrade) optionen.elementAt(i)).getChosenRelic();
                        if (chosenRelic != null) {
                            uniqueError = uniqueError || chosenRelic.uniqueError;
                            break;
                        }
                    } else if (optionen.elementAt(i) instanceof RuestkammerStarter) {
                        uniqueError = uniqueError || ((RuestkammerStarter) optionen.elementAt(i)).getKammer().uniqueError;
                    }
                }
                if (chosenRelic == null) {
                    for (int i = 0; i < optionen.size(); ++i) {
                        if (optionen.elementAt(i) instanceof OptionsUpgradeGruppe) {
                            ((OptionsUpgradeGruppe) optionen.elementAt(i)).enableRelics();
                        } else if (optionen.elementAt(i) instanceof OptionsEinzelUpgrade) {
                            ((OptionsEinzelUpgrade) optionen.elementAt(i)).enableRelics();
                        }
                    }
                } else {
                    for (int i = 0; i < optionen.size(); ++i) {
                        if (optionen.elementAt(i) instanceof OptionsUpgradeGruppe) {
                            ((OptionsUpgradeGruppe) optionen.elementAt(i)).disableOtherRelics(chosenRelic);
                        } else if (optionen.elementAt(i) instanceof OptionsEinzelUpgrade) {
                            ((OptionsEinzelUpgrade) optionen.elementAt(i)).disableOtherRelics(chosenRelic);
                        }
                    }
                }

                if (uniqueError) {
                    setFehlermeldung("Doppeltes Relikt");
                } else {
                    setFehlermeldung(getFehlermeldung());
                }

                if (unikat && oc.BuildaHQ.getCountFromInformationVectorGlobal(unikatName) > unikatMax) {
                    setFehlermeldung((unikatMin == unikatMax ? unikatMin : unikatMin + "-" + unikatMax) + " " + auswahl, true);
                } else {
                	setFehlermeldung(getFehlermeldung());
                }
                
                kostenLabelAktualisieren();
                panel.setSize(getBreite(), getHöhe());
                lKosten.setLocation(278, getHöhe() - 20);
                legalerEintragLabel.setLocation(278, getHöhe() - 40);

            }
        };

        this.ID = rl.getID();
    }

    public void setBuildaVater(BuildaVater buildaVater) {
        LOGGER.info("setBuildaVater " + (buildaVater == null));
        this.buildaVater = buildaVater;
    }

    private void checkUnikatErrorMessageState() {
        String fehlerBuffer = unikatFehler ? "" : getFehlermeldung();

        if (isUnikat()) {
            if (unikat && oc.BuildaHQ.getCountFromInformationVectorGlobal(unikatName) > unikatMax) {
                setFehlermeldung((unikatMin == unikatMax ? unikatMin : unikatMin + "-" + unikatMax) + " " + auswahl, true);
            } else {
                setFehlermeldung(fehlerBuffer);
            }
        }
    }

    protected void updatePosition(OptionsVater ov1, OptionsVater ov2, int seperator) {
        ov1.getPanel().setLocation(ov1.getPanel().getX(), ov2.getPanel().getY() + ov2.getPanel().getHeight() + seperator);
    }

    /**
     * minimal null, maximal unikatMax solcher Auswahl, sonst Fehlermeldung, wenn unikat = true
     */
    public void setUnikat(boolean unikat, int unikatMax) {
        checkUnikatErrorMessageState();
        this.unikat = unikat;
        this.unikatMax = unikatMax;
    }

    /**
     * minimal null, maximal unikatMax solcher Auswahl, sonst Fehlermeldung, wenn unikat = true
     */
    public void setUnikat(boolean unikat, int unikatMax, String auswahl) {
        checkUnikatErrorMessageState();
        this.unikat = unikat;
        this.unikatMax = unikatMax;
        this.auswahl = auswahl;
    }

    /**
     * minimal unikatMin, maximal unikatMax solcher Auswahl, sonst Fehlermeldung, wenn unikat = true
     */
    public void setUnikat(boolean unikat, int unikatMin, int unikatMax) {
        checkUnikatErrorMessageState();
        this.unikat = unikat;
        this.unikatMin = unikatMin;
        this.unikatMax = unikatMax;
    }

    /**
     * minimal unikatMin, maximal unikatMax solcher Auswahl, sonst Fehlermeldung, wenn unikat = true
     */
    public void setUnikat(boolean unikat, int unikatMin, int unikatMax, String auswahl) {
        checkUnikatErrorMessageState();
        this.unikat = unikat;
        this.unikatMin = unikatMin;
        this.unikatMax = unikatMax;
        this.auswahl = auswahl;
    }

    public void setUnikatName(String unikatName) {
        BuildaHQ.addToInformationVectorGlobal(unikatName, BuildaHQ.getCountFromInformationVectorGlobal(this.unikatName));
        this.unikatName = unikatName;
    }

    public boolean isUnikat() {
        return this.unikat;
    }

    /**
     * minimal null, maximal eine solche Auswahl, sonst Fehlermeldung, wenn unikat = true
     */
    public void setUnikat(boolean unikat) {
        checkUnikatErrorMessageState();
        this.unikat = unikat;
    }

    public boolean isCountToMinimum() {
        return this.countToMinimum;
    }

    public void setCountToMinimum(boolean state) {
        this.countToMinimum = state;
    }

    public boolean isCountToMaximum() {
        return this.countToMaximum;
    }

    public void setCountToMaximum(boolean state) {
        this.countToMaximum = state;
    }

    public int getKategorie() {
        return this.kategorie;
    }

    public void setKategorie(int i) {
        kategorie = i;
    }

    @Override
    public JPanel getPanel() {
        return this.panel;
    }

    public double getEintragsCNT() {
        return eintragsCNT;
    }

    protected void setEintragsCNT(double eintragsCNT) {
        this.eintragsCNT = eintragsCNT;
    }

    public void setKostenLabelVisible(boolean b) {
        lKosten.setVisible(b);
    }

    public void setFehlermeldung(String meldung, boolean unikatFehler) {
        legalerEintragLabel.setText(meldung);
        this.unikatFehler = unikatFehler;
    }

    public String getFehlermeldung() {
        return legalerEintragLabel.getText();
    }

    public void setFehlermeldung(String meldung) {
        setFehlermeldung(meldung, false);
    }

    @Override
    public String getText() {  // der Text, der in der Textarea als Armeeliste angezeigt wird, wird immer in  getText()  Methoden generiert.
        if (this instanceof LeererEintrag) return "";

        String titel = "";
        int cnt = 0;

        if (grundkosten != 0 && !keineÜberschrift) {
            String kosten = "";
            if (BuildaHQ.allePunktkosten) {
                kosten = punkteAbstandHalter + entferneNullNachkomma(grundkosten) + " " + BuildaHQ.translate("Punkte");
            }
            titel = BuildaHQ.formatierFett(name + kosten + (neuzeile ? "\n" : ""));
            ++cnt;
        } else if (überschriftSetzen) {
            titel = BuildaHQ.formatierItalic(BuildaHQ.formatierFett(name));
        }

        StringBuilder text = new StringBuilder(titel);

        for (int i = 0; i < optionen.size(); ++i) {
            if (optionen.elementAt(i).isSelected()) {
                text.append(optionen.elementAt(i).getText());
                ++cnt;
            }
        }

        //Bei alle Punktkosten: hier wird bei kostenlosen Einträgen, bei denen nur die erste Option gewählt ist, welche selbst aber noch Kosten und weitere eigene Optionen hat, die Gesamtpunktzahl nicht angezeigt. Deswegen: "gesamtpunkteImmerAnzeigen" hinzugefügt.
        if (this.getKosten() != 0 && (cnt > 1 || !BuildaHQ.allePunktkosten || (optionen.size() > 0 ? optionen.elementAt(0).getKosten() != this.getKosten() : false) || gesamtpunkteImmerAnzeigen)) {
            text.append(" " + BuildaHQ.formatierItalic(" - - - > " + entferneNullNachkomma(getKosten()) + " " + BuildaHQ.translate("Punkte") + " (PL " + getPower()+ ")"));
        }

        // ACHTUNG BEI KOSTENLOSEN EINTRÄGEN, die trotzdem angezeigt werden sollen!
        text.append(ZEILENUMBRUCH);
        text.append(ZEILENUMBRUCH);

        String s = text.toString();

        if (s.indexOf(BuildaHQ.abstand) == 0) {
            s = s.substring(BuildaHQ.abstand.length(), s.length());
        }

        return s;
    }

    public void kostenLabelAktualisieren() {
        lKosten.setText((BuildaHQ.getSprache() == Sprache.English ? "    " : "") + BuildaHQ.translate("Insgesamt") + " " + entferneNullNachkomma(getKosten()) + " " + BuildaHQ.translate("Punkte"));
    }

    public abstract void refreshen();

    @Override
    public int getBreite() {
        return auswahlBreite + randAbstand;
    }

    @Override
    public int getHöhe() {
        return super.getHöhe() > 60 ? super.getHöhe() : 60;
    }

    public void complete() {
        panel.setSize(getBreite(), getHöhe());
        lKosten.setLocation(278, getHöhe() - 20);
        refreshen();
        kostenLabelAktualisieren();
    }

    public void deleteYourself() {
        LOGGER.info("Eintrag-deleteyourself");
        BuildaHQ.addToInformationVectorGlobal(unikatName, -1);

        for (int i = 0; i < optionen.size(); ++i) {
            if (optionen.elementAt(i) instanceof RuestkammerStarter) {
                RuestkammerStarter rk = ((RuestkammerStarter) optionen.elementAt(i));

                if (!(rk.getKammer().toString().indexOf("MagicItems") == -1) || !(rk.getKammer().toString().indexOf("Banner") == -1) || !(rk.getKammer().toString().indexOf("Gabe") == -1)
                        || !(rk.getKammer().toString().indexOf("GiftsOf") == -1) || !(rk.getKammer().toString().indexOf("Spites") == -1) || !(rk.getKammer().toString().indexOf("Assassin") == -1)) {

                    String text = "";
                    if (rk.getKammer().getText().length() > 2) {
                        text = rk.getKammer().getText().substring(1, rk.getKammer().getText().length());
                    }
                    text = text.replaceAll("\n- ", "-");
                    StringTokenizer tokenizer = new StringTokenizer(text, ",");
                    while (tokenizer.hasMoreElements()) {
                        String tok = BuildaHQ.translate(tokenizer.nextToken().trim());

                        if (BuildaHQ.Items != null && BuildaHQ.Items.contains(tok)) {
                            BuildaHQ.Items.remove(tok);
                        }

                    }
                }

                BuildaHQ.addToInformationVectorGlobal(unikatName, -1);
                LOGGER.info("RuestkammerStarter-rk-deleteyourself");
                rk.deleteYourself();
            } else if (optionen.elementAt(i) instanceof OptionsUpgradeGruppe) {
                ((OptionsUpgradeGruppe) optionen.elementAt(i)).deleteYourself();
            } else if (optionen.elementAt(i) instanceof OptionsEinzelUpgrade) {
                ((OptionsEinzelUpgrade) optionen.elementAt(i)).deleteYourself();
            }
        }
    }

    public double getProzentKosten() {
        return prozentKosten;
    }

    public void setProzentKosten(double prozentKosten) {
        this.prozentKosten = prozentKosten;
    }

    public boolean hasSpecialValue(String key) {
        return false;
    }

    public void addToInformationVector(String s, int count) { // um wieviel der key s erhöht/vermindert wird
        checkBuildaVater();

        if (buildaVater != null) {
            buildaVater.addToInformationVector(s, count);
        }
    }

    public int getCountFromInformationVector(String s) {
        checkBuildaVater();

        if (buildaVater != null) {
            return buildaVater.getCountFromInformationVector(s);
        } else {
            return 0;
        }
    }

    public void setInformationVectorValue(String s, int value) {
        checkBuildaVater();

        if (buildaVater != null) {
            buildaVater.setInformationVectorValue(s, value);
        }
    }

    public int getPower() {
        return power;
    }

    public int getPts(String s) {
        checkBuildaVater();

        s = s.replaceAll(" ", "");
        s = s.replaceAll("-", "");
        s = s.toLowerCase();

        if (buildaVater.pointValues.get(s) == null) {
            LOGGER.error("getPts - " + s);
            return 0;
        } else {
            return buildaVater.pointValues.get(s);
        }
    }

    public void checkBuildaVater() {
        if (buildaVater == null) {
            buildaVater = BuildaHQ.aktBuildaVater;
        }
    }

}