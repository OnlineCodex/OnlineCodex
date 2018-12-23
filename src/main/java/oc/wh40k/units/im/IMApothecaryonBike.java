package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMApothecaryonBike extends Eintrag {

    public IMApothecaryonBike() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, BIKER, APOTHECARY);
        name = "Apothecary on Bike";
        grundkosten = getPts("Apothecary on Bike") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Twin boltgun");
        power = 4;

        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }
}
