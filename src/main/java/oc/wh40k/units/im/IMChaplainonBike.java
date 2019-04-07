package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BIKER;
import static oc.KeyWord.CHAPLAIN;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;

import oc.Eintrag;

public class IMChaplainonBike extends Eintrag {

    public IMChaplainonBike() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, BIKER, CHAPLAIN);
        name = "Chaplain on Bike";
        grundkosten = getPts("Chaplain on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Crozius arcanum") + getPts("Twin boltgun");
        power = 6;
        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
