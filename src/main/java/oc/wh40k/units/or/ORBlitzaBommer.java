package oc.wh40k.units.or;

import oc.Eintrag;

public class ORBlitzaBommer extends Eintrag {
	
	public ORBlitzaBommer() {
		name = "Blitza-Bommer";
		grundkosten = getPts("Blitza-Bommer") + getPts("supa shoota")*2 + getPts("Big shoota");
		
		power = 6;
		complete();
	}

	public void refreshen() {
		
	}
}
