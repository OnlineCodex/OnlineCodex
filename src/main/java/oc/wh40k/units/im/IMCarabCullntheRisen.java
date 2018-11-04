package oc.wh40k.units.im;

import oc.Eintrag;

public class IMCarabCullntheRisen extends Eintrag {

    public IMCarabCullntheRisen() {
        name = "Carab Culln the Risen";
        grundkosten = getPts("Carab Culln the Risen");
        power = 18;
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
