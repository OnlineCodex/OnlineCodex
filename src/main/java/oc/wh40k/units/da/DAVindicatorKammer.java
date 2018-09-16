package oc.wh40k.units.da;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class DAVindicatorKammer extends RuestkammerVater {

	public DAVindicatorKammer() {
		name = "Vindicator";
		grundkosten = 120;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/SMVindicator.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Belagerungsschild", 10));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
	}


}
