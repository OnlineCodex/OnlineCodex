package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYDeathleaper extends Eintrag {


    public TYDeathleaper() {
        name = "Deathleaper(";
        grundkosten = getPts("Deathleaper");
        power = 4;

		addWarlordTraits("Mind Eater");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}