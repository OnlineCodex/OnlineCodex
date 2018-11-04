package oc.wh40k.units.ec;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ECCorsairWaspSquadron extends Eintrag {

    OptionsEinzelUpgrade oe1;
    RuestkammerStarter w1;
    RuestkammerStarter w2;
    RuestkammerStarter w3;

    public ECCorsairWaspSquadron() {
        name = "Corsair Wasp Squadron";
        grundkosten = 0;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/ECWaspAssaultWalkerSquadron.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Corsair void burners", 5));

        seperator();

        w1 = new RuestkammerStarter(ID, randAbstand, cnt, "ECWaspAssaultWalkerKammer", "Wasp");
        w1.initKammer();
        add(w1);

        w2 = new RuestkammerStarter(ID, randAbstand, cnt, "ECWaspAssaultWalkerKammer", "Wasp");
        w2.initKammer();
        add(w2);

        w3 = new RuestkammerStarter(ID, randAbstand, cnt, "ECWaspAssaultWalkerKammer", "Wasp");
        w3.initKammer();
        add(w3);

        complete();
    }

    @Override
    public void refreshen() {
        w1.setAbwaehlbar(false);

        int walkers = (w1.isSelected() ? 1 : 0) + (w2.isSelected() ? 1 : 0) + (w3.isSelected() ? 1 : 0);

        oe1.setPreis(walkers * 5);
    }
}
