package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMMasterinGravisArmour extends Eintrag {

    public IMMasterinGravisArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, MK_X_GRAVIS, PRIMARIS, CAPTAIN, MASTER);
        name = "Master in Gravis Armour";
        grundkosten = getPts("Master in Gravis Armour") + getPts("Master-crafted power sword") + getPts("Boltstorm gauntlet");
        power = 7;

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }
}
