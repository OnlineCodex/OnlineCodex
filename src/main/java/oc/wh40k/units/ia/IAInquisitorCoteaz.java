package oc.wh40k.units.ia;

import oc.Eintrag;

public class IAInquisitorCoteaz extends Eintrag {

	public IAInquisitorCoteaz() {
		name = "Inquisitor Coteaz";
		grundkosten = 100;
		add(ico = new oc.Picture("oc/wh40k/images/GKInquisitorCoteaz.jpg"));
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
