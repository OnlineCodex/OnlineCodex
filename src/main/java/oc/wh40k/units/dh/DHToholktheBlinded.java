package oc.wh40k.units.dh;

import oc.Eintrag;

public class DHToholktheBlinded extends Eintrag {


    public DHToholktheBlinded() {
        name = "Toholk the Blinded";
        grundkosten = 125;

        add(ico = new oc.Picture("oc/wh40k/images/NENemesorZanndrekh.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }


}
