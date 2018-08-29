package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class CMLandRaiderdesChaos extends Eintrag {

	RuestkammerStarter ausruestung;
	
	public CMLandRaiderdesChaos() {
		name = "Land Raider des Chaos";
		grundkosten = 230;

		add(ico = new oc.Picture("oc/wh40k/images/ChaosLandRaider.gif"));
		
		seperator();
		
		ausruestung = new RuestkammerStarter(ID, randAbstand, cnt, "CMFahrzeugruestkammer", "Ausrüstung");
		ausruestung.initKammer(true);
		ausruestung.setButtonText("Ausrüstung");
		add(ausruestung);
		
		complete();
	}

	@Override
	public void refreshen() {
	}

}
