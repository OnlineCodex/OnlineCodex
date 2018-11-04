package oc.wh40k.units.im;

import oc.Eintrag;

public class IMTechPriestEnginseer extends Eintrag {

    public IMTechPriestEnginseer() {
        name = "Tech-Priest Enginseer";
        grundkosten = getPts("Tech-Priest Enginseer (AM)") + getPts("Omnissian axe") + getPts("Laspistol (AME)") + getPts("Servo-arm (AME)");
        power = 3;
        complete();
    }

    @Override
    public void refreshen() {
    }
}
