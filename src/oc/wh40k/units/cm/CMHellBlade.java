package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CMHellBlade extends Eintrag {

	public CMHellBlade() {
		name = "Hell Blade";
		grundkosten = 115;

		add(ico = new oc.Picture("oc/wh40k/images/HellBlade.gif"));
		

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Possession", 20));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
