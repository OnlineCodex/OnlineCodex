package oc.wh40k.units.ta;

import oc.Eintrag;

public class TADahyakGrekh extends Eintrag {


    public TADahyakGrekh() {
        name = "Dahyak Grekh";
        grundkosten = getPts("Dahyak Grekh");
        power = 2;

        seperator();

        addWarlordTraits("", true);

        complete();

    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        setUnikat(true);
    }
}
