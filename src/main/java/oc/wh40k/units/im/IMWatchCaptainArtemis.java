package oc.wh40k.units.im;

import oc.Eintrag;

public class IMWatchCaptainArtemis extends Eintrag {

    public IMWatchCaptainArtemis() {
        name = "Watch Captain Artemis";
        grundkosten = getPts("Watch Captain Artemis");
        power = 7;
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
