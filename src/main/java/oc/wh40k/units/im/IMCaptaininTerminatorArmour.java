package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CAPTAIN;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TERMINATOR;

import oc.Eintrag;

public class IMCaptaininTerminatorArmour extends Eintrag {

    public IMCaptaininTerminatorArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, TERMINATOR, CAPTAIN);

        name = "Captain in Terminator Armour";
        grundkosten = getPts("Captain in Terminator Armour");
        power = 8;

        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}

