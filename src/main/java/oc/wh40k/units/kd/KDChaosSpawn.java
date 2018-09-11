package oc.wh40k.units.kd;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class KDChaosSpawn extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe mal;
	
	public KDChaosSpawn() {
		//name = "Chaosbrut";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Spawn", 1, 5, 32);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpawn.gif"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
	}

}
