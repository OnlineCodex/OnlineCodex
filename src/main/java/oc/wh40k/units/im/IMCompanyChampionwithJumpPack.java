package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCompanyChampionwithJumpPack extends Eintrag {

    public IMCompanyChampionwithJumpPack() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, JUMP_PACK, COMPANY_CHAMPION);
        name = "Company Champion with Jump Pack";
        grundkosten = getPts("Company Champion with Jump Pack") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)");
        power = 5;

        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}