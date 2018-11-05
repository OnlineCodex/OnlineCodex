package oc.wh40k.units;

import oc.Eintrag;

public class GrandMasterVoldus extends Eintrag {

    public GrandMasterVoldus() {
        name = "Grand Master Voldus";
        grundkosten = 240;

        add(ico = new oc.Picture("oc/wh40k/images/ASSanktCelestine.jpg"));

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
