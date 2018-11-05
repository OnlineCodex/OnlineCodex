package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ABSiegeTankSquadron extends Eintrag {

    RuestkammerStarter v1;
    RuestkammerStarter v2;
    RuestkammerStarter v3;

    public ABSiegeTankSquadron() {
        name = "Siege Tank Squadron";
        grundkosten = 0;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/ABThundererSiegeTankSquadron.jpg"));

        v1 = new RuestkammerStarter(ID, randAbstand, cnt, "ABSiegeTank", "Siege Tank");
        v1.initKammer();
        v1.setGrundkosten(140);
        add(v1);

        seperator();

        v2 = new RuestkammerStarter(ID, randAbstand, cnt, "ABSiegeTank", "Siege Tank");
        v2.initKammer();
        v2.setGrundkosten(140);
        add(v2);

        seperator();

        v3 = new RuestkammerStarter(ID, randAbstand, cnt, "ABSiegeTank", "Siege Tank");
        v3.initKammer();
        v3.setGrundkosten(140);
        add(v3);

        complete();
    }

    @Override
    public void refreshen() {
    }

}
