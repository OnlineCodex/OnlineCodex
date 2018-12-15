package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHHorticulousSlimux extends Eintrag {

    public CHHorticulousSlimux() {
        name = "Horticulous Slimux";
        grundkosten = getPts("Horticulous Slimux");
        power = 4;
        setKeywords(ImmutableSet.of(CHAOS, NURGLE, DAEMON, CHARACTER, CAVALRY, HERALD_OF_NURGLE, PLAGUEBEARER, HORTICULOUS_SLIMUX));
        
        seperator();
        
        addWarlordTraits("Nurgle: Acidic Ichor", true);

        complete();
    }

    @Override
    public void refreshen() {

    }

}
