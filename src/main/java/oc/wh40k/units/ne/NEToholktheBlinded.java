package oc.wh40k.units.ne;

import oc.Eintrag;

public class NEToholktheBlinded extends Eintrag {

	public NEToholktheBlinded() {
		name = "Toholk the Blinded";
		grundkosten = getPts("Toholk the Blinded");
		power = 8;
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
            setUnikat(true);    
	}
}