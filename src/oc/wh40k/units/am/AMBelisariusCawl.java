package oc.wh40k.units.am;

import oc.Eintrag;

public class AMBelisariusCawl extends Eintrag {

	public AMBelisariusCawl() {
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
