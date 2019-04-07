package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TECHMARINE;

import oc.BuildaHQ;
import oc.Eintrag;

public class IMTechmarine extends Eintrag {

    public IMTechmarine() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, TECHMARINE);
        name = "Techmarine";
        grundkosten = getPts("Techmarine") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        if(BuildaHQ.aktBuildaVater.getFormationType().equals("Dark Angels"))
        	addWeapons(IMDarkAngelsRuestkammer.class, true);
        else
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
