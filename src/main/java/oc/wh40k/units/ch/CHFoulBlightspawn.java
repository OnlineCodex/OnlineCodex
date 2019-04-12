package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATH_GUARD;
import static oc.KeyWord.FOUL_BLIGHTSPAWN;
import static oc.KeyWord.HERETIC_ASTARTES;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.NURGLE;

import oc.Eintrag;

public class CHFoulBlightspawn extends Eintrag {

    public CHFoulBlightspawn() {
    	super(CHAOS, NURGLE, HERETIC_ASTARTES, DEATH_GUARD, CHARACTER, INFANTRY, FOUL_BLIGHTSPAWN);

        name = "Foul Blightspawn";
        grundkosten = getPts("Foul Blightspawn");
        power = 4;

        seperator();

        addWeapons(CHDeathGuardRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }
}
