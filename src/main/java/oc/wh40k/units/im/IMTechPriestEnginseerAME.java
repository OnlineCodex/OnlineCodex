package oc.wh40k.units.im;

import oc.Eintrag;

public class IMTechPriestEnginseerAME extends Eintrag {

    public IMTechPriestEnginseerAME() {
        name = "Tech-Priest Enginseer";
        grundkosten = getPts("Tech-Priest Enginseer (AME)") + getPts("Omnissian axe") + getPts("Laspistol (AME)") + getPts("Servo-arm (AME)");
        power = 3;
        complete();
    }

    @Override
    public void refreshen() {
    }
}
