package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCompanyChampiononBike extends Eintrag {

    public IMCompanyChampiononBike() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, BIKER, COMPANY_CHAMPION);
        name = "Company Champion on Bike";
        grundkosten = getPts("Company Champion on Bike") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Twin boltgun");
        power = 5;

        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}