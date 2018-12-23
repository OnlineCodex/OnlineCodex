package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;

import java.util.Vector;

public class TATX7HammerheadGunships extends Eintrag {

    public TATX7HammerheadGunships() {
        name = "TX7 Hammerhead Gunships";
        grundkosten = 0;
        power = 9;

        überschriftSetzen = true;

        RuestkammerStarter rs = new RuestkammerStarter(ID, randAbstand, cnt, new TATX7HammerheadKammer(), "TX7 Hammerhead Gunship");
        rs.setAbwaehlbar(false);
        rs.setGrundkosten(getPts("TX7 Hammerhead Gunship"));
        add(rs);

        complete();
    }
}
