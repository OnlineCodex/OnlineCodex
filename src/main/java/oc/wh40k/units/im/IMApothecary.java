package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.BuildaHQ;
import oc.Eintrag;

public class IMApothecary extends Eintrag {

    public IMApothecary() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, APOTHECARY);
        name = "Apothecary";
        grundkosten = getPts("Apothecary") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)");
        power = 3;
        
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
