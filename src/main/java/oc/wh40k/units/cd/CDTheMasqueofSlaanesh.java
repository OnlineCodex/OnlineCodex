package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDTheMasqueofSlaanesh extends Eintrag {

	public CDTheMasqueofSlaanesh() {

		name = "The Masque of Slaanesh";
        grundkosten = getPts("The Masque of Slaanesh");
        power = 4;   
		complete();

	}

	@Override
	public void refreshen() {
	}
}
