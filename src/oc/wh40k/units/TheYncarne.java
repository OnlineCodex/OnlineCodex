package oc.wh40k.units;

import oc.Eintrag;

public class TheYncarne extends Eintrag {

	public TheYncarne() {
		name = "The Yncarne";
		grundkosten = 275;

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
