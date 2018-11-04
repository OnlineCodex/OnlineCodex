package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;

import java.util.Vector;

public class TALongstrike extends Eintrag {

    Vector<RuestkammerStarter> rk;

    public TALongstrike() {
        name = "TX7 Hammerhead Gunships";
        überschriftSetzen = true;
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/KrisisKampfanzugteam.gif"));


        seperator();

        rk = new Vector<RuestkammerStarter>();
        for (int i = 0; i < 1; i++) {
            rk.add(new RuestkammerStarter(ID, randAbstand, cnt, "TATX7HammerheadKammer", "Longstrike"));
            rk.lastElement().initKammer(false, false, false, false, false, false, true);
            rk.lastElement().setGrundkosten(getPts("Longstrike"));
            add(rk.lastElement());
        }

        rk.firstElement().setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        power = 10;
    }
}
