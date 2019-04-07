package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.HERALD_OF_NURGLE;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.PLAGUEBEARER;
import static oc.KeyWord.SLOPPITY_BILEPIPER;

import oc.Eintrag;

public class CHSloppityBilepiper extends Eintrag {

    public CHSloppityBilepiper() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, INFANTRY, PLAGUEBEARER, HERALD_OF_NURGLE, SLOPPITY_BILEPIPER);
        name = "Sloppity Bilepiper";
        grundkosten = getPts("Sloppity Bilepiper") + getPts("Marotter");
        power = 3;

        seperator();

        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        addWarlordTraits("", NURGLE);

        complete();
    }
}
