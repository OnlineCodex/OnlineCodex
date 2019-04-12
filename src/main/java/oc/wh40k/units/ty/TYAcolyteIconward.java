package oc.wh40k.units.ty;



import static oc.KeyWord.ACOLYTE_ICONWARD;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CULT;
import static oc.KeyWord.GENESTEALER_CULTS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TYRANIDS;

import oc.Eintrag;



public class TYAcolyteIconward extends Eintrag {



    public TYAcolyteIconward() {
    	super(TYRANIDS, GENESTEALER_CULTS, CULT, CHARACTER, INFANTRY, ACOLYTE_ICONWARD);

        name = "Acolyte Iconward";

        grundkosten = getPts("Acolyte Iconward") + getPts("Rending claws (GSC)") + getPts("Blasting charges");

        power = 3;

        seperator();

        addWeapons(TYGenestealerCultRuestkammer.class, true);

        addWarlordTraits("");

        complete();

    }



    @Override

    public void refreshen() {

    }



}

