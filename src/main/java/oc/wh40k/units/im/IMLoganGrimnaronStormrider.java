package oc.wh40k.units.im;

import oc.Eintrag;

public class IMLoganGrimnaronStormrider extends Eintrag {


    public IMLoganGrimnaronStormrider() {
        name = "Logan Grimnar on Stormrider";
        grundkosten = getPts("Logan Grimnar on Stormrider");
        power = 12;

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
