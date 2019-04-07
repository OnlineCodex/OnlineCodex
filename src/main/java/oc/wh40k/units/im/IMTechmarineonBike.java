package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BIKER;
import static oc.KeyWord.CHAPTER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.TECHMARINE;

import oc.Eintrag;

public class IMTechmarineonBike extends Eintrag {

    public IMTechmarineonBike() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, BIKER, TECHMARINE);
        name = "Techmarine on Bike";
        grundkosten = getPts("Techmarine on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Twin boltgun (SM)");

        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 6 + (((IMSpaceMarinesRuestkammer) weapons.getKammer()).oe1.isSelected() ? 1 : 0);
    }
}
