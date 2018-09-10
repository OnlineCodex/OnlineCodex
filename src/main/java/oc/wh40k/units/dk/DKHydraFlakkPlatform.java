package oc.wh40k.units.dk;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DKHydraFlakkPlatform extends Eintrag {


	public DKHydraFlakkPlatform() {
		grundkosten = 50;

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo netting", 20));

		complete();
	}

  @Override
	public void refreshen() {
	}
}
