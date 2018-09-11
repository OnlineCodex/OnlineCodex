package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DKThundererSiegeTankSquadron extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public DKThundererSiegeTankSquadron() {
		name = "Thunderer Siege Tank Squadron";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGLemanRussSquadron.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKThundererSiegeTank", "Thunderer Siege Tank", 1);
		t1.initKammer();
		t1.setButtonText("Thunderer Siege Tank 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKThundererSiegeTank", "Thunderer Siege Tank", 1);
		t2.initKammer();
		t2.setButtonText("Thunderer Siege Tank 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKThundererSiegeTank", "Thunderer Siege Tank", 1);
		t3.initKammer();
		t3.setButtonText("Thunderer Siege Tank 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
