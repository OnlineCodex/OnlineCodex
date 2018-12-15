package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHExaltedFlamer extends Eintrag {

    public CHExaltedFlamer() {

        name = "Exalted Flamer";
        grundkosten = getPts("Exalted Flamer");
        power = 4;
        setKeywords(ImmutableSet.of(CHAOS, TZEENTCH, DAEMON, CHARACTER, INFANTRY, FLAMER, FLY, EXALTED_FLAMER));
        
        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);
        
        seperator();
        
        addWarlordTraits("", true, TZEENTCH);

        complete();

    }
}
