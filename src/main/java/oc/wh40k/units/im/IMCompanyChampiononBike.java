package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BIKER;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.COMPANY_CHAMPION;
import static oc.KeyWord.IMPERIUM;

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

        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}