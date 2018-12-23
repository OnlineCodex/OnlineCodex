package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCaptaininCataphractiiArmour extends Eintrag {

    public IMCaptaininCataphractiiArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, TERMINATOR, CAPTAIN);
    	
        name = "Captain in Cataphractii Armour";
        grundkosten = getPts("Captain in Cataphractii Armour");
        power = 8;

        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
