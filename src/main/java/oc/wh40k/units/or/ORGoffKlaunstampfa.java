package oc.wh40k.units.or;

import oc.Eintrag;

public class ORGoffKlaunstampfa extends Eintrag {

	public ORGoffKlaunstampfa() {
		name = "Goff-Klau'nstampfa";
		grundkosten = 450;


		add(ico = new oc.Picture("oc/wh40k/images/Goff-Klaunstampfa.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
