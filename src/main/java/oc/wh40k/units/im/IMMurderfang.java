package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMMurderfang extends Eintrag {

    RuestkammerStarter rkPod;

    public IMMurderfang() {
        name = "Murderfang";
        grundkosten = getPts("Murderfang");
        power = 10;
        complete();
    }

    @Override
    public void refreshen() {
    }

}
