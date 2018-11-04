package oc.wh40k.units.da;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class DAWhirlwindKammer extends RuestkammerVater {

    public DAWhirlwindKammer() {
        name = "Whirlwind";
        grundkosten = 65;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/Whirlwind.gif"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

        sizeSetzen();
    }

    @Override
    public void refreshen() {

    }


}
