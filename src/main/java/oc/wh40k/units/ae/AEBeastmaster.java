package oc.wh40k.units.ae;

import static oc.KeyWord.AELDARI;
import static oc.KeyWord.BEASTMASTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DRUKHARI;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.WYCH_CULT;

import oc.BuildaHQ;
import oc.Eintrag;

public class AEBeastmaster extends Eintrag {

    public AEBeastmaster() {
    	super(AELDARI, DRUKHARI, INFANTRY, CHARACTER, BEASTMASTER);

        name = "Beastmaster";
        grundkosten = getPts("Beastmaster") + getPts("Splinter pods");
        power = 3;

        seperator();

        if(BuildaHQ.aktBuildaVater.getFormationType().equals("Ynnari"))
        	addWeapons(AEYnnariRuestkammer.class, true);
        else
        	addWeapons(AEDrukhariRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", WYCH_CULT);

        complete();
    }
}
