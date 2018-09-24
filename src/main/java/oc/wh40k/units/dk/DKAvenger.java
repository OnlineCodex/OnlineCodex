package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DKAvenger extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public DKAvenger() {
		name = "Avenger Squadron";
		grundkosten = 0;
		überschriftSetzen=true;

		add(ico = new oc.Picture("oc/wh40k/images/ABThunderbolt.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKAvengerKammer", "Avenger");
		t1.initKammer();
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKAvengerKammer", "Avenger");
		t2.initKammer();
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKAvengerKammer", "Avenger");
		t3.initKammer();
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
