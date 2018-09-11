package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMKnightCaptainElamCourbray extends Eintrag {
	//TODO Firehawks only
	public SMKnightCaptainElamCourbray() {
		name = "Knight-Captain Elam Courbray";
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
