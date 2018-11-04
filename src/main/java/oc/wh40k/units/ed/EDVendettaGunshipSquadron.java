package oc.wh40k.units.ed;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class EDVendettaGunshipSquadron extends Eintrag {

    RuestkammerStarter v1;
    RuestkammerStarter v2;
    RuestkammerStarter v3;

    public EDVendettaGunshipSquadron() {
        name = "Vendetta Gunship Squadron";
        grundkosten = 0;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/ABVendettaGunshipSquadron.jpg"));

        v1 = new RuestkammerStarter(ID, randAbstand, cnt, "EDVendetta", "Vendetta");
        v1.initKammer();
        v1.setGrundkosten(130);
        add(v1);

        seperator();

        v2 = new RuestkammerStarter(ID, randAbstand, cnt, "EDVendetta", "Vendetta");
        v2.initKammer();
        v2.setGrundkosten(130);
        add(v2);

        seperator();

        v3 = new RuestkammerStarter(ID, randAbstand, cnt, "EDVendetta", "Vendetta");
        v3.initKammer();
        v3.setGrundkosten(130);
        add(v3);


        complete();
    }

    @Override
    public void refreshen() {

    }
}
