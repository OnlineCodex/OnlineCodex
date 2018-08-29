package oc.wh40k.units.as;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class ASDominatris extends RuestkammerVater {

	public ASDominatris() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
    	add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
