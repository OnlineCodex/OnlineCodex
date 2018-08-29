package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHTallyman extends Eintrag {

	OptionsUpgradeGruppe bell, pp;
	public CHTallyman() {

		name = "Tallyman";
        grundkosten = getPts("Tallyman") + getPts("Plasma pistol") + getPts("Blight grenades") + getPts("Krak grenades");
        power = 4;        
        
		complete();

	}

	@Override
	public void refreshen() {
	}
}
