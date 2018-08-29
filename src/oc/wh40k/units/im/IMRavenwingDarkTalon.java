package oc.wh40k.units.im;

import oc.Eintrag;

public class IMRavenwingDarkTalon extends Eintrag {

	public IMRavenwingDarkTalon() {
		name = "Ravenwing Dark Talon";
		grundkosten = getPts("Ravenwing Dark Talon") + 2*getPts("Hurricane bolter") + getPts("Rift cannon");
		power = 8;
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
	}
}
