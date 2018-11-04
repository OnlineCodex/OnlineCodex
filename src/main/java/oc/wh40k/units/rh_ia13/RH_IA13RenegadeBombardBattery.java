package oc.wh40k.units.rh_ia13;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class RH_IA13RenegadeBombardBattery extends Eintrag {

    RuestkammerStarter t1;
    RuestkammerStarter t2;
    RuestkammerStarter t3;

    public RH_IA13RenegadeBombardBattery() {
        name = "Renegade Bombard Battery";
        grundkosten = 0;
        this.überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/IGHellhoundSquadron.jpg"));

        seperator();

        t1 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeBombardKammer", "Renegade Colossus", 1);
        t1.initKammer();
        add(t1);

        seperator();

        t2 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeBombardKammer", "Renegade Colossus", 1);
        t2.initKammer();
        add(t2);

        seperator();

        t3 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeBombardKammer", "Renegade Colossus", 1);
        t3.initKammer();
        add(t3);


        complete();
    }

    @Override
    public void refreshen() {
    }

}
