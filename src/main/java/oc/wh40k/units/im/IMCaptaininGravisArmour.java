package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCaptaininGravisArmour extends Eintrag {

    RuestkammerStarter waffenUndReliquien;

    public IMCaptaininGravisArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, MK_X_GRAVIS, PRIMARIS, CAPTAIN);
        name = "Captain in Gravis Armour";
        grundkosten = getPts("Captain in Gravis Armour");
        power = 7;
        
        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
