package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCaptaininPhobosArmour extends Eintrag {

    public IMCaptaininPhobosArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, MK_X_GRAVIS, PRIMARIS, CAPTAIN);
        name = "Captain in Phobos Armour";
        grundkosten = getPts("Captain in Phobos Armour") + getPts("Camo cloak");
        power = 7;
        
        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
