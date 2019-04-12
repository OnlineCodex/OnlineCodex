package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHAOS_LORD;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATH_GUARD;
import static oc.KeyWord.HERETIC_ASTARTES;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.TERMINATOR;

import oc.Eintrag;

public class CHDGChaosLordinTerminatorArmour extends Eintrag {

    public CHDGChaosLordinTerminatorArmour() {
    	super(CHAOS, NURGLE, HERETIC_ASTARTES, DEATH_GUARD, CHARACTER, INFANTRY, TERMINATOR, CHAOS_LORD);
        name = "Chaos Lord in Terminator Armour";
        grundkosten = getPts("Chaos Lord in Terminator Armour");
        power = 7;

        seperator();

        addWeapons(CHDeathGuardRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }
}
