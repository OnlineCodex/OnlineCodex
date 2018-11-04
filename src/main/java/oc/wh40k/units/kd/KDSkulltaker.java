package oc.wh40k.units.kd;

import oc.Eintrag;

public class KDSkulltaker extends Eintrag {

    public KDSkulltaker() {

        name = "Skulltaker";

        grundkosten = 100;

        add(ico = new oc.Picture("oc/wh40k/images/CDSchaedelsammler.gif"));

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
