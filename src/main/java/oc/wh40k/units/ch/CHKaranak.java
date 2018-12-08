package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHKaranak extends Eintrag {

    public CHKaranak() {

        name = "Karanak";
        grundkosten = getPts("Karanak");
        power = 6;
        
        seperator();
        
        addWarlordTraits("Khorne: Aspect of Death", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
