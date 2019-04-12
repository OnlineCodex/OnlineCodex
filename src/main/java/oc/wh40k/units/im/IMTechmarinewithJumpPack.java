package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.JUMP_PACK;
import static oc.KeyWord.TECHMARINE;

import oc.Eintrag;

public class IMTechmarinewithJumpPack extends Eintrag {

    public IMTechmarinewithJumpPack() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, JUMP_PACK, TECHMARINE);
        name = "Techmarine with Jump Pack";
        grundkosten = getPts("Techmarine with Jump Pack") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

		addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {
        power = 5 + (((IMSpaceMarinesRuestkammer) weapons.getKammer()).oe1.isSelected() ? 1 : 0);
    }
}
