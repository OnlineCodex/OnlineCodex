package oc.wh40k.units.as;

import oc.Eintrag;

public class ASSanktCelestine extends Eintrag {

    public ASSanktCelestine() {
        name = "Sankt Celestine";
        grundkosten = 135;

        add(ico = new oc.Picture("oc/wh40k/images/ASSanktCelestine.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
