package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHKaranak extends Eintrag {

    public CHKaranak() {

        name = "Karanak";
        grundkosten = getPts("Karanak");
        power = 6;
        setKeywords(ImmutableSet.of(CHAOS, KHORNE, DAEMON, BEAST, CHARACTER, FLESH_HOUND, KARANAK));
        
        seperator();
        
        addWarlordTraits("Khorne: Aspect of Death", true, KHORNE);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
