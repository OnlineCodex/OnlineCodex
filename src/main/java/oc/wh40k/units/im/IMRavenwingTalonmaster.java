package oc.wh40k.units.im;

import oc.Eintrag;

public class IMRavenwingTalonmaster extends Eintrag {

    public IMRavenwingTalonmaster() {
        name = "Ravenwing Talonmaster";
        grundkosten = getPts("Ravenwing Talonmaster") + getPts("Twin assault cannon") + getPts("Twin heavy bolter");
        power = 9;

        seperator();

        addWeapons(IMDarkAngelsRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }

}

