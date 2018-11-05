package oc.wh40k.units.dkab;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DKABLemanRussForwardCommandTank extends Eintrag {

    OptionsEinzelUpgrade oe1;
    RuestkammerStarter t1;

    public DKABLemanRussForwardCommandTank() {
        name = "Leman Russ Forward Command Tank";
        grundkosten = 35;
        überschriftSetzen = true;


        add(ico = new oc.Picture("oc/wh40k/images/IGLemanRussSquadron.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 20));

        seperator();

        t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKABLemanRuss", "", 1);
        t1.initKammer();
        t1.setButtonText("Leman Russ Forward Command Tank");
        add(t1);


        complete();
    }

    @Override
    public void refreshen() {

    }

}
