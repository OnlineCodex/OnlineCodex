package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ABDestroyerTankHunterSquadron extends Eintrag {

    RuestkammerStarter v1;
    RuestkammerStarter v2;
    RuestkammerStarter v3;

    public ABDestroyerTankHunterSquadron() {
        name = "Destroyer Tank Hunter Squadron";
        grundkosten = 0;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/ABDestroyerTankHunterSquadron.jpg"));

        v1 = new RuestkammerStarter(ID, randAbstand, cnt, "ABDestroyer", "Destroyer");
        v1.initKammer();
        v1.setGrundkosten(160);
        add(v1);

        seperator();

        v2 = new RuestkammerStarter(ID, randAbstand, cnt, "ABDestroyer", "Destroyer");
        v2.initKammer();
        v2.setGrundkosten(160);
        add(v2);

        seperator();

        v3 = new RuestkammerStarter(ID, randAbstand, cnt, "ABDestroyer", "Destroyer");
        v3.initKammer();
        v3.setGrundkosten(160);
        add(v3);

        complete();
    }

    @Override
    public void refreshen() {
    }

}
