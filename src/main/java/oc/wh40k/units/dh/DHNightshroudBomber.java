package oc.wh40k.units.dh;

import oc.Eintrag;

public class DHNightshroudBomber extends Eintrag {

    public DHNightshroudBomber() {
        name = "Nightshroud Bomber";
        grundkosten = 225;

        add(ico = new oc.Picture("oc/wh40k/images/NETodessichel.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
