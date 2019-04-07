package oc.wh40k.units.ta;

import java.util.Vector;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class TAKV128Stormsurge extends Eintrag {

	private final Vector<RuestkammerStarter> rk;

    public TAKV128Stormsurge() {
        name = "KV128 Stormsurges";
        überschriftSetzen = true;
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/KrisisKampfanzugteam.gif"));


        seperator();

        rk = new Vector<RuestkammerStarter>();
        for (int i = 0; i < 1; i++) {
            rk.add(new RuestkammerStarter(ID, randAbstand, cnt, TAKV128Stormsurgekammer.class, "KV128 Stormsurge"));
            rk.lastElement().initKammer(false, false, false, false, false, false, true);
            rk.lastElement().setGrundkosten(getPts("KV128 Stormsurge") + getPts("Cluster rocket system") + getPts("Destroyer missile") * 4 + getPts("Smart missile system") * 2);
            add(rk.lastElement());
        }

        rk.firstElement().setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        power = 20;
    }
}
