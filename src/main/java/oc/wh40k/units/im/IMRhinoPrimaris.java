package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class IMRhinoPrimaris extends Eintrag {

    OptionsUpgradeGruppe o1;

    public IMRhinoPrimaris() {
        name = "Rhino Primaris";
        grundkosten = getPts("Rhino Primaris") + getPts("Twin plasma gun") + getPts("Orbital array");
        power = 9;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (SM)")));

        complete();
    }

    @Override
    public void refreshen() {
    }
}
