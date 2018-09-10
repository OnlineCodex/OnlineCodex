package oc.wh40k.units.cs;

import oc.Eintrag;

public class CSSilberzitadelledesTzeentch extends Eintrag {

	public CSSilberzitadelledesTzeentch() {
		name = "Silberzitadelle des Tzeentch";
		grundkosten = 400;

		add(ico = new oc.Picture("oc/wh40k/images/CMSilberzitadelledesTzeentch.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
