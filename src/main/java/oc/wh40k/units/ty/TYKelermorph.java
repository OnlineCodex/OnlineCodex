package oc.wh40k.units.ty;



import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CULT;
import static oc.KeyWord.GENESTEALER_CULTS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.KELERMORPH;
import static oc.KeyWord.TYRANIDS;

import oc.Eintrag;

public class TYKelermorph extends Eintrag {


    public TYKelermorph() {
    	super(TYRANIDS, GENESTEALER_CULTS, CULT, CHARACTER, INFANTRY, KELERMORPH);

        name = "Kelermorph";

        grundkosten = getPts("Kelermorph") + 2 * getPts("Liberator autostub");

        power = 3;

        seperator();

        addWeapons(TYGenestealerCultRuestkammer.class, true);

        complete();

    }

}

