package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMVerdammnismoerserdesKhorne extends Eintrag {

	public CMVerdammnismoerserdesKhorne() {
		name = "Verdammnismörser des Khorne";
		grundkosten = 350;

		add(ico = new oc.Picture("oc/wh40k/images/CMVerdammnismoerserKhorne.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
