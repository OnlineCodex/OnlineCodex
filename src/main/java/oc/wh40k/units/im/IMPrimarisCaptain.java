package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.*;

public class IMPrimarisCaptain extends Eintrag {
    OptionsUpgradeGruppe o1;

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
