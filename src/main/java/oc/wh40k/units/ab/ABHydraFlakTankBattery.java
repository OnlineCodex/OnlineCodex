package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ABHydraFlakTankBattery extends Eintrag {

    OptionsEinzelUpgrade oe1;
    RuestkammerStarter v1;
    RuestkammerStarter v2;
    RuestkammerStarter v3;

    public ABHydraFlakTankBattery() {
        name = "Hydra Flak Tank Battery";
        grundkosten = 0;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/ABHydraFlakTankBattery.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo-netting", 20));

        seperator();

        v1 = new RuestkammerStarter(ID, randAbstand, cnt, "ABHydraFlakTank", "Hydra Flak Tank");
        v1.initKammer();
        v1.setGrundkosten(75);
        add(v1);

        seperator();

        v2 = new RuestkammerStarter(ID, randAbstand, cnt, "ABHydraFlakTank", "Hydra Flak Tank");
        v2.initKammer();
        v2.setGrundkosten(75);
        add(v2);

        seperator();

        v3 = new RuestkammerStarter(ID, randAbstand, cnt, "ABHydraFlakTank", "Hydra Flak Tank");
        v3.initKammer();
        v3.setGrundkosten(75);
        add(v3);

        complete();
    }

    @Override
    public void refreshen() {
        int vehicles = (v1.isSelected() ? 1 : 0) + (v2.isSelected() ? 1 : 0) + (v3.isSelected() ? 1 : 0);

        oe1.setPreis(vehicles * 20);
        oe1.setAktiv(vehicles > 0);
    }

}
