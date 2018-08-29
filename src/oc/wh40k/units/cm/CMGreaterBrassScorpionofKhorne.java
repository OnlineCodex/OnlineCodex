package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMGreaterBrassScorpionofKhorne extends Eintrag {

	public CMGreaterBrassScorpionofKhorne() {
		name = "Greater Brass Scorpion of Khorne";
		grundkosten = 700;

		add(ico = new oc.Picture("oc/wh40k/images/CMGreaterBrassScorpionofKhorne.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
