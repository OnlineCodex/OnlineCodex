package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DKHellhoundSquadron extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public DKHellhoundSquadron() {
		name = "Hellhound Squadron";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGHellhoundSquadron.jpg"));

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHellhound", "", 1);
		t1.initKammer();
		t1.setButtonText("Tank 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHellhound", "", 1);
		t2.initKammer();
		t2.setButtonText("Tank 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKHellhound", "", 1);
		t3.initKammer();
		t3.setButtonText("Tank 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
