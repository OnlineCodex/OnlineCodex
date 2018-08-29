package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDKairosFateweaver extends Eintrag {

	public CDKairosFateweaver() {

		name = "Kairos Fateweaver";
        grundkosten = getPts("Kairos Fateweaver");
        power = 20;   
		complete();

	}

	@Override
	public void refreshen() {
	}
}
