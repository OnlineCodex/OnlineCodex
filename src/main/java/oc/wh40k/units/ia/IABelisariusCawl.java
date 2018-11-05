package oc.wh40k.units.ia;

import oc.Eintrag;

public class IABelisariusCawl extends Eintrag {

    public IABelisariusCawl() {
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
