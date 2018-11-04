package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class AMHeavyArtilleryBattery extends Eintrag {

    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    RuestkammerStarter t1;
    RuestkammerStarter t2;
    RuestkammerStarter t3;
    RuestkammerStarter tr1;
    RuestkammerStarter tr2;
    RuestkammerStarter tr3;

    public AMHeavyArtilleryBattery() {
        name = "Heavy Artillery Battery";
        grundkosten = 0;
        this.überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/IGOrdnanceBattery.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo Netting", 30));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bastion-breacher shells", 5));

        seperator();

        t1 = new RuestkammerStarter(ID, randAbstand, cnt, "AMHeavyArtilleryCarriage", "", 1);
        t1.initKammer();
        t1.setButtonText("Heavy Artillery Carriage 1");
        add(t1);

        tr1 = new RuestkammerStarter(ID, randAbstand, cnt, "AMTrojan", "Trojan");
        tr1.initKammer();
        add(tr1);

        seperator();

        t2 = new RuestkammerStarter(ID, randAbstand, cnt, "AMHeavyArtilleryCarriage", "", 1);
        t2.initKammer();
        t2.setButtonText("Heavy Artillery Carriage 2");
        add(t2);

        tr2 = new RuestkammerStarter(ID, randAbstand, cnt, "AMTrojan", "Trojan");
        tr2.initKammer();
        add(tr2);

        seperator();

        t3 = new RuestkammerStarter(ID, randAbstand, cnt, "AMHeavyArtilleryCarriage", "", 1);
        t3.initKammer();
        t3.setButtonText("Heavy Artillery Carriage 3");
        add(t3);

        tr3 = new RuestkammerStarter(ID, randAbstand, cnt, "AMTrojan", "Trojan");
        tr3.initKammer();
        add(tr3);
        complete();
    }

    @Override
    public void refreshen() {
        int tanks = (t1.isSelected() ? 1 : 0) + (t2.isSelected() ? 1 : 0) + (t3.isSelected() ? 1 : 0);

        oe1.setPreis(tanks * 30);
        oe1.setAktiv(tanks > 0);

        oe2.setAktiv((((AMHeavyArtilleryCarriage) t1.getKammer()).o1.isSelected(1) || !t1.isSelected()) &&
                (((AMHeavyArtilleryCarriage) t2.getKammer()).o1.isSelected(1) || !t2.isSelected()) &&
                (((AMHeavyArtilleryCarriage) t3.getKammer()).o1.isSelected(1) || !t3.isSelected()) && (tanks > 0));

        oe2.setPreis(tanks * 5);

    }

}
