package oc.wh40k.units.or;

import oc.Eintrag;

public class ORMekboyWorkshop extends Eintrag {


    public ORMekboyWorkshop() {

        kategorie = 1;
        name = "Mekboy Workshop";
        grundkosten = getPts("Mekboy Workshop");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/GhazghkullThraka.gif"));

        complete();
    }
}
