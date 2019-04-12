package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.APOTHECARY;
import static oc.KeyWord.BIKER;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;

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

        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }
}
