package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCaptainonBike extends Eintrag {

    public IMCaptainonBike() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, BIKER, CHARACTER, CAPTAIN);
        name = "Captain on Bike";
        grundkosten = getPts("Captain on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Twin boltgun");
        power = 7;

        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
