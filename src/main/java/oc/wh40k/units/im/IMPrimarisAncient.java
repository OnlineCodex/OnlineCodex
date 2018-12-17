package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMPrimarisAncient extends Eintrag {
    RuestkammerStarter waffenUndReliquien;
    boolean spacewolves = false;
    
    public IMPrimarisAncient() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, PRIMARIS, ANCIENT);
    	spacewolves = BuildaHQ.aktBuildaVater.getFormationType().equals("Space Wolves");
        name = "Primaris Ancient";
        grundkosten = getPts("Primaris Ancient") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        
        if(spacewolves) {
        	power = 5;
        } else {
        	power = 4;
        }
        
        seperator();

        if(spacewolves) {
        	grundkosten += getPts("Bolt pistol (SM)") + getPts("Bolt rifle");
            addWeapons(IMSpaceWolvesRuestkammer.class, true);
        } else {
            addWeapons(IMSpaceMarinesRuestkammer.class, true);
        }
        
        seperator();
        
		addWarlordTraits("", true);
        
        complete();
    }
}
