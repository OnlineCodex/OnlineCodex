package oc.wh40k.units.cs;

import oc.Eintrag;

public class CSSchaedelturmdesKhorne extends Eintrag {

	public CSSchaedelturmdesKhorne() {
		name = "Schädelturm des Khorne";
		grundkosten = 700;

		add(ico = new oc.Picture("oc/wh40k/images/SchaedelturmdesKhorne.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
