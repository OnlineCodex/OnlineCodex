package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class IMLandRaiderExcelsior extends Eintrag {

	OptionsUpgradeGruppe o1;

	public IMLandRaiderExcelsior() {
		name = "Land Raider Excelsior";
		grundkosten = getPts("Land Raider Excelsior") + getPts("Twin lascannon") * 2 + getPts("Grav-cannon and grav-amp");
		power = 24;

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (SM)")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (SM)")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multi-melta", getPts("Multi-melta (SM)")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Combi plasma", getPts("Combi plasma")));

		complete();
	}

	@Override
	public void refreshen() {
	}
}
