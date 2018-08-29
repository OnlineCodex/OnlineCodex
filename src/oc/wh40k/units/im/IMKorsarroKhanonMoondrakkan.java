package oc.wh40k.units.im;

import oc.Eintrag;

public class IMKorsarroKhanonMoondrakkan extends Eintrag {

	public IMKorsarroKhanonMoondrakkan() {
		name = "Kor'sarro Khan on Moondrakkan";
		grundkosten = getPts("Kor'sarro Khan on Moondrakkan");
		power = 7;
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
            setUnikat(true);    
	}
}