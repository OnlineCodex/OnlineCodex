package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMLoganGrimnar extends Eintrag {

	OptionsEinzelUpgrade stormrider;
	
	public IMLoganGrimnar() {
		name = "Logan Grimnar";
		grundkosten = getPts("Logan Grimnar");
		power = 10;
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
}
