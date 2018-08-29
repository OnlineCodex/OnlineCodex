package oc.wh40k.units.da;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DAWhirlwind extends Eintrag {

    OptionsEinzelUpgrade ia2;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
	RuestkammerStarter techmarine;

	public DAWhirlwind() {
		name = "Whirlwind";
		grundkosten = 65;

		add(ico = new oc.Picture("oc/wh40k/images/DAWhirlwind.gif"));

		
        seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
