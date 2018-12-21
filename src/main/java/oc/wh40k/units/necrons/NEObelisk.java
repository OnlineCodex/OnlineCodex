package oc.wh40k.units.necrons;

import oc.Eintrag;

public class NEObelisk extends Eintrag {

    public NEObelisk() {
        name = "Obelisk";
        grundkosten = getPts("Obelisk") + getPts("Tesla sphere") * 4;
    }

    @Override
    public void refreshen() {
        power = 22;
    }
}
