package oc.wh40k.units.ta;

import oc.Eintrag;

public class TADarkstrider extends Eintrag {

	public TADarkstrider() {

		name = "Darkstrider";

		grundkosten = getPts("Darkstrider");

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
        power = 3;
	}
}
