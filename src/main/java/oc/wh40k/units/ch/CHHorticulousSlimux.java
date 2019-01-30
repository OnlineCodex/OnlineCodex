package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHHorticulousSlimux extends Eintrag {

    public CHHorticulousSlimux() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, CAVALRY, HERALD_OF_NURGLE, PLAGUEBEARER, HORTICULOUS_SLIMUX);
        name = "Horticulous Slimux";
        grundkosten = getPts("Horticulous Slimux");
        power = 9;

        seperator();
        
        addWarlordTraits("Nurgle: Acidic Ichor", true);

        complete();
    }
}
