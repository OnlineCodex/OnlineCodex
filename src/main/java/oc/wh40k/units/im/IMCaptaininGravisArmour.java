package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CAPTAIN;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.MK_X_GRAVIS;
import static oc.KeyWord.PRIMARIS;

import oc.Eintrag;

public class IMCaptaininGravisArmour extends Eintrag {

    public IMCaptaininGravisArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, MK_X_GRAVIS, PRIMARIS, CAPTAIN);
        name = "Captain in Gravis Armour";
        grundkosten = getPts("Captain in Gravis Armour");
        power = 7;

        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
