package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHExaltedFlamer extends Eintrag {

    public CHExaltedFlamer() {

        name = "Exalted Flamer";
        grundkosten = getPts("Exalted Flamer");
        power = 4;
        
        seperator();
        
        addWarlordTraits("", true);

        complete();

    }

    @Override
    public void refreshen() {

    }
}
