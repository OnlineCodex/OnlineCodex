package oc.wh40k.units.im;

import oc.Eintrag;

public class IMUlriktheSlayer extends Eintrag {

	public IMUlriktheSlayer() {
		name = "Ulrik the Slayer";
		grundkosten = getPts("Ulrik the Slayer");
		power = 7;
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
