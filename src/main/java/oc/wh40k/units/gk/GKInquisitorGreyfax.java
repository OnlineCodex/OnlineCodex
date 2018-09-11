package oc.wh40k.units.gk;

import oc.Eintrag;

public class GKInquisitorGreyfax extends Eintrag {

	public GKInquisitorGreyfax() {
		name = "Inquisitor Greyfax";
		grundkosten = 150;

		add(ico = new oc.Picture("oc/wh40k/images/ASSanktCelestine.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
