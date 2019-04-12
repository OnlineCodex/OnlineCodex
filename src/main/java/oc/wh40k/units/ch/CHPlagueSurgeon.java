package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATH_GUARD;
import static oc.KeyWord.HERETIC_ASTARTES;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.PLAGUE_SURGEON;

import oc.Eintrag;

public class CHPlagueSurgeon extends Eintrag {

    public CHPlagueSurgeon() {
    	super(CHAOS, NURGLE, HERETIC_ASTARTES, DEATH_GUARD, CHARACTER, INFANTRY, PLAGUE_SURGEON);

        name = "Plague Surgeon";
        grundkosten = getPts("Plague Surgeon") + getPts("Blight grenades") + getPts("Krak grenades");
        power = 4;

        seperator();

        addWeapons(CHDeathGuardRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();

    }
}
