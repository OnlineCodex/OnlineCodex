package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class IMBjorntheFellHanded extends Eintrag {

    OptionsUpgradeGruppe o1;
    RuestkammerStarter rkPod;

    public IMBjorntheFellHanded() {
        name = "Bjorn the Fellhanded";
        grundkosten = getPts("Bjorn the Fellhanded");
        power = 14;
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
