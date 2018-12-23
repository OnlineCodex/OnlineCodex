package oc.wh40k.units.ae;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AEArenaChampion extends RuestkammerVater {

    public AEArenaChampion() {
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (Drukhari)")));
        ogE.addElement(new OptionsGruppeEintrag("Agoniser", getPts("Agoniser")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        sizeSetzen();
    }
}