package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CDKreischerdesTzeentch extends Eintrag {

	AnzahlPanel CDKreischerdesTzeentch;

	public CDKreischerdesTzeentch() {

		name = "Kreischer des Tzeentch";

		grundkosten = 0;

		CDKreischerdesTzeentch = new AnzahlPanel(ID, randAbstand, cnt, "Kreischer des Tzeentch", 3, 9, 25);

		add(CDKreischerdesTzeentch);

		add(ico = new oc.Picture("oc/wh40k/images/CDKreischerdesTzeentch.gif"));

		complete();

	}

	@Override
	public void refreshen() {
	}
}
