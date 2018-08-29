package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMCaptainPellasMirsan extends Eintrag {

	public SMCaptainPellasMirsan() {
		//TODO Salamanders only
		name = "Captain Pellas Mir'san";
		grundkosten = 150;

		add(ico = new oc.Picture("oc/wh40k/images/CaptainLysander.gif"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
