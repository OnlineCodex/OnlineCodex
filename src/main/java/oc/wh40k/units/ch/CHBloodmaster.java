package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHBloodmaster extends Eintrag {

    public CHBloodmaster() {
        name = "Bloodmaster";
        grundkosten = getPts("Bloodmaster");
        power = 3;
        setKeywords(ImmutableSet.of(CHAOS, KHORNE, DAEMON, CHARACTER, INFANTRY, BLOODLETTER, HERALD_OF_KHORNE, BLOODMASTER));
        
        seperator();
        
        addWeapons(CHWaffenkammerCD.class, true);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {

    }

}
