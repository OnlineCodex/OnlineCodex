package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHSpoilpoxScrivener extends Eintrag {

    public CHSpoilpoxScrivener() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, INFANTRY, PLAGUEBEARER, HERALD_OF_NURGLE, SPOILPOX_SCRIVENER);
        name = "Spoilpox Scrivener";
        grundkosten = getPts("Spoilpox Scrivener") /*+ getPts("Plaguesword") + getPts("Distended maw") + getPts("Disgusting sneezes")*/;
        power = 3;

        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);
        
        seperator();
        
        addWarlordTraits("", NURGLE);

        complete();
    }
}
