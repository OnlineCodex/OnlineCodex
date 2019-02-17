package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATH_GUARD;
import static oc.KeyWord.HERETIC_ASTARTES;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.NOXIOUS_BLIGHTBRINGER;
import static oc.KeyWord.NURGLE;

import oc.Eintrag;

public class CHNoxiousBlightbringer extends Eintrag {

    public CHNoxiousBlightbringer() {
    	super(CHAOS, NURGLE, HERETIC_ASTARTES, DEATH_GUARD, CHARACTER, INFANTRY, NOXIOUS_BLIGHTBRINGER);
    	
        name = "Noxious Blightbringer";
        grundkosten = getPts("Noxious Blightbringer");
        power = 4;

        seperator();
        
        addWeapons(CHDeathGuardRuestkammer.class, true);
 
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }
}
