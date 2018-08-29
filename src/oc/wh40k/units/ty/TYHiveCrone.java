package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYHiveCrone extends Eintrag {

	public TYHiveCrone() {
		name = "Hive Crone";
		power = 8;
		grundkosten = getPts("Hive Crone") + getPts("Drool cannon") + getPts("Tentaclids") + getPts("Scything wings") + getPts("Wicked spur") + getPts("Stinger salvo");

		add(ico = new oc.Picture("oc/wh40k/images/TYHarpyie.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {
	}

}
