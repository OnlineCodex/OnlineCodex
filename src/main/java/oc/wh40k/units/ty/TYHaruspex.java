package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class TYHaruspex extends Eintrag {

    OptionsUpgradeGruppe o1;

    public TYHaruspex() {
        name = "Haruspex";
        grundkosten = getPts("Haruspex") + getPts("Grasping tongue") + getPts("Ravenous maw") + getPts("Shoveling claws");
        power = 12;
        add(ico = new oc.Picture("oc/wh40k/images/TYHarpyie.jpg"));

        complete();
    }
}
