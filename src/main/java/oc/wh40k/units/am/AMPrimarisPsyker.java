package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class AMPrimarisPsyker extends Eintrag {

    public AMPrimarisPsyker() {
        name = "Primaris-Psioniker";
        grundkosten = 50;
        this.setEintragsCNT(0);

        add(ico = new oc.Picture("oc/wh40k/images/IGPrimarisPsyker.gif"));

        addToInformationVector("AMPrimarisPsyker", 1);

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterschaftsgrad 2", 25));

        complete();
    }

    @Override
    public void refreshen() {
        if (getCountFromInformationVector("AMTakesHQSlot") > 0) {
            this.setEintragsCNT(1);
        }

        if (getCountFromInformationVector("AMPrimarisPsyker") > 3) {
            setFehlermeldung("0-3 Auswahl!");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        addToInformationVector("AMPrimarisPsyker", -1);
    }


}
