package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMNullMaidenRhino extends Eintrag {

    OptionsUpgradeGruppe o1;


    public IMNullMaidenRhino() {
        name = "Null-Maiden Rhino";
        grundkosten = getPts("Null-Maiden Rhino");
        power = 4;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (AMI)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (SM)")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }
}
