package oc.wh40k.units.im;

import oc.Eintrag;

public class IMRobouteGuilliman extends Eintrag {

	public IMRobouteGuilliman() {
		name = "Roboute Guilliman";
		grundkosten = getPts("Roboute Guilliman");
		power = 18;
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	
}
