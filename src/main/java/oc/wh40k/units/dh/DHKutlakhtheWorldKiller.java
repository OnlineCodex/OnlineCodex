package oc.wh40k.units.dh;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DHKutlakhtheWorldKiller extends Eintrag {
    
    RuestkammerStarter rkTransport;

	public DHKutlakhtheWorldKiller() {
		name = "Kutlakh the World Killer";
		grundkosten = 220;

		addToInformationVector("DHHochlord", 1);

		add(ico = new oc.Picture("oc/wh40k/images/NEImotekhderSturmherr.jpg"));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DHKommandogleiterKammer", "Kommando-Gleiter");
		rkTransport.initKammer();
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		addToInformationVector("DHHochlord", -1);
	}

}
