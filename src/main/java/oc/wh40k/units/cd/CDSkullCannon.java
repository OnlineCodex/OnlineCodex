package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDSkullCannon extends Eintrag {

    public CDSkullCannon() {

        name = "Skull Cannon";
        grundkosten = getPts("Skull Cannon");
        power = 7;
        complete();

    }

    @Override
    public void refreshen() {
    }
}
