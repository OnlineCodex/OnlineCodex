package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMGiantChaosSpawn extends Eintrag {

	public CMGiantChaosSpawn() {
		name = "Giant Chaos Spawn";
		grundkosten = 80;

		add(ico = new oc.Picture("oc/wh40k/images/GiantChaosSpawn.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
