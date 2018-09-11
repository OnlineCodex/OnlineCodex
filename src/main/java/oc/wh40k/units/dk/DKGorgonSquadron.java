package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DKGorgonSquadron extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public DKGorgonSquadron() {
		name = "Gorgon Squadron";
		grundkosten = 0;
		this.überschriftSetzen = true;
		this.gesamtpunkteImmerAnzeigen=false;

		add(ico = new oc.Picture("oc/wh40k/images/DKGorgonSquadron.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKGorgonKammer", "Gorgon\n");
		t1.initKammer();
		t1.setButtonText("Gorgon 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKGorgonKammer", "Gorgon\n");
		t2.initKammer();
		t2.setButtonText("Gorgon 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKGorgonKammer", "Gorgon\n");
		t3.initKammer();
		t3.setButtonText("Gorgon 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
