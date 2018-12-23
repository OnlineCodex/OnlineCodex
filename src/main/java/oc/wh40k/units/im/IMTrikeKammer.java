package oc.wh40k.units.im;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMTrikeKammer extends RuestkammerVater {

    private final OptionsUpgradeGruppe o1;

    public IMTrikeKammer() {
        grundkosten = getPts("Attack Bike Squad") + getPts("Twin boltgun");

        ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", getPts("Heavy Bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (SM)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }
}