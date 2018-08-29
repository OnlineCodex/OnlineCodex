package oc.wh40k.units.im;

import oc.Eintrag;

public class IMDeathwingApothecary extends Eintrag {

	public IMDeathwingApothecary() {
		name = "Deathwing Apothecary";
		grundkosten = getPts("Deathwing Apothecary") + getPts("Storm bolter (SM)");
		power = 4;
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
	}
}
