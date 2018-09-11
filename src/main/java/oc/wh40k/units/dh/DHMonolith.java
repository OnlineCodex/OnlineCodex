package oc.wh40k.units.dh;

import oc.Eintrag;

public class DHMonolith extends Eintrag {
    
	public DHMonolith() {
		name = "Monolith";
		grundkosten = 200;

		add(ico = new oc.Picture("oc/wh40k/images/NEMonolith.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
