package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.BuildaHQ;
import oc.Eintrag;

public class IMMasterinCataphractiiArmour extends Eintrag {

    public IMMasterinCataphractiiArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, TERMINATOR, CAPTAIN, MASTER);
        name = "Master in Cataphractii Armour";
        grundkosten = getPts("Master in Cataphractii Armour");
        power = 8;

        seperator();
        
        if(BuildaHQ.aktBuildaVater.getFormationType().equals("Dark Angels"))
        	addWeapons(IMDarkAngelsRuestkammer.class, true);
        else
        	addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
