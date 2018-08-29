package oc.wh40k.units.dh;

import oc.AnzahlPanel;
import oc.Eintrag;

public class DHCanoptekAcanthrites extends Eintrag {

	AnzahlPanel squad;

	public DHCanoptekAcanthrites() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Canoptek Acanthrites", 3, 9, 50);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NECanoptekAcanthrites.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
