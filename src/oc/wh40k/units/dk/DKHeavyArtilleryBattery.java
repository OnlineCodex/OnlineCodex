package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DKHeavyArtilleryBattery extends Eintrag {

    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    RuestkammerStarter t1;
    RuestkammerStarter t2;
    RuestkammerStarter t3;

    public DKHeavyArtilleryBattery() {
        name = "Ordnance Battery";
        grundkosten = 0;
        this.überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/IGOrdnanceBattery.jpg"));

        seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo Netting", 30));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bastion-breacher shells", 5));

		seperator();

        t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHeavyArtilleryCarriage", "", 1);
        t1.initKammer();
        t1.setButtonText("Heavy Artillery Carriage 1");
        add(t1);

        seperator();

        t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHeavyArtilleryCarriage", "", 1);
        t2.initKammer();
        t2.setButtonText("Heavy Artillery Carriage 2");
        add(t2);

        seperator();

        t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHeavyArtilleryCarriage", "", 1);
        t3.initKammer();
        t3.setButtonText("Heavy Artillery Carriage 3");
        add(t3);

        complete();
    }

    @Override
    public void refreshen() {
        int tanks = (t1.isSelected() ? 1 : 0) + (t2.isSelected() ? 1 : 0) + (t3.isSelected() ? 1 : 0);

		oe1.setPreis(tanks * 30);
		oe1.setAktiv(tanks > 0);
		
		oe2.setAktiv((((DKHeavyArtilleryCarriage)t1.getKammer()).o1.isSelected(1) || !t1.isSelected()) &&
				(((DKHeavyArtilleryCarriage)t2.getKammer()).o1.isSelected(1) || !t2.isSelected()) &&
				(((DKHeavyArtilleryCarriage)t3.getKammer()).o1.isSelected(1) || !t3.isSelected()) && (tanks > 0));
		
		oe2.setPreis(tanks * 5);
		
    }
    
}
