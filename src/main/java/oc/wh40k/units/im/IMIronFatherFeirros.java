package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.IRON_HANDS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;

import oc.Eintrag;

public class IMIronFatherFeirros extends Eintrag {

    public IMIronFatherFeirros() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, IRON_HANDS, CHARACTER, INFANTRY);
        name = "Iron Father Feirros";
        grundkosten = getPts("IronFatherFeirros");
        power = 8;
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        this.setUnikat(true);
    }
}
