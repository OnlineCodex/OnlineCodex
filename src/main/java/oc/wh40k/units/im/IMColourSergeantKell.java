package oc.wh40k.units.im;

import oc.Eintrag;

public class IMColourSergeantKell extends Eintrag {

    public IMColourSergeantKell() {
        name = "Colour Sergeant Kell";
        grundkosten = getPts("Colour Sergeant Kell");
        power = 3;

        seperator();

        addWarlordTraits("Cadian: Superior Tactical Training");

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        setUnique(true);
    }
}