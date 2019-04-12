package oc.persistence.oc;

import oc.BuildaVater;
import oc.Chooser;
import oc.ChooserGruppe;

import javax.swing.*;
import java.util.Vector;

import static oc.BuildaSTK.*;

public class OCWriter {

    public String getSaveText(Vector<BuildaVater> myBuilderz, JTabbedPane tab) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < myBuilderz.size(); i++) {
            BuildaVater buildaVater = myBuilderz.get(i);
            s.append(tab.getTitleAt(i + 1))
                    .append(SAVETEXT_UEBERSCHRIFTTRENNER2)
                    .append(buildaVater.kontingentBox.getSelectedItem())
                    .append(SAVETEXT_DETACHMENTTYPTRENNER1)
                    .append(buildaVater.formationBox.getSelectedItem())
                    .append(SAVETEXT_DETACHMENTTYPTRENNER2)
                    .append(buildaVater.Hauptkontingent.isSelected() ? "y" : "n")
                    .append(SAVETEXT_DETACHMENTTYPTRENNER3)
                    .append(getSaveText(buildaVater))
                    .append(SAVETEXT_DETACHMENTTRENNER);
        }
        return s.toString();
    }


    private String getSaveText(BuildaVater buildaVater) {
        final StringBuilder sammler = new StringBuilder();

        for (int i = 0; i < buildaVater.myChooserGruppen.size(); ++i) {
            sammler.append(getSaveText(buildaVater.myChooserGruppen.elementAt(i)));
            sammler.append(SAVETEXT_TRENNER4);
        }

        return sammler.toString();
    }

    private String getSaveText(ChooserGruppe group) {
        final StringBuilder sammler = new StringBuilder();
        for (int i = 0; i < group.mC.size(); ++i) {
            if (!group.allyString.equals("") && group.mC.elementAt(i).selectedEntry().contains(group.allyString)) {

            } else {
                sammler.append(group.mC.elementAt(i).getComboBox().getSelectedObjects()[0])
                        .append(SAVETEXT_UEBERSCHRIFTTRENNER1)
                        .append(getSaveText(group.mC.elementAt(i)));
                sammler.append(SAVETEXT_TRENNER3);
            }
        }

        return sammler.toString();
    }

    private String getSaveText(Chooser chooser) {
        try {
            return chooser.myEintrag.getSaveText(SAVETEXT_TRENNER2);
        } catch (final Exception e) {
            return "";
        }
    }
}
