package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCaptainonBike extends Eintrag {
    RuestkammerStarter waffenUndReliquien;

    public IMCaptainonBike() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, BIKER, CHARACTER, CAPTAIN);
        name = "Captain on Bike";
        grundkosten = getPts("Captain on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Twin boltgun");
        power = 7;

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
