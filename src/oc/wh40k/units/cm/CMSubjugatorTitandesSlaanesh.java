package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMSubjugatorTitandesSlaanesh extends Eintrag {

	public CMSubjugatorTitandesSlaanesh() {
		name = "Subjugator-Titan des Slaanesh";
		grundkosten = 500;

		add(ico = new oc.Picture("oc/wh40k/images/CMSubjugatorTitandesSlaanesh.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
