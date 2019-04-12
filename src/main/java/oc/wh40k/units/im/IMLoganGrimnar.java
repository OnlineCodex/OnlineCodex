package oc.wh40k.units.im;

import oc.Eintrag;

public class IMLoganGrimnar extends Eintrag {


    public IMLoganGrimnar() {
        name = "Logan Grimnar";
        grundkosten = getPts("Logan Grimnar");
        power = 10;

        seperator();

		addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
