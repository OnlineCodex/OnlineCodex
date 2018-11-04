package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYAcolyteIconward extends Eintrag {

    public TYAcolyteIconward() {
        name = "AcolyteIconward";
        grundkosten = getPts("Acolyte Iconward") + getPts("Autopistol") + getPts("Rending claws (GSC)") + getPts("Blasting charges");
        power = 3;

        complete();
    }

    @Override
    public void refreshen() {
    }

}
