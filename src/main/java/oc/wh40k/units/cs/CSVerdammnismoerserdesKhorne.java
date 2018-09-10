package oc.wh40k.units.cs;

import oc.Eintrag;

public class CSVerdammnismoerserdesKhorne extends Eintrag {

	public CSVerdammnismoerserdesKhorne() {
		name = "Verdammnismörser des Khorne";
		grundkosten = 350;

		add(ico = new oc.Picture("oc/wh40k/images/CMVerdammnismoerserKhorne.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
