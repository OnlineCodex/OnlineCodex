package oc.wh40k.units.am;

import oc.Eintrag;

public class AMInquisitorGreyfax extends Eintrag {

    public AMInquisitorGreyfax() {
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
