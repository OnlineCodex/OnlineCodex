package oc.wh40k.units.dh;

import oc.Eintrag;

public class DHGaussPylon extends Eintrag {

    public DHGaussPylon() {
        name = "Gauss Pylon";
        grundkosten = 420;

        add(ico = new oc.Picture("oc/wh40k/images/GaussPylon.gif"));

        complete();
    }

    @Override
    public void refreshen() {
    }
    
}
