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
        
        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
