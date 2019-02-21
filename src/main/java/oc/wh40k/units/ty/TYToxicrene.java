package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class TYToxicrene extends Eintrag {

    public TYToxicrene() {
        name = "Toxicrene";
        grundkosten = getPts("Toxicrene") + getPts("Choking spores") + getPts("Massive toxic lashes (NK)") + getPts("Massive toxic lashes (FK)");
        power = 7;
        add(ico = new oc.Picture("oc/wh40k/images/TYMorgon.jpg"));
        complete();
    }

    @Override
    public void refreshen() {
    }
}