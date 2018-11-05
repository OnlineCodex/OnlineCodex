package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ABGeneralGrizmund extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    RuestkammerStarter rkAceCrew;

    public ABGeneralGrizmund() {
        name = "General Grizmund (Grace of the Throne)";
        grundkosten = 280;

        add(ico = new oc.Picture("oc/wh40k/images/ABGraceoftheThrone.jpg"));
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
