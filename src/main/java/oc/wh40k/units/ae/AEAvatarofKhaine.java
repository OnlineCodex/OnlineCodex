package oc.wh40k.units.ae;

import oc.Eintrag;

public class AEAvatarofKhaine extends Eintrag {

    public AEAvatarofKhaine() {
        name = "Avatar of Khaine";
        grundkosten = getPts("Avatar of Khaine");
        power = 13;

        seperator();

        addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}