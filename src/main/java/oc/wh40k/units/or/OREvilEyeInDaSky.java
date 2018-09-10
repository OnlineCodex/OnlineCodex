package oc.wh40k.units.or;

import oc.Eintrag;

public class OREvilEyeInDaSky extends Eintrag {

	public OREvilEyeInDaSky() {
		name = "Evil Eye in da Sky";
		grundkosten = 650;


		add(ico = new oc.Picture("oc/wh40k/images/EvilEyeInDaSky.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
