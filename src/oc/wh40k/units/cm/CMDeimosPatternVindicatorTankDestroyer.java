package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class CMDeimosPatternVindicatorTankDestroyer extends Eintrag {

	RuestkammerStarter ausruestung;
	
	public CMDeimosPatternVindicatorTankDestroyer() {
		name = "Deimos Pattern Vindicator Tank Destroyer";
		grundkosten = 130;
		add(ico = new oc.Picture("oc/wh40k/images/SMVindicator.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Siege Shield", 10));
		
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
