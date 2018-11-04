package oc.wh40k.units.ed;

import oc.Eintrag;

public class EDCaptainThanstadt extends Eintrag {

    public EDCaptainThanstadt() {
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
