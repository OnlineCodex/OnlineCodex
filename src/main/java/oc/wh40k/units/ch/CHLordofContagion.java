package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATH_GUARD;
import static oc.KeyWord.HERETIC_ASTARTES;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.LORD_OF_CONTAGION;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.TERMINATOR;

import oc.Eintrag;

public class CHLordofContagion extends Eintrag {

    public CHLordofContagion() {
    	super(CHAOS, NURGLE, HERETIC_ASTARTES, DEATH_GUARD, CHARACTER, INFANTRY, TERMINATOR, LORD_OF_CONTAGION);

        name = "Lord of Contagion";
        grundkosten = getPts("Lord of Contagion");
        power = 9;

        seperator();

        addWeapons(CHDeathGuardRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
