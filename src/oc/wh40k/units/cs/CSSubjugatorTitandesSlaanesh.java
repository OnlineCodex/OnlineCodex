package oc.wh40k.units.cs;

import oc.Eintrag;

public class CSSubjugatorTitandesSlaanesh extends Eintrag {

	public CSSubjugatorTitandesSlaanesh() {
		name = "Subjugator-Titan des Slaanesh";
		grundkosten = 500;

		add(ico = new oc.Picture("oc/wh40k/images/CMSubjugatorTitandesSlaanesh.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
