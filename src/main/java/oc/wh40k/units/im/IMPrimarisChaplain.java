package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMPrimarisChaplain extends Eintrag {

    public IMPrimarisChaplain() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, PRIMARIS, CHAPLAIN);
        name = "Primaris Chaplain";
        grundkosten = getPts("Primaris Chaplain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Crozius arcanum") + getPts("Absolver bolt pistol");
        power = 6;
        
        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
