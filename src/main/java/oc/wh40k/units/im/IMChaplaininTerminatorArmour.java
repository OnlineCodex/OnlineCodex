package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMChaplaininTerminatorArmour extends Eintrag {

    public IMChaplaininTerminatorArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, TERMINATOR, CHAPLAIN);
        name = "Chaplain in Terminator Armour";
        grundkosten = getPts("Chaplain in Terminator Armour") + getPts("Crozius arcanum");
        power = 6;
        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}