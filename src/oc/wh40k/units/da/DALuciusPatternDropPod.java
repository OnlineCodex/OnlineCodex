package oc.wh40k.units.da;

import oc.Eintrag;

public class DALuciusPatternDropPod extends Eintrag {

    public DALuciusPatternDropPod() {
        name = "Lucius Pattern Drop Pod";
        grundkosten = 65;

        add(ico = new oc.Picture("oc/wh40k/images/DALuciusPatternDrop.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
    }
    
}
