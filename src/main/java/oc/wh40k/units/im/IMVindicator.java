package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class IMVindicator extends Eintrag {

    OptionsUpgradeGruppe o1;

    public IMVindicator() {
        name = "Vindicator";
        grundkosten = getPts("Vindicator") + getPts("Demolisher cannon (SM)");
        power = 7;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (SM)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (SM)")));

        complete();
    }

    @Override
    public void refreshen() {
    }
}
