package oc.wh40k.units.dw;

import oc.Eintrag;

public class DWJetekSuberei extends Eintrag {

    public DWJetekSuberei() {
        name = "Jetek Suberei";
        grundkosten = 40;

        add(ico = new oc.Picture("oc/wh40k/images/DWJetekSuberei.jpg"));


        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
