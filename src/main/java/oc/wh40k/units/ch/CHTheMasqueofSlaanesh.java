package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHTheMasqueofSlaanesh extends Eintrag {

    public CHTheMasqueofSlaanesh() {

        name = "The Masque of Slaanesh";
        grundkosten = getPts("The Masque of Slaanesh");
        power = 4;
        setKeywords(ImmutableSet.of(CHAOS, SLAANESH, DAEMON, CHARACTER, INFANTRY, DAEMONETTE, HERALD_OF_SLAANESH, THE_MASQUE_OF_SLAANESH));
        
        seperator();
        
        addWarlordTraits("Slaanesh: The Murderdance", true, SLAANESH);
        
        complete();
    }

    @Override
    public void refreshen() {
    	setUnikat(true);
    }
}
