package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYTectonicFragdrill extends Eintrag {

    public TYTectonicFragdrill() {
        grundkosten = getPts("Tectonic Fragdrill");
        name = "Tectonic Fragdrill";
        power = 4;

        add(ico = new oc.Picture("oc/wh40k/images/TYLandungsspore.jpg"));

        complete();
    }
}
