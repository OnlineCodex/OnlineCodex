package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHAPLAIN;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATHWATCH;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TERMINATOR;

import oc.Eintrag;

public class IMDeathwatchChaplaininTerminatorArmour extends Eintrag {

    public IMDeathwatchChaplaininTerminatorArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, DEATHWATCH, CHARACTER, INFANTRY, CHAPLAIN, TERMINATOR);
        
        name = "Chaplain in Terminator Armour";
        grundkosten = getPts("Chaplain in Terminator Armour");
        power = 6;
        
        seperator();
        
        addWeapons(IMDeathwatchRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
