package oc.wh40k.units.ta;

import java.util.Vector;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class TATX7HammerheadGunships extends Eintrag {

	private final Vector<RuestkammerStarter> rk;

    public TATX7HammerheadGunships() {
        name = "TX7 Hammerhead Gunships";
        applyTitle = true;
        grundkosten = 0;

        seperator();

        rk = new Vector<RuestkammerStarter>();
        for (int i = 0; i < 1; i++) {
            rk.add(new RuestkammerStarter(ID, randAbstand, cnt, TATX7HammerheadKammer.class, "TX7 Hammerhead Gunship"));
            rk.lastElement().initKammer(false, false, false, false, false, false, true);
            rk.lastElement().setGrundkosten(getPts("TX7 Hammerhead Gunship"));
            add(rk.lastElement());
        }

        rk.firstElement().setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        power = 9;
    }
}
