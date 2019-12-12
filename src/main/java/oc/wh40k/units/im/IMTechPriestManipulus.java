package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_MECHANICUS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CULT_MECHANICUS;
import static oc.KeyWord.DOMINUS;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TECH_PRIEST;

import oc.Eintrag;

public class IMTechPriestManipulus extends Eintrag {

    public IMTechPriestManipulus() {
    	super(IMPERIUM, ADEPTUS_MECHANICUS, CULT_MECHANICUS, INFANTRY, CHARACTER, TECH_PRIEST, DOMINUS);

        name = "Tech-Priest Manipulus";
        grundkosten = getPts("Tech-Priest Manipulus");
        power = 7;

        seperator();

        addWeapons(IMTechPriestRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
