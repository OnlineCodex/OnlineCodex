package oc.wh40k.units.dkab;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DKABGriffonStrikeBattery extends Eintrag {

    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    RuestkammerStarter t1;
    RuestkammerStarter t2;
    RuestkammerStarter t3;

    public DKABGriffonStrikeBattery() {
        name = "Griffon Strike Battery";
        grundkosten = 0;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/ABOrdnanceBattery.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo-netting", 20));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carcass shells", 5));

        seperator();

        t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKABGriffon", "", 1);
        t1.initKammer();
        t1.setButtonText("Griffon 1");
        add(t1);

        seperator();

        t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKABGriffon", "", 1);
        t2.initKammer();
        t2.setButtonText("Griffon 2");
        add(t2);

        seperator();

        t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKABGriffon", "", 1);
        t3.initKammer();
        t3.setButtonText("Griffon 3");
        add(t3);

        complete();
    }

    @Override
    public void refreshen() {
        int tanks = (t1.isSelected() ? 1 : 0) + (t2.isSelected() ? 1 : 0) + (t3.isSelected() ? 1 : 0);

        oe1.setPreis(tanks * 20);
        oe1.setAktiv(tanks > 0);

        oe2.setPreis(tanks * 5);
        oe2.setAktiv(tanks > 0);
    }

}
