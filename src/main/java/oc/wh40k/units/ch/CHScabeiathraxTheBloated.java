package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHScabeiathraxTheBloated extends Eintrag {

    public CHScabeiathraxTheBloated() {

        name = "Scabeiathrax the Bloated";
        grundkosten = getPts("Scabeiathrax the Bloated");
        power = 30;

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
