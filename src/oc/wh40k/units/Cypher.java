package oc.wh40k.units;

import oc.Eintrag;

public class Cypher extends Eintrag {

	public Cypher() {
		name = "Cypher";
		grundkosten = 190;

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
