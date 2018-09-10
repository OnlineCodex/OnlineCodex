package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CDHoellenschinderdesSlaanesh extends Eintrag {

	AnzahlPanel CDKreischerdesTzeentch;

	public CDHoellenschinderdesSlaanesh() {

		name = "Höllenschinder des Slaanesh";

		grundkosten = 60;

		add(ico = new oc.Picture("oc/wh40k/images/CDHöllenschinderdesSlaanesh.gif"));

		seperator();

		complete();

	}

	@Override
	public void refreshen() {
	}
}
