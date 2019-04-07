package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_MECHANICUS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CULT_MECHANICUS;
import static oc.KeyWord.ENGINSEER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TECH_PRIEST;

import oc.Eintrag;

public class IMTechPriestEnginseer extends Eintrag {


    public IMTechPriestEnginseer() {
    	super(IMPERIUM, ADEPTUS_MECHANICUS, CULT_MECHANICUS, INFANTRY, CHARACTER, TECH_PRIEST, ENGINSEER);

    	name = "Tech-Priest Enginseer";
        grundkosten = getPts("Tech-Priest Enginseer");
        power = 3;

        seperator();

        addWeapons(IMTechPriestRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
