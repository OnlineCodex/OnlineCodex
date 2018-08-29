package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCaptaininGravisArmour extends Eintrag {

	RuestkammerStarter waffenUndReliquien;

	public IMCaptaininGravisArmour() {
		name = "Captain in Gravis Armour";
		grundkosten = getPts("Captain in Gravis Armour") + getPts("Master-crafted power sword") + getPts("Boltstorm gauntlet");
		power = 7;

		complete();
	}

	@Override
	public void refreshen() {
	}
}
