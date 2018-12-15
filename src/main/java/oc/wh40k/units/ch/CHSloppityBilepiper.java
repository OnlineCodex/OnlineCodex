package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHSloppityBilepiper extends Eintrag {

    public CHSloppityBilepiper() {
        name = "Sloppity Bilepiper";
        grundkosten = getPts("Sloppity Bilepiper") + getPts("Marotter");
        power = 3;
        setKeywords(ImmutableSet.of(CHAOS, NURGLE, DAEMON, CHARACTER, INFANTRY, PLAGUEBEARER, HERALD_OF_NURGLE, SLOPPITY_BILEPIPER));
        
        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);
        
        seperator();
        
        addWarlordTraits("", true, NURGLE);

        complete();
    }
}
