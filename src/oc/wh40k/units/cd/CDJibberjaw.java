package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDJibberjaw extends Eintrag {

		public CDJibberjaw() {

		name = "Jibberjaw";
		grundkosten = 150;

		add(ico = new oc.Picture("oc/wh40k/images/CDJibberjaw.gif"));
		
		complete();

	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
}
