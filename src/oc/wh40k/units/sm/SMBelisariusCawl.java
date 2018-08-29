package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMBelisariusCawl extends Eintrag {

	public SMBelisariusCawl() {
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
