package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;

import java.util.Vector;

public class TATX78SkyRayGunships extends Eintrag {

    Vector<RuestkammerStarter> rk;

    public TATX78SkyRayGunships() {
        name = "TX78 Sky Ray Gunship";
        überschriftSetzen = true;
        grundkosten = 0;

        seperator();

        rk = new Vector<RuestkammerStarter>();
        for (int i = 0; i < 1; i++) {
            rk.add(new RuestkammerStarter(ID, randAbstand, cnt, "TATX78SkyRayKammer", "TX78 Sky Ray Gunship"));
            rk.lastElement().initKammer(false, false, false, false, false, false, true);
            rk.lastElement().setGrundkosten(getPts("TX78 Sky Ray Gunship") + getPts("Markerlight") * 2 + getPts("Seeker missile") * 6);
            add(rk.lastElement());
        }
        rk.firstElement().setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        power = 8;
    }
}
