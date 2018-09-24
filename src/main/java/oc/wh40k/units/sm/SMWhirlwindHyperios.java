package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SMWhirlwindHyperios extends Eintrag {

	public SMWhirlwindHyperios() {
		name = "Whirlwind Hyperios";
		grundkosten = 115;

		add(ico = new oc.Picture("oc/wh40k/images/SMWhirlwindHyperios.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

		complete();
	}

	@Override
	public void refreshen() {
	}

	@Override
	public void deleteYourself() {
	}

}
