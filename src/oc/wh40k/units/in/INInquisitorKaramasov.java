package oc.wh40k.units.in;

import oc.Eintrag;

public class INInquisitorKaramasov extends Eintrag {

	public INInquisitorKaramasov() {
		name = "Inquisitor Karamasov";
		grundkosten = 200;

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
