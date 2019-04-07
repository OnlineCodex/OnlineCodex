package oc.wh40k.units.im;

import oc.Eintrag;

public class IMHaraldDeathwolf extends Eintrag {


    public IMHaraldDeathwolf() {
        name = "Harald Deathwolf";
        grundkosten = getPts("Harald Deathwolf");
        power = 10;

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
