package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHAnggrathTheUnbound extends Eintrag {

    public CHAnggrathTheUnbound() {

        name = "An'ggrath the Unbound";
        grundkosten = getPts("An'ggrath the Unbound");
        power = 35;

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
