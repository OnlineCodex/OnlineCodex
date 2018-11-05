package oc.wh40k.units.im;

import oc.Eintrag;

public class IMCaptainSicarius extends Eintrag {

    public IMCaptainSicarius() {
        name = "Captain Sicarius";
        grundkosten = getPts("Captain Sicarius");
        power = 7;
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
