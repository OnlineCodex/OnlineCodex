package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHSkullCannon extends Eintrag {

    public CHSkullCannon() {

        name = "Skull Cannon";
        grundkosten = getPts("Skull Cannon");
        power = 5;
        complete();

    }

    @Override
    public void refreshen() {
    }
}
