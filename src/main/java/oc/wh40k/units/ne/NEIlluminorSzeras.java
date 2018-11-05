package oc.wh40k.units.ne;

import oc.Eintrag;

public class NEIlluminorSzeras extends Eintrag {

    public NEIlluminorSzeras() {
        name = "Illuminor Szeras";
        grundkosten = getPts("Illuminor Szeras") + getPts("Eldritch lance");

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);

        power = 8;
    }
}
