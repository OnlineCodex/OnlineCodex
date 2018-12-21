package oc.wh40k.units.necrons;

import oc.Eintrag;

public class NEMonolith extends Eintrag {

    public NEMonolith() {
        name = "Monolith";
        grundkosten = getPts("Monolith") + getPts("Gauss flux arc") * 4 + getPts("Particle whip");

        complete();
    }

    @Override
    public void refreshen() {
        power = 19;
    }
}
