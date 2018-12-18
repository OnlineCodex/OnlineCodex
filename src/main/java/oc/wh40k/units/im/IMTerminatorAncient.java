package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMTerminatorAncient extends Eintrag {

    public IMTerminatorAncient() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, ANCIENT, TERMINATOR);
        name = "Terminator Ancient";
        grundkosten = getPts("Terminator Ancient");
        power = 6;

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
