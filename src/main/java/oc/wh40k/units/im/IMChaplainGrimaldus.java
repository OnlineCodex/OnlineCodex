package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BLACK_TEMPLARS;
import static oc.KeyWord.CHAPLAIN;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.GRIMALDUS;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;

import oc.Eintrag;

public class IMChaplainGrimaldus extends Eintrag {

    public IMChaplainGrimaldus() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLACK_TEMPLARS, CHARACTER, INFANTRY, CHAPLAIN, GRIMALDUS);

        name = "Chaplain Grimaldus";
        grundkosten = getPts("Chaplain Grimaldus");
        power = 6;

        seperator();

        addWarlordTraits("Black Templars: Oathkeeper");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}

