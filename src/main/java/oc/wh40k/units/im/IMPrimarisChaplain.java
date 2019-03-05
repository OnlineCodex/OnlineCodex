package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.BuildaHQ;
import oc.Eintrag;

public class IMPrimarisChaplain extends Eintrag {

    public IMPrimarisChaplain() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, PRIMARIS, CHAPLAIN);
        name = "Primaris Chaplain";
        grundkosten = getPts("Primaris Chaplain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Crozius arcanum") + getPts("Absolver bolt pistol");
        power = 6;
        
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
