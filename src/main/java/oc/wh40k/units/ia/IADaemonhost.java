package oc.wh40k.units.ia;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class IADaemonhost extends Eintrag {

    OptionsUpgradeGruppe o1;

    public IADaemonhost() {
        name = "Daemonhost";
        grundkosten = 10;

        add(ico = new oc.Picture("oc/wh40k/images/IGTechpriestEnginseer.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
    }

    @Override
    public void deleteYourself() {
    }

}
