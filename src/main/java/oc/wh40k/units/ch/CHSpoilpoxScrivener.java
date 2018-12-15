package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHSpoilpoxScrivener extends Eintrag {

    public CHSpoilpoxScrivener() {
        name = "Spoilpox Scrivener";
        grundkosten = getPts("Spoilpox Scrivener") /*+ getPts("Plaguesword") + getPts("Distended maw") + getPts("Disgusting sneezes")*/;
        power = 3;
        setKeywords(ImmutableSet.of(CHAOS, NURGLE, DAEMON, CHARACTER, INFANTRY, PLAGUEBEARER, HERALD_OF_NURGLE, SPOILPOX_SCRIVENER));
        
        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);
        
        seperator();
        
        addWarlordTraits("", true, NURGLE);

        complete();
    }

    @Override
    public void refreshen() {

    }

}
