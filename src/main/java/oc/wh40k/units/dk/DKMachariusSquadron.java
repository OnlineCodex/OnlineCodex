package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DKMachariusSquadron extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public DKMachariusSquadron() {
		name = "Macharius Squadron";
		grundkosten = 0;
		this.überschriftSetzen = true;
		this.gesamtpunkteImmerAnzeigen=false;

		add(ico = new oc.Picture("oc/wh40k/images/DKMachariusSquadron.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKMachariusKammer", "Macharius");
		t1.initKammer();
		t1.setButtonText("Macharius 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKMachariusKammer", "Macharius");
		t2.initKammer();
		t2.setButtonText("Macharius 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKMachariusKammer", "Macharius");
		t3.initKammer();
		t3.setButtonText("Macharius 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
