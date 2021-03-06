package oc.wh40k.units.ch;

import static oc.KeyWord.NURGLE;

import oc.Eintrag;

public class CHScabeiathraxTheBloated extends Eintrag {

    public CHScabeiathraxTheBloated() {

        name = "Scabeiathrax the Bloated";
        grundkosten = getPts("Scabeiathrax the Bloated");
        power = 30;

        seperator();

        addWarlordTraits("", NURGLE);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
