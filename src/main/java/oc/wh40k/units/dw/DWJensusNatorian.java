package oc.wh40k.units.dw;

import oc.Eintrag;

public class DWJensusNatorian extends Eintrag {

    public DWJensusNatorian() {
        name = "Jensus Natorian";
        grundkosten = 95;

        add(ico = new oc.Picture("oc/wh40k/images/DWJensusNatorian.jpg"));


        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
