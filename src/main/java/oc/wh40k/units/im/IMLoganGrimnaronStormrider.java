package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMLoganGrimnaronStormrider extends Eintrag {

	OptionsEinzelUpgrade stormrider;
	
	public IMLoganGrimnaronStormrider() {
		name = "Logan Grimnar on Stormrider";
		grundkosten = getPts("Logan Grimnar on Stormrider");
		power = 12;
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
}
