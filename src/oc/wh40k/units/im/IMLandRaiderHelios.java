package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMLandRaiderHelios extends Eintrag {

	public IMLandRaiderHelios() {
		name = "Land Raider Helios";
		grundkosten = getPts("Land Raider Helios") + getPts("Helios launcher") + 2*getPts("Twin lascannon");
		power = 20;

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (IA)")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (IA)")));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
