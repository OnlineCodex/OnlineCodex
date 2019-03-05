package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATHWATCH;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PRIMARIS;
import static oc.KeyWord.WATCH_CAPTAIN;

import oc.*;

public class IMPrimarisWatchCaptain extends Eintrag {

    public IMPrimarisWatchCaptain() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, DEATHWATCH, CHARACTER, INFANTRY, WATCH_CAPTAIN, PRIMARIS);
    	
        name = "Primaris Watch Captain";
        grundkosten = getPts("Primaris Watch Captain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 6;
        
        seperator();

        addWeapons(IMDeathwatchRuestkammer.class, true);
       
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
