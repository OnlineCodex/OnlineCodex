package oc.wh40k.units.rh_ia13;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class RH_IA13RenegadeTankSquadron extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public RH_IA13RenegadeTankSquadron() {
		name = "Leman Russ Tank Squadron";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGLemanRussSquadron.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeTankKammer", "", 1);
		t1.initKammer();
		t1.setButtonText("Leman Russ 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeTankKammer", "", 1);
		t2.initKammer();
		t2.setButtonText("Leman Russ 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeTankKammer", "", 1);
		t3.initKammer();
		t3.setButtonText("Leman Russ 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {

	}

}
