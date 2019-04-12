package oc.persistence.oc;

import oc.BuildaVater;

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
            sammler.append(buildaVater.myChooserGruppen.elementAt(i).getSaveText());
            sammler.append(SAVETEXT_TRENNER4);
        }

        return sammler.toString();
    }
}
