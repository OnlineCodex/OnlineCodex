package oc.wh40k.units.kd;

import oc.Eintrag;

public class KDSkullCannon extends Eintrag {


	public KDSkullCannon() {

		name = "Skull Cannon";

		grundkosten = 125;

		add(ico = new oc.Picture("oc/wh40k/images/CDSeelenzermalmer.gif"));

		complete();

	}

	@Override
	public void refreshen() {
	}
}
