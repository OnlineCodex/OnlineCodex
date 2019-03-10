package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMPrimarisPsyker extends Eintrag {

    public IMPrimarisPsyker() {
    	super(CHARACTER, INFANTRY, PSYKER, PRIMARIS_PSYKER);
    	
        name = "Primaris Psyker";
        grundkosten = getPts("Primaris Psyker") + getPts("Laspistol") + getPts("Force stave");
        power = 2;

        seperator();
        
        addWeapons(IMAstraMilitarumRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}