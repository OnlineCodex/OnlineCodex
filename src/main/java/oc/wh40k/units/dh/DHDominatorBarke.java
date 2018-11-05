package oc.wh40k.units.dh;

import oc.Eintrag;

public class DHDominatorBarke extends Eintrag {

    public DHDominatorBarke() {
        name = "Dominator-Barke";
        grundkosten = 175;

        add(ico = new oc.Picture("oc/wh40k/images/NEDominatorBarke.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
