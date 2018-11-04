package oc.wh40k.units.im;

import oc.Eintrag;

public class IMLuciusPatternDreadnoughtDropPod extends Eintrag {

    public IMLuciusPatternDreadnoughtDropPod() {
        name = "Lucius Pattern Dreadnought Drop Pod";
        grundkosten = getPts("Lucius Pattern Dreadnought Drop Pod");
        power = 6;
        seperator();
        complete();
    }

    @Override
    public void refreshen() {
    }
}
