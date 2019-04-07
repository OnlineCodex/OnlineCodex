package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHAbaddontheDespoiler extends Eintrag {

    public CHAbaddontheDespoiler() {

        name = "Abaddon the Despoiler";
        grundkosten = getPts("Abaddon the Despoiler");
        power = 12;

        seperator();

        addWarlordTraits("Black Legion: First Amongst Traitors", true);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
