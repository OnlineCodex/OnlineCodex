package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMTechmarine extends Eintrag {

    public IMTechmarine() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, TECHMARINE);
        name = "Techmarine";
        grundkosten = getPts("Techmarine") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 4 + (((IMSpaceMarinesRuestkammer) weapons.getKammer()).oe1.isSelected() ? 1 : 0);
    }
}
