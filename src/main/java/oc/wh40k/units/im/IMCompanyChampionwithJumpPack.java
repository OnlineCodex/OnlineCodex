package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.COMPANY_CHAMPION;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.JUMP_PACK;

import oc.Eintrag;

public class IMCompanyChampionwithJumpPack extends Eintrag {


    public IMCompanyChampionwithJumpPack() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, JUMP_PACK, COMPANY_CHAMPION);
        name = "Company Champion with Jump Pack";
        grundkosten = getPts("Company Champion with Jump Pack") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)");
        power = 5;

        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}