package oc.wh40k.units.im;

import oc.Eintrag;

public class IMCanisWolfborn extends Eintrag {


    public IMCanisWolfborn() {
        name = "Canis Wolfborn";
        grundkosten = getPts("Canis Wolfborn");
        power = 8;

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
