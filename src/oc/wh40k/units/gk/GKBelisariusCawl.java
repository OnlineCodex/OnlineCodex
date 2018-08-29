package oc.wh40k.units.gk;

import oc.Eintrag;

public class GKBelisariusCawl extends Eintrag {

	public GKBelisariusCawl() {
		name = "Belisarius Cawl";
		grundkosten = 200;

		add(ico = new oc.Picture("oc/wh40k/images/ASSanktCelestine.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
