package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class IMLandRaider extends Eintrag {

	OptionsUpgradeGruppe o1;

	public IMLandRaider() {
		name = "Land Raider";
		grundkosten = getPts("Land Raider") + getPts("Twin lascannon") * 2 + getPts("Twin Heavy bolter (SM)");
		power = 19;

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (SM)")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (SM)")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multi-melta", getPts("Multi-melta (SM)")));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
