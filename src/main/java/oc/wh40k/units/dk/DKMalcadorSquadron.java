package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DKMalcadorSquadron extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public DKMalcadorSquadron() {
		name = "Malcador Squadron";
		grundkosten = 0;
		this.überschriftSetzen = true;
		this.gesamtpunkteImmerAnzeigen=false;

		add(ico = new oc.Picture("oc/wh40k/images/DKMalcadorSquadron.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKMalcadorKammer", "Malcador");
		t1.initKammer();
		t1.setButtonText("Malcador 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKMalcadorKammer", "Malcador");
		t2.initKammer();
		t2.setButtonText("Malcador 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKMalcadorKammer", "Malcador");
		t3.initKammer();
		t3.setButtonText("Malcador 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
