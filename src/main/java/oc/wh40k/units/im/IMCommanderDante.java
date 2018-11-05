package oc.wh40k.units.im;

import oc.Eintrag;

public class IMCommanderDante extends Eintrag {

    public IMCommanderDante() {
        name = "Commander Dante";
        grundkosten = getPts("Commander Dante");
        power = 11;
        seperator();
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
