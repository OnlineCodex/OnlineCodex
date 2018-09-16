package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TATidewallShieldline extends Eintrag {

	OptionsEinzelUpgrade oe1;

	public TATidewallShieldline() {
		name = "Tidewall Shieldline";
		grundkosten = getPts("Tidewall Shieldline");

		add(oe1 = new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Tidewall Defence Platform", getPts("Tidewall Defence Platform")));
		
		complete();
	}

	@Override
	public void refreshen() {
		power = 4;
		if (oe1.isSelected()) {
			power = power + 3;
		}
	}
}
