package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMSilberzitadelledesTzeentch extends Eintrag {

	public CMSilberzitadelledesTzeentch() {
		name = "Silberzitadelle des Tzeentch";
		grundkosten = 400;

		add(ico = new oc.Picture("oc/wh40k/images/CMSilberzitadelledesTzeentch.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
