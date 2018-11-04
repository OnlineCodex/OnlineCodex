package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class NETrazyntheInfinite extends Eintrag {

    RuestkammerStarter rkTransport;

    public NETrazyntheInfinite() {
        name = "Trazyn the Infinite";
        grundkosten = getPts("Trazyn the Infinite");

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        power = 5;
    }

}
