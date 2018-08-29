package oc.wh40k.units.apo;

import oc.Eintrag;

public class APOFestungderArroganz extends Eintrag {


	public APOFestungderArroganz() {
		name = "Festung der Arroganz";
		grundkosten = 960;


		add(ico = new oc.Picture("oc/wh40k/images/FestungderArroganz.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
