package oc.wh40k.units.ae;

import static oc.KeyWord.*;
import oc.Eintrag;

public class AESuccubus extends Eintrag {

    public AESuccubus() {
    	super(AELDARI, DRUKHARI, INFANTRY, CHARACTER, SUCCUBUS);
    	
        name = "Succubus";
        grundkosten = getPts("Succubus");
        power = 4;

        seperator();
        
        addWeapons(AEDrukhariRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", WYCH_CULT);

        complete();
    }
}
