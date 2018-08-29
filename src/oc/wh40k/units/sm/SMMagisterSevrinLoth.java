package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMMagisterSevrinLoth extends Eintrag {

	public SMMagisterSevrinLoth() {
		name = "Magister Sevrin Loth";
		grundkosten = 175;

		add(ico = new oc.Picture("oc/wh40k/images/SMMagisterSevrinLoth.gif"));

		complete();
	}

	@Override
	public void refreshen() {
		setUnikat(true);       
	}
}
