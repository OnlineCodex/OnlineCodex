package oc.wh40k.units.ta;

import oc.Eintrag;

public class TATidewallGunrig extends Eintrag {


	public TATidewallGunrig() {
		name = "Tidewall Gunrig";
		grundkosten = getPts("Tidewall Gunring") + getPts("Supremacy railgun");

		complete();
	}

	@Override
	public void refreshen() {
		power = 6;
	}
}
