package oc.wh40k.units.necrons;

import oc.Eintrag;

public class NEDoomScythe extends Eintrag {

    public NEDoomScythe() {
        name = "Doom Scythe";
        grundkosten = getPts("Doom Scythe") + getPts("Tesla destructor") * 2 + getPts("Death ray");

        add(ico = new oc.Picture("oc/wh40k/images/NEDoom Scythe.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
        power = 11;
    }

}
