package oc.wh40k.units.ia;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class IADominatris extends RuestkammerVater {

	public IADominatris() {
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
