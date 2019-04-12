package oc;

import java.awt.FontMetrics;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OptionsButtonUpgrade extends OptionsButton {

    private static final Logger LOGGER = LoggerFactory.getLogger(OptionsButtonUpgrade.class);

    private boolean showCost;
    boolean unique = false;
    boolean relic = false;
    private boolean selected;

    OptionsButtonUpgrade(int lX, int lY, String decoration, String name, boolean selected, double cost) {
        this(lX, lY, decoration, name, selected, cost, false);
    }

    OptionsButtonUpgrade(int lX, int lY, String decoration, String name, boolean selected, double cost, boolean showCost) {
        this.name = name;
        this.selected = selected;
        this.cost = cost;
        this.showCost = showCost;

        produceButton();
        setVerzierung(decoration);
        panel.setLocation(lX, lY);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean b) {
        selected = b;
        fontSetzen((selected ? 1 : 0));
    }

    private boolean isShowCost() {
        return showCost;
    }

    @Override
	public double getCost() {
        if (!aktiv || cost == -88) {
            return 0;
        }
        return (selected ? cost : 0);
    }

    void toggle() {
        LOGGER.info("switsch unique: " + unique);
        LOGGER.info("switsch relic: " + relic);
        if (unique || relic) {
            toggle(this.name);
        } else {
            if (aktiv) {
                selected = !selected;
                fontSetzen((selected ? 1 : 0));
            }
        }
    }

    void toggle(String txt) {
        if (aktiv) {
            selected = !selected;
            fontSetzen((selected ? 1 : 0));

            if (selected) {
                BuildaHQ.addToInformationVectorGlobal(txt, 1);
                LOGGER.info(txt + ": " + BuildaHQ.getCountFromInformationVectorGlobal(txt));
                if (BuildaHQ.getCountFromInformationVectorGlobal(txt) > 1) {
                    final JOptionPane op = new JOptionPane(txt + " " + BuildaHQ.translate("darf nur einmal enthalten sein."), JOptionPane.ERROR_MESSAGE);
                    final JDialog dialog = op.createDialog(BuildaHQ.translate("Fehler"));
                    dialog.setAlwaysOnTop(true); //<-- this line
                    dialog.setModal(true);
                    dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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

    @Override
    public void labelSetzen() {
        final FontMetrics fm = button.getFontMetrics(button.getFont());
        final StringBuilder abstandshalter = new StringBuilder();
        String punkteString = "";

        if (isShowCost()) {
            if (jeweils) {
                punkteString = BuildaHQ.translate("jeweils") + " " + ((int) cost) + " " + BuildaHQ.translate("Pkt.");
            } else {
                punkteString = ((int) cost) + " " + BuildaHQ.translate("Pkt.");
            }

            final int cnt = (buttonBreite - (fm.stringWidth((kurzerName != null ? kurzerName : name) + punkteString) + 30)) / fm.stringWidth(" .");

            for (int i = 0; i < cnt; ++i) {
                abstandshalter.append(" .");
            }
        }

        button.setText((kurzerName != null ? kurzerName : name) + abstandshalter.toString() + punkteString);
    }

    boolean hasUniqueError() {
    	return BuildaHQ.getCountFromInformationVectorGlobal(this.name) > 1;
    }

    boolean isUnique() {
        return unique;
    }

    void setUnique(boolean unique) {
        this.unique = unique;
    }

    public boolean isRelic() {
        return relic;
    }

    public void setRelic(boolean relic) {
        this.relic = relic;
    }

}