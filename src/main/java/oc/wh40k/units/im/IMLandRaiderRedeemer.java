package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMLandRaiderRedeemer extends Eintrag {


    public IMLandRaiderRedeemer() {
        name = "Land Raider Redeemer";
        grundkosten = getPts("Land Raider Redeemer") + getPts("Flamestorm cannon") * 2 + getPts("Twin Assault cannon");
        power = 18;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (SM)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (SM)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multi-melta", getPts("Multi-melta (SM other)")));

        complete();
    }

    @Override
    public void refreshen() {
    }
}
