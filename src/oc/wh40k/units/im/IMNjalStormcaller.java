package oc.wh40k.units.im;

import oc.Eintrag;

public class IMNjalStormcaller extends Eintrag {

	public IMNjalStormcaller() {
		name = "Njal Sturmbringer";
		grundkosten = getPts("Njal Stormcaller");
		power = 7;
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
}
