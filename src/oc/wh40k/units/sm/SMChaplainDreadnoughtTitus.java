package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMChaplainDreadnoughtTitus extends Eintrag {
//TODO Ultramarines only
	
	public SMChaplainDreadnoughtTitus() {
		name = "Chaplain Dreadnought Titus";
		grundkosten = 205;
		
		add(ico = new oc.Picture("oc/wh40k/images/BTGrossmarschallHelbrecht.jpg"));
		complete();
	}

	@Override
	public void refreshen() {
		setUnikat(true);
	}
}
