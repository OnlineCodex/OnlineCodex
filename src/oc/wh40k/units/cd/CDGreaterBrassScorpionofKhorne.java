package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDGreaterBrassScorpionofKhorne extends Eintrag {

	public CDGreaterBrassScorpionofKhorne() {
		name = "Greater Brass Scorpion of Khorne";
		grundkosten = 700;

		add(ico = new oc.Picture("oc/wh40k/images/CMGreaterBrassScorpionofKhorne.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
