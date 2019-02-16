package oc.wh40k.units.ty;


import static oc.KeyWord.JACKAL_ALPHUS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CULT;
import static oc.KeyWord.GENESTEALER_CULTS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TYRANIDS;

import oc.Eintrag;



public class TYJackalAlphus extends Eintrag {



    public TYJackalAlphus() {
    	super(TYRANIDS, GENESTEALER_CULTS, CULT, CHARACTER, INFANTRY, JACKAL_ALPHUS);
    	
        name = "Jackal Alphus";

        grundkosten = getPts("Jackal Alphus") + getPts("Blasting charges");

        seperator();
        
        addWeapons(TYGenestealerCultRuestkammer.class, true);
        
        seperator();
        
        addWarlordTraits("", true);
        
        power = 4;

        complete();

    }
}

