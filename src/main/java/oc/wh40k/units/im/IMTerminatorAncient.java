package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.ANCIENT;
import static oc.KeyWord.BLOOD_ANGELS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TERMINATOR;

import oc.Eintrag;

public class IMTerminatorAncient extends Eintrag {

    public IMTerminatorAncient() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, ANCIENT, TERMINATOR);
        name = "Terminator Ancient";
        grundkosten = getPts("Terminator Ancient");
        power = 6;

        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
