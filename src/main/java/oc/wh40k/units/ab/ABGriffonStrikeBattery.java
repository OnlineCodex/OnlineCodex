package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ABGriffonStrikeBattery extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;
	RuestkammerStarter t4;
	RuestkammerStarter t5;

	public ABGriffonStrikeBattery() {
		name = "Griffon Strike Battery";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/ABOrdnanceBattery.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo-netting", 20));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "ABGriffon", "",1);
		t1.initKammer();
		t1.setButtonText("Griffon 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "ABGriffon", "",1);
		t2.initKammer();
		t2.setButtonText("Griffon 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "ABGriffon", "",1);
		t3.initKammer();
		t3.setButtonText("Griffon 3");
		add(t3);
		
		seperator();

		t4 = new RuestkammerStarter(ID, randAbstand, cnt, "ABGriffon", "",1);
		t4.initKammer();
		t4.setButtonText("Griffon 4");
		add(t4);

		seperator();

		t5 = new RuestkammerStarter(ID, randAbstand, cnt, "ABGriffon", "",1);
		t5.initKammer();
		t5.setButtonText("Griffon 5");
		add(t5);

		complete();
	}

	@Override
	public void refreshen() {
		int tanks = (t1.isSelected() ? 1 : 0) + (t2.isSelected() ? 1 : 0) + (t3.isSelected() ? 1 : 0) + (t4.isSelected() ? 1 : 0) + (t5.isSelected() ? 1 : 0);

		oe1.setPreis(tanks * 30);
		oe1.setAktiv(tanks > 0);
	}

}
