package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMInquisitorGreyfax extends Eintrag {

	public SMInquisitorGreyfax() {
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
