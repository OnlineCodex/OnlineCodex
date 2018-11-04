package oc.wh40k.units.im;

import oc.Eintrag;

public class IMCallidusAssassin extends Eintrag {

    public IMCallidusAssassin() {
        name = "Callidus Assassin";
        grundkosten = getPts("Callidus Assassin");
        power = 5;

        complete();
    }

    @Override
    public void refreshen() {
    }
}
