package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMMasterHarathShen extends Eintrag {

	public SMMasterHarathShen() {
		//TODO Salamanders only
		name = "Master Harath Shen";
		grundkosten = 135;

		add(ico = new oc.Picture("oc/wh40k/images/CaptainLysander.gif"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
}
