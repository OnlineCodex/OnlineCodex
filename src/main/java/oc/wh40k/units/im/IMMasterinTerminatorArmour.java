package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMMasterinTerminatorArmour extends Eintrag {

    public IMMasterinTerminatorArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, TERMINATOR, CAPTAIN, MASTER);
        name = "Master in Terminator Armour";
        grundkosten = getPts("Master in Terminator Armour");
        power = 7;

        seperator();
        
        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
