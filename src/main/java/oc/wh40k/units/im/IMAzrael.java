package oc.wh40k.units.im;

import oc.Eintrag;

public class IMAzrael extends Eintrag {

    public IMAzrael() {
        name = "Azrael";
        grundkosten = getPts("Azrael");
        power = 9;

        seperator();

        addWarlordTraits("Brilliant Strategist (DA)");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
