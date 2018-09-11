package oc.wh40k.units.im;

import oc.Eintrag;

public class IMCaptainTycho extends Eintrag {

	public IMCaptainTycho() {
		name = "Captain Tycho";
		grundkosten = getPts("Captain Tycho");
		power = 5;
		seperator();
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
