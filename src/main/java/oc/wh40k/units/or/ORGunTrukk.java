package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;


public class ORGunTrukk extends Eintrag {

	private final RuestkammerStarter t1;
	private final RuestkammerStarter t2;
	private final RuestkammerStarter t3;
	private final RuestkammerStarter t4;
	private final RuestkammerStarter t5;

    public ORGunTrukk() {

        name = "Gun Trukk";
        grundkosten = 0;


        add(ico = new oc.Picture("oc/wh40k/images/GunTrukk.gif"));


        t1 = new RuestkammerStarter(ID, randAbstand, cnt, ORGunTrukkKammer.class, "Gun Trukk");
        t1.initKammer();
        add(t1);

        seperator();

        t2 = new RuestkammerStarter(ID, randAbstand, cnt, ORGunTrukkKammer.class, "Gun Trukk");
        t2.initKammer();
        add(t2);

        seperator();

        t3 = new RuestkammerStarter(ID, randAbstand, cnt, ORGunTrukkKammer.class, "Gun Trukk");
        t3.initKammer();
        add(t3);

        seperator();

        t4 = new RuestkammerStarter(ID, randAbstand, cnt, ORGunTrukkKammer.class, "Gun Trukk");
        t4.initKammer();
        add(t4);

        seperator();

        t5 = new RuestkammerStarter(ID, randAbstand, cnt, ORGunTrukkKammer.class, "Gun Trukk");
        t5.initKammer();
        add(t5);

        complete();


    }
}
