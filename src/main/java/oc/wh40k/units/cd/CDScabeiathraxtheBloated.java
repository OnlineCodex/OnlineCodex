package oc.wh40k.units.cd;

import oc.Eintrag;


public class CDScabeiathraxtheBloated extends Eintrag {

    public CDScabeiathraxtheBloated() {
        name = "Scabeiathrax the Bloated";
        grundkosten = 777;

        add(ico = new oc.Picture("oc/wh40k/images/ScabeiathraxtheBloated.gif"));

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}