package oc.wh40k.units.im;

import oc.Eintrag;

public class IMRavenwingTalonmaster extends Eintrag {

    public IMRavenwingTalonmaster() {
        name = "Ravenwing Talonmaster";
        grundkosten = getPts("Ravenwing Talonmaster") + getPts("Twin assault cannon") + getPts("Twin heavy bolter") + getPts("Power sword (SM)");
        power = 9;
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}

