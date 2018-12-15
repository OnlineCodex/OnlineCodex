package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHSkullmaster extends Eintrag {

    public CHSkullmaster() {
        name = "Skullmaster";
        grundkosten = getPts("Skullmaster");
        power = 5;
        setKeywords(ImmutableSet.of(CHAOS, KHORNE, DAEMON, CHARACTER, CAVALRY, BLOODLETTER, HERALD_OF_KHORNE, SKULLMASTER));
        
        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);
        
        seperator();
        
        addWarlordTraits("", true, KHORNE);

        complete();
    }

}
