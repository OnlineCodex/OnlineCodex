package oc.wh40k.units.in;

import oc.Eintrag;

public class INBelisariusCawl extends Eintrag {

    public INBelisariusCawl() {
        name = "Belisarius Cawl";
        grundkosten = 200;

        add(ico = new oc.Picture("oc/wh40k/images/ASSanktCelestine.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
