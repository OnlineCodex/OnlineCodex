package oc.wh40k.units.am;

import oc.Eintrag;

public class AMCaptainThanstadt extends Eintrag {

    public AMCaptainThanstadt() {
        name = "Captain Thanstadt";
        grundkosten = 75;


        add(ico = new oc.Picture("oc/wh40k/images/IGCaptainThanstadt.jpg"));


        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
