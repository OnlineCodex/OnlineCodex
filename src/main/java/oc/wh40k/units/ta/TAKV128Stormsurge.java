package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;

import java.util.Vector;

public class TAKV128Stormsurge extends Eintrag {

    public TAKV128Stormsurge() {
        name = "KV128 Stormsurges";
        grundkosten = 0;
        power = 20;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/KrisisKampfanzugteam.gif"));

        seperator();

        Vector<RuestkammerStarter> rk = new Vector<RuestkammerStarter>();
        for (int i = 0; i < 1; i++) {
            rk.add(new RuestkammerStarter(ID, randAbstand, cnt, new TAKV128Stormsurgekammer(), "KV128 Stormsurge"));
            rk.lastElement().setGrundkosten(getPts("KV128 Stormsurge") + getPts("Cluster rocket system") + getPts("Destroyer missile") * 4 + getPts("Smart missile system") * 2);
            add(rk.lastElement());
        }

        rk.firstElement().setAbwaehlbar(false);

        complete();
    }
}
