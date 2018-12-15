package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHTheBlueScribes extends Eintrag {

    public CHTheBlueScribes() {

        name = "The Blue Scribes";
        grundkosten = getPts("The Blue Scribes");
        power = 5;
        setKeywords(ImmutableSet.of(CHAOS, TZEENTCH, DAEMON, CAVALRY, CHARACTER, HORROR, FLY, THE_BLUE_SCRIBES));
        
        seperator();
        
        addWarlordTraits("Tzeentch: Daemonspark", true, TZEENTCH);
        
        complete();
    }

    @Override
    public void refreshen() {
    	setUnikat(true);
    }
}
