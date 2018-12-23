package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHSloppityBilepiper extends Eintrag {

    public CHSloppityBilepiper() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, INFANTRY, PLAGUEBEARER, HERALD_OF_NURGLE, SLOPPITY_BILEPIPER);
        name = "Sloppity Bilepiper";
        grundkosten = getPts("Sloppity Bilepiper") + getPts("Marotter");
        power = 3;

        seperator();
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);
        
        seperator();
        
        addWarlordTraits("", NURGLE);

        complete();
    }
}
