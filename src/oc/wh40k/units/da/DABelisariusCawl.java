package oc.wh40k.units.da;

import oc.Eintrag;

public class DABelisariusCawl extends Eintrag {

	public DABelisariusCawl() {
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
