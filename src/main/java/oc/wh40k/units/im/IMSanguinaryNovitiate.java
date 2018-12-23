package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMSanguinaryNovitiate extends Eintrag {

    public IMSanguinaryNovitiate() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, SANGUINARY_NOVITIATE);
        name = "Sanguinary Novitiate";
        grundkosten = getPts("Apothecary") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)");
        power = 3;

        seperator();
        
        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
