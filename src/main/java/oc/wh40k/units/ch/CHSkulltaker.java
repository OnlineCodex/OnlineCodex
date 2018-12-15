package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHSkulltaker extends Eintrag {

    public CHSkulltaker() {

        name = "Skulltaker";
        grundkosten = getPts("Skulltaker");
        power = 5;
        setKeywords(ImmutableSet.of(CHAOS, KHORNE, DAEMON, CHARACTER, INFANTRY, BLOODLETTER, HERALD_OF_KHORNE, SKULLTAKER));
        
        seperator();
        
        addWarlordTraits("Khorne: Devastating Blow", true, KHORNE);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
