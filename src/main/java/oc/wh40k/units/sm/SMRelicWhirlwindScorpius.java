package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SMRelicWhirlwindScorpius extends Eintrag {

	public SMRelicWhirlwindScorpius() {
		name = "Relic Whirlwind Scorpius";
		grundkosten = 125;

		add(ico = new oc.Picture("oc/wh40k/images/SMWhirlwindHyperios.jpg"));
		//TODO Relic
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
