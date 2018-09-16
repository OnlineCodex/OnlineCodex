package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDDieBlauenGelehrten extends Eintrag {

	public CDDieBlauenGelehrten() {

		name = "Die Blauen Gelehrten";

		grundkosten = 81;

		add(ico = new oc.Picture("oc/wh40k/images/CDDieBlauenGelehrten.gif"));
		
		complete();

	}

	@Override
	public void refreshen() {
            setUnikat(true);
	}
}
