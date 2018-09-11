package oc.wh40k.units.im;

import oc.Eintrag;

public class IMTychotheLost extends Eintrag {

	public IMTychotheLost() {
		name = "Tycho the Lost";
		grundkosten = getPts("Tycho the Lost");
		power = 4;
		seperator();
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
