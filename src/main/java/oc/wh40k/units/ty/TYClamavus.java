package oc.wh40k.units.ty;



import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CULT;
import static oc.KeyWord.GENESTEALER_CULTS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.CLAMAVUS;
import static oc.KeyWord.TYRANIDS;

import oc.Eintrag;



public class TYClamavus extends Eintrag {


    public TYClamavus() {
    	super(TYRANIDS, GENESTEALER_CULTS, CULT, CHARACTER, INFANTRY, CLAMAVUS);
    	
        name = "Clamavus";

        grundkosten = getPts("Clamavus");

        seperator();
        
        addWeapons(TYGenestealerCultRuestkammer.class, true);
        
        power = 3;

        complete();

    }

}

