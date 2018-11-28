package oc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class OptionsButtonUpgrade extends OptionsButton {

    private static final Logger LOGGER = LoggerFactory.getLogger(OptionsButtonUpgrade.class);
    
    boolean showKosten = true;
    boolean unique = false;
    boolean relic = false;
    private boolean selected;
    public OptionsButtonUpgrade(int ID, int lX, int lY, String verzierung, String name, boolean selected, double preis) {
        this.name = name;
        this.selected = selected;
        this.preis = preis;
        this.showKosten = true;

        produceButton();
        setVerzierung(verzierung);
        panel.setLocation(lX, lY);
    }

    public OptionsButtonUpgrade(int ID, int lX, int lY, String verzierung, String name, boolean selected, double preis, boolean showKosten) {
        this.name = name;
        this.selected = selected;
        this.preis = preis;
        this.showKosten = showKosten;

        produceButton();
        setVerzierung(verzierung);
        panel.setLocation(lX, lY);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean b) {
        selected = b;
        fontSetzen((selected ? 1 : 0));
    }

    public boolean isShowKosten() {
        return showKosten;
    }

    public void setShowKosten(boolean showKosten) {
        this.showKosten = showKosten;
    }

    public double getKosten() {
        if (!aktiv || preis == -88) {
            return 0;
        }
        return (selected ? preis : 0);
    }

    public void switsch() {
        LOGGER.info("switsch unique: " + unique);
        LOGGER.info("switsch relic: " + relic);
        if (unique || relic) {
            switsch(this.name);
        } else {
            if (aktiv) {
                selected = !selected;  // umdrehen
                fontSetzen((selected ? 1 : 0));
            }
        }
    }
    
    public void switsch(String txt) {
        if (aktiv) {
            selected = !selected;  // umdrehen
            fontSetzen((selected ? 1 : 0));

            if (selected) {
                BuildaHQ.addToInformationVectorGlobal(txt, 1);
                LOGGER.info(txt + ": " + BuildaHQ.getCountFromInformationVectorGlobal(txt));
                if (BuildaHQ.getCountFromInformationVectorGlobal(txt) > 1) {
                    JOptionPane op = new JOptionPane(txt + " " + BuildaHQ.translate("darf nur einmal enthalten sein."), JOptionPane.ERROR_MESSAGE);
                    JDialog dialog = op.createDialog(BuildaHQ.translate("Fehler"));
                    dialog.setAlwaysOnTop(true); //<-- this line
                    dialog.setModal(true);
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);

                    if (isLegal()) {
                        setLegal(false);
                    }
                }

                if (relic) {
                    BuildaHQ.addToInformationVectorGlobal("Relic", 1);

                    //TODO Armeekennung + Relic speichern
                    //TODO Test ob Relics anderer Fraktionen ausgewählt wurden -> Fehlerdialog + Fehler in Liste
                }
            }

            if (!selected) {
                BuildaHQ.addToInformationVectorGlobal(txt, -1);
                if (BuildaHQ.getCountFromInformationVectorGlobal(txt) < 0) {
                    BuildaHQ.setInformationVectorValueGlobal(txt, 0);
                }

                if (!isLegal()) {
                    setLegal(true);
                }

                if (relic) {
                    BuildaHQ.addToInformationVectorGlobal("Relic", -1);
                    //TODO Armeekennung + Relic entfernen
                    //TODO Test ob Relics anderer Fraktionen ausgewählt wurden -> Fehlerdialog + Fehler in Liste
                }
            }
        }
    }

    public void switschCost(String txt) {
        if (aktiv) {
            selected = !selected;  // umdrehen
            fontSetzen((selected ? 1 : 0));
        }
    }

    @Override
    public void labelSetzen() {
        FontMetrics fm = button.getFontMetrics(button.getFont());
        StringBuilder abstandshalter = new StringBuilder("");
        String punkteString = "";

        if (isShowKosten()) {
            if (jeweils) {
                punkteString = BuildaHQ.translate("jeweils") + " " + entferneNullNachkomma(preis) + " " + BuildaHQ.translate("Pkt.");
            } else {
                punkteString = entferneNullNachkomma(preis) + " " + BuildaHQ.translate("Pkt.");
            }

            int cnt = (buttonBreite - (fm.stringWidth((kurzerName != null ? kurzerName : name) + punkteString) + 30)) / fm.stringWidth(" .");

            for (int i = 0; i < cnt; ++i) {
                abstandshalter.append(" .");
            }
        }

        button.setText((kurzerName != null ? kurzerName : name) + abstandshalter.toString() + punkteString);
    }

    public boolean hasUniqueError() {
    	return BuildaHQ.getCountFromInformationVectorGlobal(this.name) > 1;
    }
    	
    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public boolean isRelic() {
        return relic;
    }

    public void setRelic(boolean relic) {
        this.relic = relic;
    }

}