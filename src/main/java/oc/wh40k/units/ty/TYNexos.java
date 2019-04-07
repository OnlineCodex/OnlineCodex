package oc.wh40k.units.ty;



import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CULT;
import static oc.KeyWord.GENESTEALER_CULTS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.NEXOS;
import static oc.KeyWord.TYRANIDS;

import oc.Eintrag;

public class TYNexos extends Eintrag {


    public TYNexos() {
    	super(TYRANIDS, GENESTEALER_CULTS, CULT, CHARACTER, INFANTRY, NEXOS);

        name = "Nexos";

        grundkosten = getPts("Nexos");

        power = 3;

        seperator();

        addWeapons(TYGenestealerCultRuestkammer.class, true);

        complete();

    }

}

