package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCompanyChampion extends Eintrag {

    public IMCompanyChampion() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, COMPANY_CHAMPION);
        name = "Company Champion";
        power = 3;

        if (checkBuildaVater().getFormationType().equals("Dark Angels")) {
            grundkosten += getPts("Blade of Caliban") +
                    getPts("Bolt pistol (SM)") +
                    getPts("Combat shield");
        } else {
            grundkosten = getPts("Company Champion") +
                    getPts("Frag grenade (SM)") +
                    getPts("Krak grenade (SM)");

            addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);

            seperator();
        }

		addWarlordTraits("", true);

        complete();
    }
}