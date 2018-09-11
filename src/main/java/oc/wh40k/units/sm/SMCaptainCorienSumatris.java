package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMCaptainCorienSumatris extends Eintrag {
//TODO Astral Claws only
	public SMCaptainCorienSumatris() {
		name = "Captain Corien Sumatris";
		grundkosten = 165;

		add(ico = new oc.Picture("oc/wh40k/images/CaptainLysander.gif"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
