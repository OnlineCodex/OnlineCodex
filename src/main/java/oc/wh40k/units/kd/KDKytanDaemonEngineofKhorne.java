//IA1 2nd Ed

package oc.wh40k.units.kd;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class KDKytanDaemonEngineofKhorne extends Eintrag {

    OptionsUpgradeGruppe o1;

    public KDKytanDaemonEngineofKhorne() {
        name = "Kytan Daemon Engine of Khorne";
        grundkosten = 525;

        complete();
    }

    public void refreshen() {
        getCountFromInformationVector("");
    }
}

