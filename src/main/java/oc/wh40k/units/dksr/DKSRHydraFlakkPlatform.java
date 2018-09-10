package oc.wh40k.units.dksr;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DKSRHydraFlakkPlatform extends Eintrag {


	public DKSRHydraFlakkPlatform() {
		grundkosten = 50;

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo netting", 15));

		complete();
	}

  @Override
	public void refreshen() {
	}
}
