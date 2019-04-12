package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BIKER;
import static oc.KeyWord.CAPTAIN;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;

import oc.Eintrag;

public class IMCaptainonBike extends Eintrag {

    public IMCaptainonBike() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, BIKER, CHARACTER, CAPTAIN);
        name = "Captain on Bike";
        grundkosten = getPts("Captain on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Twin boltgun");
        power = 7;

        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

		addWarlordTraits("");

        complete();
    }
}
