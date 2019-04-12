package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.ANCIENT;
import static oc.KeyWord.BIKER;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.COMPANY_ANCIENT;
import static oc.KeyWord.IMPERIUM;

import oc.Eintrag;

public class IMCompanyAncientonBike extends Eintrag {

    public IMCompanyAncientonBike() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, BIKER, ANCIENT, COMPANY_ANCIENT);
        name = "Company Ancient on Bike";
        grundkosten = getPts("Company Ancient on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Twin boltgun");
        power = 5;
        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }
}
