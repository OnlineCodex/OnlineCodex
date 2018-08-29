package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMBanelordTitandesKhorne extends Eintrag {

	public CMBanelordTitandesKhorne() {
		name = "Banelord-Titan des Khorne";
		grundkosten = 2500;

		add(ico = new oc.Picture("oc/wh40k/images/BanelordTitandesKhorne.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
