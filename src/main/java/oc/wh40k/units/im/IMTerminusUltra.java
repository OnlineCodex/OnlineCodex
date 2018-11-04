package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class IMTerminusUltra extends Eintrag {

    OptionsUpgradeGruppe o1;

    public IMTerminusUltra() {
        name = "Terminus Ultra";
        grundkosten = getPts("Terminus Ultra") + getPts("Twin lascannon") * 3 + getPts("Lascannon (SM)") * 2;
        power = 30;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (SM)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (SM)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multi-melta", getPts("Multi-melta (SM)")));

        complete();
    }

    @Override
    public void refreshen() {
    }
}
