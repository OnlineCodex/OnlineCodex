package oc.wh40k.units.cs;

import oc.Eintrag;

public class CSDreadclaw extends Eintrag {


    public CSDreadclaw() {
        name = "Dreadclaw";
        grundkosten = 85;

        add(ico = new oc.Picture("oc/wh40k/images/Ahriman.gif"));


        complete();
    }

    @Override
    public void refreshen() {
    }

}
