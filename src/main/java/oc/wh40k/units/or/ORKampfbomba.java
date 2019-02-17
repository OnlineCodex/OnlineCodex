package oc.wh40k.units.or;

import oc.Eintrag;

public class ORKampfbomba extends Eintrag {

    public ORKampfbomba() {
        name = "Kampfbomba";
        grundkosten = 210;


        add(ico = new oc.Picture("oc/wh40k/images/Kampfbomba.gif"));


        complete();

    }

}
