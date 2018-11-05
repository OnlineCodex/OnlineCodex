package oc.wh40k.units.cd;

import oc.Eintrag;


public class CDAnggraththeUnbound extends Eintrag {

    public CDAnggraththeUnbound() {
        name = "An'ggrath the Unbound";
        grundkosten = 888;

        add(ico = new oc.Picture("oc/wh40k/images/AnggraththeUnbound.gif"));

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}