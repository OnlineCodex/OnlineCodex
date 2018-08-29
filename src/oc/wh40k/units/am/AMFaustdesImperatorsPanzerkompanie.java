package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class AMFaustdesImperatorsPanzerkompanie extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter tff;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;


	public AMFaustdesImperatorsPanzerkompanie() {
		name = "'Faust des Imperators' - Panzerkompanie";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGLemanRussSquadron.jpg"));

		seperator();

		tff = new RuestkammerStarter(ID, randAbstand, cnt, "AMLemanRuss", "", 1);
		tff.initKammer();
		tff.setButtonText("Leman Russ Formationsführer");
		add(tff);

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "AMFaustdesImperatorsPanzer", "", 1);
		t1.initKammer();
		t1.setButtonText("Leman Russ Schwadron 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "AMFaustdesImperatorsPanzer", "", 1);
		t2.initKammer();
		t2.setButtonText("Leman Russ Schwadron 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "AMFaustdesImperatorsPanzer", "", 1);
		t3.initKammer();
		t3.setButtonText("Leman Russ Schwadron 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
		tff.setAbwaehlbar(false);
		t1.setAbwaehlbar(false);
		t2.setAbwaehlbar(false);
		t3.setAbwaehlbar(false);
		
	}

}
