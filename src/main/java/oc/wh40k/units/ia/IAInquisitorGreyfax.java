package oc.wh40k.units.ia;

import oc.Eintrag;

public class IAInquisitorGreyfax extends Eintrag {

    public IAInquisitorGreyfax() {
        name = "Inquisitor Greyfax";
        grundkosten = 150;

        add(ico = new oc.Picture("oc/wh40k/images/ASSanktCelestine.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
