package oc.wh40k.units.ty;



import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.LOCUS;
import static oc.KeyWord.CULT;
import static oc.KeyWord.GENESTEALER_CULTS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TYRANIDS;

import oc.Eintrag;



public class TYLocus extends Eintrag {



    public TYLocus() {
    	super(TYRANIDS, GENESTEALER_CULTS, CULT, CHARACTER, INFANTRY, LOCUS);
    	
        name = "Locus";

        grundkosten = getPts("Locus");
        
        seperator();
        
        addWeapons(TYGenestealerCultRuestkammer.class, true);
        
        power = 2;

        complete();

    }

}

