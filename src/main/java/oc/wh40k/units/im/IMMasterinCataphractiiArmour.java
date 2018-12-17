package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMMasterinCataphractiiArmour extends Eintrag {

    public IMMasterinCataphractiiArmour() {
    	super(TODO);
        name = "Master in Cataphractii Armour";
        grundkosten = getPts("Master in Cataphractii Armour");
        power = 8;

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
