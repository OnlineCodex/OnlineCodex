package oc.wh40k.units.im;

import oc.Eintrag;

public class IMEversorAssassin extends Eintrag {

	public IMEversorAssassin() {
		name = "Eversor Assassin";
		grundkosten = getPts("Eversor Assassin");
		power = 4;
		
		complete();
	}

	@Override
	public void refreshen() {
	}	
}
