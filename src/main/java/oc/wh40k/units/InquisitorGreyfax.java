package oc.wh40k.units;

import oc.Eintrag;

public class InquisitorGreyfax extends Eintrag {

	public InquisitorGreyfax() {
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
