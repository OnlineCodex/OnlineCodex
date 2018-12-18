package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMApothecary extends Eintrag {

    public IMApothecary() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, APOTHECARY);
        name = "Apothecary";
        grundkosten = getPts("Apothecary") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)");
        power = 3;
        
        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }
}
