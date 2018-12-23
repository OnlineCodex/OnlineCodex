package oc.wh40k.units.ae;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AEKlaivex extends RuestkammerVater {

    public AEKlaivex() {
        ogE.addElement(new OptionsGruppeEintrag("Klaive", getPts("Klaive")));
        ogE.addElement(new OptionsGruppeEintrag("Demiklaives (Index)", getPts("Demiklaives")));
        OptionsUpgradeGruppe o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        o1.setSelected(0, true);
        add(o1);

        sizeSetzen();
    }
}