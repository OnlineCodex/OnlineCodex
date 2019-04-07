package oc.wh40k.units.im;

import oc.Eintrag;

public class IMBelial extends Eintrag {

    public IMBelial() {
        name = "Belial";
        grundkosten = getPts("Belial");
        power = 8;

        seperator();

        addWarlordTraits("Huntsman (DA)", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
