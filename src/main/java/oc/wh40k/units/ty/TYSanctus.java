package oc.wh40k.units.ty;



import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CULT;
import static oc.KeyWord.GENESTEALER_CULTS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.SANCTUS;
import static oc.KeyWord.TYRANIDS;

import oc.Eintrag;


public class TYSanctus extends Eintrag {

    public TYSanctus() {
    	super(TYRANIDS, GENESTEALER_CULTS, CULT, CHARACTER, INFANTRY, SANCTUS);
    	
        name = "Sanctus";

        grundkosten = getPts("Sanctus");

        seperator();
        
        addWeapons(TYGenestealerCultRuestkammer.class, true);
        
        power = 3;

        complete();

    }
}

