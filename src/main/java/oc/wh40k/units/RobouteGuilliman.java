package oc.wh40k.units;

import oc.Eintrag;

public class RobouteGuilliman extends Eintrag {

	public RobouteGuilliman() {
		name = "Roboute Guilliman";
		grundkosten = 350;

		add(ico = new oc.Picture("oc/wh40k/images/ASSanktCelestine.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}
	
}
