package oc.wh40k.units.in;

import oc.Eintrag;

public class INInquisitorGreyfax extends Eintrag {

    public INInquisitorGreyfax() {
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
