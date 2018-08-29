package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMCaptainMordaciBlaylock extends Eintrag {

	public SMCaptainMordaciBlaylock() {
		//TODO Ultramarines only
		name = "Captain Mordaci Blaylock";
		grundkosten = 185;

		add(ico = new oc.Picture("oc/wh40k/images/CaptainLysander.gif"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
}
