package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYPrimus extends Eintrag {

    public TYPrimus() {
        name = "Primus";
        grundkosten = getPts("Primus") + getPts("Needle pistol") + getPts("Bonesword (GSC)") + getPts("Toxin injector claw") + getPts("Blasting charges");
        power = 4;

        complete();
    }

    @Override
    public void refreshen() {
    }

}
