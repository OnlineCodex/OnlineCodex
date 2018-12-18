package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCompanyAncient extends Eintrag {

    public IMCompanyAncient() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, ANCIENT, COMPANY_ANCIENT);
        name = "Company Ancient";
        grundkosten = getPts("Company Ancient") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 4;
        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }
}

