package oc.wh40k.units.ty;



import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CULT;
import static oc.KeyWord.GENESTEALER_CULTS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.ABOMINANT;
import static oc.KeyWord.TYRANIDS;
import static oc.KeyWord.ABERRANT;

import oc.Eintrag;

public class TYAbominant extends Eintrag {

    public TYAbominant() {
    	super(TYRANIDS, GENESTEALER_CULTS, CULT, CHARACTER, INFANTRY, ABERRANT, ABOMINANT);
    	
        name = "Abominant";

        grundkosten = getPts("Abominant");

        power = 6;

        seperator();
        
        addWeapons(TYGenestealerCultRuestkammer.class, true);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();

    }
}

