package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATH_GUARD;
import static oc.KeyWord.HERETIC_ASTARTES;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.CHAOS_LORD;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.PSYKER;

import oc.*;

public class CHDGChaosLord extends Eintrag {

    RuestkammerStarter waffen;

    public CHDGChaosLord() {
    	super(CHAOS, NURGLE, HERETIC_ASTARTES, DEATH_GUARD, CHARACTER, INFANTRY, CHAOS_LORD);
    	
        name = "Chaos Lord";
        grundkosten = getPts("Chaos Lord");
        power = 5;

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump pack", getPts("Chaos Lord with Jump Pack") - getPts("Chaos Lord")));

        seperator();

        addWeapons(CHDeathGuardRuestkammer.class, true);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }
}
