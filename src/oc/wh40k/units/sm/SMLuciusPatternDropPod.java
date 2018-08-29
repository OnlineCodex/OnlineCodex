package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMLuciusPatternDropPod extends Eintrag {

    public SMLuciusPatternDropPod() {
        name = "Lucius Pattern Drop Pod";
        grundkosten = 65;

        add(ico = new oc.Picture("oc/wh40k/images/SMLuciusPatternDrop.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
    }
    
}
