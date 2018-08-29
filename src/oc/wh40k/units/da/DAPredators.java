package oc.wh40k.units.da;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DAPredators extends Eintrag {

	RuestkammerStarter rkD1;
	RuestkammerStarter rkD2;
	RuestkammerStarter rkD3;

	public DAPredators() {
		name = "Predators";

		addToInformationVector("Predators", 1);

		rkD1 = new RuestkammerStarter(ID, randAbstand, cnt, "DAPredatorKammer", "Predator");
		rkD1.initKammer(true);
		add(rkD1);

		rkD2 = new RuestkammerStarter(ID, randAbstand, cnt, "DAPredatorKammer", "Predator");
		rkD2.initKammer(true);
		add(rkD2);

		rkD3 = new RuestkammerStarter(ID, randAbstand, cnt, "DAPredatorKammer", "Predator");
		rkD3.initKammer(true);
		add(rkD3);

		complete();
	}

	@Override
	public void refreshen() {

	}

	@Override
	public void deleteYourself() {
		addToInformationVector("Predators", -1);
		super.deleteYourself();
	}
}