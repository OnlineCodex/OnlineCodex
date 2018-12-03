package oc.wh40k.units.ae;

import oc.Eintrag;

public class AEDeathJester extends Eintrag {

    public AEDeathJester() {
        name = "Death Jester";
        grundkosten = getPts("Death Jester") + getPts("Shrieker cannon");
        power = 3;
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}