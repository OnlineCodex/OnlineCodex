package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CAPTAIN;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIAL_FISTS;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.LYSANDER;
import static oc.KeyWord.TERMINATOR;

import oc.Eintrag;

public class IMCaptainLysander extends Eintrag {

    public IMCaptainLysander() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, IMPERIAL_FISTS, CHARACTER, INFANTRY, CAPTAIN, TERMINATOR, LYSANDER);

        name = "Captain Lysander";
        grundkosten = getPts("Captain Lysander");
        power = 8;

        seperator();

        addWarlordTraits("Imperial Fists: Architect of War", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}