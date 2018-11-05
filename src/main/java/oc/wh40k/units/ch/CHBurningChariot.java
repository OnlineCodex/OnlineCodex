package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CHBurningChariot extends Eintrag {

    OptionsEinzelUpgrade waffe2;

    public CHBurningChariot() {

        name = "Burning Chariot";
        grundkosten = getPts("Burning Chariot");
        power = 5;

        add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chanting Horrors", getPts("Chanting Horrors")));

        complete();

    }

    @Override
    public void refreshen() {
    }
}
