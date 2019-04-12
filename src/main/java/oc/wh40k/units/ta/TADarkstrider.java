package oc.wh40k.units.ta;

import oc.Eintrag;

public class TADarkstrider extends Eintrag {


    public TADarkstrider() {
        name = "Darkstrider";
        grundkosten = getPts("Darkstrider");
        power = 3;

        seperator();

        addWeapons(TAKampfanzugKammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();

    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        setUnique(true);
    }
}
