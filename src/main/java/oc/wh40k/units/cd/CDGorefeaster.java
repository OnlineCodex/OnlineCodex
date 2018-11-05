package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDGorefeaster extends Eintrag {

    public CDGorefeaster() {

        name = "Gorefeaster";
        grundkosten = 160;

        add(ico = new oc.Picture("oc/wh40k/images/CDGorefeaster.gif"));

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
