package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMSanguinaryNovitiate extends Eintrag {

	RuestkammerStarter waffenUndReliquien;

	public IMSanguinaryNovitiate() {
		name = "Sanguinary Novitiate";
		grundkosten = getPts("Apothecary") + 
					  getPts("Frag grenade (SM)") + 
					  getPts("Krak grenade (SM)") + 
					  getPts("Chainsword (SM)") + 
					  getPts("Bolt pistol (SM)");
		power = 3;

		complete();
	}

	@Override
	public void refreshen() {
	}
}
