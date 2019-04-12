package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHAPTER_MASTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CRIMSON_FISTS;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PEDRO_KANTOR;

import oc.Eintrag;

public class IMPedroKantor extends Eintrag {

    public IMPedroKantor() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CRIMSON_FISTS, CHARACTER, INFANTRY, CHAPTER_MASTER, PEDRO_KANTOR);

        name = "Pedro Kantor";
        grundkosten = getPts("Pedro Kantor");
        power = 9;

        seperator();

        addWarlordTraits("Crimson Fists: Tenacious Opponent");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
