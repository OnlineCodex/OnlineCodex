package oc.wh40k.units.in;

import oc.Eintrag;

public class INInquisitorLordHectorRex extends Eintrag {

	public INInquisitorLordHectorRex() {
		name = "Inquisitor-Lord Hector Rex";
		grundkosten = 175;

		add(ico = new oc.Picture("oc/wh40k/images/GKInquisitorKaramasov.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}
