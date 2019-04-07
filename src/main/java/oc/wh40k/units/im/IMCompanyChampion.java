package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.COMPANY_CHAMPION;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;

import oc.Eintrag;

public class IMCompanyChampion extends Eintrag {

    public IMCompanyChampion() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, COMPANY_CHAMPION);
        name = "Company Champion";
        grundkosten = getPts("Company Champion") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)");

        if (buildaVater.getFormationType().equals("Dark Angels")) {
            grundkosten += getPts("Blade of Caliban") +
                    getPts("Bolt pistol (SM)") +
                    getPts("Combat shield");
        } else {
            seperator();

            addWeapons(IMSpaceMarinesRuestkammer.class, true);
        }

        power = 3;

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}