package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class IMLandRaiderCrusader extends Eintrag {

    OptionsUpgradeGruppe o1;

    public IMLandRaiderCrusader() {
        name = "Land Raider Crusader";
        grundkosten = getPts("Land Raider Crusader") + getPts("Hurricane bolter") * 2 + getPts("Twin Assault cannon");
        power = 16;

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
