package oc.wh40k.units.im;

import oc.Eintrag;

public class IMChaplainGrimaldus extends Eintrag {

    public IMChaplainGrimaldus() {
        name = "Chaplain Grimaldus";
        grundkosten = getPts("Chaplain Grimaldus");
        power = 6;
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
