package oc.wh40k.units.ch;

import static oc.KeyWord.BIOLOGUS_PUTRIFIER;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATH_GUARD;
import static oc.KeyWord.HERETIC_ASTARTES;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.NURGLE;

import oc.Eintrag;

public class CHBiologusPutrifier extends Eintrag {


    public CHBiologusPutrifier() {
    	super(CHAOS, NURGLE, HERETIC_ASTARTES, DEATH_GUARD, CHARACTER, INFANTRY, BIOLOGUS_PUTRIFIER);

        name = "Biologus Putrifier";
        grundkosten = getPts("Biologus Putrifier") + getPts("Hyper blight grenades") + getPts("Krak grenades");
        power = 4;

        seperator();

        addWeapons(CHDeathGuardRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();

    }
}
