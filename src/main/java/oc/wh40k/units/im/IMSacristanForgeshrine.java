package oc.wh40k.units.im;

import oc.Eintrag;

public class IMSacristanForgeshrine extends Eintrag {

    public IMSacristanForgeshrine() {
        name = "Sacristan Forgeshrine";
        grundkosten = getPts("Sacristan Forgeshrine");
        power = 4;

        complete();
    }
}
