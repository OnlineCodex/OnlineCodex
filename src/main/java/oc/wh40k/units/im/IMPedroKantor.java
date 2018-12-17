package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMPedroKantor extends Eintrag {

    public IMPedroKantor() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CRIMSON_FISTS, CHARACTER, INFANTRY, CHAPTER_MASTER, PEDRO_KANTOR);
    	
        name = "Pedro Kantor";
        grundkosten = getPts("Pedro Kantor");
        power = 9;
        
        seperator();

        addWarlordTraits("Crimson Fists: Tenacious Opponent", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
