package oc.wh40k.units.da;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;


public class DASammael extends Eintrag {

    OptionsEinzelUpgrade speeder;
    boolean troopAdd = false;

    public DASammael() {
        name = "Sammael, Meister des Ravenwing";
        grundkosten = 200;

        add(ico = new oc.Picture("oc/wh40k/images/DASammael.gif"));

        seperator();

        complete();
    }

    @Override
    public void deleteYourself() {

        super.deleteYourself();
    }


    @Override
    public void refreshen() {

        setUnikat(true);
    }
}
