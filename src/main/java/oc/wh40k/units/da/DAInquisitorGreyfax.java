package oc.wh40k.units.da;

import oc.Eintrag;

public class DAInquisitorGreyfax extends Eintrag {

    public DAInquisitorGreyfax() {
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
