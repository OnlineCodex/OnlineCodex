package oc.wh40k.units.im;

import oc.Eintrag;

public class IMCaptainLysander extends Eintrag {

    public IMCaptainLysander() {
        name = "Captain Lysander";
        grundkosten = getPts("Captain Lysander");
        power = 8;
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}