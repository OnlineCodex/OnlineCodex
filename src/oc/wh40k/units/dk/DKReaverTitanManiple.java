package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DKReaverTitanManiple extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public DKReaverTitanManiple() {
		name = "Reaver Titan Maniple";
		grundkosten = 0;
		this.überschriftSetzen = true;
		this.gesamtpunkteImmerAnzeigen=false;

		add(ico = new oc.Picture("oc/wh40k/images/DKMarauderSquadron.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DKReaverKammer", "Reaver\n");
		t1.initKammer();
		t1.setButtonText("Reaver");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKReaverKammer", "Reaver\n");
		t2.initKammer();
		t2.setButtonText("Reaver 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DKReaverKammer", "Reaver\n");
		t3.initKammer();
		t3.setButtonText("Reaver 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
		
	}

}
