package oc.wh40k.units.ia;

import oc.AnzahlPanel;
import oc.Eintrag;

public class IAPenitentEngines extends Eintrag {

	AnzahlPanel squad;

	public IAPenitentEngines() {
		name = "Penitent Engines";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Peniten Engines", 1, 3, 80);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASLaeuterer.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
