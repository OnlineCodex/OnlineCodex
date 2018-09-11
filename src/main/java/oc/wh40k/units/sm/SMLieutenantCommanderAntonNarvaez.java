package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMLieutenantCommanderAntonNarvaez extends Eintrag {
//TODO Ultramarines Only
	public SMLieutenantCommanderAntonNarvaez() {
		name = "Lieutenant Commander Anton Narvaez";
		grundkosten = 155;

		add(ico = new oc.Picture("oc/wh40k/images/CaptainLysander.gif"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        
	}
	
}
