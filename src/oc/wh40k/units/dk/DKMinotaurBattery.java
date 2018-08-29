package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DKMinotaurBattery extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public DKMinotaurBattery() {
		name = "Minotaur Battery";
		grundkosten = 0;
		this.überschriftSetzen = true;
		this.gesamtpunkteImmerAnzeigen=false;

		add(ico = new oc.Picture("oc/wh40k/images/DKMinotaurSquadron.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKMinotaurKammer", "Minotaur\n");
		t1.initKammer();
		t1.setButtonText("Minotaur 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKMinotaurKammer", "Minotaur\n");
		t2.initKammer();
		t2.setButtonText("Minotaur 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKMinotaurKammer", "Minotaur\n");
		t3.initKammer();
		t3.setButtonText("Minotaur 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
