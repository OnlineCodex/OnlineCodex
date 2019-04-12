package oc.wh40k.units.im;

import oc.Eintrag;

public class IMBelisariusCawl extends Eintrag {


    public IMBelisariusCawl() {
        name = "Belisarius Cawl";
        grundkosten = getPts("Belisarius Cawl");
        power = 13;

        seperator();

        addWarlordTraits("Mars: Static Psalm-code (AdMech)");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
