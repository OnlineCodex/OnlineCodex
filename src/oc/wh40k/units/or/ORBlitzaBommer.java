package oc.wh40k.units.or;

import oc.Eintrag;

public class ORBlitzaBommer extends Eintrag {

	public ORBlitzaBommer() {
		name = "Blitza-Bommer";
		grundkosten = getPts("Blitza-Bommer") + getPts("supa shoota") * 2 + getPts("Twin big shoota") + getPts("Boom bomb") *2;
		power = 7;
		complete();
	}

	public void refreshen() {}
}
