package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMSchaedelturmdesKhorne extends Eintrag {

	public CMSchaedelturmdesKhorne() {
		name = "Schädelturm des Khorne";
		grundkosten = 700;

		add(ico = new oc.Picture("oc/wh40k/images/SchaedelturmdesKhorne.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
