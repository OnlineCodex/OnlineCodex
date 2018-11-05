package oc.wh40k.units.ec;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ECCorsairVyperSquadron extends Eintrag {

    OptionsEinzelUpgrade oe1, oe2, oe3, oe4;
    RuestkammerStarter w1, w2, w3, w4, w5, w6;

    public ECCorsairVyperSquadron() {
        name = "Corsair Vyper Squadron";
        grundkosten = 0;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/ECWaspAssaultWalkerSquadron.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Corsair void burners", 5));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Corsair kinetic shroud", 15));
        add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Star engines", 15));
        add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Chain snares", 5));

        seperator();

        w1 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairVyperJetbikeKammer", "Vyper");
        w1.initKammer();
        add(w1);

        w2 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairVyperJetbikeKammer", "Vyper");
        w2.initKammer();
        add(w2);

        w3 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairVyperJetbikeKammer", "Vyper");
        w3.initKammer();
        add(w3);

        w4 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairVyperJetbikeKammer", "Vyper");
        w4.initKammer();
        add(w4);

        w5 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairVyperJetbikeKammer", "Vyper");
        w5.initKammer();
        add(w5);

        w6 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairVyperJetbikeKammer", "Vyper");
        w6.initKammer();
        add(w6);

        complete();
    }

    @Override
    public void refreshen() {
        w1.setAbwaehlbar(false);

        int walkers = (w1.isSelected() ? 1 : 0) + (w2.isSelected() ? 1 : 0) + (w3.isSelected() ? 1 : 0) +
                (w4.isSelected() ? 1 : 0) + (w5.isSelected() ? 1 : 0) + (w6.isSelected() ? 1 : 0);

        oe1.setModelle(walkers);
        oe2.setModelle(walkers);
        oe3.setModelle(walkers);
        oe4.setModelle(walkers);
    }
}
