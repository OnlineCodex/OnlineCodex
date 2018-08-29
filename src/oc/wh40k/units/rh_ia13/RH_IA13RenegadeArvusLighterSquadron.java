package oc.wh40k.units.rh_ia13;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class RH_IA13RenegadeArvusLighterSquadron extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public RH_IA13RenegadeArvusLighterSquadron() {
		name = "Renegade Arvus Lighter Squadron";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGHellhoundSquadron.jpg"));

		
		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13ArvusLighterKammer", "Renegade Arvus Lighter", 1);
		t1.initKammer();
		t1.setUeberschriftTrotzNullKostenAusgeben(true);
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13ArvusLighterKammer", "Renegade Arvus Lighter", 1);
		t2.initKammer();
		t2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13ArvusLighterKammer", "Renegade Arvus Lighter", 1);
		t3.initKammer();
		t3.setUeberschriftTrotzNullKostenAusgeben(true);
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
