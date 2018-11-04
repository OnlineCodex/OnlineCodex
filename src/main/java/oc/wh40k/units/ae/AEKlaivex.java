package oc.wh40k.units.ae;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AEKlaivex extends RuestkammerVater {

    OptionsUpgradeGruppe o1;

    public AEKlaivex() {
    }

    @Override
    public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Klaive", getPts("Klaive")));
        ogE.addElement(new OptionsGruppeEintrag("Demiklaives (Index)", getPts("Demiklaives")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        sizeSetzen();
    }

    @Override
    public void refreshen() {
    }

}
