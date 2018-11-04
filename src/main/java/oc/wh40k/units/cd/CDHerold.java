package oc.wh40k.units.cd;


import oc.BuildaHQ;
import oc.Chooser;
import oc.Eintrag;

import java.util.List;

public class CDHerold extends Eintrag {

    public CDHerold() {
    }

    @Override
    public void refreshen() {

        if (ally == false) {
            setEintragsCNT(this.calculateEntryCount());
        } else {
            setEintragsCNT(this.calculateEntryCountAlly());
        }
    }


    /**
     * eintragsCNT berechnen als Ally berechnen
     *
     * @return eintragsCNT
     */
    protected double calculateEntryCountAlly() {
        double count = 0.0;
        List<Chooser> allChooser = BuildaHQ.getChooserGruppe(1).getmC();
        for (Chooser chooser : allChooser) {
            if (chooser.getEintrag() instanceof CDHerold) {
                count += 1;
            }
        }

        return (count / count);
    }

    /**
     * eintragsCNT berechnen
     *
     * @return eintragsCNT
     */
    protected double calculateEntryCount() {
        double count = 0.0;
        List<Chooser> allChooser = BuildaHQ.getChooserGruppe(1).getmC();
        for (Chooser chooser : allChooser) {
            if (chooser.getEintrag() instanceof CDHerold) {
                count += 1;
            }
        }

        // merhfache von 2 beachten
        double adder = 1.0;
        double checkCount = count;
        while (checkCount > 4) {
            checkCount = checkCount - 4.0;
            adder++;
        }

        if (adder > 1) {
            setFehlermeldung("Max 4 Herolde");
        } else {
            setFehlermeldung("");
        }

        return adder / (count == 0.0 ? 1.0 : count);


    }

}
