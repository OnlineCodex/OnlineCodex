package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;

import java.util.Vector;

public class TATX78SkyRayGunships extends Eintrag {

    public TATX78SkyRayGunships() {
        name = "TX78 Sky Ray Gunship";
        grundkosten = 0;
        power = 8;
        überschriftSetzen = true;

        for (int i = 0; i < 1; i++) {
            RuestkammerStarter rs = new RuestkammerStarter(ID, randAbstand, cnt, new TATX78SkyRayKammer(), "TX78 Sky Ray Gunship");

            if (i == 0) {
                rs.setAbwaehlbar(false);
            }

            rs.setGrundkosten(getPts("TX78 Sky Ray Gunship") + getPts("Markerlight") * 2 + getPts("Seeker missile") * 6);
            add(rs);
        }

        complete();
    }
}
