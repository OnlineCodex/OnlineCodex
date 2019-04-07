package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHHaarkenWorldclaimer extends Eintrag {

    public CHHaarkenWorldclaimer() {

        name = "Haarken Worldclaimer";
        grundkosten = getPts("Haarken Worldclaimer");
        power = 6;

        seperator();

        addWarlordTraits("Lord of Terror", true);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
