package oc.wh40k.units.im;

import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.DEATHWATCH;
import static oc.KeyWord.WATCH_MASTER;

import oc.Eintrag;

public class IMWatchMaster extends Eintrag {

    public IMWatchMaster() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, DEATHWATCH, CHARACTER, INFANTRY, WATCH_MASTER);
    	
        name = "Watch Master";
        grundkosten = getPts("Watch Master");

        add(ico = new oc.Picture("oc/wh40k/images/Kommandant.gif"));

        seperator();
        
        addWeapons(IMDeathwatchRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", true);

        complete();

    }
}

