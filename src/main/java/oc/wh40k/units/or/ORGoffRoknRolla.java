package oc.wh40k.units.or;

import oc.Eintrag;

public class ORGoffRoknRolla extends Eintrag {

    public ORGoffRoknRolla() {
        name = "Goff Rok'n'Rolla";
        grundkosten = 520;


        add(ico = new oc.Picture("oc/wh40k/images/GoffRoknRolla.gif"));


        complete();

    }

    public void refreshen() {
    }
}
