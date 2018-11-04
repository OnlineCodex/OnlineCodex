package oc.wh40k.units.apo;

import oc.Eintrag;

public class APOKaldorDraigo extends Eintrag {

    public APOKaldorDraigo() {
        name = "Hochmeister Kaldor Draigo";
        grundkosten = 245;

        add(ico = new oc.Picture("oc/wh40k/images/GKHochmeisterKaldorDraigo.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}
