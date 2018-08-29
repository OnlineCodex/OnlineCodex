package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMBelial extends Eintrag {

	public IMBelial() {
		name = "Belial";
		grundkosten = getPts("Belial");
		power = 8;
		seperator();
		
		complete();
	}

	@Override
	public void refreshen() {
		setUnikat(true);
	}
}
