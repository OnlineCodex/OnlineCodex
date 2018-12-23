package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMTechmarinewithJumpPack extends Eintrag {

    public IMTechmarinewithJumpPack() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, JUMP_PACK, TECHMARINE);
        name = "Techmarine with Jump Pack";
        grundkosten = getPts("Techmarine with Jump Pack") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();
        
        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 5 + (((IMSpaceMarinesRuestkammer) weapons.getKammer()).oe1.isSelected() ? 1 : 0);
    }
}
