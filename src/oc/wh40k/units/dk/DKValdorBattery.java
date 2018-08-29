package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DKValdorBattery extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public DKValdorBattery() {
		name = "Valdor Battery";
		grundkosten = 0;
		this.überschriftSetzen = true;
		this.gesamtpunkteImmerAnzeigen=false;

		add(ico = new oc.Picture("oc/wh40k/images/DKValdorSquadron.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKValdorKammer", "Valdor\n");
		t1.initKammer();
		t1.setButtonText("Valdor 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKValdorKammer", "Valdor\n");
		t2.initKammer();
		t2.setButtonText("Valdor 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKValdorKammer", "Valdor\n");
		t3.initKammer();
		t3.setButtonText("Valdor 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
