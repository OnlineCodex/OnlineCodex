package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.*;

public class IMPrimarisCaptain extends Eintrag {

    public IMPrimarisCaptain() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, PRIMARIS, CAPTAIN);
        name = "Primaris Captain";
        grundkosten = getPts("Primaris Captain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Bolt pistol");
        power = 6;
        
        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
