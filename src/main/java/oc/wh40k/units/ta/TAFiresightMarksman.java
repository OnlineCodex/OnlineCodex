package oc.wh40k.units.ta;

import oc.Eintrag;

public class TAFiresightMarksman extends Eintrag {

	public TAFiresightMarksman() {

		name = "Firesight Marksman";

		grundkosten = getPts("Firesight Marksman") + getPts("Markerlight") + getPts("Pulse pistol");

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
		power = 1;
	}
}
