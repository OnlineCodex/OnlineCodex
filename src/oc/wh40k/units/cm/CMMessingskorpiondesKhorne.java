package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMMessingskorpiondesKhorne extends Eintrag {

	public CMMessingskorpiondesKhorne() {
		name = "Messingskorpion des Khorne";
		grundkosten = 400;

		add(ico = new oc.Picture("oc/wh40k/images/MessingskorpiondesKhorne.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
