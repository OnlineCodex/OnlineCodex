package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BLOOD_ANGELS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.FLY;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.JUMP_PACK;
import static oc.KeyWord.THE_SANGUINOR;

import oc.Eintrag;

public class IMTheSanguinor extends Eintrag {

    public IMTheSanguinor() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, JUMP_PACK, FLY, THE_SANGUINOR);
        name = "The Sanguinor";
        grundkosten = getPts("The Sanguinor");
        power = 9;

        seperator();

        addWarlordTraits("Heroic Bearing (BA)", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
