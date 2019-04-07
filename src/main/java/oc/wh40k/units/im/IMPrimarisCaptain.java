package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CAPTAIN;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PRIMARIS;

import oc.Eintrag;

public class IMPrimarisCaptain extends Eintrag {

    public IMPrimarisCaptain() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, PRIMARIS, CAPTAIN);
        name = "Primaris Captain";
        grundkosten = getPts("Primaris Captain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Bolt pistol");
        power = 6;

        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
