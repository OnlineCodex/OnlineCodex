package oc.wh40k.units.ia;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IAJokaeroWeaponsmith extends Eintrag {

	OptionsUpgradeGruppe o1;
	
	public IAJokaeroWeaponsmith() {
		name = "Daemonhost";
		grundkosten = 10;

		add(ico = new oc.Picture("oc/wh40k/images/IGTechpriestEnginseer.jpg"));	

		seperator();
		
		complete();
	}

	@Override
	public void refreshen() {
	}

	@Override
	public void deleteYourself() {
	}

}
