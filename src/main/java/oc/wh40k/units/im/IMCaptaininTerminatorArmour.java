package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCaptaininTerminatorArmour extends Eintrag {

    RuestkammerStarter waffenUndReliquien;

    public IMCaptaininTerminatorArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, TERMINATOR, CAPTAIN);
    	
        name = "Captain in Terminator Armour";
        grundkosten = getPts("Captain in Terminator Armour");
        power = 8;

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}

