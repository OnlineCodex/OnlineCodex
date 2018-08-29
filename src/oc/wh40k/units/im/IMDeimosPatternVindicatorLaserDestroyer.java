package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMDeimosPatternVindicatorLaserDestroyer extends Eintrag {

	public IMDeimosPatternVindicatorLaserDestroyer() {
		name = "Deimos Pattern Vindicator Laser Destroyer";
		grundkosten = getPts("Deimos Pattern Vindicator Laser Destroyer") + getPts("Laser volley cannon") + getPts("Storm bolter (IA)");
		power = 10;

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (IA)")));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
