package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCompanyAncientonBike extends Eintrag {

    public IMCompanyAncientonBike() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, BIKER, ANCIENT, COMPANY_ANCIENT);
        name = "Company Ancient on Bike";
        grundkosten = getPts("Company Ancient on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Twin boltgun");
        power = 5;

        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);

        seperator();
        
        addWarlordTraits("", true);
        
        complete();
    }
}
