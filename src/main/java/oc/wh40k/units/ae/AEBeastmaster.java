package oc.wh40k.units.ae;

import static oc.KeyWord.*;
import oc.Eintrag;

public class AEBeastmaster extends Eintrag {

    public AEBeastmaster() {
    	super(AELDARI, DRUKHARI, INFANTRY, CHARACTER, BEASTMASTER);
    	
        name = "Beastmaster";
        grundkosten = getPts("Beastmaster") + getPts("Splinter pods");
        power = 3;

        seperator();

        addWeapons(AEDrukhariRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", WYCH_CULT);

        complete();
    }
}
