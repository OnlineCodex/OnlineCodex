package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHBloodThrone extends Eintrag {

    public CHBloodThrone() {
        name = "Blood Throne";
        grundkosten = getPts("Blood Throne");
        power = 6;
        setKeywords(ImmutableSet.of(CHAOS, KHORNE, DAEMON, CHARACTER, CHARIOT, BLOODLETTER, HERALD_OF_KHORNE, BLOOD_THRONE));
        
        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);
        
        seperator();
        
        addWarlordTraits("", true, KHORNE);

        complete();
    }

    @Override
    public void refreshen() {

    }

}
