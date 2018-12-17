package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMSanguinaryNovitiate extends Eintrag {

    RuestkammerStarter waffenUndReliquien;

    public IMSanguinaryNovitiate() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, SANGUINARY_NOVITIATE);
        name = "Sanguinary Novitiate";
        grundkosten = getPts("Apothecary") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)");
        power = 3;

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}
