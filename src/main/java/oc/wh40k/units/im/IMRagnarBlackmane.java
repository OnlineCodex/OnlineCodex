package oc.wh40k.units.im;

import oc.Eintrag;

public class IMRagnarBlackmane extends Eintrag {

    public IMRagnarBlackmane() {
        name = "Ragnar Blackmane";
        grundkosten = getPts("Ragnar Blackmane");
        power = 7;
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
