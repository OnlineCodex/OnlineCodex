package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMSanguinaryPriestonBike extends Eintrag {

    public IMSanguinaryPriestonBike() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, BIKER, SANGUINARY_PRIEST);
        name = "Sanguinary Priest on Bike";
        grundkosten = getPts("Sanguinary Priest on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 6;

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
