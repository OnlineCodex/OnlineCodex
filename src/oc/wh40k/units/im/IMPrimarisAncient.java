package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMPrimarisAncient extends Eintrag {
	OptionsEinzelUpgrade jump;
	RuestkammerStarter waffenUndReliquien;

	public IMPrimarisAncient() {
		name = "Primaris Ancient";
		grundkosten = getPts("Primaris Ancient") + getPts("Bolt pistol (SM)")  + getPts("Bolt rifle")+ getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
		power = 4;
		complete();
	}

	@Override
	public void refreshen() {
	}
}
