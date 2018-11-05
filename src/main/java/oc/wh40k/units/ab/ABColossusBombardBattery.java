package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ABColossusBombardBattery extends Eintrag {

    RuestkammerStarter t1;
    RuestkammerStarter t2;
    RuestkammerStarter t3;

    public ABColossusBombardBattery() {
        name = "Colossus Bombard Battery";
        grundkosten = 0;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/ABOrdnanceBattery.jpg"));

        seperator();

        t1 = new RuestkammerStarter(ID, randAbstand, cnt, "ABColossus", "", 1);
        t1.initKammer();
        t1.setButtonText("Colossus 1");
        add(t1);

        seperator();

        t2 = new RuestkammerStarter(ID, randAbstand, cnt, "ABColossus", "", 1);
        t2.initKammer();
        t2.setButtonText("Colossus 2");
        add(t2);

        seperator();

        t3 = new RuestkammerStarter(ID, randAbstand, cnt, "ABColossus", "", 1);
        t3.initKammer();
        t3.setButtonText("Colossus 3");
        add(t3);

        complete();
    }

    @Override
    public void refreshen() {
    }

}
