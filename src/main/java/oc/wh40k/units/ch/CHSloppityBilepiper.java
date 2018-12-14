package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHSloppityBilepiper extends Eintrag {

    public CHSloppityBilepiper() {
        name = "Sloppity Bilepiper";
        grundkosten = getPts("Sloppity Bilepiper") + getPts("Marotter");
        power = 3;
        
        seperator();
        
        addWarlordTraits("", true, NURGLE);

        complete();
    }
}
