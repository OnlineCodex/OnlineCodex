package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;


public class ORGunTrukk extends Eintrag {

    public ORGunTrukk() {
        name = "Gun Trukk";
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/GunTrukk.gif"));

        add(new RuestkammerStarter(ID, randAbstand, cnt, new ORGunTrukkKammer(), "Gun Trukk"));

        seperator();

        add(new RuestkammerStarter(ID, randAbstand, cnt, new ORGunTrukkKammer(), "Gun Trukk"));

        seperator();

        add(new RuestkammerStarter(ID, randAbstand, cnt, new ORGunTrukkKammer(), "Gun Trukk"));

        seperator();

        add(new RuestkammerStarter(ID, randAbstand, cnt, new ORGunTrukkKammer(), "Gun Trukk"));

        seperator();

        add(new RuestkammerStarter(ID, randAbstand, cnt, new ORGunTrukkKammer(), "Gun Trukk"));

        complete();
    }
}
