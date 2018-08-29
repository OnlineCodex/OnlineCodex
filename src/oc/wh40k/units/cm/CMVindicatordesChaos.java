package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class CMVindicatordesChaos extends Eintrag {

	RuestkammerStarter ausruestung;
	
	public CMVindicatordesChaos() {
		name = "Vindicator des Chaos";
		grundkosten = 120;

		add(ico = new oc.Picture("oc/wh40k/images/ChaosVindicator.gif"));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Belagerungsschild", 10));
		
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
