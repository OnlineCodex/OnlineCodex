package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SMLandRaiderTerminusUltra extends Eintrag {

    public SMLandRaiderTerminusUltra() {
        name = "Land Raider Terminus Ultra";
        grundkosten = 300;

        add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderTerminus Ultra.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));

        complete();
    }

    @Override
    public void refreshen() {
    }

}
