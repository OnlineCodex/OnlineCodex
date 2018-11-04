package oc.wh40k.units.ae;

import oc.Eintrag;

public class AELhamaean extends Eintrag {

    public AELhamaean() {
        name = "Lhamaean";
        grundkosten = getPts("Lhamaean") + getPts("Splinter pistol") + getPts("Shaimeshi blade");
        power = 2;
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
    }
}