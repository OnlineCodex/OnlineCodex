package oc.wh40k.units.im;

import oc.Eintrag;

public class IMSammaelonCorvex extends Eintrag {

    public IMSammaelonCorvex() {
        name = "Sammael on Corvex";
        grundkosten = getPts("Sammael on Corvex");
        power = 10;
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
