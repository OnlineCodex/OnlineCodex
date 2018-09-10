package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMPrimarisApothecary extends Eintrag {
	OptionsEinzelUpgrade jump;
	RuestkammerStarter waffenUndReliquien;

	public IMPrimarisApothecary() {
		name = "Primaris Apothecary";
		grundkosten = getPts("Primaris Apothecary") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Absolver bolt pistol") + getPts("Reductor pistol");

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
		power = 4;
	}
}
