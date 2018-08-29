package oc.wh40k.units;

import oc.Eintrag;

public class Yvraine extends Eintrag {

	public Yvraine() {
		name = "Yvraine";
		grundkosten = 200;

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
