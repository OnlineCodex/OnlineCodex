package oc.wh40k.units.im;

import oc.Eintrag;

public class IMTheSanguinor extends Eintrag {

	public IMTheSanguinor() {
		name = "The Sanguinor";
		grundkosten = getPts("The Sanguinor");
		power = 9;
		seperator();
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
