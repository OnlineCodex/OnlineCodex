package oc.wh40k.units.kd;

import oc.Eintrag;

public class KDWrathOfKhorneBloodthirster extends Eintrag {


    public KDWrathOfKhorneBloodthirster() {

        name = "Wrath Of Khorne Bloodthirster";

        grundkosten = 300;

        add(ico = new oc.Picture("oc/wh40k/images/CDBlutdaemon.gif"));

        complete();
    }

    @Override
    public void refreshen() {
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
}
