package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMWeltuntergangsmaschine extends Eintrag {

	public CMWeltuntergangsmaschine() {
		name = "Weltuntergangsmaschine";
		grundkosten = 400;

		add(ico = new oc.Picture("oc/wh40k/images/CMWeltuntergangsmaschine.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
