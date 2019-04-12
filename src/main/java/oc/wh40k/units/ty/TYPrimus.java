package oc.wh40k.units.ty;

import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CULT;
import static oc.KeyWord.GENESTEALER_CULTS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PRIMUS;
import static oc.KeyWord.TYRANIDS;

import oc.Eintrag;

public class TYPrimus extends Eintrag {

    public TYPrimus() {
    	super(TYRANIDS, GENESTEALER_CULTS, CULT, CHARACTER, INFANTRY, PRIMUS);

        name = "Primus";

        grundkosten = getPts("Primus") + getPts("Blasting charges");

        power = 4;

        seperator();

        addWeapons(TYGenestealerCultRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();

    }
}

