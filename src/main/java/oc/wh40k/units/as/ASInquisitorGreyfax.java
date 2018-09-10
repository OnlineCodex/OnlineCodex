package oc.wh40k.units.as;

import oc.Eintrag;

public class ASInquisitorGreyfax extends Eintrag {

	public ASInquisitorGreyfax() {
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
